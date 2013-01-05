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
	private Action tryAgainAction, newSetAction;

    public Completed(String stats)
    {
		tryAgainAction = new TryAgainAction();
		newSetAction = new NewSetAction();

        statsLabel.setText(stats);

		tryAgainButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("A"), "pressed");
		tryAgainButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "pressed");
		newSetButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), "pressed");
		newSetButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "pressed");

		tryAgainButton.getActionMap().put("pressed", tryAgainAction);
		newSetButton.getActionMap().put("pressed", newSetAction);

        tryAgainButton.addActionListener(tryAgainAction);
        newSetButton.addActionListener(newSetAction);
    }

    public JPanel getPanel1()
    {
        return panel1;
    }

	public class TryAgainAction extends AbstractAction
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Controller.tryAgainPressed();
		}
	}

	public class NewSetAction extends AbstractAction
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Controller.newSetPressed();
		}
	}
}
