//https://programmers.co.kr/learn/courses/30/lessons/42578?language=java
//https://velog.io/@voicesplit/12.-%ED%95%B4%EC%89%AC-%EC%9C%84%EC%9E%A5
import java.util.*;
public class Programmers_42578 {
    public static void main(String[] args) {
        String[][] clothes1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(new Solution().solution(clothes1));
        System.out.println(new Solution().solution(clothes2));
    }
}
class Solution {
    HashMap<String, Integer> classification = new HashMap<String, Integer>(60);
    public int solution(String[][] clothes) {
        for(int i=0;i<clothes.length;i++){
            if(!classification.containsKey(clothes[i][1])){
                classification.put(clothes[i][1], 2);
            } else {
                classification.put(clothes[i][1], classification.get(clothes[i][1])+1);
            }
        }
        if(classification.size()==1) {
            return clothes.length;
        }
        else {
            int sum = 1;
            for(String s : classification.keySet()){
                sum *= classification.get(s);
            }
            return sum-1;
        }
    }
}