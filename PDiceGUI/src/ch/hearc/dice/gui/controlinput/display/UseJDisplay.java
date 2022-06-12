
package ch.hearc.dice.gui.controlinput.display;

import ch.hearc.c_gui.tools.decorateur.JFrameBaseLine;
import ch.hearc.dice.gui.service.DiceVariableService;

public class UseJDisplay
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
		new JFrameBaseLine(new JDisplay());
		DiceVariableService.getInstance().start();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
