
package ch.hearc.dice.gui;

import javax.swing.JTabbedPane;

import ch.hearc.dice.gui.about.JAbout;
import ch.hearc.dice.gui.jcomponent.JGraphic;

/**
 * singleton
 */
public class JDice extends JTabbedPane
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private JDice()
		{
		geometry();
		control();
		appearance();
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static synchronized JDice getInstance()
		{
		if (instance == null)
			{
			instance = new JDice();
			}

		return instance;
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
		this.jGraphic = new JGraphic();
		this.jAbout = new JAbout();
		add("main", jGraphic);
		add("about", jAbout);
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

	// Outputs

	//tools
	private JAbout jAbout;
	private JGraphic jGraphic;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static JDice instance = null;

	}
