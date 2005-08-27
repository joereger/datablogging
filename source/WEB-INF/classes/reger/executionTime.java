
package reger;

/*
* Object used to measure execution time of pages.
* Done this way so that executionTime display can be turned on
* and off at the app level by controlling debugExecuteTime
*/
public class executionTime{

	public long starttime;
	private boolean debugExecuteTime = true;

	/*
	* Object constructor.  The goal here is to timestamp the object's creation.
	*/
	public executionTime(){
		starttime=System.currentTimeMillis();
	}
	
	/*
	* See how long the object has been alive
	*/
	public long getElapsedMillis(){
		long endtime = System.currentTimeMillis();
		long elapsed = endtime - starttime;
		return elapsed;
	}
	
	/*
	* Output a pretty html line with the elapsed time
	*/
	public String getElapsed(){
		String elapsed="";
		if (debugExecuteTime) {
			elapsed="<br>Elapsed Time: " + getElapsedMillis() + " millis";
		}
		return elapsed;
	}
}


