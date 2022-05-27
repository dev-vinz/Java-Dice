
package ch.hearc.dice.gui.jinput;

import java.awt.GridLayout;

import javax.swing.JPanel;

import ch.hearc.dice.gui.jinput.jcomponent.JNbExperience;
import ch.hearc.dice.gui.jinput.jcomponent.JNbFace;
import ch.hearc.dice.gui.jinput.jcomponent.JTypeProcess;

public class JInput extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/


	public JInput()
		{
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

		this.gridLayout = new GridLayout();
		setLayout(gridLayout);


		add(jNbExperience);
		add(jNbFace);
		add(jTypeProcess);

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
	private GridLayout gridLayout;
	}

