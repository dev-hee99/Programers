package level1;

import java.util.Scanner;

public class GCDLCM {
	static int first;
	static int second;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int temp;
		int gcd;
		int lcm;
		System.out.println("두 수를 입력하세요");
		first = sc.nextInt();
		second = sc.nextInt();
		if(second > first) {
			temp = second; 
			second = first;
			first = temp;
		}
		gcd = gcd(first,second);
		lcm = (first*second)/gcd;
		System.out.println("최대 공약수:"+ gcd);
		System.out.println("최소 공배수:"+lcm);

	}
	
	public static int gcd(int f, int s) {
		if(f%s==0) return s;
		return gcd(f,f%s);
	}

}
