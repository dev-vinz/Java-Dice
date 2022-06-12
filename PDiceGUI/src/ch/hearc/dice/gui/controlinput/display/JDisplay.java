
package ch.hearc.dice.gui.controlinput.display;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import ch.hearc.c_gui.tools.decorateur.center.JCenter;
import ch.hearc.dice.gui.controlinput.display.jcomponent.jgraph.JGraphs;
import ch.hearc.dice.gui.controlinput.display.jcomponent.jprogressbar.JProgressBars;
import ch.hearc.dice.gui.controlinput.display.jcomponent.jtimer.JTimer;

public class JDisplay extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JDisplay()
		{
		// Tools
			{
			this.jTimer = new JTimer();
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
		setLayout(new BorderLayout());

		add(new JCenter(this.jTimer), BorderLayout.NORTH);
		add(new JCenter(this.jGraphs), BorderLayout.CENTER);
		add(new JCenter(this.jProgressBars), BorderLayout.SOUTH);
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
	private JTimer jTimer;
	private JProgressBars jProgressBars;
	private JGraphs jGraphs;

	}
