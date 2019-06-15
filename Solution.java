package main;

import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.Random;

public class Solution {
	public static void main(String[] args) throws IOException{
		System.out.println("Start");
		
		int arraySize = 612;
		System.out.println("Array Size: "+arraySize);
		Random random = new Random();
		int score = 0;
		ArrayList<Integer> baseArray = new ArrayList<Integer>(arraySize);
				
		for(int i=0; i<arraySize;i++) {
			baseArray.add(new Integer(i));
		} 
		
		int iterations = 1000000;
		
		for(int i=0; i<iterations; i++) {
			ArrayList<Integer> decreasingArray= new ArrayList<Integer>();
			ArrayList<Integer> increasingArray= new ArrayList<Integer>();
			decreasingArray.addAll(baseArray);
			
					
			while(decreasingArray.size()>0) {
				int nextRandom = random.nextInt(decreasingArray.size());
				Integer nextRemoved = decreasingArray.get(nextRandom);
				decreasingArray.remove(nextRandom);
				increasingArray.add(nextRemoved);
			}
			
			for(int j=0; j<increasingArray.size()-1;j++) {
				Integer former = increasingArray.get(j);
				Integer latter = increasingArray.get(j+1);
				Integer diff = latter - former;
				if(diff.equals(Integer.valueOf(1))) {
					score = score + 1;
					break;
				}
			}
		}

		System.out.println("Result of "+iterations+" interations: "+score);
	}
}
