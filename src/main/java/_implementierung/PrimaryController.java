package _implementierung;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class PrimaryController {
    
    @FXML
    private HBox kueche;

    @FXML
    private HBox car;
    
    @FXML
    private HBox pflege;

    @FXML
    private HBox gadgets;

    @FXML
    private Label kuecheLabel;

    @FXML
    private Label carlabel;

    @FXML
    private Label pflegelabel;

    @FXML
    private Label gadgetslabel;

    @FXML
    private Label warenkorb;

    @FXML
    private Label login;

    public void updateLoginLabel(String newText) {
        login.setText(newText);
    }

    @FXML
    public void initialize() {
        // Event-Handler für die HBox
        kueche.setOnMouseClicked(this::handleKuecheClick);
        car.setOnMouseClicked(this::handleCarClick);
        pflege.setOnMouseClicked(this::handlePflegeClick);
        gadgets.setOnMouseClicked(this::handleGadgetsClick);
        warenkorb.setOnMouseClicked(this::handleWarenkorbClick);

        // Event-Handler für das Label
        kuecheLabel.setOnMouseClicked(this::handleKuecheClick);
        carlabel.setOnMouseClicked(this::handleCarClick);
        pflegelabel.setOnMouseClicked(this::handlePflegeClick);
        gadgetslabel.setOnMouseClicked(this::handleGadgetsClick);
        login.setOnMouseClicked(this::handleLoginClick);
        login.textProperty().bind(UserManager.getInstance().userTextProperty());
    }

    private void handleLoginClick(MouseEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            Scene loginScene = new Scene(fxmlLoader.load());
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            stage.setScene(loginScene);
            stage.show();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
    private void handleWarenkorbClick(MouseEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("six.fxml"));
            Scene sixScene = new Scene(fxmlLoader.load());
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            
            stage.setScene(sixScene);
            stage.show();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private void handleGadgetsClick(MouseEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fifth.fxml"));
            Scene fifthScene = new Scene(fxmlLoader.load());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(fifthScene);
            stage.show();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }


    private void handlePflegeClick(MouseEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fourth.fxml"));
            Scene fourthScene = new Scene(fxmlLoader.load());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(fourthScene);
            stage.show();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    private void handleCarClick(MouseEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("third.fxml"));
            Scene thirdScene = new Scene(fxmlLoader.load());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(thirdScene);
            stage.show();
        }
        catch(IOException e){
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

