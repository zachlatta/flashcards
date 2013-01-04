package com.zachlatta.flashcards;

import com.zachlatta.flashcards.view.FileSelection;

import javax.swing.*;

/**
 * Start of the application.
 *
 * @author Zachary Latta
 */
public class Main
{
    public static JFrame frame;

    public static void main(String[] args)
    {
        frame = new JFrame("Flashcards");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLookAndFeel();

        frame.setContentPane(new FileSelection().getPanel1());
        frame.pack();
        frame.setVisible(true);
    }

    private static void setLookAndFeel()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }
}
