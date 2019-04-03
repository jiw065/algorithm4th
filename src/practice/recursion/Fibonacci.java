package practice.recursion;
import edu.princeton.cs.algs4.Out;

//0、1、1、2、3、5, 8、13、21、34 
// what is the number for #N?
public class Fibonacci {

	public int fabCalc(int a) {
		if(a==1 || a==2) {
			return 1;
		}
		return fabCalc(a-1)+fabCalc(a-2);
	}

	public int fab(int a) {
		int e =1;
		int f =1;
		
		for (int i = 2;i<a;i++) {
			int temp = e+f;
			e = f;
			f = temp;
		}
		
		return f;
		
		
	}
	public static void main(String[] args) {
		Fibonacci fi = new Fibonacci();
		
		System.out.println(fi.fabCalc(40));
		System.out.println(fi.fab(40));

	}

}
