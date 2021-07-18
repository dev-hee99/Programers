package level1;
/*
[3진법 뒤집기]
자연수 n이 매개변수로 주어집니다.
 n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
n은 1 이상 100,000,000 이하인 자연수입니다.
입출력 예
n	result
45	7
125	229
 */
public class Ternary {
    public static void main(String[] args) {
        System.out.println(solution(45));
    }
    public static int solution(int n) { ;
        int answer=0;
        StringBuilder sb = new StringBuilder();
        for(int i=n; 0<i; i/=3)
            sb.append(i%3);
        sb.reverse();
        String [] arr = sb.toString().split("");
        for(int i=0; i<arr.length;i++)
            answer += Math.pow(3,i) * Integer.parseInt(arr[i]);
        return answer;
    }

}
