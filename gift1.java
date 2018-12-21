/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: chen_ya1
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

class gift1 {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
    int count = Integer.parseInt(f.readLine());
    ArrayList<String> names = new ArrayList<String>(count);
    int[] balances = new int[count];
    for (int i = 0; i < count; i++) {
        names.add(f.readLine());
    }
    for (int i = 0; i < count; i++) {
        String name1 = f.readLine();
        int index1 = names.indexOf(name1);
         // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
                              // Get line, break into tokens
        int money = Integer.parseInt(st.nextToken());
        int num_friends = Integer.parseInt(st.nextToken());
        if (num_friends > 0) {
            int gift = money / num_friends;
            balances[index1] -= gift * num_friends;
            for (int j = 0; j < num_friends; j++) {
                String name2 = f.readLine();
                int index2 = names.indexOf(name2);
                balances[index2] += gift;
            }
        }
    }
    for (int i = 0; i < count; i++) {
        out.println(names.get(i) + " " + balances[i]);
    }
    out.close();  
    f.close(); // close the output file
  }
}
