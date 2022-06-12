
package ch.hearc.dice.gui.controlinput.display.jcomponent.jgraph;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class JGraphLancerMoyen extends ChartPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JGraphLancerMoyen(JFreeChart chart)
		{
		super(chart);

		// Tools
			{
			this.dataset = (DefaultCategoryDataset)chart.getCategoryPlot().getDataset();
			}
		}

	public JGraphLancerMoyen()
		{
		this(createBarGraph());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void addData(int nbFace, int lancerMoyen)
		{
		this.dataset.addValue(lancerMoyen, LANCER_MOYEN, Integer.toString(nbFace));
		}

	public void resetData()
		{
		this.dataset.clear();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static JFreeChart createBarGraph()
		{
		return ChartFactory.createBarChart("", "Nombre de Faces", "Lancers", new DefaultCategoryDataset());
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private DefaultCategoryDataset dataset;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final String LANCER_MOYEN = "Lancers Moyens";
	}
