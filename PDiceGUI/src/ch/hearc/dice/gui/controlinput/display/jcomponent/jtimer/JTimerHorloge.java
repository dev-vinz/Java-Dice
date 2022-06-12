
package ch.hearc.dice.gui.controlinput.display.jcomponent.jtimer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class JTimerHorloge extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JTimerHorloge()
		{
		// Tools
			{
			this.l2dGraduation = new Line2D.Double(0, 0, 10, 0);
			this.l2dBoule = new Ellipse2D.Double(-9, -9, 18, 18);

			this.seconds = 0;
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void setTime(int h, int m, int s)
		{
		this.seconds = (h * 60 * 60 + m * 60 + s) % NB_SECONDS;
		this.repaint();
		}

	@Override
	protected void paintComponent(Graphics g)
		{
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D)g;

		// Sauvegarde des anciens paramètres
		AffineTransform backup = g2d.getTransform();

		draw(g2d);

		// Restoration
		g2d.setTransform(backup);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void draw(Graphics2D g2d)
		{
		// Adapt for all window sizes
		int width = this.getSize().width;
		int height = this.getSize().height;

		int diameter = Math.min(width, height);

		int deltaX = width > height ? (width - diameter) / 2 : 0;
		int deltaY = width > height ? 0 : (height - diameter) / 2;

		g2d.translate(deltaX, deltaY);

		drawTimer(g2d, diameter);
		drawSeconds(g2d, diameter);
		}

	private void drawTimer(Graphics2D g2d, int diameter)
		{
		g2d.draw(new Ellipse2D.Double(0, 0, diameter, diameter));

		// Go to center
		g2d.translate(diameter / 2, diameter / 2);

		double lineSize = getLineSize(this.l2dGraduation);

		// Draw graduation
		for(int k = 0; k < NB_SECONDS; k++)
			{
			g2d.translate((diameter / 2) - lineSize, 0);
			g2d.draw(this.l2dGraduation);
			g2d.translate(-((diameter / 2) - lineSize), 0);

			g2d.rotate(DELTA_ALPHA);
			}
		}

	private void drawSeconds(Graphics2D g2d, int diameter)
		{
		// Start from top
		g2d.rotate(3 * Math.PI / 2);

		// Rotate from seconds and draw line
		g2d.rotate(this.seconds * DELTA_ALPHA);
		g2d.draw(new Line2D.Double(0, 0, (diameter / 2) - 10, 0));
		g2d.translate((diameter / 2) - 10, 0);

		// Draw the circle
		g2d.setColor(Color.RED);
		g2d.fill(this.l2dBoule);
		g2d.setColor(Color.BLACK);
		}

	private double getLineSize(Line2D line2d)
		{
		double deltaX = line2d.getX1() - line2d.getX2();
		double deltaY = line2d.getY1() - line2d.getY2();

		return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs

	// Tools
	private Line2D.Double l2dGraduation;
	private Ellipse2D.Double l2dBoule;

	private int seconds;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final int NB_SECONDS = 60;
	private static final double DELTA_ALPHA = Math.PI * 2 / NB_SECONDS;

	}
