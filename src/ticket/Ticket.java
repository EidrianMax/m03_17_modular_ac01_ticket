package ticket;

public class Ticket {
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

    return total;
  }

  /**
   * Calculates the total of a product
   * 
   * @param item array containing information of ticket
   * @return the total of a product = units * price_per_unit
   */
  private float totalUnit(float[] item) {
    return item[1] * item[2];
  }

  /**
   * Generation of the ticket
   * 
   * @param items array containing information of ticket
   * @return a generated ticket text
   */
  public String generateTicket(float[][] items) {
    return "";
  }

  private class Product {
    /**
     * Convert the code of a product to text
     * 
     * @param product the product code
     * @return the product text
     */
    private String product(float product) {
      return "";
    }

  }
}
