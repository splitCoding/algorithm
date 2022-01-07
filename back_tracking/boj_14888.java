//https://www.acmicpc.net/problem/14888
import java.util.ArrayList;
import java.util.Scanner;

public class boj_14888 {
    static ArrayList<Integer> nums;
    static ArrayList<String> ops;
    static boolean [] is_used;
    static int max = -1000000000, min = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //숫자 받기
        int n = sc.nextInt();
        nums = new ArrayList<Integer>(n);
        for(int i=0;i<n;i++){ nums.add(sc.nextInt()); }
        //연산자 받기
        String [] op_arr = {"+","-","*","/"};
        ops = new ArrayList<String>(n-1);
        is_used = new boolean[n-1];
        for( int i=0;i<op_arr.length;i++){put(op_arr[i],sc.nextInt());}
        recursive(0,1,nums.get(0));
        System.out.println(max);
        System.out.println(min);
    }
    static void put(String op, int length){
        int idx = 0;
        for( int i=0;i<length;i++){
            ops.add(op);
        }
    }

    static void recursive(int depth, int num_idx, int sum){
        if (depth == ops.size()){
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }
        for(int i=0;i< ops.size();i++){
            if(is_used[i]){
                continue;
            }
            int prev_sum = sum;
            is_used[i] = true;
            sum = calculate(sum, nums.get(num_idx) , ops.get(i));
            recursive(depth+1, num_idx+1, sum);
            is_used[i] = false;
            sum = prev_sum;
        }
    }
    static int calculate(int sum, int now, String op){
        if( op.equals("+")){
            sum += now;
        }
        else if( op.equals("-")){
            sum -= now;
        }
        else if( op.equals("*")){
            sum *= now;
        }
        else if( op.equals("/")){
            sum /= now;
        }
        return sum;
    }
}