package level2;
/*
[피보나치 수]

문제 설명
피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.

예를들어

F(2) = F(0) + F(1) = 0 + 1 = 1
F(3) = F(1) + F(2) = 1 + 1 = 2
F(4) = F(2) + F(3) = 1 + 2 = 3
F(5) = F(3) + F(4) = 2 + 3 = 5
와 같이 이어집니다.

2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.

제한 사항
* n은 1이상, 100000이하인 자연수입니다.

입출력 예
n	return
3	2
5	5
 */
public class Fibonacci {
    private static final int NUM = 1234567;
    public static void main(String[] args) {
        System.out.println(solution(60));
    }
    public static int solution(int n) {
        return fibonacci(n);
    }
    // arr[n]%NUM = (arr[n-1]%NUM + arr[n-2]%NUM)%NUM; 모듈러 성질에 의해 성립
    // int 범위 2147483647을 넘어버려 스택오버플로우 발생.

    public static int fibonacci(int n){
        int[] arr = new int[n+1];
        arr[0] = 0; arr[1] = 1;

        for(int i=2;i<=n;i++)
            arr[i] = (arr[i-1]%NUM) + (arr[i-2]%NUM);

        return arr[n]%NUM;
    }

    public static int fibonacci2(int n){
        if(n==0) return 0;
        if(n==2 || n==1) return 1;
        return fibonacci(n-1)%NUM + fibonacci(n-2);
    }
}
