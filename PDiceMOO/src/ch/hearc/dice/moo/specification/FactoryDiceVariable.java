
package ch.hearc.dice.moo.specification;

import ch.hearc.dice.moo.implementation.DiceVariable;
import ch.hearc.dice.moo.implementation.DiceVariableInput;

public class FactoryDiceVariable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static DiceVariable_I create(DiceVariableInput diceVariableInput)
		{
		return new DiceVariable(diceVariableInput);
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
