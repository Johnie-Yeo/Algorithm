package Step2Recursion;

import java.util.Scanner;

public class FloorCeiling {

	private int getFloor(int []data, int K, int begin, int end) {
		if(data[0] > K)
			return -1;
		if(end - begin <= 1) {
			if(data[begin] > K)
				return data[begin-1];
			else if(data[begin] <= K && K < data[end])
				return data[begin];
			else
				return data[end];
		}
		else {
			int mid = begin + (end - begin)/2;
			if(data[mid] == K)
				return data[mid];
			else if(data[mid] > K)
				return getFloor(data, K, begin, mid-1);
			else
				return getFloor(data, K, mid+1, end);
		}
	}
	private int getCeiling(int []data, int K, int begin, int end) {
		if(data[data.length-1] < K)
			return -1;
		if(end - begin <= 1) {
			if(data[begin] >= K)
				return data[begin];
			else if(data[end] < K)
				return data[end+1];
			else
				return data[end];
		}
		else {
			int mid = begin + (end - begin)/2;
			if(data[mid] == K)
				return data[mid];
			else if(data[mid] > K)
				return getCeiling(data, K, begin, mid-1);
			else
				return getCeiling(data, K, mid+1, end);
		}
	}
	private void processCommand() {
		int N, K;
		int []data;
		Scanner kb = new Scanner(System.in);
		N = kb.nextInt();
		data = new int[N];
		for(int i = 0; i < N; i++)
			data[i] = kb.nextInt();
		K = kb.nextInt();
		int floor = getFloor(data, K, 0, N-1);
		int ceiling = getCeiling(data, K, 0, N-1);
		System.out.println("Floor: " + floor+" Ceiling: "+ceiling+ "\n");
		kb.close();
	}
	public static void main(String[] args) {
		FloorCeiling app = new FloorCeiling();
		app.processCommand();
	}

}
