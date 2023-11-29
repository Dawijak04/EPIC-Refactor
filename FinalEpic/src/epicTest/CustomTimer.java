// Author: Pottier Victor
// Note: it turns out getTimeSeconds and reset are the only two methods relevant to the project

package epicTest;

public class CustomTimer {
	
	private double nanoDuration;
	private long initialTime;
	private double initDuration;
	

	
	public CustomTimer() { //constructor for timer
		this.nanoDuration = 0;
		this.initDuration = 0;
		this.initialTime = System.nanoTime();
	}
	
	public void reset() {
		this.nanoDuration += initDuration;
	}

	public int getTimeMillis() {
		return (int) (this.getCurrentTime() / Math.pow(10, 6));
	} //gets the time in miliseconds

	public int getTimeSeconds() {
		return (int) (this.getTimeMillis() / 1000);
	} //gets the time in seconds
	
	private double getCurrentTime() {
		return System.nanoTime() - this.initialTime;
	} //gets current time

}