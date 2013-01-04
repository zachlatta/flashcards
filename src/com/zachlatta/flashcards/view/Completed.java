package com.zachlatta.flashcards.view;

import com.zachlatta.flashcards.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Zachary Latta
 */
public class Completed
{
    private JPanel panel1;
    private JButton tryAgainButton;
    private JButton newSetButton;
    private JLabel statsLabel;

    public Completed(String stats)
    {
        statsLabel.setText(stats);

        tryAgainButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Controller.tryAgainPressed();
            }
        });

        newSetButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Controller.newSetPressed();
            }
        });
    }

    public JPanel getPanel1()
    {
        return panel1;
    }
}
