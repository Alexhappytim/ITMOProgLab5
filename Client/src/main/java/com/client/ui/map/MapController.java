package com.client.ui.map;

import com.client.Client;
import com.client.ClientMain;
import com.client.ui.collection.CollectionScene;
import com.client.ui.newDragon.NewDragonScene;
import common.dragon.Dragon;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MapController {

    @FXML
    private Button deleteButton;

    @FXML
    private ImageView dragonImg;

    @FXML
    private Button editButton;

    @FXML
    private Label idLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label speakingLabel;

    @FXML
    private Button toTableButton;

    @FXML
    private Label toothLabel;

    @FXML
    private Label typeLabel;

    @FXML
    private Label xLabel;

    @FXML
    private Label yLabel;
    @FXML
    private Pane book;
    @FXML
    private Pane pane;
    @FXML
    private Label ageLabel;
    @FXML
    private Label authorLabel;
    @FXML
    private Label colorLabel;
    @FXML
    private Label dateLabel;
    private PriorityQueue<Dragon> collection;
    private Integer currentLocaleIndex;
    private Dragon curDragon;
    private Timeline timeline;
    private ArrayList<Long> exist = new ArrayList();
    @FXML
    public void initialize() {
        book.setVisible(false);
        loadCollection();
        timeline = new Timeline(new KeyFrame(Duration.seconds(4), event -> loadCollection()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public  void loadCollection(){
        collection = Client.clientCommandManager.runCommand("show").getCollection();
        ObservableList<Node> tmp = pane.getChildren();
        tmp.clear();
        for (Dragon dragon : collection) {
                ImageView imageView = new ImageView(new Image(ClientMain.class.getResource("img/dragonOr.png").toString()));
                switch (dragon.getColor()) {
                    case BLUE -> imageView = new ImageView(new Image(ClientMain.class.getResource("img/dragonBl.png").toString()));
                    case BLACK -> imageView = new ImageView(new Image(ClientMain.class.getResource("img/dragonBlack.png").toString()));
                    case BROWN -> imageView = new ImageView(new Image(ClientMain.class.getResource("img/dragonBr.png").toString()));
                    case GREEN -> imageView = new ImageView(new Image(ClientMain.class.getResource("img/dragonGr.png").toString()));
                    case ORANGE -> imageView = new ImageView(new Image(ClientMain.class.getResource("img/dragonOr.png").toString()));
                }
                imageView.setFitWidth(64);
                imageView.setFitHeight(64);
                imageView.setX(dragon.getCoordinates().getX() * 64);
                imageView.setY(dragon.getCoordinates().getY() * 64);
                imageView.setPreserveRatio(true);
                imageView.setId(dragon.getId().toString());

                imageView.setOnMouseClicked(event -> showDragonInfo(dragon));
            synchronized(this){
                pane.getChildren().add(imageView);
            }
        }


    }
    public void showDragonInfo(Dragon dragon){
        curDragon = dragon;
        book.setVisible(true);
        switch (dragon.getColor()){
            case BLUE -> dragonImg.setImage(new Image(ClientMain.class.getResource("img/dragonBl.png").toString()));
            case BLACK -> dragonImg.setImage(new Image(ClientMain.class.getResource("img/dragonBlack.png").toString()));
            case BROWN-> dragonImg.setImage(new Image(ClientMain.class.getResource("img/dragonBr.png").toString()));
            case GREEN -> dragonImg.setImage(new Image(ClientMain.class.getResource("img/dragonGr.png").toString()));
            case ORANGE -> dragonImg.setImage(new Image(ClientMain.class.getResource("img/dragonOr.png").toString()));
        }
        idLabel.setText(dragon.getId().toString());
        nameLabel.setText(dragon.getName());
        speakingLabel.setText(Boolean.toString(dragon.isSpeaking()));
        toothLabel.setText(dragon.getToothCount().toString());
        typeLabel.setText(dragon.getType().toString());
        xLabel.setText(dragon.getCoordinates().getX().toString());
        yLabel.setText(Float.toString(dragon.getCoordinates().getY()));
        ageLabel.setText(dragon.getAge().toString());
        authorLabel.setText(dragon.getAuthorId().toString());
        colorLabel.setText(dragon.getColor().toString());
        dateLabel.setText(dragon.getCreationDate().toString());
    }
    public void hideDragonInfo() {
        book.setVisible(false);
    }

    public void onEditButtonClick(){
        NewDragonScene newDragonScene = new NewDragonScene(currentLocaleIndex, curDragon);
        newDragonScene.show();}
    public void onDeleteButtonClick(){
        Client.clientCommandManager.runCommand("remove_by_id " + curDragon.getId());
    }
    public void onToTableButtonClick(){
        Stage stage = (Stage) toTableButton.getScene().getWindow();
        stage.close();
        CollectionScene collectionsScene = new CollectionScene(currentLocaleIndex);
        collectionsScene.show();
    }

    public void setCurrentLocaleIndex(Integer currentLocaleIndex) {
        this.currentLocaleIndex = currentLocaleIndex;
    }
}
