
package ch.hearc.dice.gui.controlinput.display.jcomponent.jprogressbar;

import java.awt.Color;

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
			int h = JProgressBarGlobal.this.getWidth();

			float hue01 = 0;
			float dhue = 1/(100000*(float)h);
			@Override
			public void run()
				{
				while(JProgressBarGlobal.this.threadAnimation.isAlive())
					{
					int value = JProgressBarGlobal.this.getValue();


					if (isAscending)
						{
						value++;
						hue01 += dhue;
						if (value >= MAX_VALUE)
							{
							isAscending = false;
							}
						}
					else
						{
						value--;
						hue01 -= dhue;
						if (value <= 0)
							{
							isAscending = true;
							}
						}
					int colorInt = Color.HSBtoRGB(hue01, 1, 1);
					Color myColor = new Color(colorInt);
					JProgressBarGlobal.this.setValue(value);
					JProgressBarGlobal.this.repaint();
					JProgressBarGlobal.this.setForeground(myColor);
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
