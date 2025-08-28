package com.client.ui.newDragon;

import com.client.Client;
import common.dragon.*;
import common.network.Request;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewDragonController {
    @FXML
    private Button acceptButton;

    @FXML
    private TextField ageField;

    @FXML
    private Button cancelButton;

    @FXML
    private ComboBox<Color> colorComboBox;

    @FXML
    private TextField nameField;

    @FXML
    private ComboBox<Boolean> speakingComboBox;

    @FXML
    private TextField toothField;

    @FXML
    private ComboBox<DragonType> typeComboBox;

    @FXML
    private TextField xField;

    @FXML
    private TextField yField;
    private Dragon dragon=null;

    @FXML
    public void initialize() {
        colorComboBox.getItems().addAll(Color.GREEN, Color.BLACK, Color.BLUE, Color.ORANGE, Color.BROWN);
        speakingComboBox.getItems().addAll(true, false);
        typeComboBox.getItems().addAll(DragonType.WATER, DragonType.UNDERGROUND, DragonType.AIR, DragonType.FIRE);
    }
    @FXML
    public void onAcceptButtonClick() {
        boolean flag = true;
        String tmpNF = nameField.getText();
        if (tmpNF.isEmpty()) {
            flag = false;
            nameField.setStyle("-fx-control-inner-background: #FF0000");
        } else {
            nameField.setStyle("-fx-control-inner-background: #00FF00");
        }
        Long x = null;
        try {
            x = Long.parseLong(xField.getText());
            if (x > 41) {
                flag = false;
                xField.setStyle("-fx-control-inner-background: #FF0000");
            } else {
                xField.setStyle("-fx-control-inner-background: #00FF00");
            }
        } catch (Exception e) {
            flag = false;
            xField.setStyle("-fx-control-inner-background: #FF0000");
        }
        Float y = null;
        try {
            y = Float.parseFloat(yField.getText());
            if (y < -49) {
                flag = false;
                yField.setStyle("-fx-control-inner-background: #FF0000");
            } else {
                yField.setStyle("-fx-control-inner-background: #00FF00");
            }
        } catch (Exception e) {
            flag = false;
            yField.setStyle("-fx-control-inner-background: #FF0000");
        }
        Long age = null;
        try {
            age = Long.parseLong(ageField.getText());
            if (age < 0) {
                flag = false;
                ageField.setStyle("-fx-control-inner-background: #FF0000");
            } else {
                ageField.setStyle("-fx-control-inner-background: #00FF00");
            }
        } catch (Exception e) {
            flag = false;
            ageField.setStyle("-fx-control-inner-background: #FF0000");
        }
        DragonHead head = null;
        if(!toothField.getText().isEmpty()) {
            Double toothCount = null;
            try {
                toothCount = Double.parseDouble(toothField.getText());
                    toothField.setStyle("-fx-control-inner-background: #00FF00");
            } catch (Exception e) {
                flag = false;
                toothField.setStyle("-fx-control-inner-background: #FF0000");
            }
            head = new DragonHead(toothCount);
        }
        if(flag) {
            Dragon dragon = new Dragon(tmpNF, new Coordinates(x, y), age, speakingComboBox.getValue(), colorComboBox.getValue(), typeComboBox.getValue(), head,43);
            if(this.dragon!=null){
                Client.requestsManager.sendRequest(new Request("update "+this.dragon.getId(),dragon));
            }
            else{
            Client.requestsManager.sendRequest(new Request("add",dragon));}
            Client.requestsManager.receiveRespond();
            onCancelButtonClick();
        }

    }
    @FXML
    public void onCancelButtonClick(){
        Stage stage = (Stage) acceptButton.getScene().getWindow();
        stage.close();
    }
    public void setDragon(Dragon dragon){
        this.dragon = dragon;
        nameField.setText(dragon.getName());
        xField.setText(dragon.getCoordinates().getX().toString());
        yField.setText(Float.toString(dragon.getCoordinates().getY()));
        ageField.setText(dragon.getAge().toString());
        speakingComboBox.setValue(dragon.isSpeaking());
        colorComboBox.setValue(dragon.getColor());
        typeComboBox.setValue(dragon.getType());
        toothField.setText(dragon.getToothCount().toString());
    }
}
