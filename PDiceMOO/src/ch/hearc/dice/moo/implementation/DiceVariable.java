
package ch.hearc.dice.moo.implementation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ch.hearc.b_poo.j_thread.c_vecteurs.tools.Intervale;
import ch.hearc.dice.moo.specification.DiceVariable_I;
import ch.hearc.tools.Chrono;
import ch.hearc.tools.algo.AlgoIteratif_A;

public class DiceVariable extends AlgoIteratif_A implements DiceVariable_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public DiceVariable(DiceVariableInput diceVariableInputs)
		{
		// Inputs
			{
			this.diceVariableInput = diceVariableInputs;
			}

		// Outputs
			{
			this.mapFaceLancer = new HashMap<Integer, Integer>();
			this.mapFaceChrono = new HashMap<Integer, Chrono>();
			}

		// Tools
			{
			this.nbSteps = diceVariableInputs.getIntervalNbFace().getB() - diceVariableInputs.getIntervalNbFace().getA();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void iterationStep(int i)
		{
		int nbFace = getNbFaceAt(i);

		// Launch a dice
		Dice dice = new Dice(nbFace, getNbExperience(), this.diceVariableInput.getTypeProcessing());

		// Chronometer the run
		Chrono chrono = new Chrono();
		dice.run();
		chrono.stop();

		// Get the number of launches, and add it to HashMap
		int nbLancerMoyen = dice.getNbLancerMoyen();

		this.mapFaceLancer.put(nbFace, nbLancerMoyen);
		this.mapFaceChrono.put(nbFace, chrono);
		}

	@Override
	public boolean isFini(int i)
		{
		// V1
		//			{
		//			int nbFace = getNbFaceAt(i);
		//
		//			return this.mapFaceLancer.containsKey(nbFace);
		//			}

		// V2
			{
			return i >= this.nbSteps;
			}
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	@Override
	public Map<Integer, Integer> getMapFaceLancer()
		{
		return this.mapFaceLancer;
		}

	@Override
	public Map<Integer, Chrono> getMapFaceChrono()
		{
		return this.mapFaceChrono;
		}

	@Override
	public Intervale getNbFaces()
		{
		return this.diceVariableInput.getIntervalNbFace();
		}

	@Override
	public int getNbExperience()
		{
		return this.diceVariableInput.getNbExperience();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private int getNbFaceAt(int i)
		{
		// TODO : Trouver plus efficace
		// Get the number of face of the interval
		Iterator<Integer> iterator = getNbFaces().iterator();

		int nbFace = 0;
		int cpt = 0;

		while(iterator.hasNext() && cpt++ <= i)
			{
			nbFace = iterator.next();
			}

		return nbFace;
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private DiceVariableInput diceVariableInput;

	// Outputs
	private Map<Integer, Integer> mapFaceLancer;
	private Map<Integer, Chrono> mapFaceChrono;

	// Tools
	private int nbSteps;
	}
