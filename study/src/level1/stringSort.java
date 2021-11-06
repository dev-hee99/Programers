package level1;

import java.util.*;

/*
[문자열 내 마음대로 정렬하기]

문제 설명
문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.

제한 조건
strings는 길이 1 이상, 50이하인 배열입니다.
strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
모든 strings의 원소의 길이는 n보다 큽니다.
인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
입출력 예
strings	n	return
["sun", "bed", "car"]	1	["car", "bed", "sun"]
["abce", "abcd", "cdx"]	2	["abcd", "abce", "cdx"]

 */
public class stringSort {
    private static String[] strings = {"sun", "bed", "car"};
    private static int n = 1;

    public static void main(String[] args) {

        for (String s : solution(strings, n))
            System.out.println(s);

        for (String s : solution2(strings, n))
            System.out.println(s);
    }

    //방법1
    public static String[] solution(String[] strings, int n) {
        List<String> list = new ArrayList<>();
        for (String s : strings) list.add(s);

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int i = s1.charAt(n) - s2.charAt(n);
                return i == 0 ? s1.compareTo(s2) : i;
            }
        });
        return list.toArray(new String[list.size()]);
    }

    //방법2
    public static String[] solution2(String[] strings, int n){
        ArrayList<String> list = new ArrayList<>();
        for(String s : strings){
            list.add(""+s.charAt(n)+s);
        }
        Collections.sort(list);
        String[] answer = new String[list.size()];
        for(int i=0; i<answer.length;i++)
            answer[i] = list.get(i).substring(1,list.size()+1);

        return answer;
    }
}
