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
import org.bson.Document;
import com.mongodb.MongoException;

public class RegisterController {

    @FXML
    private Button login;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField password_1;

    @FXML
    private Label fehlermeldung;

    @FXML
    public void initialize() {
        login.setOnMouseClicked(this::handleHomeClick);
    }

    private void handleHomeClick(MouseEvent event) {
        String user = username.getText();
        String pass = password.getText();
        String passConfirm = password_1.getText();

        if (user.isEmpty() || pass.isEmpty() || passConfirm.isEmpty()) {
            fehlermeldung.setText("Alle Felder müssen ausgefüllt werden.");
        } else if (!pass.equals(passConfirm)) {
            fehlermeldung.setText("Passwörter stimmen nicht überein.");
        } else {
            try {
                // Save user to MongoDB
                MongoDBUtil.insertUser(user, pass);
                fehlermeldung.setText("Registrierung erfolgreich!");

                // Load login.fxml
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
                Scene loginScene = new Scene(fxmlLoader.load());

                // Get the current stage
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                // Set the new scene
                stage.setScene(loginScene);
                stage.show();
            } catch (IOException e) {
                fehlermeldung.setText("Fehler beim Laden der Login-Seite.");
                e.printStackTrace();
            } catch (MongoException e) {
                fehlermeldung.setText("Fehler beim Speichern der Benutzerdaten.");
                e.printStackTrace();
            }
        }
    }
}
