package ticket;

public class Ticket {
  Product product = new Product();
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
      total += items[i][1] * items[i][2];
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

    for (int i = 0; i < items.length; i++) {
      float productId = items[i][0];
      String productName = product.product(productId);
      float units = items[i][1];
      float priceUnit = items[i][2];

      float total = totalUnit(items[i]);

      bill += String.format("%-25s%4.0f%15.2f%10.2f€%n", productName, units, priceUnit, total);
    }

    float totalBill = total(items);
    float tax = Tax.tax(totalBill, IVA);
    float totalWithoutTax = Tax.totalWithoutTax(totalBill, IVA);

    bill += "-".repeat(55) + "\n";
    bill += String.format("%-25s%5.2f€%n", "TAX:", tax);
    bill += "-".repeat(55) + "\n";
    bill += String.format("%-24s%5.2f€%n", "TOTAL WHITHOUT TAX:", totalWithoutTax);
    bill += "-".repeat(55) + "\n";
    bill += String.format("%-48s%5.2f€", "TOTAL:", tax + totalWithoutTax);

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
      String[] productsNames = {
          "NON DIPOSIBLE",
          "Coffe large",
          "Expresso",
          "Coffee latte",
          "Machiatto",
          "Chocolate",
          "Frappuccino",
          "Coffee mocha",
          "Americano",
          "Brewed coffee"
      };

      return productsNames[(int) product];
    }
  }
}
