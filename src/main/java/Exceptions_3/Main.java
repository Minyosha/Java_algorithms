package Exceptions_3;

import java.io.*;
import java.nio.file.FileSystemException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            makeRecord();
            System.out.println("Запись в файл успешна");
        } catch (FileSystemException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }


    public static boolean isNumeric(String string) {
        int intValue;
        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.print("");
            // Тест
//            System.out.println("Передаваемая строка не может быть преобразована в тип Integer");
        }
        return false;
    }

    public static boolean isSimpleDate(String string) {
        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        Date birthdateTest;

        try {
            birthdateTest = format.parse(string);
            return true;
        } catch (ParseException e) {
            System.out.print("");
            // Тест
//            throw new ParseException("Неверный формат даты рождения", e.getErrorOffset());
        }
        return false;

    }

    public static void makeRecord() throws Exception {
        String sex = null;
        String phone = null;
        String dateOfBirth = null;
        String surname = null;
        String name = null;
        String patronymic = null;
        String fullStringToWrite = null;
        StringBuilder sb = new StringBuilder();
        int sexCount = 0;
        int phoneCount = 0;
        int birthDateCount = 0;
        int fullNameCount = 0;


        System.out.println("Введите ФИО, дату рождения, номер телефона, пол (f или m), разделенные пробелом");
        String inputText;
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            inputText = bf.readLine();
        } catch (IOException e) {
            throw new Exception("Ошибка при работе с консолью");
        }

        String[] inputArray = inputText.split(" ");
        if (inputArray.length != 6) {
            System.out.println("Введено неверное количество параметров");
            throw new Exception("Введено неверное количество параметров");
        }

        for (int i = 0; i < inputArray.length; i++) {
            if ((inputArray[i].toLowerCase().equals("m")) || (inputArray[i].toLowerCase().equals("f"))) {
                sexCount++;
                sex = inputArray[i];
            }
        }

        if (sexCount != 1) {
//            System.out.println(sexCount);
            System.out.println("Неверно введен пол");
            throw new RuntimeException("Неверно введен пол");
        }


        for (int i = 0; i < inputArray.length; i++) {
            if (isNumeric(inputArray[i]) == true) {
                phone = inputArray[i];
                phoneCount++;
            }
        }

        if (phoneCount != 1) {
//            System.out.println(phoneCount);
            System.out.println("Неверно введен телефон");
            throw new RuntimeException("Неверно введен телефон");
        }

        for (int i = 0; i < inputArray.length; i++) {
            if (isSimpleDate(inputArray[i]) == true) {
                dateOfBirth = inputArray[i];
                birthDateCount++;
            }
        }

        if (birthDateCount != 1) {
//            System.out.println(birthDateCount);
            System.out.println("Неверно введена дата рождения");
            throw new RuntimeException("Неверно введена дата рождения");
        }

        for (int i = 0; i < inputArray.length; i++) {
            if ((inputArray[i] == sex) || (inputArray[i] == phone) || (inputArray[i] == dateOfBirth)) {

            } else {
                fullStringToWrite = sb.append(inputArray[i]).toString();
                fullStringToWrite = sb.append(" ").toString();
                fullNameCount++;
                if (fullNameCount == 1) {
                    surname = inputArray[i];
                } else if (fullNameCount == 2) {
                    name = inputArray[i];
                } else if (fullNameCount == 3) {
                    patronymic = inputArray[i];
                }
            }
        }

        fullStringToWrite = sb.append(dateOfBirth).toString();
        fullStringToWrite = sb.append(" ").toString();
        fullStringToWrite = sb.append(phone).toString();
        fullStringToWrite = sb.append(" ").toString();
        fullStringToWrite = sb.append(sex).toString();

//        System.out.println(fullStringToWrite);
//        System.out.println(surname);
//        System.out.println(name);
//        System.out.println(patronymic);
//        System.out.println(phone);
//        System.out.println(sex);
//        System.out.println(dateOfBirth);

        assert surname != null;
        String fileName = surname.toLowerCase() + ".txt";
        File file = new File(fileName);
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            if (file.length() > 0) {
                fileWriter.write('\n');
            }
            fileWriter.write(fullStringToWrite);
        } catch (IOException e) {
            throw new FileSystemException("Возникла ошибка при работе с файлом");
        }

    }
}
