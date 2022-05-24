
package ch.hearc.dice.moo.implementation.use;

import java.util.Map;

import ch.hearc.b_poo.j_thread.c_vecteurs.tools.Intervale;
import ch.hearc.dice.moo.implementation.DiceVariableInput;
import ch.hearc.dice.moo.implementation.TypeProcessing;
import ch.hearc.dice.moo.specification.DiceVariable_I;
import ch.hearc.dice.moo.specification.FactoryDiceVariable;
import ch.hearc.tools.algo.EtatAlgo;
import ch.hearc.tools.algo.IterationEvent;
import ch.hearc.tools.algo.IterationListener;

public class UseDiceVariableListener
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

		DiceVariable_I diceVariable = FactoryDiceVariable.create(input);
		diceVariable.addIterationListener(createListener());

		System.out.println("Start of run...");
		diceVariable.run();

		Map<Integer, Integer> mapLancer = diceVariable.getMapFaceLancer();

		System.out.println(mapLancer);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static IterationListener createListener()
		{
		return new IterationListener()
			{

			@Override
			public void iterationPerformed(IterationEvent iterationEvent)
				{
				String msg = "[" + iterationEvent.getEtatAlgo() + "]";

				if (iterationEvent.getEtatAlgo() == EtatAlgo.RUNNING)
					{
					msg += " : Traitement indice " + iterationEvent.getIndice();
					}

				System.out.println(msg);
				}
			};
		}
	}
