import java.io.PrintStream;

public class DinnerAdvisor {
    public void getAdvice(double moneyBeforeSalary, int daysBeforeSalary) {
        PrintStream out = System.out;

        boolean lessThanTenDaysBeforePayday = daysBeforeSalary < 10;
        int caseNumber = 0;

        if (moneyBeforeSalary < 3000) {
            caseNumber = 1;
        } else if (moneyBeforeSalary < 10000) {
            caseNumber = 2;
        } else if (moneyBeforeSalary < 30000) {
            caseNumber = 3;
        }

        switch (caseNumber) {
            case 0:
                out.println("We have not received any information from you.");
                break;
            case 1:
                out.println("Today it is better to eat at home. Save and you'll make it to paycheck!");
                return;
            case 2:
                if (lessThanTenDaysBeforePayday) {
                    out.println("Okay, time to McDuck!");
                } else {
                    out.println("Today it is better to eat at home. Save and you'll make it to paycheck!");
                }
                return;
            case 3:
                if (lessThanTenDaysBeforePayday) {
                    out.println("Excellent! Order crabs!");
                } else {
                    out.println("Not bad! Buy some dollars and go to dinner at a cool place. :)");
                }
                return;
            default:
                break;
        }
    }

}