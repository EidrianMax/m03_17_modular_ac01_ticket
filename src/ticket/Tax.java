package ticket;

public class Tax {
  /**
   * Calculates the tax value
   *
   * @param amount total amount with TAX
   * @param tax    a TAX value, for example 0.21f
   * @return tax value from the specified amount
   */
  static float tax(float amount, float tax) {
    return amount * tax;
  }

  /**
   * Calculates the amount without tax
   *
   * @param total total amount with TAX
   * @param tax   a TAX value, for example 0.21f
   * @return total amount without tax value
   */
  static float totalWithoutTax(float total, float tax) {
    return  total - (total * tax);
  }
}
