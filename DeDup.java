package com.sei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/** Class : Returns an array that has no duplicates.
 */
public class DeDup {

	// The below is the array which has duplicates.
    public int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
            20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
            13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};   

	/** 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        DeDup objDeDup = new DeDup();
		//Remove duplicates Using for loop
		objDeDup.remDeDupsWithFOR((int[]) objDeDup.randomIntegers.clone());
		
		//Remove duplicates using Array.sort
		objDeDup.remDeDupsArraySort((int[]) objDeDup.randomIntegers.clone());		
		
		//Remove duplicates using collection framework API and retain original order
		objDeDup.remDeDupsLinkedHashSet(objDeDup.randomIntegers);		
		
	}

	/**
	 * remDeDupsWithFOR(int[])
	 * Advantages:
	 * 1.) This is most Simplest method to remove duplicate integers from an array of integers.
	 * 
	 * DisAdvantages:
	 * 1.) This method will always have time complexity of O(n^2). 
	 * 2.) Does not retain Insertion Order and it's not good performance on large set of data
	 * 
	 * @param numbers an array of integers
	 */
	public void remDeDupsWithFOR(int[] randomIntegers)
	{
    	try {
    		long startTime,endTime,totalTime;
    		startTime = new Date().getTime();
    		
			int arrLen = randomIntegers.length;
			for (int i = 0; i < arrLen; i++) 
			{
				for (int j = i+1; j < arrLen; j++) 
				{
					if(randomIntegers[i]==randomIntegers[j]){
						randomIntegers[j]=randomIntegers[arrLen-1];
						arrLen--;
						j--;
					}					
				}				
			}   

			int[] uniqueArray = new int[arrLen];
			System.arraycopy(randomIntegers, 0, uniqueArray, 0, arrLen);
			uniqueNumbers(uniqueArray);
			endTime = new Date().getTime();
			totalTime = endTime - startTime;
			System.out.println("Time taken remDeDupsWithFOR Method in millisecond : " + totalTime);
		} catch (Exception e) {
			e.printStackTrace();
		}     
	}
	
	/**
	 * remDeDupsArraySort(int[]):
	 * Advantages: 
	 * 1.) it's efficient method and This method uses java.util.Array.sort() method to sort the array of integers.
	 * 
	 * DisAdvantages:
	 * 1.) Does not retain Insertion Order and Performance might be o(n^2) for worst case scenario.
	 * @param numbers an array of integers
	 */
	public void remDeDupsArraySort(final int[] randomNumbers) {

		try {
			long startTime,endTime,totalTime;
    		startTime = new Date().getTime();
			Arrays.sort(randomNumbers);
			int[] uniqueArray = removeDeDuplicates(randomNumbers);
			uniqueNumbers(uniqueArray);
			endTime = new Date().getTime();
			totalTime = endTime - startTime;
			System.out.println("Time taken remDeDupsArraySort Method in millisecond : " + totalTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * This method removes duplicate integers from an array of integers
	 * @param numbers an array of integers
	 * @return an array of integers
	 */
	private int[] removeDeDuplicates(int[] randomNumbers) {

		try {
			int[] tempIntArray = new int[randomNumbers.length];
			int count = 1;
			int prevNumber = randomNumbers[0];
			tempIntArray[0] = prevNumber;
			for (int i = 1; i < randomNumbers.length; ++i) {
				if (randomNumbers[i] != prevNumber) {
					tempIntArray[count] = randomNumbers[i];
					count++;
				}
				prevNumber = randomNumbers[i];
			}
			final int[] retNumbers = new int[count];
			System.arraycopy(tempIntArray, 0, retNumbers, 0, count);
			return retNumbers;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * remDeDupsLinkedHashSet(int[])
	 * Remove duplicates using collection framework API and retain original order
	 * Advantages:
	 * 1.) code is more compact as it uses java collection(LinkedHashSet).
	 * 2.) Retains Insertion Order
	 * DisAdvantages:
	 * 
	 * 1.)Don't use this method if you have memory constraint.
	 * 
	 * @param numbers an array of integers
	 */
	public void remDeDupsLinkedHashSet(final int[] randomNumbers){

		long startTime,endTime,totalTime;
		startTime = System.currentTimeMillis();
		int i = 0;
		int[] uniqueArray = null;
		Set<Integer> setNumbers = new LinkedHashSet<Integer>();
		for(int num : randomNumbers){
			setNumbers.add(num);
		}
		uniqueArray = new int[setNumbers.size()];
		for (Iterator<Integer> iterator = setNumbers.iterator(); iterator.hasNext();) {
			uniqueArray[i++] = iterator.next();
		}
		uniqueNumbers(uniqueArray);
		System.out.println("Time taken remDeDupsLinkedHashSet Method in millisecond : " + (System.currentTimeMillis()-startTime));
	}

	/**
	 * Display integer array on console in a single line
	 * 
	 * @param uniqueNumbers an array of integers
	 */
	private void uniqueNumbers(int[] intUnique) {
		
		if(intUnique==null){
			System.out.println("No Numbers to Display");
		}
		List<Integer> list = new ArrayList<>();
        for (int i : intUnique) {
            list.add(i);
        }
        System.out.println("list : " + list);	}
}
