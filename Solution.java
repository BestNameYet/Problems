package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Solution {
	public static void main(String[] args) throws IOException{
		System.out.println("Solution running...");
		
		int result = 0;
		int arraySize = 612;
		int iterations = 1000000;
		ArrayList<Integer> baseArray = new ArrayList<Integer>(arraySize);
		Random randomIntegerGenerator = new Random();
				
		for(int i=0; i<arraySize;i++) {
			baseArray.add(new Integer(i));
		} 
		
		
		for(int i=0; i<iterations; i++) {
			ArrayList<Integer> workingArray= new ArrayList<Integer>(baseArray.size());
			workingArray.addAll(baseArray);
			
			int randomIndex = randomIntegerGenerator.nextInt(workingArray.size());
			Integer formerValue = workingArray.get(randomIndex);
			Integer latterValue = null;
			workingArray.remove(randomIndex);
					
			while(workingArray.size()>0) {
								
				randomIndex = randomIntegerGenerator.nextInt(workingArray.size());
				latterValue = workingArray.get(randomIndex);
				workingArray.remove(randomIndex);
				
				Integer diff = latterValue - formerValue;
				if(diff.equals(Integer.valueOf(1))) {
					result = result + 1;
					break;
				}
				else {
					formerValue = latterValue;
				}
				
			}
			
		
		}
		System.out.println("Array Size: "+arraySize);
		System.out.println("Result of "+iterations+" interations: "+result);
	}
}
