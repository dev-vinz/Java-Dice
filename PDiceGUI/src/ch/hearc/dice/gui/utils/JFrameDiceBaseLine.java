
package ch.hearc.dice.gui.utils;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import ch.hearc.c_gui.tools.decorateur.JFrameBaseLine;

public class JFrameDiceBaseLine extends JFrameBaseLine
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameDiceBaseLine(JComponent jcomponent, ImageIcon imageIcon, Dimension prefDimension)
		{
		super(jcomponent, imageIcon);
		this.setMinimumSize(new Dimension (800,800));
		this.setMinimumSize(prefDimension);
		this.setBounds(20, 20, prefDimension.width, prefDimension.height);
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

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	}

