package algorithems4th.sorting.pattern;

import java.io.File;
import java.time.chrono.MinguoChronology;
import java.util.Arrays;
import java.util.Collections;

import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;

/**
 * 	public BruteCollinearPoints(Point[] points)    // finds all line segments containing 4 points
	public           int numberOfSegments()        // the number of line segments
	public LineSegment[] segments()                // the line segments
 * @author Amber
 *
 */
public class BruteCollinearPoints2 {
	Point p = new Point(0,0);
	Point[] aux;
	LineSegment[] segList;
	final int SIZE = 3;
	int numSeg = 0;
	public BruteCollinearPoints2(Point[] points) {
		segList = new LineSegment[points.length];
		aux = points.clone();
		this.numSeg = 0;
		Point invoker = null;
		double seg_scope = 0;
		Arrays.sort(aux,Collections.reverseOrder());
		for (int p= 0; p<aux.length;p++) {
			
//			if (invoker !=null && invoker.slopeTo(aux[p]) == seg_scope) {
//				continue;
//			}
			invoker = aux[p];
			
			Arrays.sort(points, invoker.slopeOrder());
			int i = 0;
			int j= i; 
			int counter = 0; 
			while(i<points.length ) {	
				//System.out.println(invoker.toString()+	" while  "+points[i].toString()+" "+counter);
				double scope = invoker.slopeTo(points[j]);	
				if(invoker.compareTo(points[i])>=0) {
					
					
					if(scope == invoker.slopeTo(points[i])  ) {
						counter ++;
					//	System.out.println(invoker.toString()+" scopeee "+points[i].toString()+" "+scope+" "+counter);

						if(counter == SIZE  ) {
						//	System.out.println(invoker.toString()+" adadad  "+points[i].toString()+" "+scope);
							seg_scope = scope;
							segList[this.numSeg] = new LineSegment(invoker, points[i]);
							this.numSeg++;
						}
					}else {
						j = i;
						counter = 1;
					}
				}else {
					break;
				}
				i++;			
			}	
		}
	}

	public int numberOfSegments() {
		return numSeg;
	}
	
	public LineSegment[] segments() {
		return segList;
	}
	public static void main(String[] args) {
		 In in = new In(new File("J:\\programs\\cs\\ALgorithms\\al4th\\sort\\input20.txt"));
		    int n = in.readInt();
		    Point[] plist = new Point[n];
		    for (int i = 0; i < n; i++) {
		        int x = in.readInt();
		        int y = in.readInt();
		        plist[i] = new Point(x, y);
		    }
        
		Point[] copy = plist.clone();    
		Arrays.sort(copy,Collections.reverseOrder());
        
    	for(Point p1 : copy) {
		System.out.print(p1.toString()+" ");
	}
    	System.out.println();
    	for(int i=0;i<copy.length;i++) {
    	
    	Point p = copy[i];
    	System.out.println("sort "+p.toString());
    	Arrays.sort(plist, p.slopeOrder());
    	
    	for(Point p2 : plist) {
    		System.out.print(p2.toString()+" = "+p.slopeTo(p2)+", ");
    	}
    	System.out.println();
    	}

//    	BruteCollinearPoints bp = new BruteCollinearPoints(plist);
//    	System.out.println(bp.numberOfSegments());
//    	for (LineSegment ls : bp.segments()) {
//    		if(ls!=null) {
//    			System.out.println(ls.toString());
//    		}	
//    	}
	}

}
