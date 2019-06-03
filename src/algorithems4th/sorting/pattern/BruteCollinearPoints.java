package algorithems4th.sorting.pattern;

import java.io.File;
import java.time.chrono.MinguoChronology;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;

/**
 * 	public BruteCollinearPoints(Point[] points)    // finds all line segments containing 4 points
	public           int numberOfSegments()        // the number of line segments
	public LineSegment[] segments()                // the line segments
 * @author Amber
 *
 */
public class BruteCollinearPoints {
	Point p = new Point(0,0);
	Point[] aux;
	LineSegment[] segList;
	HashSet<Point> lset = new HashSet<LineSegment>();
	final int SIZE = 3;
	int numSeg = 0;
	public BruteCollinearPoints(Point[] points) {
		segList = new LineSegment[points.length];
		this.numSeg = 0;
		Arrays.sort(points);
		Point max = new Point(0,0);
		Point min = new Point(32767,32767);
		Point min_temp = min;
		Point max_temp = max;
		for (int i=0;i<points.length;i++) {
			for(int j=i+1;j<points.length;j++) {
				for(int k= j+1;k<points.length;k++) {
					for(int m=k+1;m<points.length;m++) {
						double s1 = points[i].slopeTo(points[j]);
						double s2 = points[i].slopeTo(points[k]);
						double s3 = points[i].slopeTo(points[m]);
						
						if(s1==s2 && s2==s3) {
							if(min.compareTo(points[i])>=0||max.compareTo(points[m])!=0) {
								min = points[i];			
							}
							if(max.compareTo(points[m])<=0 || min.compareTo(points[i])!=0) {
								max = points[m];
							}
					
						}
					}
				}
			}
			
			if(min.compareTo(new Point(32767,32767))!=0&& max.compareTo(new Point(0,0))!=0) {

				if (min.compareTo(min_temp)!=0 && max.compareTo(max_temp)!=0) {
					min_temp = min;
					max_temp = max;
					segList[numSeg] = new LineSegment(min, max);
				
					numSeg++;
				}
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
		 In in = new In(new File("J:\\programs\\cs\\ALgorithms\\al4th\\sort\\input8.txt"));
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
