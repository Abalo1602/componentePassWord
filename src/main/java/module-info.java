module com.example.componentepassword {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.componentepassword to javafx.fxml;
    exports com.example.componentepassword;
}