package Lesson_2;
import java.util.Scanner;

public class Task_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите текст: ");
            String userInput = scanner.nextLine();

            if (userInput.isEmpty()) {
                throw new Exception("Пустые строки вводить нельзя.");
            }
            
            System.out.println("Вы ввели: " + userInput);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    
}
