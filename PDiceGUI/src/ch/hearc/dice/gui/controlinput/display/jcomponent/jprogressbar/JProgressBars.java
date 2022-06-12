
package ch.hearc.dice.gui.controlinput.display.jcomponent.jprogressbar;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class JProgressBars extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JProgressBars()
		{
		// Tools
			{
			this.jProgressFace = new JProgressBarFace();
			this.jProgressGlobal = new JProgressBarGlobal();
			this.gridLayout = new GridLayout(-1, 1);
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
		setLayout(this.gridLayout);

		add(this.jProgressFace);
		add(this.jProgressGlobal);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		// rien
		this.setBackground(Color.YELLOW);
		this.gridLayout.setVgap(10);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private GridLayout gridLayout;
	private JProgressBarFace jProgressFace;
	private JProgressBarGlobal jProgressGlobal;

	}
