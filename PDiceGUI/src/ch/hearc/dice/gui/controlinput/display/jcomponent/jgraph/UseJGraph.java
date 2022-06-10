
package ch.hearc.dice.gui.controlinput.display.jcomponent.jgraph;

import ch.hearc.b_poo.j_thread.c_vecteurs.tools.Intervale;
import ch.hearc.c_gui.tools.decorateur.JFrameBaseLine;
import ch.hearc.dice.moo.implementation.DiceVariable;
import ch.hearc.dice.moo.implementation.DiceVariableInput;
import ch.hearc.dice.moo.implementation.TypeProcessing;
import ch.hearc.dice.moo.specification.DiceVariable_I;

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
		DiceVariable_I diceVariable = new DiceVariable(new DiceVariableInput(new Intervale(6, 100), 20000, TypeProcessing.PARALLEL));

		new JFrameBaseLine(new JGraphs(diceVariable));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
