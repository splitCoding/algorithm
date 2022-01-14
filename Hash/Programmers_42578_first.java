//https://programmers.co.kr/learn/courses/30/lessons/42578?language=java
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
    HashMap<String, Integer> classification = new HashMap<String, Integer>(30);
    String [] category_arr;
    int count = -1;

    public int solution(String[][] clothes) {
        //classification : clothes 이중배열을 "옷종류" = [인덱스1, 인덱스2 ... 인덱스n] 인 HashMap으로 변환
        for(int i=0;i<clothes.length;i++){
            //등록이 안된 종류일 경우 value를 2로 하여 등록
            if(!classification.containsKey(clothes[i][1])){
                classification.put(clothes[i][1], 2);
            }
            //등록이 된 경우는 value에 1 추가
            else {
                classification.put(clothes[i][1], classification.get(clothes[i][1])+1);
            }
        }
        if(classification.size()==1) {
            //분류했을 때 종류가 한가지만 있으면 옷의 총 갯수 리턴
            return clothes.length;
        } else {
            //분류햇을 때 종류가 한가지 이상인 경우

            //category_arr : 무슨무슨 종류가 있는 적혀있는 배열
            category_arr = new String[classification.size()];
            classification.keySet().toArray(category_arr);

            recursive(0,0);
            return count;
        }
    }
    void recursive(int category_idx, int depth){
        if(depth == category_arr.length){
            count++;
            return;
        }
        for(int i=0;i<classification.get(category_arr[category_idx]);i++){
//            is_used.put(category_arr[category_idx], true);
            recursive(category_idx+1, depth+1);
        }
    }
}
