
package ch.hearc.dice.gui.controlinput.display;

import javax.swing.Box;
import javax.swing.BoxLayout;

import ch.hearc.c_gui.tools.decorateur.center.JCenterH;
import ch.hearc.dice.gui.controlinput.display.jcomponent.jgraph.JGraphs;
import ch.hearc.dice.gui.controlinput.display.jcomponent.jprogressbar.JProgressBars;
import ch.hearc.dice.gui.utils.Settings;

public class JDisplay extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JDisplay()
		{
		super(BoxLayout.Y_AXIS);

		// Tools
			{
			//this.jTimer = new JTimer();
			this.jProgressBars = new JProgressBars();
			this.jGraphs = new JGraphs();
			}

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
		add(Box.createVerticalStrut(Settings.MARGE));
		//add(new JCenterH(this.jTimer));
		add(new JCenterH(this.jGraphs));
		add(new JCenterH(this.jProgressBars));
		add(Box.createVerticalStrut(Settings.MARGE));
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		// rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	//private JTimer jTimer;
	private JProgressBars jProgressBars;
	private JGraphs jGraphs;

	}
