package CoffeeMachine;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int cup = input.nextInt();
        System.out.println("For " + cup + " cups of coffee you will need:\n" +
                 cup * 200 + " ml of water\n" +
                cup * 50 + " ml of milk\n" +
                cup * 15 + " g of coffee beans");
    }
}