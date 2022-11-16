package com.example.mail_application_javafx;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Client {
    /**
     * Il client è il mio model. Il client gestisce le mail in arrivo
     * in una listView da cui è possibile selezionare quella che si vuole
     * leggere in una textArea. Il client mostra i dati della mail (from, to, object)
     * e l'indirizzo del proprietario della casella.
     * Avro bisogno quindi:
     * di una proprietà per le mail inbox
     * di una per il loro contenuto
     * di una per mostrare la mail del proprietario
     */

    private StringProperty mailAddress;
    private ListProperty<Email> inbox;
    private ObservableList<Email> inboxContent;

    public Client(String emailAddress){
        this.mailAddress = new SimpleStringProperty(emailAddress);
        this.inboxContent = FXCollections.observableList(new LinkedList<>());
        /* Ho scelto di gestire la lista del contenuto delle mail con una linked list. */
        this.inbox = new SimpleListProperty<>();
        this.inbox.set(inboxContent);
    }

    public ListProperty<Email> inboxProperty(){
        return this.inbox;
    }

    public StringProperty mailAddress(){
        return this.mailAddress;
    }

    public void removeMail(Email mailToRemove){
        this.inboxContent.remove(mailToRemove);
    }

    /* Dovrà prendere mail dal server */
    public void generateRandomMails(int n){
        String[] people = new String[] {"Paolo", "Alessandro", "Enrico", "Giulia", "Gaia", "Simone"};
        String[] subjects = new String[] {
                "Importante", "A proposito della nostra ultima conversazione", "Tanto va la gatta al lardo",
                "Non dimenticare...", "Domani scuola" };
        String[] texts = new String[] {
                "È necessario che ci parliamo di persona, per mail rischiamo sempre fraintendimenti",
                "Ricordati di comprare il latte tornando a casa",
                "L'appuntamento è per domani alle 9, ci vediamo al solito posto",
                "Ho sempre pensato valesse 42, tu sai di cosa parlo"
        };
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            Email email = new Email(
                    people[r.nextInt(people.length)],
                    List.of(people[r.nextInt(people.length)]),
                    texts[r.nextInt(texts.length)],
                    subjects[r.nextInt(subjects.length)]);
            inboxContent.add(email);
        }
    }


}
