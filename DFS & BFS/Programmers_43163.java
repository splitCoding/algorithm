public class Programmers_43163 {
    static String begin = "hit", target = "cog";
    static String [] words = {"hot", "dot", "dog", "lot", "log", "cog"};
    static boolean [] visited = new boolean[words.length];
    static int min = words.length + 1;
//    static String tmp = "hit";

    public static void main(String[] args) {
        boolean possible = false;
        for(String word:words)
            if(word.equals(target))
                possible = true;
        if(possible){
            bfs(1, begin);
            System.out.println(min);
            System.exit(0);
        }
        System.out.println(0);
    }

    static void bfs(int depth, String current){
//        System.out.println(tmp);
        if( depth > min ) return;
        if( changable(current, target) ){
            min = Math.min(min, depth);
            return;
        }
        for( int i = 0;i<words.length;i++){
            if(visited[i])continue;
            if(changable(current, words[i])){
//                String tmp_tmp = tmp;
                visited[i] = true;
//                tmp += words[i];
                bfs(depth+1, words[i]);
                visited[i] = false;
//                tmp = tmp_tmp;
            }
        }
    }
    static boolean changable(String a, String b){
        int diff = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) == b.charAt(i)){ continue; }
            if( ++diff > 1 ){ return false; }
        }
        if( diff == 1) return true;
        else return false;
    }
}
