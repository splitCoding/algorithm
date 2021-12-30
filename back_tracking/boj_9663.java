import java.util.Scanner;

class boj_9663 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Answer a = new Answer(n);
    }
}
class Answer{
    int n;
    int queen [];
    int count = 0;

    Answer(int n){
        this.n = n;
        queen = new int[n];
        backtrack(0);
        System.out.println(count);
    }
    void backtrack(int row){
        //퀸이 n까지 모두 배치가 될경우 가능한 케이스로 count++
        if(row==n){count++;return;}
        //n번쨰 row에 0부터 n까지의 col에 차례대로 퀸을 배치보고 배치 가능할 경우 row+1로 재귀
        for(int col=0;col<n;col++){
            queen[row] = col;
            if (possible(row)){
                backtrack(row+1);
            }
        }
    }
    boolean possible(int current_row){
        //그전 행들의 퀸이 있는 열을 보기위한 반복문
        for(int prev_row=0;prev_row<current_row;prev_row++){
            //그전 행에 같은 열에 퀸이 있는경우 return false
            if(queen[prev_row]==queen[current_row])return false;
            //그전 행에 같은 대각선상에 퀸이 있는 경우 ( row끼리의 차이의 절대값과 col끼리의 차이의 절대이가 같은 경우 같은 대각선 상)
            if(Math.abs(prev_row - current_row) == Math.abs(queen[prev_row] - queen[current_row]))return false;
        }
        return true;
    }
}
