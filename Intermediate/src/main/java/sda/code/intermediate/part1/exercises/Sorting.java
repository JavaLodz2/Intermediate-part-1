package sda.code.intermediate.part1.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Sorting {

	

	public int[] bubbleSort(int array[]) {
		int out[] = array.clone();
		bubbleSortInner(out);
		return out;
	}

	private void bubbleSortInner(int array[]) {

		int len = array.length;
		boolean isSorted;
		do {
			isSorted = false;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					int a = array[i];
					array[i + 1] = array[i];
					array[i] = a;
					isSorted = true;
				}
			}
		} while (isSorted);

	}

	public int[] quickSort(int array[]) {
		int out[] = array.clone();
		quickSortInner(out, 0, out.length - 1);
		return out;
	}

	private void quickSortInner(int[] out, int low, int high) {
		if (low < high) {
			int mid = QuickSortInnerPartition(out, low, high);
			quickSortInner(out, low, mid - 1);
			quickSortInner(out, mid + 1, high);
		}
		// throw new UnsupportedOperationException("Not implemented yet");
	}

	private int QuickSortInnerPartition(int[] array, int low, int high) {
		int x = array[high];
		int i = low;
		for (int j = low; j < high; j++) {
			if (array[j] <= x) {
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
				i += 1;
			}
		}
		int temp = array[high];
		array[high] = array[i];
		array[i] = temp;
		return i;
	}

	public int[] mergeSort(int array[]) {

		if (array.length <= 1)
			return array;
		int half = array.length / 2;
		int[] left = new int[half];
		int[] right = new int[array.length - half];

		int leftCount = 0;
		int rightCount = 0;

		for (int i = 0; i < array.length; i++) {
			if (i < half) {
				left[leftCount] = array[i];
				leftCount++;
			} else {
				right[rightCount] = array[i];
				rightCount++;
			}
		}
		return merge(mergeSort(left), mergeSort(right));
		// throw new UnsupportedOperationException("Not implemented yet");
	}

	private int[] merge(int[] left, int[] right) {

		int leftSize = left.length;
		int rightSize = right.length;

		int size = leftSize + rightSize;

		int[] result = new int[size];

		int leftCount = 0;
		int rightCount = 0;

		for (int i = 0; i < size; i++) {
			if (leftCount < left.length && rightCount < right.length) {

				if (left[leftCount] <= right[rightCount]) {
					result[i] = left[leftCount];
					leftCount++;
				} else {
					result[i] = right[rightCount];
					rightCount++;
				}
			}
		}
		while (leftCount < left.length) {
			result[leftCount + rightCount] = left[leftCount];
			leftCount++;
		}
		while (rightCount < right.length) {
			result[leftCount + rightCount] = right[rightCount];
			rightCount++;
		}
		return result;
	}

	public String[] sortStrings(String[] array) {

		int len = array.length;
		boolean isSorted;
		do {
			isSorted = false;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i].compareTo(array[i + 1]) > 0) {
					String a = array[i];
					array[i + 1] = array[i];
					array[i] = a;
				}
			}
		} while (isSorted);

		return array;
		// throw new UnsupportedOperationException("Not implemented yet");
	}

	@SuppressWarnings("unchecked")
	public ArrayList<String> sortWithComparator(ArrayList<String> array, Comparator<String> comp) {
		ArrayList<String> out = (ArrayList<String>) array.clone();
		out.sort(comp);
		return out;
	}

	public <T extends Comparable<? super T>> T[] sortComparable(T array[]) {
		T[] out = array.clone();
		sortComparableInner(out);
		return out;
	}

	private <T extends Comparable<? super T>> void sortComparableInner(T[] array) {
		int len = array.length;
		boolean isSorted;
		do {
			isSorted = false;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i].compareTo(array[i + 1]) > 0) {
					T a = array[i];
					array[i + 1] = array[i];
					array[i] = a;
				}
			}
		} while (isSorted);

	}

	public static class NumericIntegerComparator implements Comparator<String> {

		@Override
		public int compare(String arg0, String arg1) {
//			if(Integer.parseInt(arg0)>Integer.parseInt(arg1)) return 1;
//			else if(Integer.parseInt(arg0)<Integer.parseInt(arg1)) return -1;
//			else return 0;
			return Integer.parseInt(arg0) - Integer.parseInt(arg1);
		}

	}
}
