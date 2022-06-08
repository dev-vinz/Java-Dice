
package ch.hearc.dice.gui.controlinput.display;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import ch.hearc.c_gui.tools.decorateur.center.JCenter;
import ch.hearc.dice.gui.controlinput.display.jcomponent.JChronometre;

public class JDisplay extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JDisplay()
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
		this.jChronometre = new JChronometre();
		setLayout(new BorderLayout());

		add(new JCenter(this.jChronometre),BorderLayout.NORTH);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		// rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private JChronometre jChronometre;

	}
