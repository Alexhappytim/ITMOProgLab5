package com.client.ui.register;


import com.client.Client;
import com.client.ui.collection.CollectionScene;
import com.client.ui.login.LoginScene;
import common.network.Response;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class RegistrationController {
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
    protected void onSignUpButtonClick() {
        try {
            String username = loginField.getText().trim();
            String password = passwordField.getText().trim();
            if(username.isEmpty() || password.isEmpty()){
                Client.errorAlert("Введите логин и пароль");
            }else{
                Response res  = Client.clientCommandManager.runCommand("register " + username+ " "+password);
                switch (res.getStatusCode()) {
                    case 0 -> {
                        Client.infoAlert("Вы успешно зарегистрировались");
                        onSignInButtonClick();
                    }
                    case 4 -> {
                        Client.errorAlert("Такой логин уже существует");
                    }
                }
            }
        } catch (Exception e) {
            Client.errorAlert("Server is dead :(");
            e.printStackTrace();
        }
    }

    @FXML
    protected void onSignInButtonClick() {
        try {
            LoginScene loginScene = new LoginScene(currentLocaleIndex);
            loginScene.show();
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
