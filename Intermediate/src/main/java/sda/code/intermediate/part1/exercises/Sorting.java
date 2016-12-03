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

		/*
		 * Pseudocode procedure bubbleSort( A : list of sortable items ) n =
		 * length(A) repeat swapped = false for i = 1 to n-1 inclusive do / if
		 * this pair is out of order / if A[i-1] > A[i] then / swap them and
		 * remember something changed / swap( A[i-1], A[i] ) swapped = true end
		 * if end for until not swapped end procedure throw new
		 * UnsupportedOperationException("Not implemented yet");
		 */
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

	/*
	 * PSEUDOKOD: PROCEDURE Quicksort(tablica, l, r) BEGIN IF l < r THEN {
	 * jeĹ›li fragment dĹ‚uĹĽszy niĹĽ 1 element } BEGIN i :=
	 * PodzielTablice(tablica, l, r); { podziel i zapamiÄ™taj punkt podziaĹ‚u }
	 * Quicksort(tablica, l, i-1); { posortuj lewÄ… czÄ™Ĺ›Ä‡ }
	 * Quicksort(tablica, i+1, r); { posortuj prawÄ… czÄ™Ĺ›Ä‡ } END END
	 * 
	 * {wybiera element, ktĂłry ma byÄ‡ uĹĽyty do podziaĹ‚u i przenosi wszystkie
	 * elementy mniejsze na lewo od tego elementu, a elementy wiÄ™ksze lub
	 * rĂłwne, na prawo od wybranego elementu } PROCEDURE
	 * PodzielTablice(tablica, l, r) BEGIN indeksPodzialu :=
	 * WybierzPunktPodzialu(l, r); {wybierz element, ktĂłry posĹ‚uĹĽy do
	 * podziaĹ‚u tablicy} wartoscPodzialu := tablica[indeksPodzialu];
	 * {zapamiÄ™taj wartoĹ›Ä‡ elementu} Zamien(tablica, indeksPodzialu, r);
	 * {przenieĹ› element podziaĹ‚u na koniec tablicy, aby sam nie braĹ‚
	 * udziaĹ‚u w podziale}
	 * 
	 * aktualnaPozycja := l; FOR i:=l; TO r-1 DO {iteruj przez wszytkie
	 * elementy, jeĹ›li element jest mniejszy niĹĽ wartoĹ›Ä‡ elementu podziaĹ‚u
	 * dodaj go do "lewej" strony} BEGIN IF tablica[i] < wartoscPodzialu THEN
	 * BEGIN Zamien(tablica, i, aktualnaPozycja); aktualnaPozycja :=
	 * aktualnaPozycja + 1; END END Zamien(tablica, aktualnaPozycja, r); {wstaw
	 * element podziaĹ‚u we wĹ‚aĹ›ciwe miejsce} return aktualnaPozycja; END
	 * 
	 * { podstawowa implementacja wyboru punktu podziaĹ‚u - wybiera element
	 * "Ĺ›rodkowy" w tablicy } PROCEDURE WybierzPunktPodzialu(l, r) BEGIN return
	 * l + (r-l) div 2; END
	 * 
	 * { zamienia miejscami elementy w komĂłrkach i1, i2 } PROCEDURE
	 * Zamien(tablica, i1, i2) BEGIN aux := tablica[i1]; tablica[i1] :=
	 * tablica[i2]; tablica[i2] := aux; END
	 */

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
		throw new UnsupportedOperationException("Not implemented yet");
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
		throw new UnsupportedOperationException("Not implemented yet");
	}

}
