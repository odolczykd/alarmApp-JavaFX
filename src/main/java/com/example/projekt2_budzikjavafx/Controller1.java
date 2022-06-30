/***
 PROGRAMOWANIE III (Java)
 Praca domowa #2: Budzik JavaFX
 Autor: Dawid Odolczyk (grupa LA)

 OPIS PLIKÓW:
 * Alarm - klasa pomocnicza przechowująca informacje o ustawionych alarmach
 * Controller1 + scene1.fxml - pliki obsługujące pierwsze okno (to z listą aktywnych alarmów)
 * Controller2 + scene2.fxml - pliki obsługujące drugie okno (kreator nowego alarmu)
 ***/

package com.example.projekt2_budzikjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller1 {
    @FXML private Label alarmsLabel;
    @FXML private Button exitButton;

    /* STATYCZNA zmienna przechowująca Stringa ze wszystkimi alarmami
       (statyczna, aby można było rzeczywiście przechowywać wszystkie alarmy, a nie tylko ten ostatnio dodany) */
    private static String alarms = "";

    // funkcja dodająca nowy alarm
    protected void addAlarm(Alarm a){
        alarms += a.write();
        insert();
    }

    // funkcja wstawiające wszystkie dotychczas ustawione alarmy do Labela
    @FXML
    protected void insert(){
        alarmsLabel.setText(alarms);
    }

    // obsługa naciśnięcia przycisku "Zakończ"
    @FXML
    protected void onExitButtonClick() {
        Stage s = (Stage) exitButton.getScene().getWindow();
        s.close();
    }

    /* obsługa naciśnięcia przycisku "Dodaj nowy alarm"
       funkcja otwiera nowe okno z kreatorem nowego alarmu
     */
    @FXML
    protected void onAddNewButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene2.fxml"));
        Scene s = new Scene(loader.load(), 300, 365);
        Stage st = new Stage();
        st.setTitle("Dodaj nowy alarm");
        st.setScene(s);
        st.show();
        onExitButtonClick();
    }
}