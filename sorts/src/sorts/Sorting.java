package sorts;
import static java.lang.Math.toIntExact;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Sorting {

	public static void main(String[] args){
		Sorting meeh = new Sorting();
		int[] gah = randP(10000);
		//System.out.println(Arrays.toString(gah));
		int[] gahpart2 = gah.clone();
		//int n = toIntExact(endtime);
		long starttime = System.currentTimeMillis();

		for(int i = 0; i <100; i++) {
			gahpart2 = gah.clone();
			quicksort(gahpart2);
		}
		long endtime = System.currentTimeMillis();
		System.out.println("Recursive calls: " + quickCount);
		System.out.println("Quicksort: " + (endtime - starttime));
		//int nu = toIntExact(endtime);
		int[] gahpart3 = gah.clone();
		starttime = System.currentTimeMillis();
		for(int i = 0; i <100; i++) {
			gahpart3 = gah.clone();
			mergesort(gahpart3);
		}
		endtime = System.currentTimeMillis();
		System.out.println("Mergesort: " + (endtime - starttime));
		int[] gahpart4 = gah.clone();
		//int num = toIntExact(endtime);
		starttime = System.currentTimeMillis();
		for(int i = 0; i <100; i++) {
			gahpart4 = gah.clone();
			bubbleSort(gahpart4);
		}
		endtime = System.currentTimeMillis();
		System.out.println("Bubblesort: " + (endtime - starttime));
		int[] gahpart5 = gah.clone();
		//int numb = toIntExact(endtime);
		starttime = System.currentTimeMillis();
		for(int i = 0; i <100; i++) {
			gahpart5 = gah.clone();
			insertionSort(gahpart5);
		}
		endtime = System.currentTimeMillis();
		System.out.println("Insertionsort: "+(endtime - starttime));
		int[] gahpart6 = gah.clone();
		//int numbe = toIntExact(endtime);
		starttime = System.currentTimeMillis();
		for(int i = 0; i <100; i++) {
			gahpart6 = gah.clone();
			selectionSort(gahpart6);
		}
		endtime = System.currentTimeMillis();
		System.out.println("Selectionsort: " + (endtime - starttime));
		int[] gahpart7 = gah.clone();
		//int number = toIntExact(endtime);
		starttime = System.currentTimeMillis();
		for(int i = 0; i <100; i++) {
			gahpart7 = gah.clone();
			heapsort(gahpart7);
		}
		endtime = System.currentTimeMillis();
		System.out.println("Heapsort: " + (endtime - starttime));
	}
	static int quickCount = 0;
	static void quicksort(int[] a) {
		quick(a, 0, a.length-1);
	}

	static void quick(int[] a, int left, int right) {
		quickCount++;
		if (right > left) {
			int pivotPos = partition(a, left, right);
			quick(a, left, pivotPos-1);
			quick(a, pivotPos+1, right);
			
		}
	}

	static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];  
        int i = (low-1);
        for (int j=low; j<high; j++){
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
        return i+1; 
	}

	static void swap1(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void mergesort(int[] arr) {
		ms(arr, 0, arr.length-1);
	}

	private static void ms(int[] a, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			ms(a, low, mid);
			ms(a, mid+1, high);
			merge(a, low, mid, high);
		}
	}

	private static void merge (int[] a, int low, int mid, int high) {
		int[] b = new int[a.length];
		int i, j, k;

		for (i = low; i <= high; i++)
			b[i]=a[i];

		i = low; j = mid+1; k = low;
		while (i <= mid && j <= high)
			if (b[i]<=b[j])
				a[k++]=b[i++];
			else
				a[k++]=b[j++];

		while (i <= mid)
			a[k++]=b[i++];
	}

	static void bubbleSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j+1]) {
					swap1(a, j, j+1);
				}
			}
		}
	}

	static void insertionSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			insert(a, i);
		}
	}

	static void insert(int[] a, int i) {
		int j;
		for (j = 0; a[i] > a[j] && j < i; j++) {}
		int temp = a[i];
		for (int k = i; k > j; k--) {
			a[k] = a[k-1];
		}
		a[j] = temp;
	}

	static void selectionSort(int[] a) {
		int min, minPos;
		for (int i = 0; i < a.length; i++) {
			min = a[i];
			minPos = i;
			for (int j = i; j < a.length; j++) {
				if (a[j] < min) {
					min = a[j];
					minPos = j;
				}
			}
			swap1(a, i, minPos);
		}
	}

	public static void heapsort(int[]a) {
		buildHeap(a);
		sortHeap(a);
	}


	private static void buildHeap(int[] a) {
		for (int i = a.length-1; i >= 0; i--) {
			trickle(a, i, a.length);
		}
	}

	private static void sortHeap(int[] a) {
		for (int i = a.length-1; i >= 0; i--) {
			swap1(a, 0, i);
			trickle(a, 0, i);
		}
	}

	private static void trickle(int[] a, int i, int lastPosition) {
		int max = 0, maxPos = 0;
		if (hasChildren(i, lastPosition)) {
			if (hasOnlyLeftChild(i, lastPosition)) {
				max = a[left(i)];
				maxPos = left(i);
			} else {
				maxPos = (a[left(i)] > a[right(i)]) ? left(i) : right(i);
				max = a[maxPos];
			}
			if (max > a[i]) {
				swap1(a, i, maxPos);
				trickle(a, maxPos, lastPosition);
			}
		}
	}

	private static int left(int x) { return 2*x + 1; }
	private static int right(int x) { return 2*x + 2; }
	private static int parent(int x) { return (x-1) / 2; }

	private static void swap(int[] arr, int i1, int i2) {
		int temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
	}

	private static boolean hasChildren(int index, int length) {
		return (index+1 <= (length >> 1));
	}

	private static boolean hasOnlyLeftChild(int index, int length) {
		return ((index*2)+2 == length);
	}

	void printArray(int[] a) {
		System.out.print("{ " + a[0]);
		for (int i = 1; i < a.length; i++) {
			System.out.print(", " + a[i]);
		}
		System.out.println(" }");
	}

	public static int[] randP(int size){
		Random rand = new Random();
		int[] arr = new int[size];
		for(int i = 0; i < size; i++){
			arr[i] = i;
		}
		for(int x = size - 1; x > 0; x--){
			int chosenone = rand.nextInt(x + 1);
			swap1(arr, arr[chosenone], arr[x]);
		}
		
		return arr;
	}

}
