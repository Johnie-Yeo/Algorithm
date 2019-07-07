package Step2Recursion;

import java.util.Scanner;

public class CountPairsOfIntergers {
	private Scanner kb;
	public static void main(String[] args) {
		CountPairsOfIntergers CPOI = new CountPairsOfIntergers();
		CPOI.kb = new Scanner(System.in);
		CPOI.processCommand();
		CPOI.kb.close();
	}
	private void processCommand() {
		int N, K;
		int []data;
		while(true) {
			System.out.print("$ ");
			N = kb.nextInt();
			if(N < 0)
				break;
			data = new int[N];
			for(int i=0; i<N; i++)
				data[i] = kb.nextInt();
			K = kb.nextInt();
			
			int start = 0, end = N-1;
			System.out.println(getPairs(data, N, K, start, end));
		}
	}
	private int getPairs(int[] data, int n, int k, int start, int end) {
		if(start >= end)
			return 0;
		int sum = data[start]+data[end];
		if(sum > k)
			return getPairs(data, n, k, start, end-1);
		else if(sum < k)
			return getPairs(data, n, k, start+1, end);
		else
			return 1+getPairs(data, n, k, start+1, end-1);
	}
}
