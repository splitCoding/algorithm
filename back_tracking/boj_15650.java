import java.util.Scanner;

public class boj_15650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Answer a = new Answer(n,m);
        a.Solution(0);
    }
}
class Answer{
    int n,m;
    int [] arr = new int [10];
    boolean [] is_used = new boolean[10];
    Answer(int n, int m){
        this.n = n;
        this.m = m;
    }
    void Solution(int k){
        if(k==this.m){
            for(int i=0;i<this.m;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=(k>0)? arr[k-1]:1;i<=this.n;i++){
            if(!is_used[i]){
                arr[k] = i;
                is_used[i] = true;
                Solution(k+1);
                is_used[i] = false;
            }
        }
    }
}
