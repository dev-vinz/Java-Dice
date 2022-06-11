
package ch.hearc.tools;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Utils
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static <T, U> Entry<T, U> getLastEntry(Map<T, U> map)
		{
		Set<Entry<T, U>> entrySet = map.entrySet();
		Iterator<Entry<T, U>> it = entrySet.iterator();

		Entry<T, U> lastEntry = null;

		while(it.hasNext())
			{
			lastEntry = it.next();
			}

		return lastEntry;
		}
	}
