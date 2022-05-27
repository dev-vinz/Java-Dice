
package ch.hearc.dice.gui.controlinput;

import javax.swing.Box;
import javax.swing.BoxLayout;

import ch.hearc.c_gui.tools.decorateur.center.JCenterH;
import ch.hearc.dice.gui.controlinput.jcontrol.JControl;
import ch.hearc.dice.gui.controlinput.jinput.JInput;
import ch.hearc.dice.gui.utils.Settings;

public class JControlInput extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/


	public JControlInput()
		{

		super(BoxLayout.Y_AXIS);

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
		this.jControl = new JControl();
		this.jInput = new JInput();

		add(jControl);
		add(jInput);

		add(Box.createVerticalStrut(Settings.MARGE));
		add(new JCenterH(this.jInput));
		add(Box.createVerticalStrut(Settings.MARGE));
		add(new JCenterH(this.jControl));
		add(Box.createVerticalStrut(Settings.MARGE));
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
	private JControl jControl;
	private JInput jInput;
	}


