package _implementierung;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserManager {
    private static UserManager instance;
    private StringProperty userText = new SimpleStringProperty("Login");

    private UserManager() {}

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public String getUserText() {
        return userText.get();
    }

    public void setUserText(String text) {
        if (text == null || text.isEmpty()) {
            userText.set("Login");
        } else {
            userText.set(text);
        }
    }

    public StringProperty userTextProperty() {
        return userText;
    }
}
