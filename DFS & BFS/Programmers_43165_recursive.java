import java.util.HashSet;

public class Programmers_43165_recursive {
    public static void main(String[] args) {
        int numbers [] = { 1,1,1,1,1 }, target = 5, count = 0;
        Solution s = new Solution(numbers, target);
        for(String i:s.combinations) {
            count++;
        }
        System.out.println(count);
    }
}
class Solution{
    int numbers [], target = 0, ret_count = 0;
    boolean is_used [];
    HashSet<String> combinations = new HashSet<String>();
    Solution( int [] numbers, int target ){
        this.numbers = numbers;
        this.target = target;
        this.is_used = new boolean[numbers.length];
        recursive(0);
    }
    String combination = "";
    void recursive(int depth){
        String prev_combination = combination;
        if( depth == numbers.length && calculate(combination) == target ){
            if ( calculate(combination) == target ){
                combinations.add(combination);
            }
            return;
        }
        for(int i=0;i< numbers.length;i++){
            if(is_used[i]){ continue; }
            is_used[i] = true;
            combination = prev_combination + "+"+numbers[i];
            recursive(depth + 1);
            combination = prev_combination + "-"+numbers[i];
            recursive(depth + 1);
            combination = prev_combination;
            is_used[i] = false;
        }
    }

    int calculate(String combination){
        //연산자배열, 피연산자배열로 나누기
        int length = combination.length() / 2;
        char [] op = new char[length];
        int [] num =  new int[length];
        int op_idx = 0, num_idx = 0;
        for(int i=0;i<combination.length();i++){
            if(i%2==0) {
                op[op_idx++] = combination.charAt(i);
            } else {
                num[num_idx++] = combination.charAt(i)-'0';
            }
        }
        //두 배열 제일 앞요소부터 꺼내서 조합
        int ret = 0;
        op_idx = 0;
        num_idx = 0;
        for(int i=0;i<op.length;i++){
            if(op[i] == '+'){ ret += num[i]; }
            else if(op[i] == '-') { ret -= num[i]; }
        }
        return ret;
    }
}