
package ch.hearc.dice.gui.controlinput.display.jcomponent.jgraph;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JPanel;

import ch.hearc.dice.moo.specification.DiceVariable_I;
import ch.hearc.tools.Chrono;
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
					int nbFace = diceVariable.getNbFaces().getA() + iterationEvent.getIndice();

					Collection<Integer> lancers = diceVariable.getMapFaceLancer().values();
					Iterator<Integer> itLancer = lancers.iterator();

					Collection<Chrono> chronos = diceVariable.getMapFaceChrono().values();
					Iterator<Chrono> itChrono = chronos.iterator();

					int nbLancer = 0;
					Chrono chrono = null;

					while(itLancer.hasNext())
						{
						nbLancer = itLancer.next();
						}

					while(itChrono.hasNext())
						{
						chrono = itChrono.next();
						}

					graphLancerMoyen.addData(nbFace, nbLancer);
					graphDuration.addData(nbFace, chrono);
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
