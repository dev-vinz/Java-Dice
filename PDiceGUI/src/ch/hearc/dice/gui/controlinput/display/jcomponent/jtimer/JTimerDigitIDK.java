
package ch.hearc.dice.gui.controlinput.display.jcomponent.jtimer;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.hearc.tools.Chrono;

public class JTimerDigitIDK extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JTimerDigitIDK()
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
		this.jTime = new JLabel("002");
		this.jTitle = new JLabel("Chronomètre : ");

		this.flowlayout = new FlowLayout(FlowLayout.RIGHT);
		setLayout(this.flowlayout);

		add(this.jTitle);
		add(this.jTime);
		}

	private void control()
		{
		this.globalChrono = new Chrono();
		this.time = globalChrono.getTimeMS();
		}

	private void appearance()
		{
	    this.jTitle.setFont(clockFont);
	    this.jTime.setFont(clockFont);
	    this.jTitle.setOpaque(true);
	    this.jTime.setOpaque(true);
	    this.jTitle.setForeground(Color.BLACK);
	    this.jTitle.setBackground(Color.LIGHT_GRAY);
	    this.jTime.setForeground(Color.WHITE);
	    this.jTime.setBackground(Color.BLACK);

		//setBorder(BorderFactory.createTitledBorder("Number of faces"));
		//Sizes.setHorizontal(jSpinnerMin, Settings.BUTTON_WIDTH/2);
		//Sizes.setHorizontal(jSpinnerMax, Settings.BUTTON_WIDTH/2);
		//Sizes.setVertical(jSpinnerMin, Settings.BUTTON_HEIGHT);
		//Sizes.setVertical(jSpinnerMax, Settings.BUTTON_HEIGHT);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	Font clockFont = new Font("Tahoma", Font.BOLD, 21);

	//Tools
	private JLabel jTime;
	private JLabel jTitle;
	private FlowLayout flowlayout;
	private long time;
	private Chrono globalChrono;
	}


