/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: chen_ya1
LANG: JAVA
TASK: beads
*/
import java.io.*;

class beads {
  public static int count_same_color_beads(String beads, int begin, int end, int direction) {
      char color = 'w';
      int index = begin;
      int count=0;
      do {
          char this_color = beads.charAt(index);
          if (color == 'w') {
              color = this_color;
          }
          if (this_color != color && this_color != 'w') {
              break;
          }
          count++;
          index += direction;
          if (index >= beads.length()) {
              index -= beads.length();
          } else if (index < 0) {
              index += beads.length();
          }
      }
      while (index != end);
      return count;
  }
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("beads.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
    int count = Integer.parseInt(f.readLine());
    String beads = f.readLine();
    int max_count = 0;
    for (int i = 0; i < beads.length(); i++) {
        count = count_same_color_beads(beads, i, i, 1);
        if (count < beads.length()) {
            int begin_left = i-1;
            if (begin_left < 0) {
                 begin_left += beads.length();
            }
            int end_left = i + count - 1;
            if (end_left >= beads.length()) {
                end_left -= beads.length();
            }
            count += count_same_color_beads(beads, begin_left, end_left, -1);
        }
        if (count > max_count) {
            max_count = count;
            if (max_count >= beads.length()) {
                break;
            }
        }
    }
    out.println(max_count);
    out.close();  
    f.close(); // close the output file
  }
}