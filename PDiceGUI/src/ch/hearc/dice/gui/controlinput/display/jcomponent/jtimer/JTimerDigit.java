
package ch.hearc.dice.gui.controlinput.display.jcomponent.jtimer;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import ch.hearc.tools.Utils;

public class JTimerDigit extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JTimerDigit()
		{
		super(BoxLayout.X_AXIS);

		// Tools
			{
			this.jLabel = new JLabel();
			}

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void setTime(int h, int m, int s)
	{
	StringBuilder sBuilder = new StringBuilder();
	sBuilder.append(Utils.toTwoDigitsString(h));
	sBuilder.append(".");
	sBuilder.append(Utils.toTwoDigitsString(m));
	sBuilder.append(".");
	sBuilder.append(Utils.toTwoDigitsString(s));

	this.jLabel.setText(sBuilder.toString());
	}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		add(this.jLabel);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
	    this.jLabel.setFont(CLOCK_FONT);
	    this.jLabel.setOpaque(true);
	    this.jLabel.setForeground(Color.WHITE);
	    this.jLabel.setBackground(Color.BLACK);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JLabel jLabel;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final Font CLOCK_FONT = new Font("Tahoma", Font.BOLD, 21);
	}
