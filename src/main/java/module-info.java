module com.example.mail_application_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mail_application_javafx to javafx.fxml;
    exports com.example.mail_application_javafx;
}