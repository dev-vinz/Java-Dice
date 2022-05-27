
package ch.hearc.dice.gui.jcomponent;

import javax.swing.JSplitPane;

import ch.hearc.dice.gui.controlinput.JControlInput;
import ch.hearc.dice.gui.controlinput.display.JDisplay;

public class JGraphic extends JSplitPane
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JGraphic()
		{
		super(JSplitPane.HORIZONTAL_SPLIT);

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
		this.jdisplay = new JDisplay();
		this.jControlInput = new JControlInput();

		setLeftComponent(this.jdisplay);
		setRightComponent(this.jControlInput);
		}

	private void control()
		{
		setOneTouchExpandable(true);
		}

	private void appearance()
		{
		setDividerLocation(200); //plus besoin car une taille min sur JControl
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private JControlInput jControlInput;
	private JDisplay jdisplay;

	}

