
package ch.hearc.dice.gui.controlinput.display.jcomponent.jgraph;

import ch.hearc.c_gui.tools.decorateur.JFrameBaseLine;
import ch.hearc.dice.gui.service.DiceVariableService;

public class UseJGraph
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
		new JFrameBaseLine(new JGraphs());
		DiceVariableService.getInstance().start();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
