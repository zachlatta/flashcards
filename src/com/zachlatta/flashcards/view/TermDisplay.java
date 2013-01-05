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
	private Action flipAction;

    public TermDisplay(Flashcard flashcard)
    {
        flipAction = new FlipAction(flashcard);

        termLabel.setText(flashcard.getTerm());

        flipCardButton.addActionListener(flipAction);
    }

    public JPanel getPanel1()
    {
        return panel1;
    }

	public class FlipAction extends AbstractAction
	{
		private Flashcard flashcard;

		public FlipAction(Flashcard flashcard)
		{
			this.flashcard = flashcard;
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			Controller.flipButtonPressed(flashcard);
		}
	}
}
