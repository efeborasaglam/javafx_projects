package _implementierung;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SecondController {

    @FXML
    private Label home;

    @FXML
    private HBox kueche;
    
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

    @FXML
    private GridPane product;

    @FXML
    public void initialize() {
        // Event-Handler für die HBox
        home.setOnMouseClicked(this::handleHomeClick);
        carlabel.setOnMouseClicked(this::handleCarClick);
        pflegelabel.setOnMouseClicked(this::handlePflegeClick);
        gadgetslabel.setOnMouseClicked(this::handleGadgetsClick);
        warenkorb.setOnMouseClicked(this::handleWarenkorbClick);
        login.setOnMouseClicked(this::handleLoginClick);
        product.setOnMouseClicked(this::handleProductClick);
        login.textProperty().bind(UserManager.getInstance().userTextProperty());
    }

    private void handleProductClick(MouseEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("product.fxml"));
            Scene productScene = new Scene(fxmlLoader.load());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(productScene);
            stage.show();
        }
        catch(IOException e){
            e.printStackTrace();
        }
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

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
