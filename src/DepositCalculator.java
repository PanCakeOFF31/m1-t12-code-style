import java.util.Scanner;

public class DepositCalculator {
    private final static double YEAR_RATE = 0.06; // Процентная ставка
    private final static int PLACE = 2;

    public static void main(String[] args) {
        DepositCalculator deposit = new DepositCalculator();

        deposit.calculateDepositWorth();
    }

    void calculateDepositWorth() {
        Scanner scanner = new Scanner(System.in);
        int period;
        int action;

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double depositWorth = 0;

        if (action == 1) {
            depositWorth = calculateSimplePercentFunction(amount, period);
        } else if (action == 2) {
            depositWorth = calculateComplexPercentFunction(amount, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + depositWorth);
    }

    double calculateSimplePercentFunction(double amount, int period) {
        double depositWorth;

        depositWorth = amount + amount * YEAR_RATE * period;

        return round(depositWorth);
    }

    double calculateComplexPercentFunction(double amount, int period) {
        double depositWorth;

        depositWorth = amount * Math.pow((1 + YEAR_RATE / 12), 12 * period);

        return round(depositWorth);
    }

    double round(double value) {
        double scale;

        scale = Math.pow(10, PLACE);
        value = Math.round(value * scale) / scale;

        return value;
    }
}