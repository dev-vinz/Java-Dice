
package ch.hearc.dice.gui.controlinput.display.jcomponent.jtimer;

import ch.hearc.c_gui.tools.decorateur.JFrameBaseLine;
import ch.hearc.dice.gui.service.DiceVariableService;

public class UseJTimerAlone
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
		new JFrameBaseLine(new JTimer());
		DiceVariableService.getInstance().start();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}

