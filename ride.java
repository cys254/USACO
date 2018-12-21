/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: chen_ya1
LANG: JAVA
TASK: ride
*/
import java.io.*;

class ride {
  public static long line_to_int(PrintWriter out, String line) {
      long sum = 1;
      for (int i = 0; i < line.length(); i++) {
          sum *= line.charAt(i) - 'A' + 1;
      }
      return sum % 47;
  }
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
    String comit = f.readLine();
    String group = f.readLine();
    out.println(line_to_int(out, comit) == line_to_int(out, group) ? "GO" : "STAY");
    out.close();  
    f.close(); // close the output file
  }
}