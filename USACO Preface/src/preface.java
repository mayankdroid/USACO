import java.io.*;
import java.util.*;
/*
ID:shrey.c1
LANG:JAVA
TASK:preface
*/
public class preface {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("preface.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
		int n = Integer.parseInt(f.readLine());
		//I 1,L 50,M 1000,V 5,C 100,X 10,D 500
		char[] numerals = {'I','V','X','L','C','D','M'};
		int[] numVals = {1,5,10,50,100,500,1000};
		int[] numCount = new int[numerals.length];
		for(int i = 1; i <= n; i++){
			int num = i;
			String st = "";
			for(int j = numVals.length-1; j >= 0; j--){
				int count = num/numVals[j];
				
				
				//.out.println(count + " " + numVals[i]);
				num = num%numVals[j];
				if(count <= 3){
					for(int k = 0; k < count; k++){
						st += numerals[j];
						numCount[j]++;
					}
				}
				else if(count > 3){
					st += numerals[j] + "" + numerals[j+1];
					numCount[j]++;
					numCount[j+1]++;
				}
				if(j%2 == 0 && j >= 2 && num/numVals[j-2] == 9){
					st += numerals[j-2] + "" + numerals[j];
					num -= numVals[j-2] * 9;	
					numCount[j-2]++;
					numCount[j]++;
				}
			}
		}
		for(int i = 0; i < numCount.length; i++){
			if(numCount[i] > 0){
				out.println(numerals[i] + " " + numCount[i]);
			}
		}
		out.close();
	}
	
}
