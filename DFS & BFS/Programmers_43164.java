import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_43164 {
    static final String [][] TICKETS = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
    static boolean [] is_used = new boolean[TICKETS.length];
    static ArrayList<String> tmp = new ArrayList<String>(TICKETS.length);
    static String [] root = new String[TICKETS.length+1];
    static String [] final_root = new String[TICKETS.length+1];
    static int root_idx = 1;
    static boolean find = false;

    public static void main(String[] args) {
        root[0] = ("ICN");
        dfs(0,root[0]);
        System.out.println(Arrays.toString(final_root));
    }

    static String [] usable_tickets(String current){
        tmp.clear();
        for(int i=0;i<TICKETS.length;i++){
            if( TICKETS[i][0].equals(current)) {
                tmp.add(TICKETS[i][1] + "," + i);
            }
        }
        String [] arr = new String[tmp.size()];
        Arrays.sort(tmp.toArray(arr));
        return arr;
    }

    static void dfs(int depth, String start){
        if( find ) return;
        if (depth == TICKETS.length) {
            final_root = root.clone();
            find = true;
        }
        if( usable_tickets(start).length == 0){ return; }
        String [] next = usable_tickets(start);
        for( int i=0;i<next.length;i++){
            String [] next_info = next[i].split(",");
            if(!is_used[Integer.parseInt(next_info[1])]){
                is_used[Integer.parseInt(next_info[1])] = true;
                root[root_idx++] = next_info[0];
                dfs(depth+1, next_info[0]);
                is_used[Integer.parseInt(next_info[1])] = false;
                root_idx--;
            }
        }
    }
}
