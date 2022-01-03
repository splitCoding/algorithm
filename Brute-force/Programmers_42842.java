import java.util.Arrays;
// https://programmers.co.kr/learn/courses/30/lessons/42842?language=java
// 완전탐색 - 카펫
public class Programmers_42842 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(10,2)));
        System.out.println(Arrays.toString(s.solution(8,1)));
        System.out.println(Arrays.toString(s.solution(24,24)));
    }
}
class Solution{
    int width, height;
    int [] answer = new int[2];
    int [] solution(int brown, int yellow){
        for( int i=1;i<=Math.sqrt(yellow);i++){
            if( yellow % i == 0){
                width = (int)(yellow / i);
                height = i;
                if( (width + 2) * 2 + 2 * height == brown) {
                    answer[0] = width + 2;
                    answer[1] = height + 2;
                }
            }
        }
        return answer;
    }
}