package com.zachlatta.flashcards.view;

import com.zachlatta.flashcards.controller.CSVFileFilter;
import com.zachlatta.flashcards.controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * @author Zachary Latta
 */
public class FileChooser
{
    public static void show(Component parent)
    {
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setDialogTitle("Select the source CSV file");
        fileChooser.setFileFilter(new CSVFileFilter());

        int returnValue = fileChooser.showOpenDialog(parent);

        if(returnValue == JFileChooser.APPROVE_OPTION)
        {
            Controller.setCsvPath(fileChooser.getSelectedFile().getPath());
        }
    }
}
