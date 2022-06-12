
package ch.hearc.dice.gui.controlinput.jinput;

import javax.swing.Box;
import javax.swing.BoxLayout;

import ch.hearc.b_poo.j_thread.c_vecteurs.tools.Intervale;
import ch.hearc.c_gui.tools.decorateur.center.JCenterH;
import ch.hearc.dice.gui.controlinput.display.jcomponent.jtimer.JTimer;
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
			this.jTimer = new JTimer();
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
		add(jTimer);
		add(jNbExperience);
		add(jNbFace);
		add(jTypeProcess);

		int dy = 35;
		add(new JCenterH(this.jTimer));
		add(Box.createVerticalStrut(dy));
		add(new JCenterH(this.jNbExperience));
		add(Box.createVerticalStrut(dy));
		add(new JCenterH(this.jNbFace));
		add(Box.createVerticalStrut(dy));
		add(new JCenterH(this.jTypeProcess));
		add(Box.createVerticalStrut(dy));
		}

	private void control()
		{
		// Rien
		}

	private void appearance()
		{
		//rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JTimer jTimer;
	private JNbExperience jNbExperience;
	private JNbFace jNbFace;
	private JTypeProcess jTypeProcess;
	private DiceVariableInput diceVariableInput;

	}
