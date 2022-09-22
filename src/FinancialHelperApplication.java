import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FinancialHelperApplication {

    public static void main(String[] args) {
        startFinancialHelperApp();
    }

    private static void startFinancialHelperApp() {
        Scanner userInput = new Scanner(System.in);
        PrintStream out = System.out;

        double moneyBeforeSalary = getMoneyBeforeSalary(userInput);
        int daysBeforeSalary = getDaysBeforeSalary(userInput);

        DinnerAdvisor dinnerAdvisor;
        Converter converter;
        ExpensesManager expensesManager = new ExpensesManager();;

        while (true) {
            showCommandList();
            int userChoose = userInput.nextInt();

            switch (userChoose) {
                case 0:
                    out.println("Exit");
                    return;
                case 1:
                    out.printf("Your savings: %s UAH%s", moneyBeforeSalary, System.lineSeparator());
                    converter = new Converter(41.5, 41.7);
                    converter.convert(moneyBeforeSalary);
                case 2:
                    dinnerAdvisor = new DinnerAdvisor();
                    dinnerAdvisor.getAdvice(moneyBeforeSalary, daysBeforeSalary);
                case 3:
                    out.println("Enter the amount of spending:");
                    double expense = getMoneyBeforeSalary(userInput);
                    out.println("What category is spending?");
                    String category = userInput.next();
                    moneyBeforeSalary = expensesManager.saveExpense(moneyBeforeSalary, category, expense);
                case 4:
                    expensesManager.printAllExpensesByCategories();
                case 5:
                    out.println("What category to look for?");
                    String userCategory = userInput.next();
                    double maxExpenseInCategory = expensesManager.findMaxExpenseInCategory(userCategory);
                    out.printf("The biggest spend in the category %s was %f uah", userCategory, maxExpenseInCategory);
                case 6:
                    expensesManager.removeAllExpenses();
                case 7:
                    out.println("Total spent: " + expensesManager.getExpensesSum());
                case 8:
                    out.println("Which category do you want to remove?");
                    category = userInput.next();
                    expensesManager.removeCategory(category);
                case 9:
                    out.println("In category " + expensesManager.getMaxCategoryName() + " you spent the most.");
                default:
                    out.println("Sorry, there is no such command yet.");
                    return;
            }
        }
    }

    private static int getDaysBeforeSalary(Scanner userInput) {
        System.out.println("How many days until payday?");
        return userInput.nextInt();
    }

    private static double getMoneyBeforeSalary(Scanner scanner) {
        System.out.println("How much money do you have left before payday?");
        return scanner.nextDouble();
    }

    public static void showCommandList() {
        ArrayList<String> commandList = new ArrayList<>();

        commandList.add("Choose an operation: ");
        commandList.add("1 - Convert currency");
        commandList.add("2 - Get advice");
        commandList.add("3 - Enter spending");
        commandList.add("4 - Show spending by category");
        commandList.add("5 - Show the biggest spend in the selected category");
        commandList.add("6 - Clear spending table");
        commandList.add("7 - Refund the amount of all expenses");
        commandList.add("8 - Delete category");
        commandList.add("9 - Get the name of the most expensive category");
        commandList.add("0 - Exit");

        for (String command : commandList) {
            System.out.println(command);
        }
    }

}