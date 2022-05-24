
package ch.hearc.dice.moo.implementation.use;

import ch.hearc.dice.moo.implementation.Dice;
import ch.hearc.dice.moo.implementation.TypeProcessing;
import ch.hearc.tools.Chrono;

public class UseSpeedUp
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
		int nbFace = Integer.parseInt(System.getProperty("nbFace"));
		int nbExperience = Integer.parseInt(System.getProperty("nbExperience"));

		Dice sequentialDice = new Dice(nbFace, nbExperience, TypeProcessing.SEQUENTIEL);
		Dice parallelDice = new Dice(nbFace, nbExperience, TypeProcessing.PARALLEL);

		// Sequential
		Chrono chronoSequential = new Chrono();
		sequentialDice.run();
		chronoSequential.stop();

		// Parallel
		Chrono chronoParallel = new Chrono();
		parallelDice.run();
		chronoParallel.stop();

		// Display informations
		System.out.println("Nombre de core : " + Runtime.getRuntime().availableProcessors());
		System.out.println("Temps Sequentiel : " + chronoSequential);
		System.out.println("Temps Parall�le : " + chronoParallel);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
