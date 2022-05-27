
package ch.hearc.dice.gui.controlinput.jcontrol.jcomponent;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import ch.hearc.c_gui.tools.decorateur.Sizes;
import ch.hearc.dice.gui.utils.Settings;
import ch.hearc.dice.gui.utils.ShopImage;

public class JButtonKill extends JPanel
	{


	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JButtonKill()
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
		this.button = new JButton();
		this.gridLayout = new GridLayout();
		setLayout(gridLayout);
		add(this.button);
		}


	private void control()
		{
		// rien
		}

	private void appearance()
		{
		button.setIcon(ShopImage.KILL);
		Sizes.setHorizontal(button, Settings.BUTTON_WIDTH);
		Sizes.setVertical(button, Settings.BUTTON_HEIGHT);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JButton button;
	private GridLayout gridLayout;
	}


