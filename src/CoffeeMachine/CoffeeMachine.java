package CoffeeMachine;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // w = water, m = milk, cb = coffee beans, c = cup, $ = money
        Integer[] w_m_cb_c_$ = new Integer[]{400, 540, 120, 9, 550};

        while (true) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            String action = input.nextLine();
            if (action.equals("exit")) {
                break;
            }
            switch (action) {
                case "buy" -> {
                    System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String drink = input.nextLine();
                    switch (drink) {
                        case "1" -> {  // espresso
                            if (w_m_cb_c_$[0] < 250 || w_m_cb_c_$[2] < 16 || w_m_cb_c_$[3] < 0){
                                Integer[] lst_for_check = new Integer[] {w_m_cb_c_$[0] - 250, 0, w_m_cb_c_$[2] - 16, w_m_cb_c_$[3] - 1};
                                System.out.println(Check.check(lst_for_check));
                            } else {
                                w_m_cb_c_$[0] -= 250;
                                w_m_cb_c_$[2] -= 16;
                                w_m_cb_c_$[3]--;
                                w_m_cb_c_$[4] += 4;
                                System.out.println("I have enough resources, making you a coffee!");}
                        }
                        case "2" -> {  // latte
                            if (w_m_cb_c_$[0] < 350 || w_m_cb_c_$[1] < 75 || w_m_cb_c_$[2] < 20 || w_m_cb_c_$[3] < 0) {
                                Integer[] lst_for_check = new Integer[]{w_m_cb_c_$[0] - 350, w_m_cb_c_$[1] - 75, w_m_cb_c_$[2] - 20, w_m_cb_c_$[3] - 1};
                                System.out.println(Check.check(lst_for_check));
                            } else {
                                w_m_cb_c_$[0] -= 350;
                                w_m_cb_c_$[1] -= 75;
                                w_m_cb_c_$[2] -= 20;
                                w_m_cb_c_$[3]--;
                                w_m_cb_c_$[4] += 7;
                                System.out.println("I have enough resources, making you a coffee!");}
                        }
                        case "3" -> {  // cappuccino
                            if (w_m_cb_c_$[0] < 200 || w_m_cb_c_$[1] < 100 || w_m_cb_c_$[2] < 12 || w_m_cb_c_$[3] < 0) {
                                Integer[] lst_for_check = new Integer[]{w_m_cb_c_$[0] - 200, w_m_cb_c_$[1] - 100, w_m_cb_c_$[2] - 12, w_m_cb_c_$[3] - 1};
                                System.out.println(Check.check(lst_for_check));
                            } else {
                                w_m_cb_c_$[0] -= 200;
                                w_m_cb_c_$[1] -= 100;
                                w_m_cb_c_$[2] -= 12;
                                w_m_cb_c_$[3]--;
                                w_m_cb_c_$[4] += 6;
                                System.out.println("I have enough resources, making you a coffee!");}
                        }
                        case "back" -> {
                        }
                    }
                }
                case "fill" -> {
                    System.out.println("\nWrite how many ml of water you want to add:");
                    int water_to_add = input.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    int milk_to_add = input.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    int cb_to_add = input.nextInt();
                    System.out.println("Write how many disposable coffee cups you want to add:");
                    int cups_to_add = input.nextInt();
                    w_m_cb_c_$[0] += water_to_add;
                    w_m_cb_c_$[1] += milk_to_add;
                    w_m_cb_c_$[2] += cb_to_add;
                    w_m_cb_c_$[3] += cups_to_add;
                }
                case "take" -> {
                    System.out.println("I give you " + w_m_cb_c_$[4]);
                    w_m_cb_c_$[4] -= w_m_cb_c_$[4];
                }
                case "remaining" -> {
                    System.out.println(Remaining.remaining(w_m_cb_c_$));
                }
            }
        }
    }
}

class Check {
    public static String check(Integer[] lst_for_check){
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
}

class Remaining {
    // w = water, m = milk, cb = coffee beans, c = cup, $ = money
    public static String remaining(Integer[] w_m_cb_c_$){
        return ("\nThe coffee machine has:\n" +
                w_m_cb_c_$[0] + " of water\n" +
                w_m_cb_c_$[1] + " of milk\n" +
                w_m_cb_c_$[2] + " of coffee beans\n" +
                w_m_cb_c_$[3] + " of disposable cups\n" +
                w_m_cb_c_$[4] + " of money");
    }
}
