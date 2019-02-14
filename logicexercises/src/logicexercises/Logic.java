package logicexercises;

import java.util.Arrays;
import java.util.LinkedList;

public class Logic {

	public static void main(String[] args) {
		allxarenty();
		somexarez();
		noxarez();
	}
	
	public static boolean allXareY(int[] x, int[] y) {
		LinkedList<Integer> x2 = new LinkedList<Integer>();
		LinkedList<Integer> y2 = new LinkedList<Integer>();
		for(int i = 0; i < x.length; i++) {
			x2.add(x[i]);
		}
		for(int z = 0; z < y.length; z++) {
			y2.add(y[z]);
		}
		for(int a = 0; a < x2.size(); a++) {
			if(y2.contains(x[a])) {
				
			} else {
				return false;
			}
		}
		return true;
	}
	
	private static int[] whichIsLarger(int[] x, int[] y) {
		if(x.length > y.length) {
			return x;
		} else if(y.length > x.length) {
			return y;
		} else {
			return x;
		}
	}
	
	public static boolean someXareY(int[] x, int[] y) {
		LinkedList<Integer> arrtolist = new LinkedList<Integer>();
		if(whichIsLarger(x, y) == x) {
			for(int i = 0; i < x.length; i++) {
				arrtolist.add(x[i]);
			}
		} else {
			for(int i = 0; i < y.length; i++) {
				arrtolist.add(y[i]);
			}
		}
		for(int z = 0; z < arrtolist.size(); z++) {
			if(arrtolist.contains(x[z])) {
				return true;
			}
		}
		return false;
	}
	
	static int [] x = {1, 2, 3};
	static int[] y = {4, 5, 6};
	static int [] z = {1, 2, 3, 4, 5, 6};
	
	public static String allxarez() {
		if(allXareY(x, z)) {
			return "All x are z";
		}	
		return null;
	}
	
	public static String allyarez() {
		if(allXareY(y, z)) {
			return "All y are z";
		}
		return null;
	}
	
	public static void allxarenty() {
		System.out.println("x: " + Arrays.toString(x));
		System.out.println("y: " + Arrays.toString(y));
		System.out.println("z: " + Arrays.toString(z));
		System.out.println(allxarez());
		System.out.println(allyarez());
		System.out.println("Not all x are y");
	}
	
	static int[] x1 = {1, 2, 3, 7, 8, 9};
	static int[] y1 = {1, 2, 3, 4, 5, 6};
	static int[] z1 = {1, 2, 3, 4, 5, 6};
	
	public static String somexarey() {
		if(someXareY(x1, y1)) {
			return "some x are y";
		}
		return null;
	}
	
	public static String allyarez2() {
		if(allXareY(y1, z1)) {
			return "all y are z";
		}
		return null;
	}
	
	public static void somexarez() {
		System.out.println("x: " + Arrays.toString(x1));
		System.out.println("y: " + Arrays.toString(y1));
		System.out.println("z: " + Arrays.toString(z1));
		System.out.println(somexarey());
		System.out.println(allyarez());
		System.out.println("Some x are z");
	}
	
	
	public static int[] x2 = {1, 2, 3};
	public static int[] y2 = {1, 2, 3, 4, 5, 6};
	public static int[] z2 = {4, 5, 6, 7, 8, 9};
	
	public static String allxarey() {
		if(allXareY(x2, y2)) {
			return "All x are y";
		}
		return null;
	}
	
	public static String someyarez2() {
		if(someXareY(y2, z2)) {
			return "some y are z";
		}
		return null;
	}
	
	public static void noxarez() {
		System.out.println("x: " + Arrays.toString(x2));
		System.out.println("y: " + Arrays.toString(y2));
		System.out.println("z: " + Arrays.toString(z2));
		System.out.println(allxarey());
		System.out.println(someyarez2());
		System.out.println("No x are z");
	}
}