import java.util.Scanner;


public class TicTacToe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String game_net = input.nextLine();
        char[] row1 = new char[3];
        char[] row2 = new char[3];
        char[] row3 = new char[3];
        game_net.getChars(0, 3, row1, 0);
        game_net.getChars(3, 6, row2, 0);
        game_net.getChars(6, 9, row3, 0);
        System.out.println("---------");
        System.out.println("| " + row1[0] + " " + row1[1] + " " + row1[2] + " |");
        System.out.println("| " + row2[0] + " " + row2[1] + " " + row2[2] + " |");
        System.out.println("| " + row3[0] + " " + row3[1] + " " + row3[2] + " |");
        System.out.println("---------");
    }
}
