//TIP Для <b>запуска</b> кода нажмите <shortcut actionId="Run"/> или
// щелкните значок <icon src="AllIcons.Actions.Execute"/> в боковой области.
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final int SIZE = 8;

    public static void main(String[] args) {
        int[][] colors = new int[SIZE][SIZE];
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Заполнение матрицы случайными числами
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }

        // Вывод исходной матрицы
        System.out.println("Исходная матрица:");
        printMatrix(colors);

        // Запрос у пользователя угла поворота
        System.out.println("\nВыберите угол поворота (90, 180 или 270 градусов):");
        int angle = scanner.nextInt();

        // Проверка корректности ввода
        while (angle != 90 && angle != 180 && angle != 270) {
            System.out.println("Некорректный ввод. Пожалуйста, выберите 90, 180 или 270 градусов:");
            angle = scanner.nextInt();
        }

        // Поворот матрицы на выбранный угол
        int[][] rotatedColors = rotateMatrix(colors, angle);

        // Вывод повёрнутой матрицы
        System.out.println("\nМатрица после поворота на " + angle + " градусов:");
        printMatrix(rotatedColors);

        scanner.close();
    }

    // Метод для вывода матрицы на экран
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    // Метод для поворота матрицы на заданный угол
    public static int[][] rotateMatrix(int[][] matrix, int angle) {
        int[][] rotatedMatrix = new int[SIZE][SIZE];
        switch (angle) {
            case 90:
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        rotatedMatrix[j][SIZE - 1 - i] = matrix[i][j];
                    }
                }
                break;
            case 180:
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        rotatedMatrix[SIZE - 1 - i][SIZE - 1 - j] = matrix[i][j];
                    }
                }
                break;
            case 270:
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        rotatedMatrix[SIZE - 1 - j][i] = matrix[i][j];
                    }
                }
                break;
            default:
                // Если угол не 90, 180 или 270, возвращаем исходную матрицу
                rotatedMatrix = matrix;
                break;
        }
        return rotatedMatrix;
    }
}