package CoffeeMachine;
import java.util.Arrays;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = input.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = input.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffee_beans = input.nextInt();
        var count = new int[] {water / 200, milk / 50, coffee_beans / 15};
        var min = Arrays.stream(count).min();
//        System.out.println(min.getAsInt());
        System.out.println("Write how many cups of coffee you will need:");
        int cup = input.nextInt();
        if (min.getAsInt() == cup){
            System.out.println("Yes, I can make that amount of coffee");
        } else if (min.getAsInt() > cup) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (min.getAsInt() - cup) + " more than that)");
        }else {
            System.out.println("No, I can make only " + min.getAsInt() + " cups of coffee");
        }
    }
}