
package ch.hearc.dice.gui.service;

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

	public static synchronized DiceVariableService getInstance()
		{
		if (instance == null)
			{
			instance = new DiceVariableService();
			}

		return instance;
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
			this.curentDiceVariable = FactoryDiceVariable.create(diceVariableInput);
			this.thread = new Thread(this.curentDiceVariable);
			thread.start();

			DiceVariableServiceEvent event = new DiceVariableServiceEvent(instance, curentDiceVariable, diceVariableInput, LifeCycle.CREATED_STARTED);
			avertirDiceVariableListener(event);

			this.curentDiceVariable.addIterationListener(new IterationListener()
				{

				@Override
				public void iterationPerformed(IterationEvent iterationEvent)
					{
					if(iterationEvent.getEtatAlgo()==EtatAlgo.END)
						{
						isStarted.set(false);
						}
					}
				});

			return this.curentDiceVariable;
			}
		// TODO else // message d’erreur

		return curentDiceVariable;
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
	private DiceVariable_I curentDiceVariable;
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
