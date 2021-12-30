//https://programmers.co.kr/learn/courses/30/lessons/42839?language=java

public class programmers_42389 {
    public static void main(String[] args) {
        String input = "17";
        String input2 = "011";
        Answer_42389 a = new Answer_42389(input);
        Answer_42389 a1 = new Answer_42389(input2);
    }
}
class Answer_42389{
    String input, tmp="";
    int combinations[], combinations_idx, count;
    boolean [] is_used;
    Answer_42389(String input){
        this.input = input;
        is_used = new boolean[input.length()];
        combinations = new int[(int)Math.pow(10,input.length())];
        Solution(0);
        System.out.println(count);
    }
    void Solution(int tmp_length){
        //만들어진 tmp의 길이가 input의 길이보다 클 경우 모두다 사용된 것이기에 return;
        if(tmp_length == input.length()) return;
        //input앞부터 차례차례 tmp에 저장
        for(int i=0;i<input.length();i++){
            //사용하고 있지 않은 문자일 경우
            if(!is_used[i]){
                String tmp_tmp = tmp; //재귀이후 다음 케이스에 보낼 변경전 tmp값 저장
                tmp += input.charAt(i); //tmp에 해당 문자 추가
                //해당 문자가 이전에 조합이 안됐던 문자일 때
                if(!exist(Integer.parseInt(tmp))){
                    is_used[i] = true; //i번째 문자 사용됨으로 변환
                    combinations[combinations_idx++] = Integer.parseInt(tmp); //combinations에 tmp 추가
                    if(Prime(Integer.parseInt(tmp)))count++; //tmp가 소수일 경우 count++
                    Solution(tmp_length+1);//문자를 사용한 상태로 더 조합하기 위한 재귀
                }
                is_used[i] = false; //사용하고 있는 상태로 재귀는 실행됐으니 이제 다음 케이스를 위해 사용안함으로 바꿈
                tmp = tmp_tmp;
            }
        }
    }
    boolean exist(int tmp){
        for(int i=0;i<=combinations_idx;i++) {
            if(combinations[i] == tmp){
                return true;
            }
        }
        return false;
    }
    boolean Prime(int num){
        if(num < 2)return false;
        for(int i=2;i<=(int)Math.sqrt(num);i++){
            if( num % i == 0 ){
                return false;
            }
        }
        return true;
    }
}
