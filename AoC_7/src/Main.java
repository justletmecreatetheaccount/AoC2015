import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //READ FILE
        StringBuilder input = new StringBuilder();
        try {
            File inputFile = new File("res/input.txt");
            Scanner myReader = new Scanner(inputFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                input.append(data).append("\n");
            }
            myReader.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String [] instructions = input.toString().split("\n");
        String [][] instructionsArray = new String[instructions.length][];
        for (int i = 0; i < instructions.length; i++) {
            instructionsArray[i] = instructions[i].split(" ");
        }
        //READ FILE

        //Map <String, smth> wires = new HashMap<>();
        //CIRUIT CONSTRUCTION
    }
}