package sda.code.intermediate.part1.exercises;

import java.math.BigInteger;

public class Algorithms {

	public int smallest(int array[]) {
		if (array == null || array.length < 1)
			throw new IllegalArgumentException();
		int smallestVal = array[0];
		for (int i = 1; i < array.length; i++) {
			smallestVal = (smallestVal > array[i]) ? array[i] : smallestVal;
			// if (smallestVal > array[i]) {
			// smallestVal = array[i];
			// }
		}
		return smallestVal;
		 //throw new UnsupportedOperationException("Not implemented yet");
	}

	public int largest(int array[]) {
		if (array == null || array.length < 1)
			throw new IllegalArgumentException();
		int largestVal = array[0];
		for (int i = 1; i < array.length; i++) {
			largestVal = (largestVal < array[i]) ? array[i] : largestVal;
			// if (largestVal < array[i]) {
			// largestVal = array[i];
			// }
		}
		return largestVal;
		// throw new UnsupportedOperationException("Not implemented yet");
	}

	public long factorial(long n) {
		long result = 1L;

		if (n < 0)
			throw new IllegalArgumentException();
		for (long i = 1L; i <= n; ++i) {
			result *= i;
		}
		return result;

		// throw new UnsupportedOperationException("Not implemented yet");
	}

	public long fibonacci(long n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		if (n == 0) {
			return 0L;
		}
		long n1 = 0L;
		long result = 1L;
		for (int i = 2; i <= n; ++i) {
			long n2 = result;
			result = result + n1;
			n1 = n2;
		}
		return result;
		// throw new UnsupportedOperationException("Not implemented yet");
	}

	public BigInteger bigFibonacci(int n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		if (n == 0) {
			return BigInteger.ZERO;
		}
		BigInteger n1 = BigInteger.ZERO;
		BigInteger result = BigInteger.ONE;
		for (int i = 2; i <= n; ++i) {
			BigInteger n2 = result;
			result = result.add(n1);
			n1 = n2;
		}
		return result;
		//throw new UnsupportedOperationException("Not implemented yet");
	}

	public int[] createRandomArray(int length) {
		if (length<0) throw new IllegalArgumentException();
		int[] tab = new int[length];
		for(int i=0;i<length;i++){
			tab[i]=(int)(Math.random() * 100);
		}
		return tab;
		//throw new UnsupportedOperationException("Not implemented yet");
		//
	}

}
