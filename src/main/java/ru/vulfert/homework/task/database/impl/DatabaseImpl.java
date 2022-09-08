package ru.vulfert.homework.task.database.impl;

import ru.vulfert.homework.task.model.Note;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Реализация паттерна (анти-паттерна) Singleton
 */
public enum DatabaseImpl {
    INSTANCE;

    private HashMap<String, Note> database = new HashMap<>();

    public void save(String id, Note note) {
        database.put(id, note);
    }

    public void update(String id, Note note) {
        database.replace(id, note);
    }

    public List<Note> select() {
        return new ArrayList<>(database.values());
    }

    public void delete(String id) {
        database.remove(id);
    }
}
