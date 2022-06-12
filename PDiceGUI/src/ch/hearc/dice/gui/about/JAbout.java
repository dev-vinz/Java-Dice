package ch.hearc.dice.gui.about;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
		this.jLabelText.setText(convertToMultiline("Projet présenté pour M. Bilat\nCour java2 \nPar Alessio Comi \nPar Vincent Jeannin"));
		this.jLabelText.setFont(TEXT_FONT);
		this.jLabelText.setHorizontalAlignment(SwingConstants.CENTER);
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

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final Font TEXT_FONT = new Font("Tahoma", Font.BOLD, 21);
	}
