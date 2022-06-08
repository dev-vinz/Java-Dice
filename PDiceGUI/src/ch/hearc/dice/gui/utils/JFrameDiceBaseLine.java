
package ch.hearc.dice.gui.utils;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import ch.hearc.c_gui.tools.decorateur.JFrameBaseLine;

public class JFrameDiceBaseLine extends JFrameBaseLine
	{

	public JFrameDiceBaseLine(JComponent jcomponent, ImageIcon imageIcon, Dimension minDimension, Dimension prefDimension)
		{
		super(jcomponent, imageIcon);
		this.setMinimumSize(minDimension);
		this.setMinimumSize(prefDimension);
		}

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

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

