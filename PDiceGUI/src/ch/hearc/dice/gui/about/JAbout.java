package ch.hearc.dice.gui.about;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.hearc.dice.gui.utils.ShopImage;

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

		this.jLabelText = new JLabel();
		this.jLabelImage = new JLabel(ShopImage.HEARC);


		this.borderLayout = new BorderLayout();
		setLayout(borderLayout);

		add(this.jLabelText,BorderLayout.CENTER);
		add(this.jLabelImage,BorderLayout.SOUTH);

		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		this.jLabelImage.setOpaque(true);
		this.jLabelText.setText(convertToMultiline("Projet présenté pour M. Bilat\ndans le cadre du cour java \nPar Alessio Comi \nPar Vinceant Jeannin"));
		this.borderLayout.setHgap(50);
		this.borderLayout.setVgap(50);
		}

	private String convertToMultiline(String string)
		{
		return "<html>" + string.replaceAll("\n", "<br>");
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JLabel jLabelText;
	private JLabel jLabelImage;

	private BorderLayout borderLayout;

	}
