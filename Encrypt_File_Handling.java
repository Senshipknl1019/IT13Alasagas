package Midterm;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Encrypt_File_Handling {
    public static void main(String[] args) {
        int key = 6;
        String message = "I love you!\nGwapo ko!\nBuotan si Maam!";

        try {
            String userDir = System.getProperty("user.home");
            File myObj = new File(userDir + "\\Documents\\Input.txt");
            File encrypted = new File(userDir + "\\Documents\\encrypted.txt");

            if (!myObj.exists()) {
                myObj.createNewFile();
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("Input file already exists.");
            }

            try (FileWriter sulat = new FileWriter(myObj)) {
                sulat.write(message);
            }

            String encryptedMessage = encryptMessage(message, key);

            try (FileWriter encryptedWriter = new FileWriter(encrypted)) {
                encryptedWriter.write(encryptedMessage);
            }

            System.out.println("Original  : \n" + message + "\n");
            System.out.println("Encrypted message : \n" + encryptedMessage);

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String encryptMessage(String message, int key) {
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetterOrDigit(chars[i])) {
                chars[i] = (char) (chars[i] + key);
                if (Character.isLetter(chars[i])) {
                    if (Character.isLowerCase(chars[i]) && chars[i] > 'z') {
                        chars[i] -= 26;
                    } else if (Character.isUpperCase(chars[i]) && chars[i] > 'Z') {
                        chars[i] -= 26;
                    }
                }
                if (Character.isDigit(chars[i]) && chars[i] > '9') {
                    chars[i] -= 10;
                }
            }
        }
        return new String(chars);
    }
}

