package algorithems4th.unionfind;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	private int trials;
	private double[] results;
	private double mean;
	private double stddev;
	private double confLo;
	private double confHi;
	
   public PercolationStats(int n, int trials) {
	   if (n <= 0) {
			throw new IllegalArgumentException("Cannot create " + n + " * " + n + " site!");
		}
	   
	   if (trials <= 0) {
			throw new IllegalArgumentException("The number of trial is not valid!");
		}
	   results = new double[trials];
	   
	   int i = 0;
	   while(i<trials) {
		   Percolation pr = new Percolation(n);
		   while(!pr.percolates()) {
			   pr.open(StdRandom.uniform(n)+1, StdRandom.uniform(n)+1);
		   }
		   
		   results[i] = (double)pr.numberOfOpenSites()/(n*n);
		   i++;
	   }
	   
	   mean = StdStats.mean(results);
	   stddev = StdStats.stddev(results);
	   confLo = mean - (1.96 * stddev / Math.sqrt(trials));
	   confHi = mean + (1.96 * stddev / Math.sqrt(trials));
	   
   }
   public double mean() {
	   return mean;
   }
   public double stddev() {
	   return stddev;
   }
   public double confidenceLo() {
	   return confLo;
   }
   public double confidenceHi() {
	   return confHi;
   }

   public static void main(String[] args) {
	   int n = Integer.parseInt(args[0]);
	   int t = Integer.parseInt(args[1]);
	   PercolationStats prStats = new PercolationStats(n, t);
	   System.out.printf("mean                     = %f\n", prStats.mean());
	   System.out.printf("stddev                   = %f\n", prStats.stddev());
	   System.out.printf("95%s confidence interval  = [%f, %f]\n", "%", prStats.confidenceLo(), prStats.confidenceHi());
   }
}