package level1;

import java.util.ArrayList;
import java.util.List;

/*
[약수의 개수와 덧셈]
두 정수 left와 right가 매개변수로 주어집니다. left부터 right까지의 모든 수들 중에서,
 약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.

13	17	43
24	27	52
*/
public class evenDivisorsCount {
    private static int [] left = {13,24};
    private static int [] right = {17,27};
    public static void main(String[] args) {
        for(int i=0;i<left.length;i++) System.out.println(solution(left[i],right[i]));
    }
    private static int solution(int left,int right){
        int answer = 0;
        List<Integer> divisors = new ArrayList<>();
        for(int i=left; i<=right;i++){
            divisors.clear();
            for(int j=1; j<=i;j++ ){
                if(i%j==0) divisors.add(j);
            }
            answer = divisors.size()%2==0 ? answer+i : answer-i;
        }
        return answer;
    }
}
