package algorithems4th.sorting;

import java.io.File;
import java.util.Arrays;

import algorithems4th.sorting.pattern.BruteCollinearPoints;
import algorithems4th.sorting.pattern.LineSegment;
import algorithems4th.sorting.pattern.Point;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class Test {

	public static void main(String[] args) {

	    // read the n points from a file
	    In in = new In(new File("J:\\programs\\cs\\ALgorithms\\al4th\\sort\\input20.txt"));
	    int n = in.readInt();
	    Point[] points = new Point[n];
	    for (int i = 0; i < n; i++) {
	        int x = in.readInt();
	        int y = in.readInt();
	        points[i] = new Point(x, y);
	    }

	    // draw the points
	    StdDraw.enableDoubleBuffering();
	    StdDraw.setXscale(0, 32768);
	    StdDraw.setYscale(0, 32768);
	    for (Point p : points) {
	        p.draw();
	    }
	    StdDraw.show();
  
	    // print and draw the line segments
	    BruteCollinearPoints collinear = new BruteCollinearPoints(points);
	    for (LineSegment segment : collinear.segments()) {
	    	if(segment!=null) {
	        StdOut.println(segment);
	        segment.draw();
	    	}
	    }
	    StdDraw.show();
	}

}
