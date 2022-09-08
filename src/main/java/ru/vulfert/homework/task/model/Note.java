package ru.vulfert.homework.task.model;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Note {


    private Instant date;
    private String body;
    private String name;

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        final String PATTERN_FORMAT = "dd.MM.yyyy hh:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT).withZone(ZoneId.systemDefault());
        return "*************************\n"
                + formatter.format(date) + "\n" +
                name + "\n" +
                body + "\n" +
                "*************************";
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Note(Instant date, String name, String body) {
        this.date = date;
        this.name = name;
        this.body = body;
    }
}
