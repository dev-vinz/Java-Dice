
package ch.hearc.dice.gui.controlinput.display.jcomponent.jprogressbar;

import javax.swing.JProgressBar;

import org.junit.jupiter.api.Assertions;

import ch.hearc.b_poo.j_thread.c_vecteurs.tools.Intervale;
import ch.hearc.dice.gui.service.DiceVariableService;
import ch.hearc.dice.gui.service.DiceVariableServiceEvent;
import ch.hearc.dice.gui.service.DiceVariableServiceListener;
import ch.hearc.dice.gui.service.LifeCycle;
import ch.hearc.dice.moo.specification.DiceVariable_I;
import ch.hearc.tools.algo.EtatAlgo;
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
			public void diceVariableServicePerformed(DiceVariableServiceEvent diceVariableServiceEvent)
				{
				if (diceVariableServiceEvent.getLifeCycle() == LifeCycle.CREATED_STARTED)
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
				int value = iterationEvent.getEtatAlgo() == EtatAlgo.END ? JProgressBarFace.this.getMaximum() : iterationEvent.getIndice() + 1;

				JProgressBarFace.this.setValue(value);
				JProgressBarFace.this.repaint();
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
		Intervale intervale = DiceVariableService.getInstance().getCurrentDiceVariable().getNbFaces();

		this.setStringPainted(true);
		this.setMinimum(0);
		this.setMaximum(intervale.getB() - intervale.getA());
		this.setValue(0);

		// on s’abonne au nouveau DiceVariable
		this.iterationListener = createIterationListener();
		this.diceVariable = DiceVariableService.getInstance().getCurrentDiceVariable();
		this.diceVariable.addIterationListener(iterationListener);
		}

	/*------------------------------------------------------------------*\
	|* 						Attributs Private			 				*|
	\*------------------------------------------------------------------*/

	// Tools
	private IterationListener iterationListener;
	private DiceVariable_I diceVariable;
	}
