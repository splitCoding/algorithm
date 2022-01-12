//https://programmers.co.kr/learn/courses/30/lessons/42576?language=java 해쉬-완주하지 못한 선수
import java.util.HashMap;
public class Programmers_42576 {
    public static void main(String[] args) {
        String [] participant = {"mislav", "stanko", "mislav", "ana"};
        String [] completion = {"stanko", "ana", "mislav"};
        HashMap<String, Integer> check = new HashMap<>();
        for(String p:participant) {
            if(!check.containsKey(p)){
                check.put(p,1);
            } else {
                Integer new_value = check.get(p)+1;
                check.put(p,new_value);
            }
        }
        for(String c : completion) {
            if(check.get(c) == 1){
                check.remove(c);
            } else {
                Integer new_value = check.get(c)-1;
                check.put(c,new_value);
            }
        }
        System.out.println(String.join("",check.keySet()));
    }
}
/*
import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> check = new HashMap<>();
        for(String p:participant) {
            if(!check.containsKey(p)){
                check.put(p,1);
            } else {
                Integer new_value = check.get(p)+1;
                check.put(p,new_value);
            }
        }
        for(String c : completion) {
            if(check.get(c) == 1){
                check.remove(c);
            } else {
                Integer new_value = check.get(c)-1;
                check.put(c,new_value);
            }
        }
        return String.join("",check.keySet());
    }
}
 */
