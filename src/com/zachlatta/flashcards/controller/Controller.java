package com.zachlatta.flashcards.controller;

import au.com.bytecode.opencsv.CSVReader;
import com.zachlatta.flashcards.model.Flashcard;
import com.zachlatta.flashcards.model.FlashcardSet;
import com.zachlatta.flashcards.view.FileChooser;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * The main controller class
 *
 * @author Zachary Latta
 */
public class Controller
{
    private static String csvPath = "File path";
    private static FlashcardSet flashcardSet = new FlashcardSet();

    public static void loadFlashcards(JFrame frame)
    {
        try
        {
            CSVReader reader = new CSVReader(new FileReader(csvPath));

            String[] line;

            for(int index = 0; (line = reader.readNext()) != null; index++)
            {
                flashcardSet.addFlashcard(new Flashcard(line[0], line[1]));
            }
        }
        catch(FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(
                    frame,
                    "No file found at " + csvPath,
                    "File Not Found",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(
                    frame,
                    "Unable to load from " + csvPath,
                    "Unable to Read From File",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void showFileChooser(Component parent)
    {
        FileChooser.show(parent);
    }

    public static void setCsvPath(String csvPath)
    {
        Controller.csvPath = csvPath;
    }
}
