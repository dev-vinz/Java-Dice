
package ch.hearc.dice.gui.controlinput.jinput.jcomponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import ch.hearc.c_gui.tools.Sizes;
import ch.hearc.dice.gui.controlinput.jinput.JInput;
import ch.hearc.dice.gui.utils.Settings;
import ch.hearc.dice.moo.implementation.TypeProcessing;

public class JTypeProcess extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JTypeProcess(JInput jInput)
		{
		super(BoxLayout.Y_AXIS);

		// Inputs
			{
			this.jInput = jInput;
			}

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		this.jRadioSequentialButton = new JRadioButton("Sequentiel");
		this.jRadioRunnableButton = new JRadioButton("Runnable");
		this.jRadioParallelButton = new JRadioButton("Parallel");
		this.jRadioParallelButton.setSelected(true);

		this.radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(jRadioSequentialButton);
		radioButtonGroup.add(jRadioRunnableButton);
		radioButtonGroup.add(jRadioParallelButton);

		add(Box.createVerticalStrut(Settings.MARGE));
		add(this.jRadioSequentialButton);
		add(Box.createVerticalStrut(Settings.MARGE));
		add(this.jRadioRunnableButton);
		add(Box.createVerticalStrut(Settings.MARGE));
		add(this.jRadioParallelButton);

		}

	private void control()
		{
		this.jRadioParallelButton.addActionListener(createActionListener(TypeProcessing.PARALLEL));
		this.jRadioRunnableButton.addActionListener(createActionListener(TypeProcessing.RUNNABLE));
		this.jRadioSequentialButton.addActionListener(createActionListener(TypeProcessing.SEQUENTIEL));
		}

	private void appearance()
		{
		setBorder(BorderFactory.createTitledBorder("Type Process"));
		Sizes.setHorizontal(jRadioSequentialButton, Settings.WIDTH);
		Sizes.setHorizontal(jRadioRunnableButton, Settings.WIDTH);
		Sizes.setHorizontal(jRadioParallelButton, Settings.WIDTH);
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private ActionListener createActionListener(TypeProcessing process)
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				JTypeProcess.this.jInput.setTypeProcess(process);
				}
			};
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Inputs
	private JInput jInput;

	//Tools
	private ButtonGroup radioButtonGroup;
	private JRadioButton jRadioSequentialButton;
	private JRadioButton jRadioRunnableButton;
	private JRadioButton jRadioParallelButton;

	}
