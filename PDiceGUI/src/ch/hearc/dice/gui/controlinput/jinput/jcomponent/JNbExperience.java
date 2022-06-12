
package ch.hearc.dice.gui.controlinput.jinput.jcomponent;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ch.hearc.c_gui.tools.Sizes;
import ch.hearc.dice.gui.controlinput.jinput.JInput;
import ch.hearc.dice.gui.utils.Settings;
import ch.hearc.dice.moo.implementation.DiceVariableInput;

public class JNbExperience extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JNbExperience(JInput jInput)
		{
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

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		this.jSlider = new JSlider(1, DiceVariableInput.NB_EXPERIENCE);
		this.jSlider.setValue(DiceVariableInput.NB_EXPERIENCE);

		this.jLabel = new JLabel();
		this.gridLayout = new GridLayout(2, 1);

		setLayout(gridLayout);
		add(this.jLabel);
		add(this.jSlider);
		}

	private void control()
		{
		this.jLabel.setText(Integer.toString(jSlider.getValue()));

		jSlider.addChangeListener(new ChangeListener()
			{

			@Override
			public void stateChanged(ChangeEvent e)
				{
				int nbExperience = jSlider.getValue();
				onChanged(nbExperience);
				}
			});
		}

	private void appearance()
		{
		setBorder(BorderFactory.createTitledBorder("Number of experiment"));
		Sizes.setHorizontal(jSlider, Settings.BUTTON_WIDTH);
		}

	private void onChanged(int nbExperience)
		{
		this.jLabel.setText(Integer.toString(nbExperience));
		this.jInput.setNbExperience(nbExperience);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private JInput jInput;

	// Tools
	private JSlider jSlider;
	private JLabel jLabel;
	private GridLayout gridLayout;

	}
