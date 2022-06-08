
package ch.hearc.dice.gui.service;

import ch.hearc.dice.moo.implementation.DiceVariableInput;
import ch.hearc.dice.moo.specification.DiceVariable_I;

public class DiceVariableServiceEvent
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public DiceVariableServiceEvent(DiceVariableService source, DiceVariable_I curentDiceVariable, DiceVariableInput diceVariableInput, LifeCycle lifeCycle)
		{
		super();
		this.source = source;
		this.curentDiceVariable = curentDiceVariable;
		this.diceVariableInput = diceVariableInput;
		this.lifeCycle = lifeCycle;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public DiceVariableService getSource()
		{
		return this.source;
		}

	public DiceVariable_I getCurentDiceVariable()
		{
		return this.curentDiceVariable;
		}

	public DiceVariableInput getDiceVariableInput()
		{
		return this.diceVariableInput;
		}

	public LifeCycle getLifeCycle()
		{
		return this.lifeCycle;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs/Outputs
	private DiceVariableService source ; // inutile
	private DiceVariable_I curentDiceVariable;
	private DiceVariableInput diceVariableInput ;
	private LifeCycle lifeCycle ;

	}

