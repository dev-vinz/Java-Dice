
package ch.hearc.tools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ch.hearc.b_poo.j_thread.Threads;

public class TestChrono
	{

	/*------------------------------------------------------------------*\
	 |*							Methodes Public							*|
	 \*-----------------------------------------------------------------*/

	@Test
	public void testChrono()
		{
		long durationMs = 1500;
		long deltaMs = 20;

		Chrono chrono = new Chrono();

		sleepMS(durationMs);

		long elapsedTime = chrono.stop();

		Assertions.assertTrue(elapsedTime >= durationMs - deltaMs && elapsedTime <= durationMs + deltaMs);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void sleepMS(long ms)
		{
		Threads.sleep(ms);
		}

	}
