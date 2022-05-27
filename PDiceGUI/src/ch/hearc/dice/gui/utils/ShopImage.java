package ch.hearc.dice.gui.utils;

import javax.swing.ImageIcon;

import ch.hearc.c_gui.tools.image.ImageLoader;

public class ShopImage
	{

	private static final String PATH_IN_JAR = "images/Dice/"; // conseil : specifier toujours le nom du projet, pour garantir l'uniciter!

	/*------------------------------------------------------------------*\
	|*		 Version Synchrone (bloquant)								*|
	\*------------------------------------------------------------------*/

	public static final ImageIcon HEARC = ImageLoader.loadSynchroneJar(PATH_IN_JAR + "HEARC.png");
	public static final ImageIcon JAVA = ImageLoader.loadSynchroneJar(PATH_IN_JAR + "java.png");
	public static final ImageIcon START = ImageLoader.loadSynchroneJar(PATH_IN_JAR + "start.png");
	public static final ImageIcon STOP = ImageLoader.loadSynchroneJar(PATH_IN_JAR + "stop.png");
	public static final ImageIcon KILL = ImageLoader.loadSynchroneJar(PATH_IN_JAR + "danger.png");
	public static final ImageIcon DICE20 = ImageLoader.loadSynchroneJar(PATH_IN_JAR + "dice.png");

	}
