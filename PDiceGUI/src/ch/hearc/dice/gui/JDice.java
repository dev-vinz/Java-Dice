
package ch.hearc.dice.gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class JDice extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JDice()
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
	private void appearance()
		{
		this.logo = new JLabel("");
		this.logo.setIcon(ShopImage.HEARC);

		this.borderlayout = new BorderLayout();
		setLayout(this.borderlayout);

		add(this.logo, BorderLayout.SOUTH);
		}

	private void control()
		{
		// TODO Auto-generated method stub

		}

	private void geometry()
		{
		//this.borderlayout.setHgap(50);
		//this.borderlayout.setVgap(50);
		}
	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//tools
	private BorderLayout borderlayout;
	private JLabel logo;
	}

