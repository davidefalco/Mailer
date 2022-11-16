package com.example.mail_application_javafx;

import java.util.ArrayList;
import java.util.List;

public class Email {
    private String from;
    private List<String> to;
    private String message;
    private String obj;

    /**
     * Costruttore
     * @param sender email del mittente
     * @param receivers emails dei riceventi
     * @param message contenuto mail
     * @param obj oggetto della mail
     * */

    public Email(String sender, List<String> receivers, String message, String obj) {
        from = sender;
        to = new ArrayList<>(receivers);
        this.message = message;
        this.obj = obj;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public String getObj() {
        return obj;
    }

    @Override
    public String toString() {
        return from.toString() + " - " + obj.toString();
    }
}
