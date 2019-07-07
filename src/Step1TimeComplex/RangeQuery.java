package Step1TimeComplex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RangeQuery {
	private int n;
	private int []data;
	private int []query;
	private Scanner kb;
	
	public static void main(String[] args) {
		RangeQuery rq = new RangeQuery();
		rq.readData();
		rq.kb = new Scanner(System.in);
		rq.processCommand();
		rq.kb.close();
	}
	void readData() {
		Scanner sc;
		try {
			sc = new Scanner(new File("data.txt"));
			n = sc.nextInt();
			if(n > 10000) {
				System.out.println("N should be lesser than 1000.");
				System.exit(0);
			}
			int m = (int)Math.sqrt((double)n);
			int num_idx = (n-1)/m + 1;
			data = new int[n];
			query = new int[num_idx];
			
			int idx = 0;
			for(int i=0; i<n; i++) {
				data[i] = sc.nextInt();
				if((i+1) % m == 0) {
					query[idx++] = findDataMinimum(i-m+1,i);
				}					
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("No file.");
			System.exit(0);
		}
	}
	void processCommand() {
		while(true) {
			System.out.print("$ ");
			int i = kb.nextInt();
			if(i < 0)
				System.exit(0);
			int j = kb.nextInt();
			
			int min = findMinimum(i, j);
			System.out.println(min);
		}
	}
	private int findMinimum(int i, int j) {
		int m = (int)Math.sqrt((double)n);
		int min1, min2, min3;
		int mod = i % m;
		if(mod != 0)
			min1 = findDataMinimum(i, i+(m-mod)-1);
		else
			min1 = query[i/m];
		mod = j % m;
		if(mod != m-1)
			min2 = findDataMinimum(j-mod, j);
		else
			min2 = query[j/m];
		if(min1 > min2)
			min1 = min2;
		min3 = findQueryMinimum(i/m+1,j/m-1);
		if(min1 > min3)
			min1 = min3;
		return min1;
	}
	private int findDataMinimum(int idx1, int idx2) {
		if(idx1 == idx2)
			return data[idx1];
		int min = data[idx2];
		for(int i = idx1; i < idx2; i++)
			if(data[i] < min)
				min = data[i];
		return min;
	}
	private int findQueryMinimum(int i, int j) {
		int min= query[j];
		for(int k = i; k < j; k++)
			if(query[k] < min)
				min = query[k];
		return min;
	}
}