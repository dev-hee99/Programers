package level1;

import java.util.Scanner;
/*
 * 팩토리얼 알고리즘
 * 
 * */
public class Factorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		int result = factorial(sc.nextInt());
		System.out.println(result);
	}
	public static int factorial(int num) {
		if(num==1) return 1;
		return num * factorial(num-1);
	}
}
