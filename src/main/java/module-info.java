module com.example.projekt2_budzikjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projekt2_budzikjavafx to javafx.fxml;
    exports com.example.projekt2_budzikjavafx;
}