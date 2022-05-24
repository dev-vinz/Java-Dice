
package ch.hearc.dice.moo.implementation.use;

import java.util.Map;

import ch.hearc.b_poo.j_thread.c_vecteurs.tools.Intervale;
import ch.hearc.dice.moo.implementation.DiceVariable;
import ch.hearc.dice.moo.implementation.DiceVariableInput;
import ch.hearc.dice.moo.implementation.TypeProcessing;

public class UseDiceVariable
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
		int min = 6;
		int max = 9;

		Intervale intervale = new Intervale(min, max + 1);
		DiceVariableInput input = new DiceVariableInput(intervale, Integer.MAX_VALUE / 100, TypeProcessing.PARALLEL);

		DiceVariable diceVariable = new DiceVariable(input);

		System.out.println("Start of run...");
		diceVariable.run();

		Map<Integer, Integer> mapLancer = diceVariable.getMapFaceLancer();

		System.out.println(mapLancer);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
