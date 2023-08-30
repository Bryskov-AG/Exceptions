// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
// и возвращает введенное значение. 
// Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо 
// повторно запросить у пользователя ввод данных.


import java.util.Scanner;

public class Task_1 {
    public static float getInputFloat() {
        Scanner scanner = new Scanner(System.in);
        float value = 0.0f;
        boolean isValidInput = false;

       
        
        while (!isValidInput) {
            try {
                System.out.print("Введите дробное число: ");
                String input = scanner.nextLine();
                value = Float.parseFloat(input);
                isValidInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат числа. Пожалуйста, введите дробное число.");
            }
        }
        
        return value;
        
    }
    

    public static void main(String[] args) {
        float floatValue = getInputFloat();
        System.out.println("Вы ввели: " + floatValue);
    }
}
