package com.zachlatta.flashcards.view;

import com.zachlatta.flashcards.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Zachary Latta
 */
public class FileSelection
{
    private JPanel panel1;
    private JButton chooseAFileButton;
    private JButton openFileButton;
    private JLabel filePathLabel;

    public FileSelection()
    {
        chooseAFileButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Controller.chooseAFilePressed(panel1, filePathLabel);
            }
        });

        openFileButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Controller.openPressed();
            }
        });
    }

    public JPanel getPanel1()
    {
        return panel1;
    }

    public JButton getChooseAFileButton()
    {
        return chooseAFileButton;
    }

    public JButton getOpenFileButton()
    {
        return openFileButton;
    }

    public JLabel getFilePathLabel()
    {
        return filePathLabel;
    }
}
