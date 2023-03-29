//.Реализуйте алгоритм сортировки пузырьком числового массива,
// результат после каждой итерации запишите в лог-файл.
package Homework2;

import java.io.IOException;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Task1 {

    public static void run() throws IOException {
        Logger logger = Logger.getLogger(Task1.class.getName());
        FileHandler fh = new FileHandler("logTask1.xml");
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        logger.info("CORRECT BUBLE SORTING");
        int[] array = createArray();
        printArray(array);
        boobleSort(array);
        System.out.println("\n Sorted array: -");
        printArray(array);

    }

    public static void boobleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static int[] createArray() {
        int sizeArray = 10;
        int[] array = new int[sizeArray];
        Random rand = new Random();
        for (int i = 0; i < sizeArray; i++) {
            array[i] = rand.nextInt(5);
        }
        return array;

    }

    public static void printArray(int[] array) {
        for (int j : array) {
            System.out.printf(j + " ");
        }


    }
}
