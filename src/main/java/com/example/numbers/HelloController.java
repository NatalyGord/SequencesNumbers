package com.example.numbers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    String numSequence = "";
    @FXML
    Label label;

    // create a tabpane
    @FXML
    TabPane tabpane = new TabPane();

    String sequence = "";
    int count = 1;
    boolean start = false;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    public void onButtonStartClick() {
        if (sequence != "" && !start) {
            // create Tab
            Tab tab = new Tab(sequence + " (" + count + ")");
            // create a label
            label = new Label(numSequence);
            // add label to the tab
            tab.setContent(label);
            // add tab
            tabpane.getTabs().add(tab);

            start = true;
            count++;

            if (sequence == "Фибоначчи") {
                i = 1;
                num1 = 0;
                num2 = 1;
                numSequence = "";

                for (int i = 0; i < 20; i++) {
//                while (true){
                    numSequence += sequenceFib() + " ";
                    label.setText(numSequence);
                    // add label to the tab
                    tab.setContent(label);

//                    try {
//                        Thread.sleep(300);
//                    } catch (InterruptedException e) {
//                    }
//                    if(!start){
//                        break;
//                    }
                }
            } else if (sequence == "Лукас") {
                iLu = 1;
                num1Lu = 2;
                num2Lu = 1;
                numSequence = "";

                for (int i = 0; i < 20; i++) {
//                while (true){
                    numSequence += sequenceLu() + " ";
                    label.setText(numSequence);
                    // add label to the tab
                    tab.setContent(label);
                }
            }
        }
    }

    @FXML
    public void onButtonStopClick() {
        start = false;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.getItems().add("Фибоначчи");
        comboBox.getItems().add("Лукас");
    }

    public void onComboBoxChanged(ActionEvent actionEvent) {
        String selectedValue = comboBox.getSelectionModel().getSelectedItem(); //что выбрано
        sequence = selectedValue;
    }

    int i = 1;
    int num1 = 0;
    int num2 = 1;

    public int sequenceFib() {
        if (i != 1) {
            int sum = num1 + num2;
            num1 = num2;
            num2 = sum;
        }
        i++;
        return (num1);
    }

    int iLu = 1;
    int num1Lu = 2;
    int num2Lu = 1;

    public int sequenceLu() {
        if (iLu != 1) {
            int sum = num1Lu + num2Lu;
            num1Lu = num2Lu;
            num2Lu = sum;
        }
        iLu++;
        return (num1Lu);
    }
}

