package level1;

import java.net.StandardSocketOptions;
import java.util.*;
import java.util.stream.Stream;

/**
 * 2022 KAKAO BLIND RECRUITMENT
 * 문제
 * 신고 결과 받기
 *
 * [문제 설명]g
 * 신입사원 무지는 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템을 개발하려 합니다. 무지가 개발하려는 시스템은 다음과 같습니다.
 *
 * 각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
 * 신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
 * 한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
 * k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
 * 유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.
 * 다음은 전체 유저 목록이 ["muzi", "frodo", "apeach", "neo"]이고, k = 2(즉, 2번 이상 신고당하면 이용 정지)인 경우의 예시입니다.
 *
 * 유저 ID	유저가 신고한 ID	설명
 * "muzi"	"frodo"	"muzi"가 "frodo"를 신고했습니다.
 * "apeach"	"frodo"	"apeach"가 "frodo"를 신고했습니다.
 * "frodo"	"neo"	"frodo"가 "neo"를 신고했습니다.
 * "muzi"	"neo"	"muzi"가 "neo"를 신고했습니다.
 * "apeach"	"muzi"	"apeach"가 "muzi"를 신고했습니다.
 * 각 유저별로 신고당한 횟수는 다음과 같습니다.
 *
 * 유저 ID	신고당한 횟수
 * "muzi"	1
 * "frodo"	2
 * "apeach"	0
 * "neo"	2
 * id_list	report	k	result
 * ["muzi", "frodo", "apeach", "neo"]	["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]	2	[2,1,1,0]
 * ["con", "ryan"]	["ryan con", "ryan con", "ryan con", "ryan con"]	3	[0,0]
 */
public class Declaration {
    static final String [] id_list = {"muzi", "frodo", "apeach", "neo"};
    static final String [] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
    static final int k = 2;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(id_list,report,k)));
    }
    public static int [] solution(String[] id_list, String[] report, int k){
        //유저ID, 유저가 신고한 ID들
        Map<String, HashSet> reportMap = new HashMap<>();
        //유저ID, 신고 당한 횟수
        Map<String, Integer> countMap = new HashMap<>();
        //유저ID, 유저가 신고하여 정지시킨 ID Count
        Map<String, Integer> resultMap = new LinkedHashMap<>();
        String [] tempArr = null;

        //Map 초기화
        for(String id : id_list){
            reportMap.put(id,new HashSet());
            countMap.put(id,0);
            resultMap.put(id,0);
        }

        //유저ID, 신고ID 분리하여 reportMap에 유저가 신고한 ID추가
        for(String rep : report) {
            tempArr = rep.split(" ");
            reportMap.get(tempArr[0]).add(tempArr[1]);
        }

        //유저 신고당한 횟수 정리
        for(String id :reportMap.keySet()){
            for(Object reportedId : reportMap.get(id)){
                countMap.put(String.valueOf(reportedId),countMap.get(reportedId) + 1);
            }
        }

        //k회 이상 신고 당한 유저ID가 내가 신고한 ID와 동일할 경우 내가 신고하여 정지된 유저 Count 증가
        for(String reportedId : countMap.keySet()){
            if(countMap.get(reportedId) >= k){
                for(String id : countMap.keySet()) {
                    if(reportMap.get(id).contains(reportedId))
                        resultMap.put(id,resultMap.get(id)+1);
                }
            }
        }


        return resultMap.entrySet().stream().mapToInt(Map.Entry::getValue).toArray();
    }
}
