package HashMap;
import java.io.*;
import java.util.*;

public class MedianPriorityQueue {
    public static class MedianPriorityQueue1 {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        public MedianPriorityQueue1() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void add(int val) {
           /* if(left.size()==0 || left.peek()>val){
                left.add(val);
            }
            else{
                right.add(val);
            }*/

            if(right.size()==0 || right.peek()>val){
                right.add(val);
            }
            else{
                left.add(val);
            }


            if(left.size()- right.size()==2){
                right.add(left.remove());
            }
            else if(right.size()- left.size()==2){
                left.add(right.remove());
            }

        }

        public int remove() {
            if(left.size()==0 && right.size()==0){
                System.out.println("Underflow");
                return -1;
            }
            else if(right.size()>left.size()){
                return right.remove();
            }
            else{
                return left.remove();
            }
        }

        public int peek() {
            if(left.size()==0 && right.size()==0){
                System.out.println("Underflow");
                return -1;
            }
            else if(right.size()>left.size()){
                return right.peek();
            }
            else{
                return left.peek();
            }
        }

        public int size() {
            return left.size()+ right.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MedianPriorityQueue1 qu = new MedianPriorityQueue1();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}
/*add 10
add 20
add 30
add 40
peek
30
add 50
peek
50
remove
50
peek
30
remove
30
peek
10
remove
10
peek
20
remove
20
peek
40
quit
 */