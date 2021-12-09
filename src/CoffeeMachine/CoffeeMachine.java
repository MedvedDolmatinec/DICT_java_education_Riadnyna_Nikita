package CoffeeMachine;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        // water, milk, coffee beans, cup, money
        Integer[] resources = new Integer[]{400, 540, 120, 9, 550};

        while (true) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            String action = (String) Input("String");
            if (action.equals("exit")) {
                break;
            }
            switch (action) {
                case "buy" -> {
                    Buy(resources);
                }
                case "fill" -> {
                    Fill(resources);
                }
                case "take" -> {
                    System.out.println("I give you " + resources[4]);
                    resources[4] -= resources[4];
                }
                case "remaining" -> {
                    System.out.println(Remaining(resources));
                }
            }
        }
    }

    public static void Buy(Integer[] resources) {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String drink = (String) Input("String");

        switch (drink) {
            case "1" -> {  // espresso
                if (resources[0] < 250 || resources[2] < 16 || resources[3] < 0){
                    Integer[] lst_for_check = new Integer[] {resources[0] - 250, 0, resources[2] - 16, resources[3] - 1};
                    System.out.println(Check(lst_for_check));
                } else {
                    Integer[] minus = new Integer[]{250, 0, 16, 0, 4};
                    Minus_resources(resources, minus);
                }
            }
            case "2" -> {  // latte
                if (resources[0] < 350 || resources[1] < 75 || resources[2] < 20 || resources[3] < 0) {
                    Integer[] lst_for_check = new Integer[]{resources[0] - 350, resources[1] - 75, resources[2] - 20, resources[3] - 1};
                    System.out.println(Check(lst_for_check));
                } else {
                    Integer[] minus = new Integer[]{350, 75, 20, 0, 7};
                    Minus_resources(resources, minus);
                }
            }
            case "3" -> {  // cappuccino
                if (resources[0] < 200 || resources[1] < 100 || resources[2] < 12 || resources[3] < 0) {
                    Integer[] lst_for_check = new Integer[]{resources[0] - 200, resources[1] - 100, resources[2] - 12, resources[3] - 1};
                    System.out.println(Check(lst_for_check));
                } else {
                    Integer[] minus = new Integer[]{200, 100, 12, 0, 6};
                    Minus_resources(resources, minus);
                }
            }
            case "back" -> {
            }
        }
    }

    public static void Fill(Integer[] resources){
        System.out.println("\nWrite how many ml of water you want to add:");
        int water_to_add = (int) Input("Integer");
        System.out.println("Write how many ml of milk you want to add:");
        int milk_to_add = (int) Input("Integer");
        System.out.println("Write how many grams of coffee beans you want to add:");
        int cb_to_add = (int) Input("Integer");
        System.out.println("Write how many disposable coffee cups you want to add:");
        int cups_to_add = (int) Input("Integer");
        resources[0] += water_to_add;
        resources[1] += milk_to_add;
        resources[2] += cb_to_add;
        resources[3] += cups_to_add;
    }

    public static String Remaining(Integer[] resources){
        return ("\nThe coffee machine has:\n" +
                resources[0] + " of water\n" +
                resources[1] + " of milk\n" +
                resources[2] + " of coffee beans\n" +
                resources[3] + " of disposable cups\n" +
                resources[4] + " of money");
    }

    public static String Check(Integer[] lst_for_check){
        String not_enough;
        if (lst_for_check[0] < 0) {
            not_enough = "water";
        } else if (lst_for_check[1] < 0) {
            not_enough = "milk";
        } else if (lst_for_check[2] < 0){
            not_enough = "coffee beans";
        } else {not_enough = "cups";}
        return ("Sorry, not enough " + not_enough + "!");
    }

    static Object Input(String condition) {
        Scanner input = new Scanner(System.in);
        if ("String".equals(condition)) {
            return input.nextLine();
        } else {return input.nextInt();}
    }

    public static void Minus_resources(Integer[] resources, Integer[] minus) {
        resources[0] -= minus[0];
        resources[1] -= minus[1];
        resources[2] -= minus[2];
        resources[3]--;
        resources[4] += minus[4];

        System.out.println("I have enough resources, making you a coffee!");
    }
}
