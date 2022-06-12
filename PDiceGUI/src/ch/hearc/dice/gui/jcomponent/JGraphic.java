
package ch.hearc.dice.gui.jcomponent;

import javax.swing.JSplitPane;

import ch.hearc.dice.gui.controlinput.JRightComponent;
import ch.hearc.dice.gui.controlinput.display.JDisplay;

public class JGraphic extends JSplitPane
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JGraphic()
		{
		super(JSplitPane.HORIZONTAL_SPLIT);

		//tools
			{
			this.jdisplay = new JDisplay();
			this.jControlInput = new JRightComponent();
			}

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
		setLeftComponent(this.jdisplay);
		setRightComponent(this.jControlInput);
		}

	private void control()
		{
		setOneTouchExpandable(true);
		}

	private void appearance()
		{
		setDividerLocation(1000);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JRightComponent jControlInput;
	private JDisplay jdisplay;

	}

