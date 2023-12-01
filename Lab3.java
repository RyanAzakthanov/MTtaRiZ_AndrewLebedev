import java.util.Scanner;

public class Lab3
{
    public static void main(String[] args) {
        Player player1 = new Player("Player1", 'X');
        Player player2 = new Player("Player2", 'O');
        Playground game = new Playground();

        System.out.println("Хрестики Нулики");

        System.out.println("Х - гравець , бажаєте увiйти або зареєструватися? (1 або 2)");
        System.out.println("1");
        System.out.println("Введiть iм'я:");
        System.out.println("Player1");
        System.out.println("Введiть пароль:");
        System.out.println("Pass1");
        System.out.println("");

        System.out.println("O - гравець , бажаєте увiйти або зареєструватися? (1 або 2)");
        System.out.println("1");
        System.out.println("Введiть iм'я:");
        System.out.println("Player2");
        System.out.println("Введiть пароль:");
        System.out.println("Pass2");
        System.out.println("");

        game.displayBoard();

        for (int turn = 0; turn < 9; turn++) {
            if (turn % 2 == 0) {
                player1.makeMove(game);
            } else {
                player2.makeMove(game);
            }

            game.displayBoard();

            if (turn >= 4 && game.checkVictory(player1.symbol)) {
                System.out.println(player1.name + " здобув перемоги!");
                System.out.println(player1.name + " - Перемог:1 Поразок:0");
                System.out.println(player2.name + " - Перемог:0 Поразок:1");
                break;
            } else if (turn >= 4 && game.checkVictory(player2.symbol)) {
                System.out.println(player2.name + " здобув перемоги!");
                break;
            }

            if (turn == 8) {
                System.out.println("Нiчия!");
            }
        }
    }
}


class Playground {
    private char[][] board;

    public Playground() {
        board = new char[3][3];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
        System.out.println();
    }

    public boolean makeMove(int row, int col, char symbol) {
        if (isValidMove(row, col) && board[row][col] == ' ') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    public boolean checkVictory(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true; // Перемога по вертикалі
            }
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true; // Перемога по горизонталі
            }
        }

        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true; // Перемога по диагоналі (із верхнього лівого кута до нижнього правого)
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true; // Перемога по диагоналі (із верхнього правого кута до нижнього лівого)
        }

        return false;
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }
}

class Player {
    public String name;
    public char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public void makeMove(Playground playground) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(name + " робить хiд (" + symbol + ")");
        int row, col;
        do {
            System.out.print("Введить номер строки (0, 1, або 2): ");
            row = scanner.nextInt();
            System.out.print("Введить номер стовпця (0, 1, або 2): ");
            col = scanner.nextInt();
        } while (!playground.isValidMove(row, col) || !playground.makeMove(row, col, symbol));
    }
}

