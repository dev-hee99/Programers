package level1;

/*
 * 
 * 0���� 9������ ���� �� �Ϻΰ� ����ִ� �迭 numbers�� �Ű������� �־����ϴ�. 
 * numbers���� ã�� �� ���� 0���� 9������ ���ڸ� ��� ã�� ���� ���� return �ϵ��� solution �Լ��� �ϼ����ּ���.
*/
public class P1_2021_1106 {
	static final int[] numbers = { 1, 2, 3, 4, 6, 7, 8, 0 };

	public static void main(String[] args) {
		System.out.println(solution(numbers));
	}

	public static int solution(int [] numbers) {
		int answer = 0;
		
        for(int i=1; i<10 ; i++){
            answer += i;
        }
        
        for(int j=0; j<numbers.length;j++)
            answer -= numbers[j];

		return answer;
	}

}
