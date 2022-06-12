
package ch.hearc.dice.gui.controlinput.display.jcomponent.jprogressbar;

import javax.swing.JProgressBar;

import ch.hearc.dice.gui.service.DiceVariableService;
import ch.hearc.dice.gui.service.DiceVariableServiceEvent;
import ch.hearc.dice.gui.service.DiceVariableServiceListener;
import ch.hearc.dice.gui.service.LifeCycle;

public class JProgressBarGlobal extends JProgressBar
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JProgressBarGlobal()
		{
		control();
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

	private void control()
		{
		DiceVariableService.getInstance().addDiceVariableServiceListener(new DiceVariableServiceListener()
			{

			@Override
			public void diceVariableServicePerformed(DiceVariableServiceEvent diceVariableServiceEvent)
				{
				if (diceVariableServiceEvent.getLifeCycle() == LifeCycle.CREATED_STARTED)
					{
					lancerProgressBar();
					}
				else
					{
					arreterProgressBar();
					}
				}

			});
		}

	private void arreterProgressBar()
		{
		this.threadAnimation.stop();
		this.setVisible(false);
		this.repaint();
		}

	private void lancerProgressBar()
		{
		this.isAscending = true;

		this.setStringPainted(false);
		this.setMinimum(0);
		this.setMaximum(MAX_VALUE);
		this.setValue(0);

		this.setVisible(true);
		this.repaint();

		this.threadAnimation = new Thread(createAnimation());
		this.threadAnimation.start();
		}

	private Runnable createAnimation()
		{
		return new Runnable()
			{

			@Override
			public void run()
				{
				while(JProgressBarGlobal.this.threadAnimation.isAlive())
					{
					int value = JProgressBarGlobal.this.getValue();

					if (isAscending)
						{
						value++;

						if (value >= MAX_VALUE)
							{
							isAscending = false;
							}
						}
					else
						{
						value--;

						if (value <= 0)
							{
							isAscending = true;
							}
						}

					JProgressBarGlobal.this.setValue(value);
					JProgressBarGlobal.this.repaint();
					}
				}
			};
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private Boolean isAscending;
	private Thread threadAnimation;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final int MAX_VALUE = Integer.MAX_VALUE / 100;
	}
