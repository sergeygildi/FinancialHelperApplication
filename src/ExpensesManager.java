import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {
    HashMap<String, ArrayList<Double>> expensesByCategories;

    ExpensesManager() {
        expensesByCategories = new HashMap<>();
    }

    double saveExpense(double moneyBeforeSalary, String category, double expense) {
        moneyBeforeSalary = moneyBeforeSalary - expense;

        System.out.println("Value saved! Your current balance in hryvnia: " + moneyBeforeSalary);

        if (expensesByCategories.containsKey(category)) {
            ArrayList<Double> expenses = expensesByCategories.get(category);
            expenses.add(expense);
        } else {
            ArrayList<Double> expenses = new ArrayList<>();
            expenses.add(expense);
            expensesByCategories.put(category, expenses);
        }
        if (moneyBeforeSalary < 1000) {
            System.out.println("There is very little left in your account. It's time to start saving!");
        }
        return moneyBeforeSalary;
    }

    void printAllExpensesByCategories() {
        for (String category : expensesByCategories.keySet()) {
            System.out.println(category);
            ArrayList<Double> expenses = expensesByCategories.get(category);
            for (Double expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    double findMaxExpenseInCategory(String category) {
        double maxExpense = 0;
        if (expensesByCategories.containsKey(category)) {
            ArrayList<Double> expenses = expensesByCategories.get(category);
            for (Double expense : expenses) {
                if (expense > maxExpense) {
                    maxExpense = expense;
                }
            }
        } else {
            System.out.println("There is no such category yet.");
        }
        return maxExpense;
    }

    void removeAllExpenses() {
        expensesByCategories.clear();
        System.out.println("Spending removed.");
    }

    public void removeCategory(String category) {
        expensesByCategories.remove(category);
    }

    /**
     * Return the sum of all expenses
     *
     * @return Double
     */
    public Double getExpensesSum() {
        Double sum = 0d;
        for (String expense : expensesByCategories.keySet()) {
            for (Double spend : expensesByCategories.get(expense)) {
                sum += spend;
            }
        }
        return sum;
    }

    /**
     * Return the name of the category which the amount of spending is the most
     *
     * @return String
     */
    public String getMaxCategoryName() {
        double maxCategorySum = 0;
        String maxCategoryName = "";
        for (String category : expensesByCategories.keySet()) {
            Double sum = 0d;
            for (Double expense : expensesByCategories.get(category)) {
                sum += expense;
                if (sum > maxCategorySum) {
                    maxCategorySum = sum;
                    maxCategoryName = category;
                }
            }
        }
        return maxCategoryName;
    }

}