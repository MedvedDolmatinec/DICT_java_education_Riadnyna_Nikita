import java.util.Scanner;

public class TicTacToe {
    Scanner scanner = new Scanner(System.in);
    String line_1 = "___";
    String line_2 = "___";
    String line_3 = "___";
    char moveNow = 'X';

    public static void main(String[] args) {
        TicTacToe play = new TicTacToe();
        play.field();
        play.show();
        play.action();
    }

    public void field() {
        System.out.println("Enter cells:");
        String newField = scanner.nextLine();
        line_1 = newField.substring(0,3);
        line_2 = newField.substring(3, 6);
        line_3 = newField.substring(6, 9);
    }
    public void show() {
        System.out.printf("---------\n" +
                "| %s |\n" +
                "| %s |\n" +
                "| %s |\n" +
        "---------\n", line_1, line_2, line_3);
    }
    public boolean check_action(String coordinates) {
        if (coordinates.length() != 3) {
            System.out.println("You should enter two numbers separated by space!");
            return false;
        } else if (!(Character.isDigit(coordinates.charAt(0)) && Character.isDigit(coordinates.charAt(2)))) {
            System.out.println("You should enter numbers");
            return false;
        } else if (!(Character.getNumericValue(coordinates.charAt(0)) <= 3
                && Character.getNumericValue(coordinates.charAt(0)) <= 3)) {
            System.out.println("Numbers should be from 1 to 3");
            return false;
        } else if (Character.getNumericValue(coordinates.charAt(0)) == 1) {
            if (line_1.charAt(Character.getNumericValue(coordinates.charAt(2)) - 1) != '_') {
                System.out.println("This cell is occupied, choose another one");
                return false;
            } else {
                return true;
            }
        } else if (Character.getNumericValue(coordinates.charAt(0)) == 2) {
            if (line_2.charAt(Character.getNumericValue(coordinates.charAt(2)) - 1) != '_') {
                System.out.println("This cell is occupied, choose another one");
                return false;
            } else {
                return true;
            }
        } else if (Character.getNumericValue(coordinates.charAt(0)) == 3) {
            if (line_3.charAt(Character.getNumericValue(coordinates.charAt(2)) - 1) != '_') {
                System.out.println("This cell is occupied, choose another one");
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    public String transformation(String string, char character, int index) {
        return string.substring(0, index) + character + string.substring(index+1);
    }
    public String status() {
        boolean oWin = false;
        boolean xWin = false;
        if (line_1.charAt(0) == 'X' && line_1.charAt(1) == 'X' && line_1.charAt(2) == 'X' || line_2.charAt(0) == 'X' &&
                line_2.charAt(1) == 'X' && line_2.charAt(2) == 'X' || line_3.charAt(0) == 'X' && line_3.charAt(1) == 'X' &&
                line_3.charAt(2) == 'X' || line_1.charAt(0) == 'X' && line_2.charAt(0) == 'X' && line_3.charAt(0) == 'X' ||
                line_1.charAt(1) == 'X' && line_2.charAt(1) == 'X' && line_3.charAt(1) == 'X' || line_1.charAt(2) == 'X' &&
                line_2.charAt(2) == 'X' && line_3.charAt(2) == 'X' || line_1.charAt(0) == 'X' && line_2.charAt(1) == 'X' &&
                line_3.charAt(2) == 'X' || line_1.charAt(2) == 'X' && line_2.charAt(1) == 'X' && line_3.charAt(0) == 'X') {
            xWin = true;
        }

        if (line_1.charAt(0) == 'O' && line_1.charAt(1) == 'O' && line_1.charAt(2) == 'O' || line_2.charAt(0) == 'O' &&
                line_2.charAt(1) == 'O' && line_2.charAt(2) == 'O' || line_3.charAt(0) == 'O' && line_3.charAt(1) == 'O' &&
                line_3.charAt(2) == 'O' || line_1.charAt(0) == 'O' && line_2.charAt(0) == 'O' && line_3.charAt(0) == 'O' ||
                line_1.charAt(1) == 'O' && line_2.charAt(1) == 'O' && line_3.charAt(1) == 'O' || line_1.charAt(2) == 'O' &&
                line_2.charAt(2) == 'O' && line_3.charAt(2) == 'O' || line_1.charAt(0) == 'O' && line_2.charAt(1) == 'O' &&
                line_3.charAt(2) == 'O' || line_1.charAt(2) == 'O' && line_2.charAt(1) == 'O' && line_3.charAt(0) == 'O') {
            oWin = true;
        }
        if (count("X") - count("O") > 1 || count("O") -
                count("X")> 1) {
            return "Impossible";
        } else if (xWin && oWin) {
            return "Impossible";
        } else if (xWin) {
            return "X is winner!";
        } else if (oWin) {
            return "O is winner!";
        } else if (line_1.contains("_") || line_2.contains("_") || line_3.contains("_")) {
            return "Game unfinished";
        } else {
            return "Draw";
        }

    }

    public int count(String target) {
        String deleteTarget1 = line_1.replace (target, "");
        String deleteTarget2 = line_2.replace (target, "");
        String deleteTarget3 = line_3.replace (target, "");
        return (line_1.length () + line_2.length() + line_3.length()) - (deleteTarget1.length () + deleteTarget2.length()
                + deleteTarget3.length());
    }


    public void action() {
        System.out.println("Enter coordinates");
        String place = scanner.nextLine();

        if (check_action(place)) {
            if (place.charAt(0) == '1') {
                line_1 = transformation(line_1, moveNow, Character.getNumericValue(place.charAt(2)) - 1);
            } else if (place.charAt(0) == '2') {
                line_2 = transformation(line_2, moveNow, Character.getNumericValue(place.charAt(2)) - 1);
            } else if (place.charAt(0) == '3') {
                line_3 = transformation(line_3, moveNow, Character.getNumericValue(place.charAt(2)) - 1);
            }
        }
    }

}

