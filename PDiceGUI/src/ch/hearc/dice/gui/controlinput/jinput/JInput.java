
package ch.hearc.dice.gui.controlinput.jinput;

import javax.swing.Box;
import javax.swing.BoxLayout;

import ch.hearc.b_poo.j_thread.c_vecteurs.tools.Intervale;
import ch.hearc.c_gui.tools.decorateur.center.JCenterH;
import ch.hearc.dice.gui.controlinput.jinput.jcomponent.JNbExperience;
import ch.hearc.dice.gui.controlinput.jinput.jcomponent.JNbFace;
import ch.hearc.dice.gui.controlinput.jinput.jcomponent.JTypeProcess;
import ch.hearc.dice.gui.service.DiceVariableService;
import ch.hearc.dice.moo.implementation.DiceVariableInput;
import ch.hearc.dice.moo.implementation.TypeProcessing;

public class JInput extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JInput()
		{
		super(BoxLayout.Y_AXIS);

		// Tools
			{
			this.jNbExperience = new JNbExperience(this);
			this.jNbFace = new JNbFace(this);
			this.jTypeProcess = new JTypeProcess(this);

			this.diceVariableInput = new DiceVariableInput();
			}

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void setNbExperience(int nbExperience)
		{
		this.diceVariableInput.setNbExperience(nbExperience);
		DiceVariableService.getInstance().setInputs(this.diceVariableInput);
		}

	public void setNbFace(Intervale nbFace)
		{
		this.diceVariableInput.setIntervalNbFace(nbFace);
		DiceVariableService.getInstance().setInputs(this.diceVariableInput);
		}

	public void setTypeProcess(TypeProcessing typeProcessing)
		{
		this.diceVariableInput.setTypeProcessing(typeProcessing);
		DiceVariableService.getInstance().setInputs(this.diceVariableInput);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		add(jNbExperience);
		add(jNbFace);
		add(jTypeProcess);

		add(new JCenterH(this.jNbExperience));
		add(Box.createVerticalGlue());
		add(new JCenterH(this.jNbFace));
		add(Box.createVerticalGlue());
		add(new JCenterH(this.jTypeProcess));
		add(Box.createVerticalGlue());
		}

	private void control()
		{
		// Rien
		}

	private void appearance()
		{
		// Rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JNbExperience jNbExperience;
	private JNbFace jNbFace;
	private JTypeProcess jTypeProcess;
	private DiceVariableInput diceVariableInput;

	}
