package backend.academy.service;

import backend.academy.enums.AffineCoefficientColor;
import backend.academy.enums.TransformationType;

public class OutputService {

    @SuppressWarnings("checkstyle:RegexpSinglelineJava")
    public static <T> void print(T source) {
        System.out.print(source);
    }

    @SuppressWarnings("checkstyle:RegexpSinglelineJava")
    public static <T> void println(T source) {
        print(source + "\n");
    }

    public static void printColorChoose() {
        println("Choose color");
        for (int index = 0; index < AffineCoefficientColor.values().length; index++) {
            println(index + " " + AffineCoefficientColor.values()[index]);
        }
    }

    public void printTanformationChoose() {
        println("Choose transformations, type enter if stop");
        for (int i = 0; i < TransformationType.values().length; i++) {
            println(i + " " + TransformationType.values()[i]);
        }
    }
}
