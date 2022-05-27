
package ch.hearc.dice.gui.jinput.jcomponent;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

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

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Tools
	private JSpinner jSpinnerMin;
	private JSpinner jSpinnerMax;
	private GridLayout gridLayout;
	}
