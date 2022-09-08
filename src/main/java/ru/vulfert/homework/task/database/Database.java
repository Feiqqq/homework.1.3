package ru.vulfert.homework.task.database;

import ru.vulfert.homework.task.model.Note;

public interface Database {
    void save(String id, Note note);


    void update(String id, Note note);


    Note select(String id);


    void delete(String id);
}
