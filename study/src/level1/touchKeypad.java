package level1;

/**
 문제
 [카카오 인턴] 키패드 누르기

 입출력 예시
 [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"	"LRLLLRLLRRL"
 [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"	"LRLLRRLLLRR"
 [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]	"right"	"LLRLLRLLRL"
 */
public class touchKeypad {
    private static int [] numbers1 = {1,3,4,5,8,2,1,4,5,9,5};
    private static int [] numbers2 = {7,0,8,2,8,3,1,5,7,6,2};
    private static int [] numbers3 = {1,2,3,4,5,6,7,8,9,0};
    private static String hand1 = "right";
    private static String hand2 = "left";
    private static String hand3 = "right";
    public static void main(String[] args) {

        System.out.println(solution(numbers1,hand1));
        System.out.println(solution(numbers2,hand2));
        System.out.println(solution(numbers3,hand3));
    }

    private static String solution(int[] numbers, String hand) {
        String answer = "";
        String [][] keypad = {
                {"1","2","3"},
                {"4","5","6"},
                {"7","8","9"},
                {"98","0","99"}
        };
        int lx=3,ly=0;
        int rx=3,ry=2;
        hand = hand.substring(0,1).toUpperCase();
        //System.out.println(hand);
        for(int i=0; i<numbers.length;i++){
            for(int j=0;j<keypad.length;j++){
                for(int k=0; k<keypad[j].length;k++){
                    if(numbers[i] == Integer.parseInt(keypad[j][k])){
                        //키패드 위치와 손위치의 거리
                        int lgap = Math.abs(lx-j)+Math.abs(ly-k);
                        int rgap = Math.abs(rx-j)+Math.abs(ry-k);
                        //1,4,7 은 왼손
                        if(k==0){
                            answer+="L";
                            lx=j;
                            ly=k;
                            //3,6,9 는 오른손
                        }else if(k==2){
                            answer+="R";
                            rx=j;
                            ry=k;
                            //2,5,8,0 누를경우
                        }else{
                            //왼손과 오른손의 위치가 키패드와의 거리가 같을경우
                            if(lgap==rgap){
                                answer+=hand;
                                if(hand.equals("R")){
                                    rx=j;
                                    ry=k;
                                }else{
                                    lx=j;
                                    ly=k;
                                }
                             //오른손보다 왼손이 거리가 더 멀 경우
                            }else if(lgap>rgap){
                                answer+="R";
                                rx=j;
                                ry=k;
                             //그 외
                            }else{
                                answer+="L";
                                lx=j;
                                ly=k;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}
