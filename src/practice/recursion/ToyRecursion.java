package practice.recursion;
/**
 * @author Amber
 *
 */
public class ToyRecursion {

	/**
	 *  1.��1+2+3+����+n��ֵ
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
	 * 2.��1*2*3*����*n��ֵ
	 * 
	 */
	
	public static int multi(int n) {
		if(n==1) {
			return 1;
		}
		
		return n*multi(n-1);
	}
	
	/**
	 * 3.С���ӵ�һ��ժ����������,�����Ե�һ��,�ֶ��һ��.�ڶ��������ֽ�ʣ�µ����ӳ�
	          һ��,�ֶ��һ��.�Ժ�ÿ�����ϳ�ǰһ��ʣ�µ�һ����һ��.����10�����Ϻ������ٳ�ʱ��
		��,ֻʣ��һ��������.�ʵ�һ����ӹ�ժ���ٸ����ӣ�
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
