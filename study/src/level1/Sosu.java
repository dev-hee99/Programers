package level1;

import java.util.Arrays;
import java.util.Scanner;
/* �����佺�׳׽��� ü
 * ������ ��� �ڿ����� �Ҽ����� ������ ǥ���� �ȴٰ� �߽��ϴ�. ���� ���� �Ҽ� 2���� �����մϴ�.
 *  2���� N-1������ �� �߿��� 2�� ����� ��� ü�� �Ÿ��� ���� ���ڵ� �߿��� 3�� ����� �Ÿ��� �ݺ��ؼ�
 *   ������N ���� ������ �ɷ����� �ʰ� ���� ������ ��� �Ҽ��� �˴ϴ�.
 * */

public class Sosu {

	public static void main(String[] args) {
		System.out.print("2~n������ �Ҽ��� ���� ���ϱ�");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		System.out.println(solution(input));
		int [] temp = new int[5];
		Arrays.sort(temp);
		
	}
    private static int solution(int n) {
        int answer = 0;
        boolean [] sosu = new boolean[n+1];
        for(int i=2; i<=n ; i++) sosu[i]=true; //���� �Ҽ��� �ʱ�ȭ

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