
package ch.hearc.dice.gui.controlinput.display.jcomponent.jgraph;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Map;

import javax.swing.JPanel;

import ch.hearc.dice.gui.service.DiceVariableService;
import ch.hearc.dice.gui.service.DiceVariableServiceEvent;
import ch.hearc.dice.gui.service.DiceVariableServiceListener;
import ch.hearc.dice.gui.service.LifeCycle;
import ch.hearc.dice.moo.specification.DiceVariable_I;
import ch.hearc.tools.Chrono;
import ch.hearc.tools.Utils;
import ch.hearc.tools.algo.EtatAlgo;
import ch.hearc.tools.algo.IterationEvent;
import ch.hearc.tools.algo.IterationListener;

public class JGraphs extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JGraphs()
		{
		// Tools
			{
			this.gridLayout = new GridLayout(-1, 1);

			this.graphLancerMoyen = new JGraphLancerMoyen();
			this.graphDuration = new JGraphDuration();
			}

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
		setLayout(this.gridLayout);

		add(this.graphLancerMoyen);
		add(this.graphDuration);
		}

	private void control()
		{
		DiceVariableService.getInstance().addDiceVariableServiceListener(new DiceVariableServiceListener()
			{

			@Override
			public void diceVariableServicePerformed(DiceVariableServiceEvent diceVariableServiceEvent)
				{
				if (diceVariableServiceEvent.getLifeCycle() == LifeCycle.CREATED_STARTED)
					{
					lancerGraphs();
					}
				}

			});
		}

	private void appearance()
		{
		setBackground(Color.GREEN);

		this.gridLayout.setVgap(10);
		}

	private void lancerGraphs()
		{
		// On enleve les anciens listener sur l’ancien diceVariable
		if (iterationListener != null)
			{
			diceVariable.removeIterationListener(iterationListener);
			}

		// on s’abonne au nouveau DiceVariable
		this.iterationListener = new IterationListener()
			{

			@Override
			public void iterationPerformed(IterationEvent iterationEvent)
				{
				if (iterationEvent.getEtatAlgo() == EtatAlgo.RUNNING)
					{
					DiceVariable_I diceVariable = DiceVariableService.getInstance().getCurrentDiceVariable();

					Map<Integer, Integer> lancers = diceVariable.getMapFaceLancer();
					Map<Integer, Chrono> chronos = diceVariable.getMapFaceChrono();

					java.util.Map.Entry<Integer, Integer> lastLancer = Utils.getLastEntry(lancers);
					java.util.Map.Entry<Integer, Chrono> lastChrono = Utils.getLastEntry(chronos);

					graphLancerMoyen.addData(lastLancer.getKey(), lastLancer.getValue());
					graphDuration.addData(lastChrono.getKey(), lastChrono.getValue());
					}
				}
			};

		this.diceVariable = DiceVariableService.getInstance().getCurrentDiceVariable();
		this.diceVariable.addIterationListener(iterationListener);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private GridLayout gridLayout;
	private JGraphLancerMoyen graphLancerMoyen;
	private JGraphDuration graphDuration;

	private IterationListener iterationListener;
	private DiceVariable_I diceVariable;
	}
