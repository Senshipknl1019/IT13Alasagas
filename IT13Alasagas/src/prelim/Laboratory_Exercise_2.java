package laboratory_exercise_2; // Your package name

public class Laboratory_Exercise_2 {
    public static void main(String[] args) {
        
        int num1 = 25;
        int num2 = 78;
        int num3 = 87;

        System.out.println("FIRSTNUMBER " + num1);
        System.out.println("SECONDNUMBER " + num2);
        System.out.println("THIRDNUMBER " + num3);

        // Call the method to find the greatest number
        GreatestNumber.findGreatest(num1, num2, num3);

        // Calling the displayMessage method from the Laboratory_excersise2 class in the prelim package
       
    }
}

class GreatestNumber {
    public static void findGreatest(int num1, int num2, int num3) {
        int greatest = num1;
        if (num2 > greatest) {
            greatest = num2;
        }
        if (num3 > greatest) {
            greatest = num3;
        }
        System.out.println("The greatest number is: " + greatest);
    }
}
