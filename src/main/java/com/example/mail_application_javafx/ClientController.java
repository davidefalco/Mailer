package com.example.mail_application_javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class ClientController {
    @FXML
    private Label lbl_from;

    @FXML
    private Label lbl_to;

    @FXML
    private Label lbl_obj;

    @FXML
    private Label lbl_user;

    @FXML
    private TextArea txtarea_content;

    @FXML
    private ListView<Email> lst_emails;

    private Client model; /* Del mio controller fanno parte il client (Model) */
    private Email selectedEmail; /* Le mail selezionate (che devono essere mostrate nella text area)*/
    private Email emptyEmail;

    @FXML
    public void initialize(){
        if (this.model != null)
            throw new IllegalStateException("Model can only be initialized once");

        /* Istanza di un nuovo client */
        model = new Client("studente@unito.it");
        model.generateRandomMails(10);

        selectedEmail = null; /* Nessuna mail selezionata */

        // binding tra lst_emails e inboxProperty
        lst_emails.itemsProperty().bind(model.inboxProperty());
        lst_emails.setOnMouseClicked(this::showSelectedEmail);
        // lst_emails.setOnMouseClicked(e -> showSelectedEmail(e));
        lbl_user.textProperty().bind(model.mailAddress());


        emptyEmail = new Email("", List.of(""), "", "");

        updateDetailView(emptyEmail);
    }

    @FXML
    protected void onDeleteButtonClick() {
        model.removeMail(selectedEmail);
        updateDetailView(emptyEmail);
    }

    protected void showSelectedEmail(MouseEvent mouseEvent) {
        Email email = lst_emails.getSelectionModel().getSelectedItem();

        selectedEmail = email;
        updateDetailView(email);
    }

    /**
     * Aggiorna la vista con la mail selezionata
     */
    protected void updateDetailView(Email email) {
        if(email != null) {
            lbl_from.setText(email.getFrom());
            lbl_to.setText(String.join(", ", email.getTo()));
            lbl_obj.setText(email.getObj());
            txtarea_content.setText(email.getMessage());
        }
    }

}
