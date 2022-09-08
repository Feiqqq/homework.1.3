package ru.vulfert.homework.task.service.impl;

import ru.vulfert.homework.task.model.Note;
import ru.vulfert.homework.task.service.NotebookService;
import ru.vulfert.homework.task.storage.Storage;
import ru.vulfert.homework.task.storage.impl.StorageImpl;

import java.util.List;
import java.util.UUID;

public class NotebookServiceImpl implements NotebookService {

    private final Storage storageImpl = new StorageImpl();

    @Override
    public String saveNote(Note note) {
        var id = UUID.randomUUID().toString();
        storageImpl.saveNote(id, note);
        return id;
    }

    @Override
    public void updateNote(String id, Note note) {
        storageImpl.updateNote(id, note);
    }

    @Override
    public List<Note> selectNote() {
        return storageImpl.selectNote();
    }

    @Override
    public void deleteNote(String id) {
        storageImpl.deleteNote(id);
    }
}
