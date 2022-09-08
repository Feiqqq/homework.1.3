package ru.vulfert.homework.task.storage.impl;

import ru.vulfert.homework.task.database.impl.DatabaseImpl;
import ru.vulfert.homework.task.model.Note;
import ru.vulfert.homework.task.storage.Storage;

import java.util.List;

public class StorageImpl implements Storage {

    /**
     * Реализация паттерна Адаптер через экземеляр
     */
    private DatabaseImpl database = DatabaseImpl.INSTANCE;

    public void saveNote(String id, Note note) {
        database.save(id, note);
    }

    public void updateNote(String id, Note note) {
        database.update(id, note);
    }

    public List<Note> selectNote() {
        return database.select();
    }

    public void deleteNote(String id) {
        database.delete(id);
    }
}
