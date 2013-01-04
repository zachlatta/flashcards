package com.zachlatta.flashcards.view;

import com.zachlatta.flashcards.controller.Controller;
import com.zachlatta.flashcards.model.Flashcard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Zachary Latta
 */
public class DefinitionDisplay
{
    private JPanel panel1;
    private JButton correctButton;
    private JButton incorrectButton;
    private JLabel definitionLabel;

    private Flashcard flashcard;

    public DefinitionDisplay(Flashcard flashcard1)
    {
        this.flashcard = flashcard1;

        definitionLabel.setText(flashcard.getDefinition());

        correctButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Controller.correctButtonPressed(flashcard);
            }
        });

        incorrectButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Controller.incorrectButtonPressed(flashcard);
            }
        });
    }

    public JPanel getPanel1()
    {
        return panel1;
    }
}
