package practice.recursion;
/**
 * @author Amber
 *
 */
public class ToyRecursion {

	/**
	 *  1.求1+2+3+……+n的值
	 * @param n
	 * @return
	 */
	public static int sum(int n) {
		if(n==1) {
			return 1;
		}
		
		return sum(n-1)+n;
	}
	
	/**
	 * 2.求1*2*3*……*n的值
	 * 
	 */
	
	public static int multi(int n) {
		if(n==1) {
			return 1;
		}
		
		return n*multi(n-1);
	}
	
	/**
	 * 3.小猴子第一天摘下若干桃子,当即吃掉一半,又多吃一个.第二天早上又将剩下的桃子吃
	          一半,又多吃一个.以后每天早上吃前一天剩下的一半另一个.到第10天早上猴子想再吃时发
		现,只剩下一个桃子了.问第一天猴子共摘多少个桃子？
	 * 
	 */
	
	public static double monkey(int n) {
		if(n==10) {
			return 1;
		}
		return monkey(n+1)+1.5;
	}
	
	
	
	public static void main(String[] args) {
		//System.out.println("sum "+sum(50));
		//System.out.println("multiply "+multi(10));
		System.out.println("Monkey "+monkey(0));
	}

}
