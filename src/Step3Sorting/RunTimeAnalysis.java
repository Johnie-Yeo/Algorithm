package Step3Sorting;

import java.util.Arrays;

public class RunTimeAnalysis extends SortingAlg{
	private int []data;
	RunTimeMeasurement rm;
	
	private void makeTable() {
		rm = new RunTimeMeasurement();
		
		System.out.println("\t\tRandom1000\tReverse1000\tRandom10000\tReverse10000\tRandom100000\tReverse100000");
		System.out.print("Bubble\t\t");
		runTimeBubble();
		System.out.println();
		System.out.print("Selection\t");
		runTimeSelection();
		System.out.println();
		System.out.print("Insertion\t");
		runTimeInsertion();
		System.out.println();
		System.out.print("Merge\t\t");
		runTimeMerge();
		System.out.println();
		System.out.print("QuickN\t\t");
		runTimeQuick();
		System.out.println();
		System.out.print("QuickM\t\t");
		runTimeQuickMedian();
		System.out.println();
		System.out.print("QuickR\t\t");
		runTimeQuickRandom();
		System.out.println();
		System.out.print("Heap\t\t");
		runTimeHeap();
		System.out.println();
		System.out.print("Library\t\t");
		runTimeLibrary();
		System.out.println();
	}
	private void runTimeLibrary() {
		int size = 1000;
		float result = 0;
		for(int i = 0; i < 3; i++) {			
			float tmp = 0;
			for(int j = 0; j < 10; j++) {
				makeRandomData(size);
				rm.startTimer();
				Arrays.sort(data, 0, size-1);
				tmp += rm.stopTimer();
			}
			result = (float) (tmp / 10.0);
			System.out.print((float)result + "s\t\t");
			
			makeReverseData(size);
			rm.startTimer();
			Arrays.sort(data, 0, size-1);
 			result = (float) rm.stopTimer();
			System.out.print((float)result + "s\t\t");
			
			size *= 10;
		}			
	}
	private void runTimeHeap() {
		int size = 1000;
		float result = 0;
		for(int i = 0; i < 3; i++) {			
			float tmp = 0;
			for(int j = 0; j < 10; j++) {
				makeRandomData(size);
				rm.startTimer();
				heapSort(data, size);
				tmp += rm.stopTimer();
			}
			result = (float) (tmp / 10.0);
			System.out.print((float)result + "s\t\t");
			
			makeReverseData(size);
			rm.startTimer();
			heapSort(data, size);
			result = (float) rm.stopTimer();
			System.out.print((float)result + "s\t\t");
			
			size *= 10;
		}			
	}
	private void runTimeQuickRandom() {
		int size = 1000;
		float result = 0;
		for(int i = 0; i < 3; i++) {			
			float tmp = 0;
			for(int j = 0; j < 10; j++) {
				makeRandomData(size);
				rm.startTimer();
				quickSortRan(data, 0, size-1);
				tmp += rm.stopTimer();
			}
			result = (float) (tmp / 10.0);
			System.out.print((float)result + "s\t\t");
			
			makeReverseData(size);
			rm.startTimer();
			quickSortRan(data, 0, size-1);
 			result = (float) rm.stopTimer();
			System.out.print((float)result + "s\t\t");
			
			size *= 10;
		}			
	}
	private void runTimeQuickMedian() {
		int size = 1000;
		float result = 0;
		for(int i = 0; i < 3; i++) {			
			float tmp = 0;
			for(int j = 0; j < 10; j++) {
				makeRandomData(size);
				rm.startTimer();
				quickSortMed(data, 0, size-1);
				tmp += rm.stopTimer();
			}
			result = (float) (tmp / 10.0);
			System.out.print((float)result + "s\t\t");
			
			makeReverseData(size);
			rm.startTimer();
			quickSortMed(data, 0, size-1);
 			result = (float) rm.stopTimer();
			System.out.print((float)result + "s\t\t");
			
			size *= 10;
		}			
	}
	private void runTimeQuick() {
		int size = 1000;
		float result = 0;
		for(int i = 0; i < 3; i++) {			
			float tmp = 0;
			for(int j = 0; j < 10; j++) {
				makeRandomData(size);
				rm.startTimer();
				quickSort(data, 0, size-1);
				tmp += rm.stopTimer();
			}
			result = (float) (tmp / 10.0);
			System.out.print((float)result + "s\t\t");
			
			makeReverseData(size);
			rm.startTimer();
			quickSort(data, 0, size-1);
			result = (float) rm.stopTimer();
			System.out.print((float)result + "s\t\t");
			
			size *= 10;
		}			
	}
	private void runTimeMerge() {
		int size = 1000;
		float result = 0;
		for(int i = 0; i < 3; i++) {			
			float tmp = 0;
			for(int j = 0; j < 10; j++) {
				makeRandomData(size);
				rm.startTimer();
				mergeSorting(data, 0, size-1);
				tmp += rm.stopTimer();
			}
			result = (float) (tmp / 10.0);
			System.out.print((float)result + "s\t\t");
			
			makeReverseData(size);
			rm.startTimer();
			mergeSorting(data, 0, size-1);
 			result = (float) rm.stopTimer();
			System.out.print((float)result + "s\t\t");
			
			size *= 10;
		}			
	}
	private void runTimeInsertion() {
		int size = 1000;
		float result = 0;
		for(int i = 0; i < 3; i++) {			
			float tmp = 0;
			for(int j = 0; j < 10; j++) {
				makeRandomData(size);
				rm.startTimer();
				insertionSort(data, size);
				tmp += rm.stopTimer();
			}
			result = (float) (tmp / 10.0);
			System.out.print((float)result + "s\t\t");
			
			makeReverseData(size);
			rm.startTimer();
			insertionSort(data, size);
 			result = (float) rm.stopTimer();
			System.out.print((float)result + "s\t\t");
			
			size *= 10;
		}				
	}
	private void runTimeSelection() {
		int size = 1000;
		float result = 0;
		for(int i = 0; i < 3; i++) {			
			float tmp = 0;
			for(int j = 0; j < 10; j++) {
				makeRandomData(size);
				rm.startTimer();
				selectionSort(data, size);
				tmp += rm.stopTimer();
			}
			result = (float) (tmp / 10.0);
			System.out.print((float)result + "s\t\t");
			
			makeReverseData(size);
			rm.startTimer();
			selectionSort(data, size);
 			result = (float) rm.stopTimer();
			System.out.print((float)result + "s\t\t");
			
			size *= 10;
		}		
	}
	private void runTimeBubble() {
		int size = 1000;
		float result = 0;
		for(int i = 0; i < 3; i++) {			
			float tmp = 0;
			for(int j = 0; j < 10; j++) {
				makeRandomData(size);
				rm.startTimer();
				bubbleSort(data, size);
				tmp += rm.stopTimer();
			}
			result = (float)(tmp / 10.0);
			System.out.print((float)result + "s\t\t");
			
			makeReverseData(size);
			rm.startTimer();
			bubbleSort(data, size);
 			result = (float)rm.stopTimer();
			System.out.print((float)result + "s\t\t");
			
			size *= 10;
		}		
	}
	
	private void makeReverseData(int N) {
		data = new int[N];
		for(int i = 0; i < N; i++)
			data[i] = N-i;
	}
	private void makeRandomData(int N) {
		data = new int[N];
		for(int i = 0; i < N; i++)
			data[i] = (int)(Math.random()*N) + 1;
	}
	
	public static void main(String[] args) {
		RunTimeAnalysis app = new RunTimeAnalysis();
		app.makeTable();
	}

}
