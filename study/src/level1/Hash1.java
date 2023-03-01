package level1;

import java.util.*;

/**
 * [완주하지 못한 선수]
 * 문제 설명
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 *
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
 * 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * completion의 길이는 participant의 길이보다 1 작습니다.
 * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * 참가자 중에는 동명이인이 있을 수 있습니다.
 */
public class Hash1 {

    public static void main(String[] args) {
        String[] participant = new String[]{"leo", "kiki", "eden"};
        String[] completion = new String[]{"eden", "kiki"};
        System.out.println(solution(participant, completion));
    }

    /**
     * HashMap 풀이법
     * @param participant
     * @param completion
     * @return
     */
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> playerMap = new HashMap<>();

        // 참가자 중 동명이인이 있을 수 있으므로 이름으로 참가자를 Count한다.
        for(String name : participant){
            playerMap.put(name , playerMap.getOrDefault(name,0) + 1);
        }

        // 완주자를 제외시킨다.
        for(String name : completion){
            playerMap.put(name ,  playerMap.get(name) - 1);
        }

        // 동명이인을 포함하여 완주를 못한 참가자는 1로 남음.
        for(String name : playerMap.keySet()){
            if(1 == playerMap.get(name)){
                answer = name;
            }
        }
        return answer;
    }

    /**
     * List 풀이법
     * @param participant
     * @param completion
     * @return
     */
    private static String solution2(String[] participant, String[] completion) {
        List<String> participantList = Arrays.asList(participant);
        List<String> completionList = Arrays.asList(completion);

        // 정렬
        participantList.sort(String::compareTo);
        completionList.sort(String::compareTo);

        int idx = 0;
        Iterator iterator = completionList.listIterator();
        while (iterator.hasNext()){
            if(!participantList.get(idx).equals(iterator.next())){
                return participantList.get(idx);
            }
            idx++;
        }

        return participantList.get(idx);
    }

}
