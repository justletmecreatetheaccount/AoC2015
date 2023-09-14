import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static final int stringLength = 16;
    static char[] treatedInput;
    static class firstStar {
        static void findNumberNice(String input) {
            int niceStrings = 0;
            boolean doubleLettersFlag, forbiddenLettersFlag;
            int numberOfVowels;
            char previousChar;
            treatedInput = input.toCharArray();

            for (int i = 0; i < input.length() / stringLength; i++) {
                doubleLettersFlag = false;
                forbiddenLettersFlag = false;
                numberOfVowels = 0;
                previousChar = '&';
                stringIteration:
                for (int j = 0; j < stringLength; j++) {
                    switch (treatedInput[i * 16 + j]) {
                        case 'a':
                            numberOfVowels++;
                            break;
                        case 'e':
                            numberOfVowels++;
                            break;
                        case 'i':
                            numberOfVowels++;
                            break;
                        case 'u':
                            numberOfVowels++;
                            break;
                        case 'o':
                            numberOfVowels++;
                            break;
                        case 'y':
                            if (previousChar == 'x') {
                                forbiddenLettersFlag = true;
                                break stringIteration;
                            }
                            break;
                        case 'b':
                            if (previousChar == 'a') {
                                forbiddenLettersFlag = true;
                                break stringIteration;
                            }
                            break;
                        case 'd':
                            if (previousChar == 'c') {
                                forbiddenLettersFlag = true;
                                break stringIteration;
                            }
                            break;
                        case 'q':
                            if (previousChar == 'p') {
                                forbiddenLettersFlag = true;
                                break stringIteration;
                            }
                            break;
                    }
                    if (previousChar == treatedInput[i * 16 + j]) {
                        doubleLettersFlag = true;
                    }
                    previousChar = treatedInput[i * 16 + j];
                }
                if (numberOfVowels > 2 && !forbiddenLettersFlag && doubleLettersFlag) {
                    niceStrings++;
                    System.out.println(input.substring(i * 16, (i + 1) * 16) + " " + numberOfVowels);
                }
            }
            System.out.println(niceStrings);
        }
    }

    static  class secondStar {
        static void findNumberNice(String input) {
            treatedInput = input.toCharArray();
            int niceString = 0;
            char prevChar;
            char prevPrevChar;
            String toCompare;
            boolean rep4;
            boolean rep2;
            for (int i = 0; i < input.length() / stringLength; i++) {
                rep4 = false;
                rep2 = false;
                prevChar = '&';
                prevPrevChar = '&';
                stringIteration:
                for (int j = 0; j < stringLength; j++) {
                    if (prevPrevChar == treatedInput[i * 16 + j]) {
                        rep2 = true;
                    }
                    for (int k = j + 2; k < stringLength; k++) {
                        toCompare = String.valueOf(treatedInput[i * 16 + k - 1]) + treatedInput[i * 16 + k];
                        if (toCompare.equals(String.valueOf(treatedInput[i * 16 + j])+ prevChar)){
                            rep4 = true;
                        }
                    }
                    prevPrevChar = prevChar;
                    prevChar = treatedInput[i * 16 + j];
                }
                if (rep2 && rep4) {
                    niceString++;
                }
            }
            System.out.println(niceString);
        }
    }
    static String input = "";
    public static void main(String[] args) {

        try {
            File inputFile = new File("res/input.txt");
            Scanner myReader = new Scanner(inputFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                input += data;
            }
            myReader.close();
        } catch (
        FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
         secondStar.findNumberNice(input);
    }
}