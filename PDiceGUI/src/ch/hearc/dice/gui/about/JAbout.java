package ch.hearc.dice.gui.about;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class JAbout extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JAbout()
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
		this.jLabelText = new JLabel("Java DICE");
		this.jLabelImage = new JLabel("HE-ARC");

		this.borderLayout = new BorderLayout();
		setLayout(borderLayout);

		add(jLabelText,BorderLayout.CENTER);
		add(jLabelImage,BorderLayout.SOUTH);

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

	// Tools
	private JLabel jLabelText;
	private JLabel jLabelImage;
	private BorderLayout borderLayout;

	}
