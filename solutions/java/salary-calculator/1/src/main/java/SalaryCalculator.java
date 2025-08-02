public class SalaryCalculator {

    private static final double MAX_SALARY = 2000.0;
    private static final double SALARY = 1000.0;
    private static final double PENALTY = 15.0;
    private static final int NO_PENALTY_DAYS = 4;
    private static final int PRODUCTS_FOR_BONUS = 20;
    private static final int BASE_UNITS_PER_PRODUCT = 10;
    private static final int BONUS_UNITS_PER_PRODUCT = 13;
    
    public double salaryMultiplier(int daysSkipped) {
        return daysSkipped <= NO_PENALTY_DAYS ? 1.0 : (100.0 - PENALTY) / 100.0;
    }

    public int bonusMultiplier(int productsSold) {
        return productsSold >= PRODUCTS_FOR_BONUS ? BONUS_UNITS_PER_PRODUCT : BASE_UNITS_PER_PRODUCT;
    }

    public double bonusForProductsSold(int productsSold) {
        return bonusMultiplier(productsSold) * productsSold;
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        return Math.min(MAX_SALARY, SALARY * salaryMultiplier(daysSkipped) + bonusForProductsSold(productsSold));
    } 
}
