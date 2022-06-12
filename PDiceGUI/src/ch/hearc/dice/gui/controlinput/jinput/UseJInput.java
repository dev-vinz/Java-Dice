
package ch.hearc.dice.gui.controlinput.jinput;

import java.awt.Dimension;

import ch.hearc.dice.gui.service.DiceVariableService;
import ch.hearc.dice.gui.utils.JFrameDiceBaseLine;
import ch.hearc.dice.gui.utils.ShopImage;

public class UseJInput
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		new JFrameDiceBaseLine(new JInput(),ShopImage.DICE20, new Dimension(200,200), new Dimension(200,200));
		DiceVariableService.getInstance().start();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}

