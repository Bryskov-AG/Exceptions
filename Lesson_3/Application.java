package Lesson_3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите данные в следующем порядке, разделяя пробелом:");
            System.out.println("Фамилия Имя Отчество Дата_рождения Номер_телефона Пол");
            
            String inputLine = scanner.nextLine();
            String[] inputData = inputLine.split(" ");

            if (inputData.length != 6) {
                throw new IllegalArgumentException("Введено недостаточно данных или слишком много данных");
            }

            String lastName = inputData[0];
            String firstName = inputData[1];
            String middleName = inputData[2];
            String birthDate = inputData[3];
            String phoneNumber = inputData[4];
            String gender = inputData[5];

            
            if (!isValidDate(birthDate) || !isValidPhoneNumber(phoneNumber) || !isValidGender(gender)) {
                throw new IllegalArgumentException("Неверный формат данных");
            }

            
            String userDataString = lastName + " " + firstName + " " + middleName + " " +
                    birthDate + " " + phoneNumber + " " + gender;

            
            writeToFile(lastName, userDataString);

            System.out.println("Данные успешно записаны в файл " + lastName + ".txt");
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static boolean isValidDate(String date) {
        String datePattern = "\\d{2}\\.\\d{2}\\.\\d{4}";
        return Pattern.matches(datePattern, date);
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d+");
    }

    private static boolean isValidGender(String gender) {
        return gender.equals("f") || gender.equals("m");
    }

    private static void writeToFile(String fileName, String data) throws IOException {
        try (FileWriter writer = new FileWriter(fileName + ".txt", true)) {
            writer.write(data + "\n");
        }
    }
    
}
