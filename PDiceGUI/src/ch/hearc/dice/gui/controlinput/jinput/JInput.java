
package ch.hearc.dice.gui.controlinput.jinput;

import javax.swing.Box;
import javax.swing.BoxLayout;

import ch.hearc.c_gui.tools.decorateur.center.JCenterH;
import ch.hearc.dice.gui.controlinput.jinput.jcomponent.JNbExperience;
import ch.hearc.dice.gui.controlinput.jinput.jcomponent.JNbFace;
import ch.hearc.dice.gui.controlinput.jinput.jcomponent.JTypeProcess;

public class JInput extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/


	public JInput()
		{

		super(BoxLayout.Y_AXIS);

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/
	private void geometry()
		{
		this.jNbExperience = new JNbExperience();
		this.jNbFace = new JNbFace();
		this.jTypeProcess = new JTypeProcess();

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
		// TODO Auto-generated method stub

		}

	private void appearance()
		{
		// TODO Auto-generated method stub

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//tools
	private JNbExperience jNbExperience;
	private JNbFace jNbFace;
	private JTypeProcess jTypeProcess;
	}

