public class Programmers_43165{
    static int count = 0;
    static int [] numbers;
    static int target = 0;
    public static void main(String[] args) {
        numbers = new int []{1, 1, 1, 1, 1};
        target = 3;
        recursive(0,0);
        System.out.println(count);
    }
    static void recursive(int depth, int sum){
        if(depth == numbers.length){
            if( sum == target)count++;
            return;
        }
        recursive(depth+1,sum + numbers[depth]);
        recursive(depth+1,sum - numbers[depth]);
    }
}