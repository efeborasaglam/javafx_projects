package _implementierung;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class ProductItemController {

    @FXML
    private Label productname;

    @FXML
    private Label price;

    @FXML
    private ComboBox<String> productDropdown;

    @FXML
    private ComboBox<Integer> wocheDropdown;

    @FXML
    private ComboBox<Integer> anzahlDropdown;

    private Map<String, Integer> productMap;

    @FXML
    public void initialize() {
        productMap = new HashMap<>();
        productMap.put("Standmixer", 40);
        productMap.put("Früchte Mixer", 30);
        productMap.put("exclusiv Mixer", 30);
        productMap.put("Kaffemaschine", 50);
        productMap.put("Abstandmixer", 80);
        productMap.put("Autophone", 15);
        productMap.put("Handymagnet", 2);
        productMap.put("Haarschneider", 5);
        productMap.put("Rasierer", 5);
        productMap.put("e-Zahnbürste", 15);
        productMap.put("Haarföne", 6);
        productMap.put("Pro Kamera", 50);
        productMap.put("Drone", 100);
        productMap.put("Strom-Tester", 5);
        productMap.put("USB-C converter", 1);

        productDropdown.getItems().addAll(productMap.keySet());
        wocheDropdown.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        anzahlDropdown.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        productDropdown.setOnAction(event -> updatePrice());
        wocheDropdown.setOnAction(event -> updatePrice());
        anzahlDropdown.setOnAction(event -> updatePrice());

        // Set default values
        wocheDropdown.getSelectionModel().selectFirst();
        anzahlDropdown.getSelectionModel().selectFirst();
    }

    private void updatePrice() {
        String selectedProduct = productDropdown.getSelectionModel().getSelectedItem();
        Integer selectedWoche = wocheDropdown.getSelectionModel().getSelectedItem();
        Integer selectedAnzahl = anzahlDropdown.getSelectionModel().getSelectedItem();

        if (selectedProduct != null && selectedWoche != null && selectedAnzahl != null) {
            productname.setText(selectedProduct);
            int basePrice = productMap.get(selectedProduct);
            int totalPrice = basePrice * selectedWoche * selectedAnzahl;
            price.setText(totalPrice + " Fr.");
        }
    }
}
