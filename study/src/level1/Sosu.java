package level1;

import java.util.Arrays;
import java.util.Scanner;
/* 에라토스테네스의 체
 * 위에서 모든 자연수는 소수들의 곱으로 표현이 된다고 했습니다. 제일 작은 소수 2부터 시작합니다.
 *  2부터 N-1까지의 수 중에서 2의 배수를 모두 체로 거르고 남은 숫자들 중에서 3의 배수로 거르고를 반복해서
 *   제곱근N 까지 나눠서 걸러지지 않고 남은 수들이 모두 소수가 됩니다.
 * */

public class Sosu {

	public static void main(String[] args) {
		System.out.print("2~n까지의 소수의 개수 구하기");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		System.out.println(solution(input));
		int [] temp = new int[5];
		Arrays.sort(temp);
		
	}
    private static int solution(int n) {
        int answer = 0;
        boolean [] sosu = new boolean[n+1];
        for(int i=2; i<=n ; i++) sosu[i]=true; //전부 소수로 초기화

        int sqrt = (int)Math.sqrt(n);

        for(int i=2; i<=sqrt; i++){

            for(int j=i;i*j<=n;j++){
                sosu[i*j] = false;
            }

        }

        for(int i=2; i<=n; i++){
            if(sosu[i]==true) answer++;
        }

        return answer;
    }

}