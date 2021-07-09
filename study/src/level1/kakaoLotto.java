package level1;

import java.util.Arrays;
import java.util.List;

/*
    [로또의 최고순위와 최저순위]
문제 설명
로또 6/45(이하 '로또'로 표기)는 1부터 45까지의 숫자 중 6개를 찍어서 맞히는 대표적인 복권입니다. 아래는 로또의 순위를 정하는 방식입니다. 1

순위	당첨 내용
1	6개 번호가 모두 일치
2	5개 번호가 일치
3	4개 번호가 일치
4	3개 번호가 일치
5	2개 번호가 일치
6(낙첨)	그 외

입출력 예
lottos                  win_nums                    result
[44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]	    [3, 5]
[0, 0, 0, 0, 0, 0]	    [38, 19, 20, 40, 15, 25]	[1, 6]
[45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]	    [1, 1]

 */
public class kakaoLotto {
    private static List<int[]> lotto_list = Arrays.asList(
            new int[]{44,1,0,0,31,25},
            new int[]{0,0,0,0,0,0},
            new int[]{45,4,35,20,3,9}
    );
    private static List<int[]> win_nums_list = Arrays.asList(
            new int[]{31,10,45,1,6,19},
            new int[]{38,19,20,40,15,25},
            new int[]{20,9,3,45,4,35}
    );
    public static void main(String[] args) {
        for(int i=0; i< lotto_list.size();i++){
            solution(lotto_list.get(i),win_nums_list.get(i));
        }
    }
    private static int[] solution(int[] lottos, int[] win_nums) {
        int highestRank=0,lowestRank=0;
        int cnt=0,sum=0; //0을 제외한 일치하는 숫자 카운트,0을 포함하여 일치하는 숫자 카운트
        int zerocnt=0; // 0 카운트

        for(int lottoNum : lottos){
            if(lottoNum==0) zerocnt++;
            for(int win_num : win_nums){
                if(lottoNum==0) continue;
                if(lottoNum==win_num) cnt++;
            }
        }

        sum = cnt+zerocnt;

        highestRank = getGrade(sum);
        lowestRank = getGrade(cnt);

        return new int[]{highestRank,lowestRank};
    }

    private static int getGrade(int sameNum){
        if(sameNum==6) return 1;
        else if(sameNum==5) return 2;
        else if(sameNum==4) return 3;
        else if(sameNum==3) return 4;
        else if(sameNum==2) return 5;
        else return 6;
    }
}
