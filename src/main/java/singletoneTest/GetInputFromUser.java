package singletoneTest;

import java.util.Scanner;

public class GetInputFromUser {

    public static void main(String[] args) {
        Scanner fromUser = new Scanner(System.in);
        WriteToFileSingleTone writer1 = WriteToFileSingleTone.getInstance(); // get instance from singletone class
        WriteToFileSingleTone writer2 = WriteToFileSingleTone.getInstance(); // get instance from singletone class
        // allthough I created 2 different instances of the same class, when i write to a file using writeTextToFile
        // the string will be written to the same file as only one instance can be created, both writer1 and writer2
        // are pointing to the same singletone.WriteToFileSingleTone instance

        System.out.println("Please enter your Name");
        writer1.writeTextToFile(fromUser.nextLine());

        System.out.println("Please enter your Age");
        writer2.writeTextToFile(fromUser.nextLine());

        System.out.println("Please enter your Address");
        writer2.writeTextToFile(fromUser.nextLine());

        System.out.println("Please enter your Phone number");
        writer2.writeTextToFile(fromUser.nextLine());


    }


}
