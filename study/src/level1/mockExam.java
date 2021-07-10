package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
문제 설명
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

* */
class Student{
    int no;
    int[]role;
    int answer=0;
    Student(int no,int[] role){
        this.no=no;
        this.role=role;
    }
    public void addAnswer(){
        answer++;
    }

}
public class mockExam {
    public static int [] answer={1,3,2,4,2};
    public static int [] first={1,2,3,4,5}; //1번 수포자 번호찍는 방식
    public static int [] second={2, 1, 2, 3, 2, 4, 2, 5}; //2번 수포자 번호찍는 방식
    public static int [] third={3,3,1,1,2,2,4,4,5,5}; //3번 수포자 번호찍는 방식
    public static void main(String[] args) {
        for(int i : solution(answer))
            System.out.print(i);
    }
    public static int[] solution(int[] answers) {
        List<Student> studentList = new ArrayList<Student>(){{
            add(new Student(1,new int[]{1,2,3,4,5}));
            add(new Student(2,new int[]{2,1,2,3,2,4,2,5}));
            add(new Student(3,new int[]{3,3,1,1,2,2,4,4,5,5}));
        }};

        for(Student s : studentList) {
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == s.role[i % s.role.length]) s.addAnswer();
            }
        }

        int temp=0;
        List<Integer>list = new ArrayList<>();
        for(Student s : studentList){
            if(s.answer==0) continue;
            if(s.answer>temp) {
                list.clear();
                list.add(s.no);
                temp=s.answer;
            }else if(s.answer==temp){
                list.add(s.no);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
