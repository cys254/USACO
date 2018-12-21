/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: chen_ya1
LANG: JAVA
TASK: friday
*/
import java.io.*;

class friday {
  public static int[] days_of_months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
  public static int begin_year = 1900;
  public static int begin_day = 0;
  public static int get_days_of_month(int year_index, int month) {
      int year = begin_year + year_index;
      return days_of_months[month] + (month != 1 ? 0 : year % 4 != 0 ? 0 : year % 400 == 0 ? 1 : year % 100 == 0 ? 0 : 1 );
  }
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("friday.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
    int num_of_years = Integer.parseInt(f.readLine());
    int[] results = new int[7];
    int day = begin_day;
    for (int i = 0; i < num_of_years; i++) {
        for (int j = 0; j < 12; j++) {
            results[day] ++;
            day = (day + get_days_of_month(i, j)) % 7;
        }
    }
    for (int i = 0; i < 7; i++) {
        out.print(results[i]);
        out.print(i == 6 ? "\n" : " ");
    }
    out.close();  
    f.close(); // close the output file
  }
}
