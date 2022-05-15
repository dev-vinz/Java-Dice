
package ch.hearc.dice.moo.implementation;

import java.util.Map;

import ch.hearc.b_poo.j_thread.c_vecteurs.tools.Intervale;
import ch.hearc.dice.moo.specification.DiceVariable_I;
import ch.hearc.tools.Chrono;
import ch.hearc.tools.algo.IterationListener;

public class DiceVariable implements DiceVariable_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public DiceVariable(DiceVariableInput diceVariableInputs)
		{
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void stop()
		{
		// TODO Auto-generated method stub

		}

	@Override
	public void addIterationListener(IterationListener iterationListener)
		{
		// TODO Auto-generated method stub

		}

	@Override
	public void removeIterationListener(IterationListener iterationListener)
		{
		// TODO Auto-generated method stub

		}

	@Override
	public void iterationStep(int i)
		{
		// TODO Auto-generated method stub

		}

	@Override
	public boolean isFini(int i)
		{
		// TODO Auto-generated method stub
		return false;
		}

	@Override
	public void onBegin()
		{
		// TODO Auto-generated method stub

		}

	@Override
	public void onEnd()
		{
		// TODO Auto-generated method stub

		}

	@Override
	public void run()
		{
		// TODO Auto-generated method stub

		}

	@Override
	public Map<Integer, Integer> getMapFaceLancer()
		{
		// TODO Auto-generated method stub
		return null;
		}

	@Override
	public Map<Integer, Chrono> getMapFaceChrono()
		{
		// TODO Auto-generated method stub
		return null;
		}

	@Override
	public Intervale getNbFaces()
		{
		// TODO Auto-generated method stub
		return null;
		}

	@Override
	public int getNbExperience()
		{
		// TODO Auto-generated method stub
		return 0;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}
