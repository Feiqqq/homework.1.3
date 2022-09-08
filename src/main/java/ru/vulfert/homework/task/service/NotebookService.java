package ru.vulfert.homework.task.service;

import ru.vulfert.homework.task.model.Note;

import java.util.List;

public interface NotebookService {

    String saveNote(Note note);

    void updateNote(String id, Note note);

    List<Note> selectNote();

    void deleteNote(String id);

}
