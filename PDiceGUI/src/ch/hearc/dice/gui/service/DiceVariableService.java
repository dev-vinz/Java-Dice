
package ch.hearc.dice.gui.service;

import java.util.concurrent.atomic.AtomicBoolean;

import com.sun.tools.javac.util.List;

import ch.hearc.dice.moo.implementation.DiceVariable;
import ch.hearc.dice.moo.implementation.DiceVariableInput;
import ch.hearc.dice.moo.specification.DiceVariable_I;

public class DiceVariableService
	{
	...

	public static synchronized DiceVariableService getInstance()
		{
		...
		}

	public DiceVariable_I getCurentDiceVariable()
		{
		return curentDiceVariable;
		}

	/**
	* use by JInputs every time a input change
	*/
	public void setInputs(DiceVariableInput diceVariableInput)
		{
		this.diceVariableInput= diceVariableInput :
		}

	/*------------------------------------------------------------------*\
	|* start/stop/kill *|
	\*------------------------------------------------------------------*/

	public synchronized DiceVariable_I start() // called by buttonStart
		{
		Assertions.assertTrue(diceVariableInput != null);
		if (!isStarted.get())
			{
			this.curentDiceVariable = FactoryDiceVariable.create(diceVariableInput);
			// TODO démarer un thread qui execute l’algo (attribut tools)
			// TODO call avertirDiceVariableListener
			// TODO metrre un listener sur l’algo pour changer le flag isStarted à la fin de l’algo
			return this.curentDiceVariable;
			}
		// TODO else // message d’erreur
		}

	public synchronized void stop() // called by buttonStop
		{
		if (isStarted.get())
			{
			// TODO arreter l’ago proprement avec la méthode stop de AlgoIteratif_A
			// TODO call avertirDiceVariableListener
			this.isStarted.set(false);
			}
		// TODO else // message d’erreur
		}

	public synchronized void kill() // called by buttonKill
		{
		if (isStarted.get())
			{
			// TODO, arreter brutalement et immediatement l’algo,
			// en stopant le thread
			// TODO call avertirDiceVariableListener
			this.isStarted.set(false);
			}
		// TODO else // message d’erreur
		}

	/*------------------------------------------------------------------*\
	|* listener *|
	\*------------------------------------------------------------------*/
	public synchronized void addDiceVariableServiceListener(DiceVariableServiceListener diceVariableServiceListener)
		{
		this.listDiceVariableServiceListener.add(diceVariableServiceListener);
		}

	public synchronized void removeDiceVariableServiceListener(DiceVariableServiceListener diceVariableServiceListener)
		{
		this.listDiceVariableServiceListener.remove(diceVariableServiceListener);
		}

	private synchronized void avertirDiceVariableListener(DiceVariableEvent diceVariableEvent)
		{
		// TODO foreach sur listDiceVariableServiceListener
		}

	/*------------------------------------------------------------------*\
	|* Attributs *|
	\*------------------------------------------------------------------*/
	// Tools
	private DiceVariable_I diceVariableCurrent;
	private List<DiceVariableServiceListener> listDiceVariableServiceListener;
	private AtomicBoolean isStarted;
	private Thread thread;
	// Inputs
	private DiceVariableInput diceVariableInput;

	}
