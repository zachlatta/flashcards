package com.zachlatta.flashcards.view;

import com.zachlatta.flashcards.controller.Controller;
import com.zachlatta.flashcards.model.Flashcard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Zachary Latta
 */
public class DefinitionDisplay
{
    private JPanel panel1;
    private JButton correctButton;
    private JButton incorrectButton;
    private JLabel definitionLabel;
	private Action correctAction, incorrectAction;

    public DefinitionDisplay(Flashcard flashcard)
    {
        correctAction = new CorrectAction(flashcard);
		incorrectAction = new IncorrectAction(flashcard);

        definitionLabel.setText(flashcard.getDefinition());

		correctButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("A"), "pressed");
		correctButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "pressed");
		incorrectButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), "pressed");
		incorrectButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "pressed");

		correctButton.getActionMap().put("pressed", correctAction);
		incorrectButton.getActionMap().put("pressed", incorrectAction);

        correctButton.addActionListener(correctAction);
        incorrectButton.addActionListener(incorrectAction);
    }

    public JPanel getPanel1()
    {
        return panel1;
    }

	public class CorrectAction extends AbstractAction
	{
		private Flashcard flashcard;

		public CorrectAction(Flashcard flashcard)
		{
			this.flashcard = flashcard;
		}

		public void actionPerformed(ActionEvent e)
		{
			Controller.correctButtonPressed(flashcard);
		}
	}

	public class IncorrectAction extends AbstractAction
	{
		private Flashcard flashcard;

		public IncorrectAction(Flashcard flashcard)
		{
			this.flashcard = flashcard;
		}

		public void actionPerformed(ActionEvent e)
		{
			Controller.incorrectButtonPressed(flashcard);
		}
	}
}
