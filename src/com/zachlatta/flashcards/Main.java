package com.zachlatta.flashcards;

import com.zachlatta.flashcards.controller.Controller;
import com.zachlatta.flashcards.view.FileSelection;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Start of the application.
 *
 * @author Zachary Latta
 */
public class Main
{
    public static JFrame frame;
    public static Controller controller = new Controller();

    public static void main(String[] args)
    {
        frame = new JFrame("FileSelection");
        frame.setContentPane(new FileSelection().getPanel1());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
