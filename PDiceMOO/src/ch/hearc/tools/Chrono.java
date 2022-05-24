
package ch.hearc.tools;

public class Chrono
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Chrono()
		{
		start();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void start()
		{
		if (this.isStopped)
			{
			this.isStopped = false;
			this.startTime = System.currentTimeMillis();
			}
		}

	public long stop()
		{
		this.endTime = System.currentTimeMillis();
		this.isStopped = true;

		return getTimeMS();
		}

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append(getTimeMS());
		builder.append("ms");
		return builder.toString();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public long getTimeMS()
		{
		if (this.isStopped)
			{
			return this.endTime - this.startTime;
			}
		else
			{
			return System.currentTimeMillis() - this.startTime;
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private Boolean isStopped = true;
	private long startTime;
	private long endTime;
	}
