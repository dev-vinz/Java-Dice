
package ch.hearc.dice.gui.controlinput.jinput.jcomponent;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import ch.hearc.c_gui.tools.decorateur.Sizes;
import ch.hearc.dice.gui.utils.Settings;

public class JNbFace extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JNbFace()
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
		SpinnerModel model = new SpinnerNumberModel(
				2, //valeur initiale
				0, //valeur minimum
				200, //valeur maximum
				1 //pas
		);

		//il faudra créer un moyen de mettre le minimum du jSpinnerMax à la valeur du jSpinnerMin
		this.jSpinnerMax = new JSpinner(model);
		this.jSpinnerMin = new JSpinner();

		this.gridLayout = new GridLayout(1, 2);
		setLayout(this.gridLayout);

		add(this.jSpinnerMin);
		add(this.jSpinnerMax);
		}

	private void control()
		{
		// TODO Auto-generated method stub

		}

	private void appearance()
		{
		setBorder(BorderFactory.createTitledBorder("Number of faces"));
		Sizes.setHorizontal(jSpinnerMin, Settings.BUTTON_WIDTH/2);
		Sizes.setHorizontal(jSpinnerMax, Settings.BUTTON_WIDTH/2);
		Sizes.setVertical(jSpinnerMin, Settings.BUTTON_HEIGHT);
		Sizes.setVertical(jSpinnerMax, Settings.BUTTON_HEIGHT);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Tools
	private JSpinner jSpinnerMin;
	private JSpinner jSpinnerMax;
	private GridLayout gridLayout;
	}
