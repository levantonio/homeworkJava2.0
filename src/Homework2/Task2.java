
//Дана строка json:
//        [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//        Написать метод, который распарсит этот текст и, используя StringBuilder, создаст строки вида:
//        Студент [фамилия] получил [оценка] по предмету [предмет]. Например:
//        Студент Иванов получил 5 по предмету Математика.
//        Студент Петрова получил 4 по предмету Информатика.
//        Студент Краснов получил 5 по предмету Физика.

package Homework2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static void inParse() {
        StringBuilder newString = new StringBuilder();
        try (BufferedReader fileReader = new BufferedReader(new FileReader("C:\\java_projects\\homeworks\\homework2\\dataForParse.txt"))) {
            String data;
            while ((data = fileReader.readLine()) != null) {
                newString.append(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, String> map = new HashMap<>(); // dictionary initial


        String[] keys = newString.toString().replace("{", "").
                replace("[", "").
                replace("]", "").
                replace("\"", "").
                replaceAll("\\s", "").
                split("},");

        for (String data : keys) {
            String[] person = data.split(",");
            for (String keyValues : person) {
                String[] keyValue = keyValues.replace("}", "").split(":");
                String key = keyValue[0];
                String value = keyValue[1];
                map.put(key, value);
            }
            System.out.printf("Студент %s получил %s по предмету %s.\n", map.get("фамилия"),
                    map.get("оценка"), map.get("предмет"));
        }
    }
}
