
package ch.hearc.dice.gui.jinput.jcomponent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class JTypeProcess extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JTypeProcess()
		{
		super(BoxLayout.Y_AXIS);

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

		this.radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(jRadioSequentialButton);
		radioButtonGroup.add(jRadioRunnableButton);
		radioButtonGroup.add(jRadioParallelButton);

		final int DY = 15;

		add(Box.createVerticalStrut(DY));
		add(this.jRadioSequentialButton);
		add(Box.createVerticalGlue());
		add(this.jRadioRunnableButton);
		add(Box.createVerticalGlue());
		add(this.jRadioParallelButton);
		add(Box.createVerticalStrut(DY));
		}

	private void control()
		{
		// TODO Auto-generated method stub

		}

	private void appearance()
		{

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Tools
	private BoxLayout boxLayout;
	private ButtonGroup radioButtonGroup;
	private JRadioButton jRadioSequentialButton;
	private JRadioButton jRadioRunnableButton;
	private JRadioButton jRadioParallelButton;

	}
