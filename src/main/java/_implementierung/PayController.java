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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PayController{

    @FXML
    private Label home;

    @FXML
    private Label kuecheLabel;

    @FXML
    private Label carlabel;

    @FXML
    private Label pflegelabel;

    @FXML
    private Label gadgetslabel;

    @FXML
    private Button rent;

    @FXML
    private Label warenkorb;

    @FXML
    private Label login;

    @FXML
    private Label fehlermeldung;

    @FXML
    private PasswordField number;

    @FXML
    private TextField month;

    @FXML
    private TextField year;

    @FXML
    private PasswordField code;

    @FXML
    public void initialize() {
        kuecheLabel.setOnMouseClicked(this::handleKuecheClick);
        carlabel.setOnMouseClicked(this::handleCarClick);
        pflegelabel.setOnMouseClicked(this::handlePflegeClick);
        home.setOnMouseClicked(this::handleHomeClick);
        gadgetslabel.setOnMouseClicked(this::handleGadgetsClick);
        warenkorb.setOnMouseClicked(this::handleWarenkorbClick);
        rent.setOnMouseClicked(this::handleRentClick);
        login.setOnMouseClicked(this::handleLoginClick);
        login.textProperty().bind(UserManager.getInstance().userTextProperty());
    }

    private void handleLoginClick(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            Scene loginScene = new Scene(fxmlLoader.load());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(loginScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleRentClick(MouseEvent event) {
        // Clear any previous error message
        fehlermeldung.setText("");
    
        // Get the input values
        String cardNumber = number.getText();
        String cardMonth = month.getText();
        String cardYear = year.getText();
        String cardCode = code.getText();
    
        // Validate the inputs
        if (cardNumber.isEmpty() || cardMonth.isEmpty() || cardYear.isEmpty() || cardCode.isEmpty()) {
            fehlermeldung.setText("Bitte füllen Sie alle Felder aus.");
            return; // Stop the method here, do not proceed to load the new scene
        }
    
        // Proceed with loading the rent.fxml scene
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("rent.fxml"));
            Scene rentScene = new Scene(fxmlLoader.load());
    
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(rentScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    private void handleWarenkorbClick(MouseEvent event) {
        try {
            // Lade second.fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("six.fxml"));
            Scene sixScene = new Scene(fxmlLoader.load());

            // Hole die aktuelle Stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Setze die neue Scene
            stage.setScene(sixScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void handleGadgetsClick(MouseEvent event) {
        try {
            // Lade second.fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fifth.fxml"));
            Scene fifthScene = new Scene(fxmlLoader.load());

            // Hole die aktuelle Stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Setze die neue Scene
            stage.setScene(fifthScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void handlePflegeClick(MouseEvent event) {
        try {
            // Lade second.fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fourth.fxml"));
            Scene fourthScene = new Scene(fxmlLoader.load());

            // Hole die aktuelle Stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Setze die neue Scene
            stage.setScene(fourthScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void handleCarClick(MouseEvent event) {
        try {
            // Lade second.fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("third.fxml"));
            Scene firthScene = new Scene(fxmlLoader.load());

            // Hole die aktuelle Stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Setze die neue Scene
            stage.setScene(firthScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    private void handleHomeClick(MouseEvent event) {
        try {
            // Lade second.fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("primary.fxml"));
            Scene primaryScene = new Scene(fxmlLoader.load());

            // Hole die aktuelle Stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Setze die neue Scene
            stage.setScene(primaryScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleKuecheClick(MouseEvent event) {
        try {
            // Lade second.fxml
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("second.fxml"));
            Scene secondScene = new Scene(fxmlLoader.load());

            // Hole die aktuelle Stage
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Setze die neue Scene
            stage.setScene(secondScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}