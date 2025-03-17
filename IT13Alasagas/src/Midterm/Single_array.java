package Midterm;

public class Single_array {
    public static void main(String[] args) {
        String[] letters = {"A", "B", "C", "D", "E", "F", "G"};
        
        for (int i = 0; i < letters.length; i++) {
            System.out.print(letters[i]);
            if (i < letters.length - 1) {
                System.out.print(",");
            }
        }
    }
}
