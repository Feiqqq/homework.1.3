package ru.vulfert.homework.task.storage;

import ru.vulfert.homework.task.model.Note;

import java.util.List;

public interface Storage {
    void saveNote(String id, Note note);


    void updateNote(String id, Note note);


    List<Note> selectNote();


    void deleteNote(String id);
}
