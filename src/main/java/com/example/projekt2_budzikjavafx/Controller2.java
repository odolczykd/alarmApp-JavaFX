package com.example.projekt2_budzikjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {
    @FXML private Button confirmButton, exitButton;
    @FXML private Spinner<Integer> hours, minutes;
    @FXML private TextField alarmName;
    @FXML private CheckBox day1, day2, day3, day4, day5, day6, day7, repeatCheckBox;
    @FXML private Slider volumeSlider;

    // obsługa naciśnięcia przycisku "Anuluj"
    @FXML
    protected void onExitButtonClick() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene1.fxml"));
        Stage st = new Stage();
        st.setScene(new Scene(loader.load()));
        Controller1 c = loader.getController();
        st.setTitle("Budzik");
        c.insert();
        st.show();

        Stage s = (Stage) exitButton.getScene().getWindow();
        s.close();
    }

    // obsługa naciśnięcia przycisku "Zatwierdź" (dodanie alarmu)
    @FXML
    protected void onConfirmButtonClick() throws IOException {
        // pobieranie wszystkich wartości z TextFieldów, CheckBoxów itp. i dodanie ich do obiektu klasy Alarm
        Alarm a = new Alarm(
            alarmName.getText(),
            hours.getValue(),
            minutes.getValue(),
            getWeekDays(),
            repeatCheckBox.isSelected(),
            (int)volumeSlider.getValue()
        );

        // "połączenie" z pierwszym oknem
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene1.fxml"));
        Stage st = new Stage();
        st.setScene(new Scene(loader.load()));
        Controller1 c = loader.getController();
        // dodanie nowego alarmu
        c.addAlarm(a);
        st.setTitle("Budzik");
        // pokazanie pierwszego okna...
        st.show();
        // ... i zamknięcie drugiego
        Stage s = (Stage) confirmButton.getScene().getWindow();
        s.close();
    }

    // funkcja odczytująca dni tygodnia z CheckBoxów
    protected String getWeekDays(){
        String wd = "";

        if(day1.isSelected()) wd += ", pon";
        if(day2.isSelected()) wd += ", wt";
        if(day3.isSelected()) wd += ", śr";
        if(day4.isSelected()) wd += ", czw";
        if(day5.isSelected()) wd += ", pt";
        if(day6.isSelected()) wd += ", sob";
        if(day7.isSelected()) wd += ", nd";

        return wd.substring(2);
    }

    // do poprawnego działania Spinnerów
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SpinnerValueFactory<Integer> valueFactoryHours = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,23);
        SpinnerValueFactory<Integer> valueFactoryMins = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,59);
        valueFactoryHours.setValue(8);
        valueFactoryMins.setValue(15);
        hours.setValueFactory(valueFactoryHours);
        minutes.setValueFactory(valueFactoryMins);
    }
}