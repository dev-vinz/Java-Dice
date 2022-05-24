
package ch.hearc.dice.moo.implementation;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.Assertions;

public class Experience implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Experience(int nbFaces)
		{
		// Inputs
			{
			this.nbFaces = nbFaces;
			}

		// Outputs
			{
			this.nbLancer = 0;
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		Set<Integer> setFaces = new HashSet<Integer>();
		this.nbLancer = 0;

		do
			{
			int random = getRandom(nbFaces);

			setFaces.add(random);

			this.nbLancer++;

			} while(setFaces.size() < nbFaces);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public int getNbLancer()
		{
		return this.nbLancer;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * Gets a random number between min and max
	 * @param min The minimum - include
	 * @param max The maximum - exclude
	 * @return The random number
	 */
	private static int getRandom(int min, int max)
		{
		double random01 = ThreadLocalRandom.current().nextDouble();
		int random = min + (int)(random01 * (max - min));

		Assertions.assertTrue(random >= min && random < max);

		return random;
		}

	/**
	 * Gets a random  number between 0 and max
	 * @param max The maximum - exclude
	 * @return The random number
	 */
	private static int getRandom(int max)
		{
		return getRandom(0, max);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private int nbFaces;

	// Outputs
	private int nbLancer;
	}
