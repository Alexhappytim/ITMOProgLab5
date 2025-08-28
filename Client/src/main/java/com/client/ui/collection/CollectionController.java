package com.client.ui.collection;

import com.client.Client;
import com.client.ui.UTF8Control;
import com.client.ui.commands.CommandsScene;
import com.client.ui.newDragon.NewDragonScene;
import common.dragon.Dragon;
import common.dragon.DragonType;
import common.network.Response;
import com.client.ui.map.MapScene;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionController {
    @FXML
    private Button toMapButton;
    @FXML
    private Button addButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button commandsButton;

    private ResourceBundle currentBundle;
    private Stage stage;

    private FileChooser fileChooser;
    private String scriptPath;
    private Map<Long, String> ownershipMap;
    private Map<String, Color> clientColorMap = new HashMap<>();

    private final List<Locale> supportedLocales = Arrays.asList(
            new Locale("en", "NZ"),
            new Locale("ru"),
            new Locale("hr"),
            new Locale("cs")
    );

    private int currentLocaleIndex = 0;
    private PriorityQueue<Dragon> collection;
    @FXML
    private TableView<Dragon> table;
    @FXML
    private TableColumn<Dragon, Long> idColumn;
    @FXML
    private TableColumn<Dragon, String> nameColumn;
    @FXML
    private TableColumn<Dragon, Long> xColumn;
    @FXML
    private TableColumn<Dragon, Float> yColumn;
    @FXML
    private TableColumn<Dragon, String> dateColumn;
    @FXML
    private TableColumn<Dragon, Long> ageColumn;
    @FXML
    private TableColumn<Dragon, Boolean> speakingColumn;
    @FXML
    private TableColumn<Dragon, String> colorColumn;
    @FXML
    private TableColumn<Dragon, String> typeColumn;
    @FXML
    private TableColumn<Dragon, Double> toothCountColumn;
    @FXML
    private TableColumn<Dragon, Integer> authorColumn;

    @FXML
    private Label userLabel;

    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private TextField filterField;
    private Timeline timeline;

    @FXML
    public void initialize() {
        Response res = Client.clientCommandManager.runCommand("show");
        collection = res.getCollection();
        ownershipMap = res.getOwnershipMap();
        // handle locales
//        currentBundle = ResourceBundle.getBundle("MessagesBundle", supportedLocales.get(currentLocaleIndex), new UTF8Control());
//        updateUI();

        // init graphics stuff
        comboBox.getItems().addAll("id", "name", "x", "y", "date", "age", "speaking", "color", "type", "tooth_count", "author");

        // init username
        String currentUsername = Client.curLogin;
        userLabel.setText(currentUsername);

        // Setup cellValueFactories
        idColumn.setCellValueFactory(cellData -> new SimpleLongProperty(cellData.getValue().getId()).asObject());
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        xColumn.setCellValueFactory(cellData -> new SimpleLongProperty(cellData.getValue().getCoordinates().getX()).asObject());
        yColumn.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().getCoordinates().getY()).asObject());
        dateColumn.setCellValueFactory(cellData -> new SimpleStringProperty(getDate(cellData.getValue().getCreationDate())));
        ageColumn.setCellValueFactory(cellData -> new SimpleLongProperty(cellData.getValue().getAge()).asObject());
        speakingColumn.setCellValueFactory(cellData -> new SimpleBooleanProperty(cellData.getValue().isSpeaking()).asObject());
        colorColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getColor().toString()));
        typeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType().toString()));
        toothCountColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getToothCount()).asObject());
        authorColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getAuthorId()).asObject());

        // Initialize the FileChooser for the Execute script button
//        fileChooser = new FileChooser();
//        fileChooser.setTitle("Open Script File");
//        fileChooser.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("Script Files", "*.txt"),
//                new FileChooser.ExtensionFilter("All Files", "*.*"));

        // Set the initial directory
        // for laptop:
//        fileChooser.setInitialDirectory(new File("C:\\Users\\Admin\\Itmo\\Java_labs\\lab8\\client\\src\\main\\resources\\scripts"));
        // for pc:
        //fileChooser.setInitialDirectory(new File("C:\\Users\\Boris\\Itmo\\Java_labs\\lab8\\client\\src\\main\\resources\\scripts"));

        // setup Client
        System.out.println(ownershipMap);
//        table.setRowFactory(tv -> new TableRow<Dragon>() {
//            @Override
//            public void updateItem(Dragon dragon, boolean empty) {
//                super.updateItem(dragon, empty);
//                if (dragon == null) {
//                    setStyle("");
//                } else {
//                    Color color = clientColorMap.get(ownershipMap.get(dragon.getId()));
//                    String rgb = String.format("#%02X%02X%02X",
//                            (int)(color.getRed() * 255),
//                            (int)(color.getGreen() * 255),
//                            (int)(color.getBlue() * 255));
//                    setStyle("-fx-border-color: " + rgb + ";");
//                }
//            }
//        });

        // listener for filtering using Stream API
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && !newValue.isEmpty()) {
                String selectedValue = comboBox.getSelectionModel().getSelectedItem();
                filterCities(selectedValue, newValue);
            } else {
                table.setItems(FXCollections.observableArrayList(collection));
            }
        });
        loadCollection();
        // Start the timeline for loading collection to TableView
        timeline = new Timeline(new KeyFrame(Duration.seconds(4), event -> loadCollection()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }




    private String getDate(Date date) {
        if (date == null) return "null";
//        DateFormat formatter = DateFormat.getDateInstance(DateFormat.FULL, currentBundle.getLocale());
//        return formatter.format(date);
        return date.toString();
    }
    private void loadCollection() {
        setCollection(Client.clientCommandManager.runCommand("show").getCollection());
        String selectedValue = comboBox.getSelectionModel().getSelectedItem();
        String newValue = filterField.getText();
        if(newValue != null && !newValue.isEmpty()){
        filterCities(selectedValue, newValue);}
    }

    public void setCollection(PriorityQueue<Dragon> collection) {
        this.collection = collection;
        if (collection != null) {
            for (Dragon dragon : collection) {
                System.out.println(dragon.toString());
            }
            table.setItems(FXCollections.observableArrayList(collection));

            table.refresh();

        }
    }


//    private void updateUI() {
//        idColumn.setText(currentBundle.getString("id"));
//        nameColumn.setText(currentBundle.getString("name"));
//        xColumn.setText(currentBundle.getString("coordX"));
//        yColumn.setText(currentBundle.getString("coordY"));
//        dateColumn.setText(currentBundle.getString("creation"));
//        ageColumn.setText(currentBundle.getString("area"));
//        speakingColumn.setText(currentBundle.getString("population"));
//        colorColumn.setText(currentBundle.getString("metersAboveSeaLevel"));
//        typeColumn.setText(currentBundle.getString("climate"));
//        toothCountColumn.setText(currentBundle.getString("government"));
//        authorColumn.setText(currentBundle.getString("standards"));
//
//        ObservableList<String> localizedItems = FXCollections.observableArrayList(
//                currentBundle.getString("id"),
//                currentBundle.getString("name"),
//                currentBundle.getString("coordX"),
//                currentBundle.getString("coordY"),
//                currentBundle.getString("date"),
//                currentBundle.getString("age"),
//                currentBundle.getString("speaking"),
//                currentBundle.getString("color"),
//                currentBundle.getString("type"),
//                currentBundle.getString("toothCount"),
//                currentBundle.getString("author")
//        );
//        comboBox.getItems().setAll(localizedItems);
//        commandsButton.setText(currentBundle.getString("commandsButton"));
//        deleteButton.setText(currentBundle.getString("deleteButton"));
//        editButton.setText(currentBundle.getString("editButton"));
//        addButton.setText(currentBundle.getString("addButton"));
//        toMapButton.setText(currentBundle.getString("toMapButton"));
//
//
//           }

    @FXML
    protected void onCreateButtonClick() {
        NewDragonScene newDragonScene = new NewDragonScene(currentLocaleIndex);
        newDragonScene.show();
    }

    @FXML
    protected void onEditButtonClick() {
        Dragon selecteddragon = table.getSelectionModel().getSelectedItem();
        if (selecteddragon != null) {
            NewDragonScene newDragonScene = new NewDragonScene(currentLocaleIndex, selecteddragon);
            newDragonScene.show();
        } else {
            Client.infoAlert("Please, select any dragon to edit it!)");
        }
    }

    @FXML
    protected void onDeleteButtonClick() {
        Dragon selectedDragon = table.getSelectionModel().getSelectedItem();

        if (selectedDragon != null) {
            table.getItems().remove(selectedDragon);
                Client.clientCommandManager.runCommand("remove_by_id " + selectedDragon.getId());
        } else {
            Client.infoAlert("Please, select any dragon to delete it!)");
        }
    }

    @FXML
    protected void onToMapButtonClick() {
        MapScene mapScene = new MapScene(currentLocaleIndex,collection);
        mapScene.show();
        mapScene.loadColorMap(clientColorMap, ownershipMap);
        Stage stage = (Stage) toMapButton.getScene().getWindow();
        timeline.stop();
        stage.close();
    }



    public void setLocale(int index) {
        this.currentLocaleIndex = index;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }






    @FXML
    protected void onCommandsButtonClick() {
        CommandsScene newDragonScene = new CommandsScene(currentLocaleIndex);
        newDragonScene.show();

    }

    private void filterCities(String property, String value) {
        Stream<Dragon> dragonStream = collection.stream();
        switch (property) {
            case "id":
                long id = Long.parseLong(value);
                dragonStream = dragonStream.filter(dragon -> dragon.getId() == id);
                break;
            case "date":
                DateTimeFormatter formatter;
                switch (currentBundle.getLocale().toString()) {
                    case "en_NZ":
                        formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy", currentBundle.getLocale()); // for English (NZ) locale
                        break;
                    case "hr":
                        formatter = DateTimeFormatter.ofPattern("EEEE, d. MMMM yyyy.", currentBundle.getLocale()); // for Croatian locale
                        break;
                    case "ru":
                        formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy 'г.'", currentBundle.getLocale()); // for Russian locale
                        break;
                    case "cs":
                        formatter = DateTimeFormatter.ofPattern("EEEE, d. MMMM yyyy", currentBundle.getLocale()); // for Czech locale
                        break;
                    default:
                        formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy", Locale.US); // default to US locale
                        break;
                }
                LocalDate date = LocalDate.parse(value, formatter);
                dragonStream = dragonStream.filter(dragon -> {
                    String dragonCreationDateString = getDate(dragon.getCreationDate());
                    LocalDate dragonCreationDate = LocalDate.parse(dragonCreationDateString, formatter);
                    return dragonCreationDate.equals(date);
                });

                break;
            case "x":
                Long x = Long.parseLong(value);
                dragonStream = dragonStream.filter(dragon -> dragon.getCoordinates().getX().equals(x));
                break;
            case "y":
                Float y = Float.parseFloat(value);
                dragonStream = dragonStream.filter(dragon -> y.equals( dragon.getCoordinates().getY()));
                break;
            case "age":
                Long age = Long.parseLong(value);
                dragonStream = dragonStream.filter(dragon -> dragon.getAge().equals(age));
                break;
            case "name":
                dragonStream = dragonStream.filter(dragon -> dragon.getName().equals(value));
                break;
            case "speaking":
                Boolean speaking = Boolean.valueOf(value);
                dragonStream = dragonStream.filter(dragon -> speaking.equals(dragon.isSpeaking()));
                break;
            case "color":
                Color color = Color.valueOf(value);
                dragonStream = dragonStream.filter(dragon -> dragon.getColor().equals(color));
                break;
            case "type":
                DragonType type = DragonType.valueOf(value);
                dragonStream = dragonStream.filter(dragon -> dragon.getType().equals(type));
                break;
            case "tooth_count":
                Double tooth = Double.valueOf(value);
                dragonStream = dragonStream.filter(dragon -> dragon.getToothCount().equals(tooth));
                break;
            case "author":
                Integer author = Integer.valueOf(value);
                dragonStream = dragonStream.filter(dragon -> dragon.getAuthorId().equals(author));
                break;
            default:
                break;
        }
        table.setItems(FXCollections.observableArrayList(dragonStream.collect(Collectors.toList())));
    }
}
