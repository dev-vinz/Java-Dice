
package ch.hearc.dice.gui.about;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import ch.hearc.c_gui.tools.Sizes;
import ch.hearc.c_gui.tools.decorateur.center.JCenter;
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

		this.jTextArea = new JTextArea();
		this.jLabelImage = new JLabel(ShopImage.HEARC);

		this.borderLayout = new BorderLayout();
		setLayout(borderLayout);

		add(new JCenter(this.jTextArea), BorderLayout.CENTER);
		add(this.jLabelImage, BorderLayout.SOUTH);

		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		this.jLabelImage.setOpaque(true);

		this.jTextArea.setEditable(false);
		this.jTextArea.setText("Projet présenté pour M. Bilat\nCours Java II \nPar Alessio Comi \nPar Vincent Jeannin");
		this.jTextArea.setFont(TEXT_FONT);
		this.jTextArea.setOpaque(false);

		Sizes.setHorizontal(jTextArea, 300);
		Sizes.setVertical(jTextArea, 100);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JTextArea jTextArea;
	private JLabel jLabelImage;

	private BorderLayout borderLayout;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final Font TEXT_FONT = new Font("Tahoma", Font.BOLD, 21);
	}
