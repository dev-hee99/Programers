package level3;

import java.util.*;

/**
 * [베스트앨범]
 * 문제 설명
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며,
 * 노래를 수록하는 기준은 다음과 같습니다.
 *
 * 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,
 * 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 *
 * 제한사항
 * genres[i]는 고유번호가 i인 노래의 장르입니다.
 * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
 * genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
 * 장르 종류는 100개 미만입니다.
 * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 * 모든 장르는 재생된 횟수가 다릅니다.
 */
public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays  = new int[]{500, 600, 150, 800, 2500};
        Arrays.stream(solution(genres, plays)).forEach(i -> System.out.println(i));
    }

    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> playTotal = new HashMap<>();
        HashMap<String, ArrayList<PlayInfo>> genreHashMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            playTotal.put(genres[i], playTotal.getOrDefault(genres[i],0) + plays[i]);
            ArrayList<PlayInfo> currentList = genreHashMap.computeIfAbsent(genres[i], l -> new ArrayList<PlayInfo>());
            currentList.add(new PlayInfo(i, plays[i]));
        }

        // 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
        List<Map.Entry<String,Integer>> playTotalList = new ArrayList<>(playTotal.entrySet());
        playTotalList.sort(Map.Entry.comparingByValue((o1, o2) -> o2 - o1));

        // 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
        // 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
        for(Map.Entry<String, ArrayList<PlayInfo>> entry : genreHashMap.entrySet()){
            entry.getValue().sort((o1, o2) -> {
                if (o1.plays < o2.plays) {
                    return 1;
                }else if(o1.plays == o2.plays){
                    return o1.id - o2.id;
                }else{
                    return -1;
                }
            });
        }

        List<Integer> resultList = new ArrayList<>();

        for(Map.Entry<String, Integer> playMap : playTotalList){
            ArrayList<PlayInfo> values = genreHashMap.get(playMap.getKey());
            int max = values.size() > 2 ? 2 : values.size();
            for(int i = 0 ; i < max; i ++){
                resultList.add(values.get(i).id);
            }
        }

        int [] answer = new int[resultList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = resultList.get(i).intValue();
        }

        return answer;
    }

    static class PlayInfo{
        int id;
        int plays;

        PlayInfo(int id, int plays){
            this.id = id;
            this.plays = plays;
        }

    }
}
