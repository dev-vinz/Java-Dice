
package ch.hearc.dice.gui.controlinput.jinput.jcomponent;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ch.hearc.c_gui.tools.Sizes;
import ch.hearc.dice.gui.utils.Settings;

public class JNbExperience extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JNbExperience()
		{
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
		this.jSlider = new JSlider();
		this.jLabel = new JLabel();
		this.gridLayout = new GridLayout(2,1);
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
				jLabel.setText(Integer.toString(jSlider.getValue()));
				}
			});



		}


	private void appearance()
		{
		setBorder(BorderFactory.createTitledBorder("Number of experiment"));
		Sizes.setHorizontal(jSlider, Settings.BUTTON_WIDTH);

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Tools
	private JSlider jSlider;
	private JLabel jLabel;
	private GridLayout gridLayout;
	}

