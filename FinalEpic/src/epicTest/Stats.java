package epicTest;

import java.util.ArrayList;

/**
 * Tools for stats calculations such as mean, variance, max etc...
 */
public class Stats {

	/**
	 * Finds and returns the greatest value contained in an ArrayList&ltDouble&gt object
	 * @param numArray i.e. the ArrayList&ltDouble&gt to be inspected
	 * @return The maximum value contained in that array
	 */
	public static double findMax(ArrayList<Double> numArray) {
		
		if (numArray.size() == 0) {
			return 0;
		}
		
		double maxNumber = numArray.get(0);
		
		for (int arrayIndex=0; arrayIndex < numArray.size(); arrayIndex++) {
			
			maxNumber = getGreatestNumber(maxNumber, numArray.get(arrayIndex));
			
		}
		return maxNumber;
	}
	
	/**
	 * Sums the terms contained in an ArrayList&ltDouble&gt and returns the result
	 * @param numArray the ArrayList&ltDouble&gt to find the sum from
	 * @return  The total sum of the terms contained in the ArrayList&ltDouble&gt
	 */
	public static double calculateSum(ArrayList<Double> numArray) {
		
		double finalSum = 0;
		
		for (double num : numArray) {
			finalSum += num;
		}
		
		return finalSum;
	}
	
	/**
	 * Finds and returns the average of the terms contained in an ArrayList&ltDouble&gt
	 * @param numArray the ArrayList&ltDouble&gt to find the mean from
	 * @return The average value of the terms contained in the ArrayList&ltDouble&gt
	 */
	public static double calculateMean(ArrayList<Double> numArray) {
		return calculateSum(numArray) / numArray.size();
	}
	
	/**
	 * Finds and returns the variance of the terms contained in an ArrayList&ltDouble&gt
	 * @param numArray the ArrayList&ltDouble&gt to find the variance from
	 * @return The variance value of the terms contained in the ArrayList&ltDouble&gt
	 */
	public static double calculateVariance(ArrayList<Double> numArray) {
		
		double mean = calculateMean(numArray);
		double finalVariance = 0;
		for (double num : numArray) {
			finalVariance += (num - mean) * (num - mean);
		}
		//System.out.println(finalVariance);
		return finalVariance / numArray.size();
	}
	
	/**
	 * Finds and returns the standard deviation of the terms contained in an ArrayList&ltDouble&gt
	 * @param numArray the ArrayList&ltDouble&gt to find the standard deviation from
	 * @return The standard deviation value of the terms contained in the ArrayList&ltDouble&gt
	 */
	public static double calculateStandardDeviation(ArrayList<Double> numArray) {
		double variance = calculateVariance(numArray);
		return Math.sqrt(variance);
	}
	
	public static double getGreatestNumber(double num1, double num2) {
		return num1 > num2 ? num1 : num2;
	} //gets greatest number
}