package level1;
/*
[체육복]

문제 설명
점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.

전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

제한사항
전체 학생의 수는 2명 이상 30명 이하입니다.
체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
입출력 예
n	lost	reserve	return
5	[2, 4]	[1, 3, 5]	5
5	[2, 4]	[3]	        4
3	[3]	    [1] 	    2
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GymSuit {
    public static void main(String[] args) {
        System.out.println(solution(5,new int[]{1,2,3},new int[]{2,3,4}));
    }
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        //전체학생
        for(int i=1;i<=n;i++) map.put(i,true);
        //체육복을 잃어버린 학생
        for(int l : lost) map.put(l,false);

        //체육복을 잃어버린 학생중 여벌을 갖고온 학생
        for(int r=0;r<reserve.length;r++)
            if(!map.get(reserve[r])) {
                map.put(reserve[r],true);
                reserve[r]=-2;
            }
        //잃어버리지 않은 학생중 여벌을 빌려받은 학생
        for(int r : reserve) {
            for (Integer i : map.keySet()) {
                if (!map.get(i)){
                    if(i==r+1 || i==r-1){
                        map.put(i,true);
                        break;
                    }
                }
            }
        }
        //학생중 체육복이 있는 학생
        for(boolean b : map.values()) if(b) answer++;
        return answer;
    }
}
