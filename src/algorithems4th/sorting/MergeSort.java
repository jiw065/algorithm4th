package algorithems4th.sorting;

import java.util.Random;

public class MergeSort {
	
	public void sort(int[] sa) {
		int[] aux = new int[sa.length];
		mergeSort(aux,sa,0,sa.length-1);
		
	}
	public void merge(int[] aux, int[] sa,int lo, int mid,int hi) {
		int j = mid+1;
		int i = lo;
		int k = lo;
		
		while(i<=mid && j<=hi) {
			if(aux[i]<=aux[j]) {
				sa[k] = aux[i];
				i++;		
			}else {
				sa[k] = aux[j];
				j++;
			}
			k++;
		}
		//copy rest to array
		while(k <= hi) {
			if(i > mid) {
				sa[k] = aux[j];
				j++;
			}else if(j>hi) {
				sa[k] = aux[i];
				i++;
			}
			k++;
		}
		
	}
	public void mergeSort(int[]aux,int[] sa, int lo, int hi) {
		if (hi <= lo) {
			return;
		}

		// divide
		int mid = lo+(hi-lo)/2;
		mergeSort(aux,sa, lo, mid);
		mergeSort(aux,sa, mid+1, hi);
		//conquer
		
        for (int i = lo; i <= hi; i++) {
            aux[i] = sa[i];
        }
		merge(aux, sa, lo, mid, hi);
		

		
	}
	
	    public int[] setUp(int SIZE, int MAX) {
	       int[] numbers = new int[SIZE];
	        Random generator = new Random();
	        for (int i = 0; i < numbers.length; i++) {
	            numbers[i] = generator.nextInt(MAX);
	            System.out.print(numbers[i]+" ");
	        }
	        System.out.println();
	        return numbers;
	    }

	
	public static void main(String[] args) {
		
		MergeSort ms = new MergeSort();
		int[] array = ms.setUp(25, 14);
		ms.sort(array);
       
		for(int i : array) {
			System.out.print(i+" ");
		}

	}

}
