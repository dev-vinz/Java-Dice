package ch.hearc.dice.gui;

import java.awt.Dimension;

import ch.hearc.dice.gui.utils.JFrameDiceBaseLine;
import ch.hearc.dice.gui.utils.ShopImage;

public class UseJDice
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		new JFrameDiceBaseLine(JDice.getInstance(), ShopImage.DICE20,new Dimension(800,800), new Dimension(1200,800));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}

