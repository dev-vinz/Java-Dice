
package ch.hearc.dice.gui.controlinput.jcontrol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import ch.hearc.dice.gui.service.DiceVariableService;
import ch.hearc.dice.gui.service.DiceVariableServiceEvent;
import ch.hearc.dice.gui.service.DiceVariableServiceListener;
import ch.hearc.dice.gui.service.LifeCycle;
import ch.hearc.dice.gui.utils.Settings;
import ch.hearc.dice.gui.utils.ShopImage;

public class JControl extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/


	public JControl()
		{

		super(BoxLayout.X_AXIS);

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
		this.jButtonKill = new JButton();
		this.jButtonStart = new JButton();
		this.jButtonStop = new JButton();
		//this.jButtonKill = new JButtonKill();
		//this.jButtonStart = new JButtonStart();
		//this.jButtonStop = new JButtonStop();

//		add(jButtonKill);
//		add(jButtonStart);
//		add(jButtonStop);

		add(Box.createHorizontalGlue());
		add(this.jButtonStart);
		add(Box.createHorizontalGlue());
		add(Box.createHorizontalStrut(Settings.MARGE));
		add(this.jButtonStop);
		add(Box.createHorizontalGlue());
		add(Box.createHorizontalStrut(Settings.MARGE));
		add(this.jButtonKill);
		add(Box.createHorizontalGlue());

		}

	private void control()
		{
		this.jButtonKill.setEnabled(false);
		this.jButtonStart.setEnabled(true);
		this.jButtonStop.setEnabled(false);

		this.jButtonKill.addActionListener(createActionListenerKill());
		this.jButtonStart.addActionListener(createActionListenerStart());
		this.jButtonStop.addActionListener(createActionListenerStop());

		DiceVariableService.getInstance().addDiceVariableServiceListener(new DiceVariableServiceListener()
			{

			@Override
			public void diceVariableServicePerformed(DiceVariableServiceEvent diceVariableServiceEvent)
				{
				if (diceVariableServiceEvent.getLifeCycle() == LifeCycle.NATURAL_END)
					{
					inverserEtatButton();
					}
				}
			});
		}


	private ActionListener createActionListenerKill()
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				inverserEtatButton();
				DiceVariableService.getInstance().kill();
				}
			};
		}

	private ActionListener createActionListenerStart()
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				inverserEtatButton();
				DiceVariableService.getInstance().start();
				}
			};
		}

	private ActionListener createActionListenerStop()
		{
		return new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				//inverserEtatButton();
				DiceVariableService.getInstance().stop();
				}
			};
		}

	private void inverserEtatButton()
		{
		this.jButtonKill.setEnabled(!this.jButtonKill.isEnabled());
		this.jButtonStart.setEnabled(!this.jButtonStart.isEnabled());
		this.jButtonStop.setEnabled(!this.jButtonStop.isEnabled());
		}

	private void appearance()
		{
		jButtonKill.setIcon(ShopImage.KILL);
		jButtonStart.setIcon(ShopImage.START);
		jButtonStop.setIcon(ShopImage.STOP);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//tools
	private JButton jButtonKill;
	private JButton jButtonStart;
	private JButton jButtonStop;



	//private JButtonKill jButtonKill;
	//private JButtonStart jButtonStart;
	//private JButtonStop jButtonStop;
	}













