
package ch.hearc.dice.gui.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.jupiter.api.Assertions;

import ch.hearc.dice.moo.implementation.DiceVariableInput;
import ch.hearc.dice.moo.specification.DiceVariable_I;
import ch.hearc.dice.moo.specification.FactoryDiceVariable;
import ch.hearc.tools.algo.EtatAlgo;
import ch.hearc.tools.algo.IterationEvent;
import ch.hearc.tools.algo.IterationListener;

public class DiceVariableService
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	private DiceVariableService()
		{
		// Tools
			{
			this.listDiceVariableServiceListener = new ArrayList<>();
			this.isStarted = new AtomicBoolean(false);
			this.diceVariableInput = new DiceVariableInput();
			this.currentDiceVariable = FactoryDiceVariable.create(diceVariableInput);
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public static synchronized DiceVariableService getInstance()
		{
		if (instance == null)
			{
			instance = new DiceVariableService();
			}

		return instance;
		}

	public DiceVariable_I getCurrentDiceVariable()
		{
		return currentDiceVariable;
		}

	/**
	* use by JInputs every time a input change
	*/
	public void setInputs(DiceVariableInput diceVariableInput)
		{
		this.diceVariableInput = diceVariableInput;
		}

	/*------------------------------------------------------------------*\
	|* 						start/stop/kill 							*|
	\*------------------------------------------------------------------*/

	public synchronized DiceVariable_I start() // called by buttonStart
		{
		Assertions.assertTrue(diceVariableInput != null);

		if (!isStarted.get())
			{
			this.currentDiceVariable = FactoryDiceVariable.create(diceVariableInput);
			this.thread = new Thread(this.currentDiceVariable);
			thread.start();

			DiceVariableServiceEvent event = new DiceVariableServiceEvent(instance, currentDiceVariable, diceVariableInput, LifeCycle.CREATED_STARTED);
			avertirDiceVariableListener(event);

			this.currentDiceVariable.addIterationListener(new IterationListener()
				{

				@Override
				public void iterationPerformed(IterationEvent iterationEvent)
					{
					if (iterationEvent.getEtatAlgo() == EtatAlgo.END)
						{
						isStarted.set(false);
						}
					}
				});

			return this.currentDiceVariable;
			}
		else
			{
			System.out.println("[ERROR] DiceVariableService : Dice already started");

			return null;
			}
		}

	public synchronized void stop() // called by buttonStop
		{
		if (isStarted.get())
			{
			this.currentDiceVariable.stop();

			DiceVariableServiceEvent event = new DiceVariableServiceEvent(instance, currentDiceVariable, diceVariableInput, LifeCycle.STOPPED);
			avertirDiceVariableListener(event);

			this.isStarted.set(false);
			}
		else
			{
			System.out.println("[ERORR] DiceVariableService : Dice already stopped");
			}
		}

	public synchronized void kill() // called by buttonKill
		{
		if (isStarted.get())
			{
			this.thread.stop();

			DiceVariableServiceEvent event = new DiceVariableServiceEvent(instance, currentDiceVariable, diceVariableInput, LifeCycle.KILLED);
			avertirDiceVariableListener(event);

			this.isStarted.set(false);
			}
		else
			{
			System.out.println("[ERROR] DiceVariableService : Dice already killed");
			}
		}

	/*------------------------------------------------------------------*\
	|* 							listener								*|
	\*------------------------------------------------------------------*/

	public synchronized void addDiceVariableServiceListener(DiceVariableServiceListener diceVariableServiceListener)
		{
		this.listDiceVariableServiceListener.add(diceVariableServiceListener);
		}

	public synchronized void removeDiceVariableServiceListener(DiceVariableServiceListener diceVariableServiceListener)
		{
		this.listDiceVariableServiceListener.remove(diceVariableServiceListener);
		}

	private synchronized void avertirDiceVariableListener(DiceVariableServiceEvent diceVariableEvent)
		{
		for(DiceVariableServiceListener diceVariableServiceListener:listDiceVariableServiceListener)
			{
			diceVariableServiceListener.diceVariableServicePerformed(diceVariableEvent);
			}
		}

	/*------------------------------------------------------------------*\
	|* 							Attributs 								*|
	\*------------------------------------------------------------------*/

	// Tools
	private DiceVariable_I currentDiceVariable;
	private List<DiceVariableServiceListener> listDiceVariableServiceListener;
	private AtomicBoolean isStarted;
	private Thread thread;

	// Inputs
	private DiceVariableInput diceVariableInput;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static DiceVariableService instance = null;

	}
