package _implementierung;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import com.mongodb.MongoException;

public class LoginController {

    @FXML
    private Button home;

    @FXML
    private TextField user;

    @FXML
    private PasswordField password;

    @FXML
    private Button registrieren;

    @FXML
    private Label fehlermeldung;

    @FXML
    public void initialize() {
        home.setOnMouseClicked(this::handleHomeClick);
        registrieren.setOnMouseClicked(this::handleRegisterClick);
        user.textProperty().addListener((observable, oldValue, newValue) -> {
            UserManager.getInstance().setUserText(newValue);
        });
    }

    private void handleHomeClick(MouseEvent event) {
        String username = user.getText();
        String pass = password.getText();

        if (username.isEmpty() || pass.isEmpty()) {
            fehlermeldung.setText("Benutzername und Passwort dürfen nicht leer sein.");
        } else {
            try {
                if (MongoDBUtil.verifyUser(username, pass)) {
                    // Lade primary.fxml
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("primary.fxml"));
                    Scene primaryScene = new Scene(fxmlLoader.load());

                    // Hole die aktuelle Stage
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                    // Setze die neue Scene
                    stage.setScene(primaryScene);
                    stage.show();
                } else {
                    fehlermeldung.setText("Ungültiger Benutzername oder Passwort.");
                }
            } catch (IOException e) {
                fehlermeldung.setText("Fehler beim Laden der Hauptseite.");
                e.printStackTrace();
            } catch (MongoException e) {
                fehlermeldung.setText("Fehler beim Überprüfen der Benutzerdaten.");
                e.printStackTrace();
            }
        }
    }

    private void handleRegisterClick(MouseEvent event) {
        try {
            // Lade register.fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
            Scene registerScene = new Scene(fxmlLoader.load());

            // Hole die aktuelle Stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Setze die neue Scene
            stage.setScene(registerScene);
            stage.show();
        } catch (IOException e) {
            fehlermeldung.setText("Fehler beim Laden der Registrierungsseite.");
            e.printStackTrace();
        }
    }
}
