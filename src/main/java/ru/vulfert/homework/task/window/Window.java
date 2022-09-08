package ru.vulfert.homework.task.window;

import ru.vulfert.homework.task.model.Note;
import ru.vulfert.homework.task.service.NotebookService;
import ru.vulfert.homework.task.service.impl.NotebookServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class Window extends JFrame {
    private final NotebookService service = new NotebookServiceImpl();

    private final JTextArea inputName = new JTextArea(4, 50);
    private final JTextArea inputBody = new JTextArea(4, 50);


    public Window() {
        super("Notebook");
        this.setBounds(400, 400, 400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inputName.setLineWrap(true);
        inputBody.setLineWrap(true);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 1, 2, 2));
        JLabel labelInputText = new JLabel("Enter a note name: ");
        container.add(labelInputText);
        container.add(inputName);
        JLabel labelInputWordForSearch = new JLabel("Enter a body: ");
        container.add(labelInputWordForSearch);
        container.add(inputBody);
        JButton buttonReplace = new JButton("Save");
        buttonReplace.addActionListener(new ButtonEventListenerForSave());
        JButton buttonShow = new JButton("Show all: ");
        buttonShow.addActionListener(new ButtonEventListenerForShow());
        container.add(buttonReplace);
        container.add(buttonShow);
    }

    class ButtonEventListenerForSave implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder saved = new StringBuilder();
            var name = inputName.getText().trim();
            var body = inputBody.getText().trim();
            if (!name.isEmpty() && !body.isEmpty()) {
                saved.append("Saved with id: ").append(service.saveNote(new Note(Instant.now(), name, body)));
            } else {
                saved.append("Input field should be not empty");
            }
            JOptionPane.showMessageDialog(null, saved, "Saved", JOptionPane.PLAIN_MESSAGE);
        }
    }

    class ButtonEventListenerForShow implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder list = new StringBuilder();
            var notes = service.selectNote();
            if (!notes.isEmpty()) {
                notes.forEach(it -> list.append(it).append("\n"));
            } else {
                list.append("Not found!");
            }

            JOptionPane.showMessageDialog(null, list, "Saved", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
