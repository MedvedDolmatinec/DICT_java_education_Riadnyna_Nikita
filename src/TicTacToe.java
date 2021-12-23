import java.util.Scanner;

public class TicTacToe {
    Scanner userInput = new Scanner(System.in);
    String line1 = "___";
    String line2 = "___";
    String line3 = "___";
    char moveNow = 'X';

    public static void main(String[] args) {
        TicTacToe myGame = new TicTacToe();
        myGame.setField();
        myGame.showField();
        myGame.makeMove();
        myGame.showField();
    }

    public int countMatches(String target) {
        String deleteTarget1 = line1.replace (target, "");
        String deleteTarget2 = line2.replace (target, "");
        String deleteTarget3 = line3.replace (target, "");
        return (line1.length () + line2.length() + line3.length()) - (deleteTarget1.length () + deleteTarget2.length()
                + deleteTarget3.length());
    }
    public void setField() {
        System.out.println("Enter cells:");
        String newField = userInput.nextLine();
        line1 = newField.substring(0,3);
        line2 = newField.substring(3, 6);
        line3 = newField.substring(6, 9);
    }
    public void showField() {
        System.out.printf("---------\n" +
                "| %s |\n" +
                "| %s |\n" +
                "| %s |\n" +
        "---------\n", line1, line2, line3);
    }
    public String checkGameStatus() {
        boolean oWin = false;
        boolean xWin = false;
        if (line1.charAt(0) == 'X' && line1.charAt(1) == 'X' && line1.charAt(2) == 'X' || line2.charAt(0) == 'X' &&
                line2.charAt(1) == 'X' && line2.charAt(2) == 'X' || line3.charAt(0) == 'X' && line3.charAt(1) == 'X' &&
                line3.charAt(2) == 'X' || line1.charAt(0) == 'X' && line2.charAt(0) == 'X' && line3.charAt(0) == 'X' ||
                line1.charAt(1) == 'X' && line2.charAt(1) == 'X' && line3.charAt(1) == 'X' || line1.charAt(2) == 'X' &&
                line2.charAt(2) == 'X' && line3.charAt(2) == 'X' || line1.charAt(0) == 'X' && line2.charAt(1) == 'X' &&
                line3.charAt(2) == 'X' || line1.charAt(2) == 'X' && line2.charAt(1) == 'X' && line3.charAt(0) == 'X') {
            xWin = true;
        }

        if (line1.charAt(0) == 'O' && line1.charAt(1) == 'O' && line1.charAt(2) == 'O' || line2.charAt(0) == 'O' &&
                line2.charAt(1) == 'O' && line2.charAt(2) == 'O' || line3.charAt(0) == 'O' && line3.charAt(1) == 'O' &&
                line3.charAt(2) == 'O' || line1.charAt(0) == 'O' && line2.charAt(0) == 'O' && line3.charAt(0) == 'O' ||
                line1.charAt(1) == 'O' && line2.charAt(1) == 'O' && line3.charAt(1) == 'O' || line1.charAt(2) == 'O' &&
                line2.charAt(2) == 'O' && line3.charAt(2) == 'O' || line1.charAt(0) == 'O' && line2.charAt(1) == 'O' &&
                line3.charAt(2) == 'O' || line1.charAt(2) == 'O' && line2.charAt(1) == 'O' && line3.charAt(0) == 'O') {
            oWin = true;
        }
        if (countMatches("X") - countMatches("O") > 1 || countMatches("O") -
                countMatches("X")> 1) {
            return "Impossible";
        } else if (xWin && oWin) {
            return "Impossible";
        } else if (xWin) {
            return "X is winner!";
        } else if (oWin) {
            return "O is winner!";
        } else if (line1.contains("_") || line2.contains("_") || line3.contains("_")) {
            return "Game unfinished";
        } else {
            return "Draw";
        }

    }
    public boolean moveChecker (String coordinates) {
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
            if (line1.charAt(Character.getNumericValue(coordinates.charAt(2)) - 1) != '_') {
                System.out.println("This cell is occupied, choose another one");
                return false;
            } else {
                return true;
            }
        } else if (Character.getNumericValue(coordinates.charAt(0)) == 2) {
            if (line2.charAt(Character.getNumericValue(coordinates.charAt(2)) - 1) != '_') {
                System.out.println("This cell is occupied, choose another one");
                return false;
            } else {
                return true;
            }
        } else if (Character.getNumericValue(coordinates.charAt(0)) == 3) {
            if (line3.charAt(Character.getNumericValue(coordinates.charAt(2)) - 1) != '_') {
                System.out.println("This cell is occupied, choose another one");
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    public void makeMove() {
        System.out.println("Enter coordinates");
        String coordinates = userInput.nextLine();

        if (moveChecker(coordinates)) {
            if (coordinates.charAt(0) == '1') {
                line1 = replaceStringChar(line1, moveNow, Character.getNumericValue(coordinates.charAt(2)) - 1);
            } else if (coordinates.charAt(0) == '2') {
                line2 = replaceStringChar(line2, moveNow, Character.getNumericValue(coordinates.charAt(2)) - 1);
            } else if (coordinates.charAt(0) == '3') {
                line3 = replaceStringChar(line3, moveNow, Character.getNumericValue(coordinates.charAt(2)) - 1);
            }
        }
    }

    public String replaceStringChar(String string, char character, int index) {
        return string.substring(0, index) + character + string.substring(index+1);
    }
}