
package ch.hearc.dice.gui.controlinput.display.jcomponent.jgraph;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import ch.hearc.tools.Chrono;

public class JGraphDuration extends ChartPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JGraphDuration(JFreeChart chart)
		{
		super(chart);

		// Tools
			{
			this.dataset = (DefaultCategoryDataset)chart.getCategoryPlot().getDataset();
			}
		}

	public JGraphDuration()
		{
		this(createBarGraph());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void addData(int nbFace, Chrono chrono)
		{
		this.dataset.addValue(chrono.getTimeMS(), CHRONO, Integer.toString(nbFace));
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static JFreeChart createBarGraph()
		{
		return ChartFactory.createBarChart("", "Nombre de Faces", "Temps", new DefaultCategoryDataset());
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

	private static final String CHRONO = "Temps (ms)";
	}
