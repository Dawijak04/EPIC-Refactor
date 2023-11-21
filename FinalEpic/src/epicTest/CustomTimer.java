// Author: Pottier Victor
// Note: it turns out getTimeSeconds and reset are the only two methods relevant to the project

package epicTest;

public class CustomTimer {
	
	private double nanoDuration;
	private long initialTime;
	private int loops;
	private double initDuration;
	
	
	public CustomTimer(double duration, int repeats) {
		// TODO Auto-generated constructor stub
		this.nanoDuration = duration * Math.pow(10, 9);
		
		this.initDuration = nanoDuration;
		this.initialTime = System.nanoTime();
		this.loops = repeats;
		
	}
	
	public CustomTimer(double duration) {
		// TODO Auto-generated constructor stub
		this.nanoDuration = (double) duration * Math.pow(10, 9);
		this.initDuration = nanoDuration;
		this.initialTime = System.nanoTime();
		//this.loops = -1;////////////////////////////////////////////////////////////
	}
	
	public CustomTimer() {
		this.nanoDuration = 0;
		this.initDuration = 0;
		this.initialTime = System.nanoTime();
		//this.loops = -1;/////////////////////////////////////////
	}
	
	public void reset() {
		// this.initialTime = System.nanoTime();
		this.nanoDuration += initDuration;
		//this.loops--;///////////////////////////////////////////////////////
	}
	

	public void reset(boolean decreaseLoops) {
		// this.initialTime = System.nanoTime();
		this.nanoDuration += initDuration;
		//if (decreaseLoops)////////////////////////////////////////////////////////
			//this.loops--;
	}
	
	//public void setDuration(double duration) {////////////////////////////////////////////////////////////////
		//this.initDuration = (double) duration * Math.pow(10, 9);
		//this.reset(false);
	//}
	
	public int getTimeMillis() {
		return (int) (this.getCurrentTime() / Math.pow(10, 6));
	}
	
	
	public int getTimeSeconds() {
		return (int) (this.getTimeMillis() / 1000);
	}
	
	private double getCurrentTime() {
		return System.nanoTime() - this.initialTime;
	}
	
	//public boolean isReached() {///////////////////////////////////////////////////////////////////////////
		//if (this.loops != 0 && this.getCurrentTime() >= this.nanoDuration) {
			//this.reset();
			//System.out.println("Timer : " + this.nanoDuration + " reached!");
			//return true;
		//}
		//return false;
	//}

}