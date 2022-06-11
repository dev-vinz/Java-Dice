
package ch.hearc.dice.gui.controlinput.display.jcomponent.jgraph;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Map;

import javax.swing.JPanel;

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

	public JGraphs(DiceVariable_I diceVariable)
		{
		// Inputs
			{
			this.diceVariable = diceVariable;
			}

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
		diceVariable.addIterationListener(new IterationListener()
			{

			@Override
			public void iterationPerformed(IterationEvent iterationEvent)
				{
				if (iterationEvent.getEtatAlgo() == EtatAlgo.RUNNING)
					{
					Map<Integer, Integer> lancers = diceVariable.getMapFaceLancer();
					Map<Integer, Chrono> chronos = diceVariable.getMapFaceChrono();

					java.util.Map.Entry<Integer, Integer> lastLancer = Utils.getLastEntry(lancers);
					java.util.Map.Entry<Integer, Chrono> lastChrono = Utils.getLastEntry(chronos);

					graphLancerMoyen.addData(lastLancer.getKey(), lastLancer.getValue());
					graphDuration.addData(lastChrono.getKey(), lastChrono.getValue());
					}
				}
			});

		new Thread(diceVariable).start();
		}

	private void appearance()
		{
		setBackground(Color.GREEN);

		this.gridLayout.setVgap(10);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private DiceVariable_I diceVariable;

	// Tools
	private GridLayout gridLayout;
	private JGraphLancerMoyen graphLancerMoyen;
	private JGraphDuration graphDuration;

	}
