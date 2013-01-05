package com.zachlatta.flashcards.view;

import com.zachlatta.flashcards.controller.Controller;

import javax.swing.*;
import java.awt.*;
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
	private Action chooseAction, openAction;

    public FileSelection()
	{
		chooseAction = new ChooseAction(panel1, filePathLabel);
		openAction = new OpenAction();

		openFileButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "pressed");
		openFileButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("S"), "pressed");
		openFileButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "pressed");

		openFileButton.getActionMap().put("pressed", openAction);

		chooseAFileButton.addActionListener(chooseAction);
		openFileButton.addActionListener(openAction);
	}

    public JPanel getPanel1()
    {
        return panel1;
    }

    public class ChooseAction extends AbstractAction
	{
		Component parent;
		JLabel filePathLabel;

		public ChooseAction(Component parent, JLabel filePathLabel)
		{
			this.parent = parent;
			this.filePathLabel = filePathLabel;
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			Controller.chooseAFilePressed(parent, filePathLabel);
		}
	}

	public class OpenAction extends AbstractAction
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Controller.openPressed();
		}
	}
}
