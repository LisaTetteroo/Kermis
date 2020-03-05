package nl.workingtalent;

import java.util.Scanner;

public class Operator {
    public static void main(String[] args) {
        System.out.println("geef minuten");
        Scanner input =  new Scanner(System.in);
        int inputInMinutes = Integer.parseInt((input.next()));
        int hours = inputInMinutes / 60;
        int minutes = inputInMinutes % 60;

        System.out.println(inputInMinutes + " minutes is hours " + hours + " hours and " + minutes + "minutes.");

    }
}
