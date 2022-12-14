
package ch.hearc.dice.moo.implementation;

import ch.hearc.b_poo.j_thread.c_vecteurs.tools.Intervale;

public class DiceVariableInput
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public DiceVariableInput(Intervale intervalNbFace, int nbExperience, TypeProcessing typeProcessing)
		{
		this.intervalNbFace = intervalNbFace;
		this.nbExperience = nbExperience;
		this.typeProcessing = typeProcessing;
		}

	public DiceVariableInput()
		{
		this(new Intervale(NB_FACE_MIN, NB_FACE_MAX + 1), NB_EXPERIENCE, TYPE_PROCESSING);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public Intervale getIntervalNbFace()
		{
		return this.intervalNbFace;
		}

	public int getNbExperience()
		{
		return this.nbExperience;
		}

	public TypeProcessing getTypeProcessing()
		{
		return this.typeProcessing;
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setIntervalNbFace(Intervale intervalNbFace)
		{
		this.intervalNbFace = intervalNbFace;
		}

	public void setNbExperience(int nbExperience)
		{
		this.nbExperience = nbExperience;
		}

	public void setTypeProcessing(TypeProcessing typeProcessing)
		{
		this.typeProcessing = typeProcessing;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs et Outputs
	private Intervale intervalNbFace; // [a,b[
	private int nbExperience;
	private TypeProcessing typeProcessing;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static final int NB_FACE_MIN = 6;
	public static final int NB_FACE_MAX = 200;
	public static final int NB_EXPERIENCE = Integer.MAX_VALUE / 100;
	public static final TypeProcessing TYPE_PROCESSING = TypeProcessing.PARALLEL;
	}
