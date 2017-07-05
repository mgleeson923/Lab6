import java.util.Scanner;

/**
 * Created by michaelgleeson on 6/30/17.
 */
public class Lab6 {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String repeat;


        //1. Display Welcome Message
        System.out.println("Welcome to the Pig Latin Translator!\n");
        do {
            //2. Prompt for input
            System.out.print("Enter a line to be translated: ");

            //3. User input
            String userInput = scnr.nextLine();


            //4. Translate user input
            //4.1 Convert to lower case
            userInput = userInput.toLowerCase(); //changes input to lower case letters
            String result;
            if (isVowels(userInput)) {//vowels
                result = piggifiedVowels(userInput);
            } else {
                result = piggifiedConsonants(userInput);
            }

            //5. Output of Translation
            System.out.println(result + "\n");


            //6. Prompt to run again
            System.out.print("Would you like to translate another word? Y/N: ");
            repeat = scnr.nextLine();

        } while (repeat.equalsIgnoreCase("Y"));
        System.out.println("Thanks for playing. Good bye!");


    }

    //translates a word using vowel pig latin logic
    private static String piggifiedVowels(String userInput) {

        userInput = userInput + "way";


        return userInput;
    }

    //translates a word using consonant pig latin logic
    private static String piggifiedConsonants(String userInput) {

        String vowels = "aeiou";
        for (int i = 0; i < userInput.length(); i++) {
            if (vowels.contains("" + userInput.charAt(i))) {
                String prefix = userInput.substring(0, i);
                String suffix = userInput.substring(i);
                userInput = suffix + prefix + "ay";
                break;
            }
        }
        return userInput;
    }

    //determines if a word starts with a vowel or consonant
    private static boolean isVowels(String userInput) {
        if (userInput.charAt(0) == 'a' || userInput.charAt(0) == 'e' || userInput.charAt(0) == 'i' || userInput.charAt(0) == 'o' || userInput.charAt(0) == 'u') {
            return true;
        }

        return false;
    }

}
