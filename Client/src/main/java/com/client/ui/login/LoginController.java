package com.client.ui.login;


import com.client.Client;
import com.client.ui.collection.CollectionScene;
import com.client.ui.register.RegistrationScene;
import common.network.Response;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginController {
    private ResourceBundle currentBundle;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Label regLabel;

    @FXML
    private Label textLabel;

    private final List<Locale> supportedLocales = Arrays.asList(
            new Locale("en", "NZ"),
            new Locale("ru"),
            new Locale("hr"),
            new Locale("cs")
    );
    private int currentLocaleIndex = 0;

    @FXML
    public void initialize() {
//        currentBundle = ResourceBundle.getBundle("MessagesBundle", supportedLocales.get(currentLocaleIndex));
//        updateUI();
    }

    /**
     * Update LoginWindow UI
     */
//    private void updateUI() {
//        accountLabel.setText(currentBundle.getString("accountLabel"));
//        welcomeLabel.setText(currentBundle.getString("welcomeLabel"));
//        detailsLabel.setText(currentBundle.getString("detailsLabel"));
//        signInButton.setText(currentBundle.getString("signInButton"));
//        signUpLabel.setText(currentBundle.getString("signUpLabel"));
//        usernameLabel.setText(currentBundle.getString("usernameLabel"));
//        passwordLabel.setText(currentBundle.getString("passwordLabel"));
//    }


    @FXML
    protected void onSignInButtonClick() {
        try {
            String username = loginField.getText().trim();
            String password = passwordField.getText().trim();
            if(username.isEmpty() || password.isEmpty()){
                Client.errorAlert("Введите логин и пароль");
            }else{
            Client.clientCommandManager.runCommand("login " + username+ " "+password);
            Response res = Client.clientCommandManager.runCommand("show");

            if( res.getStatusCode().equals(Response.OK)){
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.close();
                CollectionScene collectionsScene = new CollectionScene(currentLocaleIndex);
                collectionsScene.show();
            }else if(res.getStatusCode().equals(Response.WRONGLOGIN)){
                Client.errorAlert("Неправильный логин/пароль");
            }
            }
        } catch (Exception e) {
            Client.errorAlert("Server is dead :(");
            e.printStackTrace();
        }
    }

    @FXML
    protected void onSignUpLabelClick() {
        try {

            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
            RegistrationScene scene = new RegistrationScene(currentLocaleIndex);
            scene.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
