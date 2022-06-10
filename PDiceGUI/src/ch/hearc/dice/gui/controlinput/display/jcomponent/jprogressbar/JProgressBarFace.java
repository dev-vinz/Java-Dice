
package ch.hearc.dice.gui.controlinput.display.jcomponent.jprogressbar;

import org.junit.jupiter.api.Assertions;

import ch.hearc.dice.gui.service.DiceVariableService;
import ch.hearc.dice.gui.service.DiceVariableServiceEvent;
import ch.hearc.dice.gui.service.DiceVariableServiceListener;
import ch.hearc.dice.moo.specification.DiceVariable_I;
import ch.hearc.tools.algo.IterationEvent;
import ch.hearc.tools.algo.IterationListener;

public class JProgressBarFace extends JProgressBar
	{

	/*------------------------------------------------------------------*\
	|* 						Constructeurs					 			*|
	\*------------------------------------------------------------------*/
	public JProgressBarFace()
		{
		control();
		}

	/*------------------------------------------------------------------*\
	|* 						Methodes Private 							*|
	\*------------------------------------------------------------------*/
	private void control()
		{
		DiceVariableService.getInstance().addDiceVariableServiceListener(new DiceVariableServiceListener()
			{

			@Override
			public void diceVariableServiceCreated(DiceVariableServiceEvent diceVariableServiceEvent)
				{
				if (iterationEvent.getLifeCycle() == CREATED_STARTED)
					{
					lancerProgressBar();
					}
				}
			});
		}

	private IterationListener createIterationListener()
		{
		return new IterationListener()
			{

			@Override
			public void iterationPerformed(IterationEvent iterationEvent)
				{
				JProgressBarFace.this.setValue(iterationEvent.getI());
				JProgressBarFace.this.repaint();// utile?
				//System.out.println(iterationEvent.getI());
				// a ameliorer pour un pourcentage
				}
			};
		}

	private void lancerProgressBar()
		{
		Assertions.assertTrue((this.iterationListener == null && diceVariable == null) || (this.iterationListener != null && diceVariable != null));
		// On eneleve les anciens listener sur l’ancien diceVariable
		if (iterationListener != null)
			{
			diceVariable.removeIterationListener(iterationListener);
			}
		// Configurer la progressBar (ie this)
		// TODO
		// on s’abonne au nouveau DiceVariable
		this.iterationListener = createIterationListener();
		this.diceVariable = DiceVariableService.getInstance().getCurentDiceVariable();
		this.diceVariable.addIterationListener(iterationListener);
		}

	/*------------------------------------------------------------------*\
	|* 						Attributs Private			 				*|
	\*------------------------------------------------------------------*/
	// Tools
	private IterationListener iterationListener;
	private DiceVariable_I diceVariable;
	}
