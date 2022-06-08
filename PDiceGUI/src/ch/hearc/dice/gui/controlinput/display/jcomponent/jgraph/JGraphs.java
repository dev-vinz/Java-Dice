
package ch.hearc.dice.gui.controlinput.display.jcomponent.jgraph;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class JGraphs extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JGraphs()
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
		this.gridLayout = new GridLayout(-1, 1);
		setLayout(this.gridLayout);

		add(new JGraphLancerMoyen());
		add(new JGraphDuration());
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		setBackground(Color.GREEN);

		this.gridLayout.setVgap(10);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private GridLayout gridLayout;

	}
