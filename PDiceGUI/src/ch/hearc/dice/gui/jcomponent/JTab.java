
package ch.hearc.dice.gui.jcomponent;

import javax.swing.JTabbedPane;

import ch.hearc.dice.gui.about.JAbout;

public class JTab extends JTabbedPane
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JTab()
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
		// TODO Auto-generated method stub

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//tools
	private JAbout jAbout;
	private JGraphic jGraphic;
	}
