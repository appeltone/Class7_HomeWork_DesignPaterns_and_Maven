package singleToneThreadSafe;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileSingleTone {
    private static WriteToFileSingleTone instance = null;
    private File file;

    // the constructor will try to connect to the file - will happen only in one instance of the writter
    private WriteToFileSingleTone() {
        file = new File("log.txt");
        try {
            file.createNewFile(); // will do nothing if file exist
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // method that returns WriteToFileSingleTone, will create new only if hasen't been created before (single-tone)
    public static WriteToFileSingleTone getInstance() {
        if (instance == null) {
            // when getInstance() method is synchronized it causes slow performance as multiple threads can’t access
            // it simultaneously so it's better to synchronize the new object creation only
            synchronized (WriteToFileSingleTone.class){ // creation of a bew object is blocked for other threads
                if (instance == null) // second check of a null deals with long creation of the object by other threads
                    instance = new WriteToFileSingleTone();
            }

        }
        return instance;
    }

    // method for writting to the file, from any of the instances of this class it will write to same file
    public void writeTextToFile(String str) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(str + "\n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
