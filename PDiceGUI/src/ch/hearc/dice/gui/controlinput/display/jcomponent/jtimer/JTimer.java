
package ch.hearc.dice.gui.controlinput.display.jcomponent.jtimer;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.Timer;

import org.junit.jupiter.api.Assertions;

import ch.hearc.c_gui.tools.decorateur.JMarge;
import ch.hearc.dice.gui.service.DiceVariableService;
import ch.hearc.dice.gui.service.DiceVariableServiceEvent;
import ch.hearc.dice.gui.service.DiceVariableServiceListener;
import ch.hearc.dice.gui.utils.Settings;
import ch.hearc.dice.moo.specification.DiceVariable_I;
import ch.hearc.tools.algo.EtatAlgo;
import ch.hearc.tools.algo.IterationEvent;
import ch.hearc.tools.algo.IterationListener;

public class JTimer extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JTimer()
		{
		// Tools
			{
			this.hours = 0;
			this.minutes = 0;
			this.seconds = 0;

			this.jTimerDigit = new JTimerDigit();
			this.jTimerHorloge = new JTimerHorloge();
			}

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void start()
		{
		reset();

		this.timerAnimation = new Timer(1000, new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				stepTimer();
				}
			});

		this.timerAnimation.start();
		}

	public void stop()
		{
		this.timerAnimation.stop();
		}

	public void reset()
		{
		this.hours = 0;
		this.minutes = 0;
		this.seconds = 0;

		this.jTimerDigit.setTime(this.hours, this.minutes, this.seconds);
		this.jTimerHorloge.setTime(this.hours, this.minutes, this.seconds);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		BorderLayout layout = new BorderLayout();
		setLayout(layout);

		Box box = new Box(BoxLayout.Y_AXIS);
		box.add(this.jTimerHorloge);
		box.add(this.jTimerDigit);

		add(new JMarge(box, Settings.MARGE,Settings.MARGE), BorderLayout.CENTER);
		}

	private void control()
		{
		DiceVariableService.getInstance().addDiceVariableServiceListener(new DiceVariableServiceListener()
			{

			@Override
			public void diceVariableServicePerformed(DiceVariableServiceEvent diceVariableServiceEvent)
				{
				switch(diceVariableServiceEvent.getLifeCycle())
					{
					case CREATED_STARTED:
						lancerTimer();
						break;
					case KILLED:
						stop();
						break;
					case NATURAL_END:
						// rien
						break;
					case STOPPED:
						// rien
						break;
					default:
						break;

					}
				}
			});
		}

	private void appearance()
		{
		// rien
		}

	/*------------------------------*\
	|*				Timer			*|
	\*------------------------------*/

	private void lancerTimer()
		{
		Assertions.assertTrue((this.iterationListener == null && diceVariable == null) || (this.iterationListener != null && diceVariable != null));

		// On eneleve les anciens listener sur l’ancien diceVariable
		if (iterationListener != null)
			{
			diceVariable.removeIterationListener(iterationListener);
			}

		// on s’abonne au nouveau DiceVariable
		this.iterationListener = createIterationListener();
		this.diceVariable = DiceVariableService.getInstance().getCurrentDiceVariable();

		start();

		this.diceVariable.addIterationListener(iterationListener);
		}

	private void stepTimer()
		{
		if (this.seconds < 59)
			{
			this.seconds++;
			}
		else
			{
			// Augmenter minutes
			this.seconds = 0;

			if (this.minutes < 59)
				{
				this.minutes++;
				}
			else
				{
				// Augmenter heures
				this.minutes = 0;
				this.hours++;
				}
			}

		this.jTimerDigit.setTime(this.hours, this.minutes, this.seconds);
		this.jTimerHorloge.setTime(this.hours, this.minutes, this.seconds);
		}

	private IterationListener createIterationListener()
		{
		return new IterationListener()
			{

			@Override
			public void iterationPerformed(IterationEvent iterationEvent)
				{
				if (iterationEvent.getEtatAlgo() == EtatAlgo.END)
					{
					stop();
					}
				}
			};
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private int hours;
	private int minutes;
	private int seconds;

	private javax.swing.Timer timerAnimation;
	private JTimerDigit jTimerDigit;
	private JTimerHorloge jTimerHorloge;

	private IterationListener iterationListener;
	private DiceVariable_I diceVariable;
	}
