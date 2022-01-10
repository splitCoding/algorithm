import java.util.Stack;

//https://programmers.co.kr/learn/courses/30/lessons/43162?language=java
public class Programmers_43162 {
    static int n=3;
    static int [][] computers = {{1, 1, 0},{1, 1, 0},{0, 0, 1}};
    static boolean [] visited = new boolean[computers.length];
    static Stack<Integer> s = new Stack<>();
    static int ret = 0;

    public static void main(String[] args) {
        //i를 push하고 computers[pop()]과 연결된 인덱스를 push
        //이 과정을 스택이 빌때 까지 반복하면 i와 연결된 모든 컴퓨터들은 방문됨으로 전환
        for( int i=0;i< visited.length;i++){
            if(!visited[i]){
                dfs(i);
                ret++;
            }
        }
        System.out.println(ret);
    }
    static void dfs(int computer){
        s.push(computer);
        while(!s.empty()){
            int next = s.pop();
            visited[next] = true;
            for( int i=0;i<computers[next].length;i++){
                if( computers[next][i] == 1 && visited[i] == false){
                    s.push(i);
                } else {
                    continue;
                }
            }
        }
    }
}