/**
 * 
 */
package algorithems4th.sorting;

import java.util.Scanner;

import javax.swing.plaf.nimbus.AbstractRegionPainter;

import org.omg.CORBA.PUBLIC_MEMBER;


/**
 * @author Amber
 *
 */
public class TestArraySort {

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
//		Scanner s = new Scanner(System.in);		
//		System.out.println("please enter the number:");
//		int n = s.nextInt();
	//	double[] ia = new double[n];
		
		//3.0,1.0, 9.0, 4.0, 1.0, 2.0, 8.0, 8.0, 5.0, 0.0
		double[] ia ={7.0,1.0, 9.0, 4.0, 1.4, 2.0, 8.8, 8.0, 5.0,2.8};
//		System.out.println("Please enter the list:");
	
//		for (int i=0;i<n;i++) {
//			ia[i] = Math.round(Math.random()*10);
//		}
		
		printArray(ia);
		//TestArraySort.printArray(ia);
		//bubbleSort(ia);
		selectionSort(ia);
		//enhancedSelectionSort(ia);
		//InsertingSort(ia);
		//qucikSort(ia,0,ia.length-1);
		//printArray(ia);
		
		//System.out.println(binarySearch(ia, 4.0));
		//System.out.println(binarySearchRec(0, ia.length-1, ia, 4.0));
	}
	

	
	/**
	 * Print sorted array
	 * @param Sorted Array
	 */
		public static void printArray(double[] d) {
			for (int i=0; i<d.length; i++) {
				System.out.print(d[i]+" ");
			}	
			System.out.println();
		}

	
/**
 * Bubble Sort - TODO
 * @param d: The input unsorted array
 * 1.compare each elements next to other 
 */
	public static void bubbleSort(double[] d) {		
		System.out.println("Bubble Sort");
	    for (int i= 0; i<d.length; i++) {
	    	for(int j=0; j< d.length-i-1;j++) {
	    		if(d[j]>d[j+1]) {
	    			swap(j,j+1,d);
	    		}
	    		
	    	}
	    }
		TestArraySort.printArray(d);
	}

/**
 * Selection Sort - TODO
 * @param d: The input unsorted array
 */
	public static void selectionSort(double[] d) {
		System.out.println("Selection Sort");
		for(int i=0; i<d.length;i++) {
			double min = Double.MAX_VALUE;
			int minindex = -1;
			for(int j=i;j<d.length;j++ ) {
				if(d[j] < min) {
					min = d[j];
					minindex = j;
				}
			}
			swap(i, minindex, d);
		}
		
		
		TestArraySort.printArray(d);
	}

/**
 * 	
 * @param d
 */
	public static void enhancedSelectionSort(double[] d) {
		System.out.println("Enhanced Selection Sort");
		int ind;
		double temp;
		for (int i=0; i<d.length; i++) {
		    ind = i;
			for (int j=ind+1; j<d.length;j++) {
				if (d[j] < d[ind]) {
						ind = j;						
				}
			}
		    temp = d[ind];
			d[ind] = d[i];
			d[i] = temp;			
		}
	   printArray(d);
	}
	// TODO
	private static void InsertingSort(double[] d) {
		int current = 0;
		double temp = 0;
        for(int i = 0;i<d.length;i++) {
        	for (int j=i; j>0; j--) {
        		if(d[i] > d[j]) {
        			
        		}
        	}
        }
		
		System.out.println("Insertion Sort");
		printArray(d);
	}	
	
	//4.0,1.0,7.0,6.0,5.0,2.0,8.0,3.0
	private static void qucikSort(double[] d,int l,int r) {
		//.out.println("quick sort inner Selection Sort");
		if (l >= r) {
			return;
		}
		double pivot = d[l];
		int left = l;
		int right = r;
		while (left < right ) {	
			while (d[right] > pivot && left < right  ) {
				right--;
			}
		
			while (d[left] <= pivot && left < right) {
				left++;											
			}
			
//			System.out.println("left "+d[left]+" right"+d[ri]);
			swap(left,right,d);
				
		}

	//	if(pivot > d[right]) {
			swap(l,left,d);
	//	}

		qucikSort(d, l, left-1);
		qucikSort(d, right+1, r);
				
	}
	
	// TODO
	public static void qSort(double[] d,int l,int r) {
		
		return;
	}
	
//	
//	private static void quickSort(double[] d,int l, int r) {
//			
//		if(l < r) {
//			int pivot = qucikSort(d, l, r);
//			quickSort(d, l, pivot);
//			quickSort(d, pivot, r);
//		}
//		
//	}
		
	public static void swap(int a,int b,double[] d) {
	//	System.out.println("swap "+d[a]+" "+d[b]);
		double temp = 0 ;
		temp = d[a];
		d[a] =d[b];
		d[b] = temp;
		
	}
	
	// TODO
	public static int binarySearch (double[] d,double num) {
		
		int index = -1;

		
		
		return index;
	}
	
	
	public static int binarySearchRec(int head,int tail,double[] d,double a) {
		int mid = (head+tail)/2;
		
		qSort(d, head, tail);
		
		
		if(mid<head||mid>tail) {
			return -1;
		}else {
			if( d[mid] == a) {
				return mid;
			} 
		int l_tail = mid-1;
		int r_head = mid+1;
		if(d[mid] > a) {
			return binarySearchRec(head, l_tail, d, a);
		}else {
			return binarySearchRec(r_head,tail, d, a);
		}
		}
	}

	
	
}
