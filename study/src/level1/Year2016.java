package level1;

import java.util.Arrays;

/*
[2016]
문제 설명
2016년 1월 1일은 금요일입니다.
2016년 a월 b일은 무슨 요일일까요? 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.
요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT

입니다. 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.
 */
public class Year2016 {
    public static void main(String[] args) {
        int a=5,b=24;
        System.out.print(solution(a,b));
    }
    public static String solution(int a, int b) {
        String[] dayOfTheWeek = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int [] dayOfMonth = {0,31,29,31,30,31,30,31,31,30,31,30,31};
        int daySum = 0; //지난달 일수 합계

        for(int i=0;i<a;i++)
            daySum +=dayOfMonth[i];

        daySum=(daySum+b+4)%7;

        return dayOfTheWeek[daySum];
    }
}
