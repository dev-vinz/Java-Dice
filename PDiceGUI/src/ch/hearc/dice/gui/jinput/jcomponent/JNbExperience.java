
package ch.hearc.dice.gui.jinput.jcomponent;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JSlider;

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
		this.gridLayout = new GridLayout();
		setLayout(gridLayout);
		//add(new JCenter(this.jSlider)); Centre sur les coté aussi
		add(this.jSlider); //Prends toute la longueur de la fenetre
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
	private JSlider jSlider;
	private GridLayout gridLayout;
	}

