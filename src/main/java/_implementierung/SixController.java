package _implementierung;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class SixController {

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
    private Button pay;

    @FXML
    private Label login;

    @FXML
    private Label productttt;

    @FXML
    private HBox product;

    @FXML
    private ImageView delete;

    @FXML
    private Label productname;

    @FXML
    private Label price;

    @FXML
    private Circle plus;

    @FXML
    private VBox productList; // Add this VBox to the FXML file for containing all products

    

    @FXML
    public void initialize() {
        kuecheLabel.setOnMouseClicked(this::handleKuecheClick);
        carlabel.setOnMouseClicked(this::handleCarClick);
        pflegelabel.setOnMouseClicked(this::handlePflegeClick);
        home.setOnMouseClicked(this::handleHomeClick);
        gadgetslabel.setOnMouseClicked(this::handleGadgetsClick);
        pay.setOnMouseClicked(this::handlePayClick);
        login.setOnMouseClicked(this::handleLoginClick);
        productttt.setOnMouseClicked(this::handleProductClick);
        login.textProperty().bind(UserManager.getInstance().userTextProperty());
        productttt.setOnMouseClicked(this::handleProductClick);
        plus.setOnMouseClicked(this::handleAddProductClick);
    }

    private void handleProductClick(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("product.fxml"));
            Scene productScene = new Scene(fxmlLoader.load());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(productScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Product clicked!");
        }
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

    private void handlePayClick(MouseEvent event) {
        if (UserManager.getInstance().getUserText().equals("Login")) {
            // User is not logged in, show an error message or redirect to login
            System.out.println("Please log in first!");
            handleLoginClick(event); // Redirect to login page
        } else {
            // User is logged in, proceed to pay
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pay.fxml"));
                Scene payScene = new Scene(fxmlLoader.load());

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                stage.setScene(payScene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleGadgetsClick(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fifth.fxml"));
            Scene fifthScene = new Scene(fxmlLoader.load());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(fifthScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handlePflegeClick(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fourth.fxml"));
            Scene fourthScene = new Scene(fxmlLoader.load());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(fourthScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleCarClick(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("third.fxml"));
            Scene firthScene = new Scene(fxmlLoader.load());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(firthScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleHomeClick(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("primary.fxml"));
            Scene primaryScene = new Scene(fxmlLoader.load());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(primaryScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleKuecheClick(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("second.fxml"));
            Scene secondScene = new Scene(fxmlLoader.load());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(secondScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAddProductClick(MouseEvent event) {
        try {
            HBox newProduct = FXMLLoader.load(getClass().getResource("productItem.fxml"));
            productList.getChildren().add(newProduct);

            ImageView deleteImage = (ImageView) newProduct.lookup("#delete");
            deleteImage.setOnMouseClicked(this::handleDeleteProductClick);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleDeleteProductClick(MouseEvent event) {
        Node source = (Node) event.getSource();
        HBox productToDelete = (HBox) source.getParent();
        productList.getChildren().remove(productToDelete);
    }
}
