package com.zachlatta.flashcards.controller;

import au.com.bytecode.opencsv.CSVReader;
import com.zachlatta.flashcards.Main;
import com.zachlatta.flashcards.model.Flashcard;
import com.zachlatta.flashcards.model.FlashcardSet;
import com.zachlatta.flashcards.view.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * The main controller class
 *
 * @author Zachary Latta
 */
public class Controller
{
    private static String csvPath = "File path";
    private static int currentIndex = 0;
    private static FlashcardSet flashcardSet = new FlashcardSet();

    public static void reset()
    {
        csvPath = "File path";
        currentIndex = 0;
        flashcardSet = new FlashcardSet();
    }

    public static void loadFlashcards()
    {
        try
        {
            CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(csvPath), "UTF-16"));

            String[] line;

            while((line = reader.readNext()) != null)
            {
                flashcardSet.addFlashcard(new Flashcard(line[0], line[1]));
            }
        }
        catch(FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(
                    Main.frame,
                    "No file found at " + csvPath,
                    "File Not Found",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(
                    Main.frame,
                    "Unable to load from " + csvPath,
                    "Unable to Read From File",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void fileChosen(File file)
    {
        csvPath = file.getPath();
    }

    public static void showFileChooser(Component parent)
    {
        FileChooser.show(parent);
    }

    public static void updateFilePathLabel(JLabel filePathLabel)
    {
        filePathLabel.setText(csvPath);
    }

    public static void flipButtonPressed(Flashcard flashcard)
    {
        Main.frame.setContentPane(new DefinitionDisplay(flashcard).getPanel1());
        Main.frame.pack();
        Main.frame.invalidate();
    }

    public static void incorrectButtonPressed(Flashcard flashcard)
    {
        flashcard.setCorrect(false);
        displayFlashcard();
    }

    public static void correctButtonPressed(Flashcard flashcard)
    {
        flashcard.setCorrect(true);
        displayFlashcard();
    }

    public static void openPressed()
    {
        loadFlashcards();
        displayFlashcard();
    }

    public static void displayFlashcard()
    {
        int size = flashcardSet.size();

        if(currentIndex < size)
        {
            Main.frame.setContentPane(new TermDisplay(flashcardSet.getFlashcard(currentIndex)).getPanel1());
            Main.frame.pack();
            Main.frame.invalidate();

            currentIndex++;
        }
        else
        {
            displayCompleted();
        }
    }

    private static void displayCompleted()
    {
        Main.frame.setContentPane(new Completed(getStats()).getPanel1());
        Main.frame.pack();
        Main.frame.invalidate();
    }

    private static String getStats()
    {

        int total = flashcardSet.size();
        int correct = 0;

        for(int index = 0; index < flashcardSet.size(); index++)
        {
            if(flashcardSet.getFlashcard(index).isCorrect())
            {
                correct++;
            }
        }

        return correct + "/" + total + " (" + (double) Math.round((double) correct / (double) total * 10000) / 100 + "%)";
    }

    public static void chooseAFilePressed(Component parent, JLabel filePathLabel)
    {
        showFileChooser(parent);
        updateFilePathLabel(filePathLabel);

        Main.frame.pack();
        Main.frame.invalidate();
    }

    public static void tryAgainPressed()
    {
        currentIndex = 0;
        displayFlashcard();
    }

    public static void newSetPressed()
    {
        reset();

        Main.frame.setContentPane(new FileSelection().getPanel1());
        Main.frame.pack();
        Main.frame.invalidate();
    }
}
