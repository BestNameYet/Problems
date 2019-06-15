package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Solution {
	public static void main(String[] args) throws IOException{
		System.out.println("Solution running...");
		
		long startTime = System.currentTimeMillis();
		int result = 0;
		int arraySize = 612;
		int iterations = 1000000;
		int randomIndex = 0;
		Integer currentValue;
		Integer nextValue;
		ArrayList<Integer> baseArray = new ArrayList<Integer>(arraySize);
		ArrayList<Integer> workingArray = new ArrayList<Integer>(baseArray.size());
		Random randomIntegerGenerator = new Random();
				
		for(int i=0; i<baseArray.size();i++) {
			baseArray.add(new Integer(i));
		} 
		
		
		for(int i=0; i<iterations; i++) {
			
			workingArray.addAll(baseArray);
			randomIndex = randomIntegerGenerator.nextInt(workingArray.size());
			currentValue = workingArray.get(randomIndex);
			nextValue = null;
			workingArray.remove(randomIndex);
					
			while(workingArray.size()>0) {
				randomIndex = randomIntegerGenerator.nextInt(workingArray.size());
				nextValue = workingArray.get(randomIndex);
				workingArray.remove(randomIndex);
				
				Integer diff = nextValue - currentValue;
				if(diff.equals(Integer.valueOf(1))) {
					result = result + 1;
					workingArray.clear();
					break;
				}
				else {
					currentValue = nextValue;
				}
				
			}
			
		
		}
		System.out.println("Array Size: "+arraySize);
		System.out.println("Result of "+iterations+" interations in "+(System.currentTimeMillis()-startTime)+" ms: "+result);
	}
}
