package ticket;

public class Ticket {
  private static final float IVA = 0.21f;

  /**
   * Calculates the total price of a ticket
   * 
   * @param items array containing information of ticket
   * @return the total price of ticket
   */
  private float total(float[][] items) {
    float total = 0;

    for (int i = 0; i < items.length; i++) {
      total += items[i][2];
    }

    return Calculations.round(total, (byte) 2);
  }

  /**
   * Calculates the total of a product
   * 
   * @param item array containing information of ticket
   * @return the total of a product = units * price_per_unit
   */
  private float totalUnit(float[] item) {
    return Calculations.round(item[1] * item[2], (byte) 2);
  }

  /**
   * Generation of the ticket
   * 
   * @param items array containing information of ticket
   * @return a generated ticket text
   */
  public String generateTicket(float[][] items) {
    String date = Calculations.generateDate();
    String time = Calculations.generateTime();

    String bill = String.format("%-25s%5s%15s%10s%n", "Ticket", "Date:", date, time);
    bill += "-".repeat(55) + "\n";
    bill += String.format("%-25s%5s%15s%10s%n", "Product", "Units", "Price Unit", "Total");
    bill += "-".repeat(55) + "\n";

    float subtotal = 0;

    for (int i = 0; i < items.length; i++) {
      float productId = items[i][0];
      float units = items[i][1];
      float priceUnit = items[i][2];

      float total = priceUnit * units;
      subtotal += total;

      bill += String.format("%-25.0f%4.0f%15.2f%10.2f€%n", productId, units, priceUnit, total);
    }

    float tax = Tax.tax(subtotal, IVA);
    float totalWithoutTax = Tax.totalWithoutTax(subtotal, tax);

    bill += "-".repeat(55) + "\n";
    bill += String.format("%-25s%5.2f€%n", "TAX:", tax);
    bill += "-".repeat(55) + "\n";
    bill += String.format("%-24s%5.2f€%n", "TOTAL WHITHOUT TAX:", totalWithoutTax);
    bill += "-".repeat(55) + "\n";
    bill += String.format("%-50s%5.2f€", "TOTAL:", tax + totalWithoutTax);

    return bill;
  }

  private class Product {
    /**
     * Convert the code of a product to text
     * 
     * @param product the product code
     * @return the product text
     */
    private String product(float product) {
      switch ((byte) product) {
        case 1:
          return "Coffee large";

        case 2:
          return "Expresso";

        case 3:
          return "Coffee latte";

        case 4:
          return "Machiatto";

        case 5:
          return "Chocolate";

        case 6:
          return "Frappuccino";

        case 7:
          return "Coffee mocha";

        case 8:
          return "Americano";

        case 9:
          return "Brewed coffee";
        default:
          return "";
      }
    }

  }
}
