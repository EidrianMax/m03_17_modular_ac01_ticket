package ticket;

import java.util.Date;

public class Calculations {
  /**
   * Round a number to a specified decimals
   * 
   * @param num      a number to round
   * @param decimals the number of decimals to round
   * @return the value rounded to a number of decimals
   */
  static float round(float num, byte decimals) {
    return (float) (Math.round(num * Math.pow(10, decimals)) / Math.pow(10,  decimals));
  }

  /**
   * Generates a date stamp with format DD.MM.YY
   * 
   * @return a date as String
   */
  static String generateDate() {
    Date date = new Date();
    String dateString = String.format("%1$td.%1$tm.%1$ty", date);

    return dateString;
  }

  /**
   * Generates a time stamps with format HH:MM:SS
   * 
   * @return a time as String
   */
  static String generateTime() {
    Date date = new Date();
    String timeString = String.format("%tT", date);

    return timeString;
  }
}
