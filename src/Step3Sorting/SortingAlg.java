package Step3Sorting;

public class SortingAlg {
	private void merge(int []arr, int begin, int middle, int end)
	{
		int i = begin, j = middle + 1, k = 0;
		int []tmp = new int[end-begin+1];
		while (i <= middle && j <= end) {
			if (arr[i] <= arr[j])
				tmp[k++] = arr[i++];
			else
				tmp[k++] = arr[j++];
		}
		while (i <= middle)
			tmp[k++] = arr[i++];
		while (j <= end)
			tmp[k++] = arr[j++];
		int idx = 0;
		for (int p = begin;p <= end;p++)
			arr[p] = tmp[idx++];
	}
	private int partition(int []data, int begin, int end)
	{
		int pivot = data[end];
		int i = begin - 1;
		for (int j = begin;j < end;j++) {
			if (data[j] <= pivot) {
				i++;
				int tmp = data[i];
				data[i] = data[j];
				data[j] = tmp;
			}
		}
		int tmp = data[i+1];
		data[i+1] = data[end];
		data[end] = tmp;

		return (i + 1);
	}
	private int partitionMedianPivot(int []data, int begin, int end)
	{
		int middle = (begin + end) / 2;
		if (data[middle] < data[begin]) {
			int tmp = data[middle];
			data[middle] = data[begin];
			data[begin] = tmp;
		}
		if (data[middle] > data[end]) {
			int tmp = data[middle];
			data[middle] = data[end];
			data[end] = tmp;
		}
		if (data[middle] < data[begin]) {
			int tmp = data[middle];
			data[middle] = data[begin];
			data[begin] = tmp;
		}
		
		int pivot = data[middle];
		int tmp = data[middle];
		data[middle] = data[end-1];
		data[end-1] = tmp;

		int i = begin;
		if (end - begin > 2) {
			for (int j = begin + 1;j < end - 1;j++) {
				if (data[j] <= pivot) {
					i++;
					tmp = data[i];
					data[i] = data[j];
					data[j] = tmp;
				}
			}
			tmp = data[end-1];
			data[end-1] = data[i+1];
			data[i+1] = tmp;
		}
		return (i + 1);
	}
	private int partitionRandomPivot(int []data, int begin, int end)
	{
		int randomIdx = (int)(Math.random() * (end - begin)) + begin;
		int pivot = data[randomIdx];
		
		int tmp = data[randomIdx];
		data[randomIdx] = data[end];
		data[end] = tmp;
		
		int i = begin - 1;
		for (int j = begin;j < end;j++) {
			if (data[j] <= pivot) {
				i++;
				tmp = data[i];
				data[i] = data[j];
				data[j] = tmp;
			}
		}
		tmp = data[end];
		data[end] = data[i+1];
		data[i+1] = tmp;

		return (i + 1);
	}
	private void maxHeapify(int []A, int i, int size)
	{
		if (!hasChild(A, i, size))
			return;
		int k = biggerChild(A, i, size);
		if (A[i] >= A[k])
			return;
		int tmp = A[i];
		A[i] = A[k];
		A[k] = tmp;
		maxHeapify(A, k, size);
	}
	private boolean hasChild(int []A, int i, int size)
	{
		if (2 * i + 1 <= size - 1)
			return true;
		return false;
	}
	private int biggerChild(int []A, int i, int size)
	{
		if (2 * i + 2 > size - 1 || A[2 * i + 1] > A[2 * i + 2])
			return 2 * i + 1;
		else
			return 2 * i + 2;
	}
	private void buildMaxHeap(int []A, int size)
	{
		for (int i = size / 2 - 1;i >= 0;i--)
			maxHeapify(A, i, size);
	}
	
	
	
	
	protected void selectionSort(int []arr, int size)
	{
		for (int i = size - 1;i > 0;i--) {
			int idx = 0;
			int max = arr[idx];
			for (int j = 1;j <= i;j++)
				if (arr[j] > max) {
					max = arr[j];
					idx = j;
				}
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
		}
	}
	
	protected void bubbleSort(int []arr, int size)
	{
		for(int i=size-1;i>0;i--)
			for(int j=0;j<=i-1;j++)
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
	}
	
	protected void insertionSort(int []arr, int size){
		for (int i = 1;i < size;i++) {
			int tmp = arr[i];
			for (int j = i;j >= 0;j--) {
				if (j == 0)
					arr[j] = tmp;
				else if (tmp >= arr[j - 1]) {
					arr[j] = tmp;
					break;
				}
				else
					arr[j] = arr[j - 1];
			}
		}
	}
	
	protected void mergeSorting(int []arr, int begin, int end)
	{
		if (begin < end) {
			int q = (begin + end) / 2;
			mergeSorting(arr, begin, q);
			mergeSorting(arr, q + 1, end);
			merge(arr, begin, q, end);
		}
	}
	
	protected void quickSort(int []data, int begin, int end)
	{
		int pivot_idx;
		if (begin < end) {
			pivot_idx = partition(data, begin, end);
			quickSort(data, begin, pivot_idx - 1);
			quickSort(data, pivot_idx + 1, end);
		}
	}
	protected void quickSortMed(int []data, int begin, int end)
	{
		int pivot_idx;
		if (begin < end) {
			pivot_idx = partitionMedianPivot(data, begin, end);
			quickSortMed(data, begin, pivot_idx - 1);
			quickSortMed(data, pivot_idx + 1, end);
		}
	}
	protected void quickSortRan(int []data, int begin, int end)
	{
		int pivot_idx;
		if (begin < end) {
			pivot_idx = partitionRandomPivot(data, begin, end);
			quickSortRan(data, begin, pivot_idx - 1);
			quickSortRan(data, pivot_idx + 1, end);
		}
	}
	protected void heapSort(int []A, int size) {
		buildMaxHeap(A, size);
		for (int i = size - 1;i > 0;i--) {
			int tmp = A[0];
			A[0] = A[i];
			A[i] =tmp;
			size--;
			maxHeapify(A, 0, size);
		}
	}
}
