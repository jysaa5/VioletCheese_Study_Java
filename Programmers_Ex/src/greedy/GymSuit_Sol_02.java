package greedy;

//����: ü����
/*
���� ����
���ɽð��� ������ ���, �Ϻ� �л��� ü������ �������߽��ϴ�. ������ ���� ü������ �ִ� �л��� �̵鿡�� ü������ �����ַ� �մϴ�. �л����� ��ȣ�� ü�� ������ �Ű��� �־�, �ٷ� �չ�ȣ�� �л��̳� �ٷ� �޹�ȣ�� �л����Ը� ü������ ������ �� �ֽ��ϴ�. ���� ���, 4�� �л��� 3�� �л��̳� 5�� �л����Ը� ü������ ������ �� �ֽ��ϴ�. ü������ ������ ������ ���� �� ���� ������ ü������ ������ ���� �ִ��� ���� �л��� ü�������� ���� �մϴ�.

��ü �л��� �� n, ü������ �������� �л����� ��ȣ�� ��� �迭 lost, ������ ü������ ������ �л����� ��ȣ�� ��� �迭 reserve�� �Ű������� �־��� ��, ü�������� ���� �� �ִ� �л��� �ִ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
��ü �л��� ���� 2�� �̻� 30�� �����Դϴ�.
ü������ �������� �л��� ���� 1�� �̻� n�� �����̰� �ߺ��Ǵ� ��ȣ�� �����ϴ�.
������ ü������ ������ �л��� ���� 1�� �̻� n�� �����̰� �ߺ��Ǵ� ��ȣ�� �����ϴ�.
���� ü������ �ִ� �л��� �ٸ� �л����� ü������ ������ �� �ֽ��ϴ�.
���� ü������ ������ �л��� ü������ ���������� �� �ֽ��ϴ�. �̶� �� �л��� ü������ �ϳ��� �������ߴٰ� �����ϸ�, ���� ü������ �ϳ��̱⿡ �ٸ� �л����Դ� ü������ ������ �� �����ϴ�.

����� ��
n	| lost  | reserve   | return
5	|[2, 4] | [1, 3, 5] |	5
5	|[2, 4]	| [3]	    |   4
3	| [3]	| [1]	    |   2

����� �� ����
���� #1
1�� �л��� 2�� �л����� ü������ �����ְ�, 3�� �л��̳� 5�� �л��� 4�� �л����� ü������ �����ָ� �л� 5���� ü�������� ���� �� �ֽ��ϴ�.

���� #2
3�� �л��� 2�� �л��̳� 4�� �л����� ü������ �����ָ� �л� 4���� ü�������� ���� �� �ֽ��ϴ�.
*/

//�ַ��: Ž���, for���� �迭

class GymSuit_Solution_02 {
	public int solution(int n, int[] lost, int[] reserve) {
		int[] people = new int[n];
		int answer = n;

		for (int l : lost)
			people[l - 1]--;
		for (int r : reserve)
			people[r - 1]++;

		for (int i = 0; i < people.length; i++) {
			if (people[i] == -1) {
				if (i - 1 >= 0 && people[i - 1] == 1) {
					people[i]++;
					people[i - 1]--;
				} else if (i + 1 < people.length && people[i + 1] == 1) {
					people[i]++;
					people[i + 1]--;
				} else
					answer--;
			}
		}
		return answer;
	}
}

public class GymSuit_Sol_02 {
	public static void main(String[] args) {

		GymSuit_Solution_02 sol = new GymSuit_Solution_02();

		// int n = 5;
		int n = 3;
//		int[] lost = {2,4};
//		int[] reserve = {1,3,5};

//		int[] lost = {2,4};
//		int[] reserve = {3};

		int[] lost = { 3 };
		int[] reserve = { 1 };

		System.out.println(sol.solution(n, lost, reserve));

	}
}