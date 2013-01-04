package com.zachlatta.flashcards.view;

import com.zachlatta.flashcards.controller.Controller;
import com.zachlatta.flashcards.model.Flashcard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Zachary Latta
 */
public class TermDisplay
{
    private JPanel panel1;
    private JLabel termLabel;
    private JButton flipCardButton;

    private Flashcard flashcard;

    public TermDisplay(Flashcard flashcard1)
    {
        this.flashcard = flashcard1;

        termLabel.setText(flashcard.getTerm());

        flipCardButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Controller.flipButtonPressed(flashcard);
            }
        });
    }

    public JPanel getPanel1()
    {
        return panel1;
    }
}
