package lesson4.counting.elements;

// 문제: MaxCounters
/*
You are given N counters, initially set to 0, and you have two possible operations on them:

increase(X) − counter X is increased by 1,
max counter − all counters are set to the maximum value of any counter.
A non-empty array A of M integers is given. This array represents consecutive operations:

if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
if A[K] = N + 1 then operation K is max counter.
For example, given integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:

    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
The goal is to calculate the value of every counter after all operations.

Write a function:
class Solution { public int[] solution(int N, int[] A); }
that, given an integer N and a non-empty array A consisting of M integers,
returns a sequence of integers representing the values of the counters.
Result array should be returned as an array of integers.
For example, given:
    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the function should return [3, 2, 2, 4, 2], as explained above.
Write an efficient algorithm for the following assumptions:
N and M are integers within the range [1..100,000];
each element of array A is an integer within the range [1..N + 1].
*/

/*
1. 문제요약

2. 솔루션
- N 카운터들 -> 초기화 = 0
- 카운터들의 작동 함수: 
- increase(X) = 카운터 X는 1씩 증가한다. 
- max counter = 모든 카운터들을 현재 갖고 있는 최대값으로 설정된다.
- 배열 A = M 정수들, 비어있지 않음. 연속작업을 한다.
i) A[k] = X 이고 1<=X<=N이면, K는 increase(X)로 작동
ii) A[k] = N+1이면 K는 maxcounter로 작동

3. 시간복잡도
: O(n+M)

4. Total Score
1) Task Score: 100%
2) Correctness: 100%
3) Performance: 100%

*/
class MaxCounters_Solution_02 {

	public int[] solution(int N, int[] A) {

		// 현재 카운터들 중에서 가장 큰 값
		int currentMax = 0;
		// max counter에서 수행하기 위해 
		int lastCalledMax = 0;
		// 카운터
		int[] counters = new int[N];

		for (int i = 0; i < A.length; i++) {
			// max counter 수행하기 위해 최대값을 따로 저장 -> 계속 수행하면 복잡도가 상승하기 때문이다.
			if (A[i] == N + 1) {
				
				lastCalledMax = currentMax;
				
			} else {
				
				int counter = A[i] - 1;
				// Max counter가 호출된 시점의 max값이 lastCalledMax보다 작을 때
				if (counters[counter] < lastCalledMax) {
					counters[counter] = lastCalledMax + 1;
				
				// 작지 않다면 해당 카운터의 값을 1증가 시킨다. 
				} else {
					counters[counter]++;
				}
				
				// 현재 최대값을 갱신한다.
				if (counters[counter] > currentMax) {
					currentMax = counters[counter];
				}
			}
		}

		// counter가 lastCalledMax보다 작으면 lastCalledMax로 대입
		for (int i = 0; i < N; i++) {
			if (counters[i] < lastCalledMax) {
				counters[i] = lastCalledMax;
			}
		}

		return counters;
	}
}

public class MaxCounters_Sol_01 {
	public static void main(String[] args) {

		MaxCounters_Solution_02 sol = new MaxCounters_Solution_02();
		int N = 5;
		int[] A = { 3, 4, 4, 6, 1, 4, 4 };
		for (int n : sol.solution(N, A)) {
			System.out.print(n);
		}

	}

}
