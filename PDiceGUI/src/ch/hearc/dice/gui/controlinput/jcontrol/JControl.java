
package ch.hearc.dice.gui.controlinput.jcontrol;

import javax.swing.Box;
import javax.swing.BoxLayout;

import ch.hearc.c_gui.tools.decorateur.center.JCenterH;
import ch.hearc.dice.gui.controlinput.jcontrol.jcomponent.JButtonKill;
import ch.hearc.dice.gui.controlinput.jcontrol.jcomponent.JButtonStart;
import ch.hearc.dice.gui.controlinput.jcontrol.jcomponent.JButtonStop;
import ch.hearc.dice.gui.utils.Settings;

public class JControl extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/


	public JControl()
		{

		super(BoxLayout.Y_AXIS);

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
		this.jButtonKill = new JButtonKill();
		this.jButtonStart = new JButtonStart();
		this.jButtonStop = new JButtonStop();

		add(jButtonKill);
		add(jButtonStart);
		add(jButtonStop);

		add(new JCenterH(this.jButtonStart));
		add(Box.createVerticalStrut(Settings.MARGE));
		add(new JCenterH(this.jButtonStop));
		add(Box.createVerticalStrut(Settings.MARGE));
		add(new JCenterH(this.jButtonKill));

		}

	private void control()
		{
		// TODO Auto-generated method stub

		}

	private void appearance()
		{
		// TODO Auto-generated method stub

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//tools
	private JButtonKill jButtonKill;
	private JButtonStart jButtonStart;
	private JButtonStop jButtonStop;
	}

