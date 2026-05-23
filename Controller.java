// Dipinsa Marasini
// JavaFX Music Store — MavTunes
// Advanced Application Development | UT Arlington

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    @FXML private TextField nameField, streetField, cityField, stateField, zipField;
    @FXML private TextField titleField, dateField, accountField;
    @FXML private CheckBox appCheck, musicCheck;
    @FXML private ComboBox<String> musicCombo;
    @FXML private RadioButton gameRadio, productivityRadio, educationRadio;
    @FXML private Label musicTypeLabel, appTypeLabel;

    private ToggleGroup appGroup;

    // Customer array
    private ArrayList<String> customerList = new ArrayList<>();

    @FXML
    public void initialize() {
        appGroup = new ToggleGroup();
        gameRadio.setToggleGroup(appGroup);
        productivityRadio.setToggleGroup(appGroup);
        educationRadio.setToggleGroup(appGroup);

        musicCombo.getItems().addAll("CHOOSE ONE", "POP", "R&B", "JAZZ", "CLASSICAL");
        musicCombo.setValue("CHOOSE ONE");
        musicCombo.setVisibleRowCount(3);
    }

    @FXML
    private void handleAppCheck() {
        boolean appChecked = appCheck.isSelected();
        musicCombo.setDisable(appChecked);
        musicTypeLabel.setDisable(appChecked);

        if (appChecked) {
            musicCheck.setSelected(false);
            gameRadio.setDisable(false);
            productivityRadio.setDisable(false);
            educationRadio.setDisable(false);
            appTypeLabel.setDisable(false);
        }
    }

    @FXML
    private void handleMusicCheck() {
        boolean musicChecked = musicCheck.isSelected();
        gameRadio.setDisable(musicChecked);
        productivityRadio.setDisable(musicChecked);
        educationRadio.setDisable(musicChecked);
        appTypeLabel.setDisable(musicChecked);

        if (musicChecked) {
            appCheck.setSelected(false);
            musicCombo.setDisable(false);
            musicTypeLabel.setDisable(false);
        }
    }

    @FXML
    private void handleSubmit() {

        if (nameField.getText().trim().isEmpty()) {
            showAlert("Name is missing!");
            nameField.requestFocus();
            return;
        }
        if (streetField.getText().trim().isEmpty()) {
            showAlert("Street is missing!");
            streetField.requestFocus();
            return;
        }
        if (cityField.getText().trim().isEmpty()) {
            showAlert("City is missing!");
            cityField.requestFocus();
            return;
        }
        if (stateField.getText().trim().isEmpty()) {
            showAlert("State is missing!");
            stateField.requestFocus();
            return;
        }
        if (zipField.getText().trim().isEmpty()) {
            showAlert("Zip is missing!");
            zipField.requestFocus();
            return;
        }
        if (!appCheck.isSelected() && !musicCheck.isSelected()) {
            showAlert("Please select APP or MUSIC!");
            return;
        }
        if (titleField.getText().trim().isEmpty()) {
            showAlert("Title is missing!");
            titleField.requestFocus();
            return;
        }
        if (dateField.getText().trim().isEmpty()) {
            showAlert("Date Purchased is missing!");
            dateField.requestFocus();
            return;
        }
        if (accountField.getText().trim().isEmpty()) {
            showAlert("Account Number is missing!");
            accountField.requestFocus();
            return;
        }

        String customer = "Name: " + nameField.getText() + "\n" +
                "Street: " + streetField.getText() + "\n" +
                "City: " + cityField.getText() + "\n" +
                "State: " + stateField.getText() + "\n" +
                "Zip: " + zipField.getText() + "\n" +
                "Title: " + titleField.getText() + "\n" +
                "Date: " + dateField.getText() + "\n" +
                "Account: " + accountField.getText() + "\n" +
                "----------------------------\n";

        customerList.add(customer);

        String fileName = appCheck.isSelected() ? "app.txt" : "music.txt";

        try {
            FileWriter fw = new FileWriter(fileName, true);
            fw.write(customer);
            fw.close();
        } catch (IOException e) {
            showAlert("Error saving to file!");
            return;
        }

        nameField.clear();
        streetField.clear();
        cityField.clear();
        stateField.clear();
        zipField.clear();
        titleField.clear();
        dateField.clear();
        accountField.clear();
        appCheck.setSelected(false);
        musicCheck.setSelected(false);
        musicCombo.setValue("CHOOSE ONE");
        musicCombo.setDisable(false);
        musicTypeLabel.setDisable(false);
        appGroup.selectToggle(null);
        gameRadio.setDisable(false);
        productivityRadio.setDisable(false);
        educationRadio.setDisable(false);
        appTypeLabel.setDisable(false);

        nameField.requestFocus();
    }

    @FXML
    private void handleFinish() {
        System.exit(0);
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Missing Info");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
