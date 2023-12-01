import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //READ FILE
        StringBuilder input = new StringBuilder();
        try {
            File inputFile = new File("res/input2.txt");
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
        ArrayList<String[]> instructionsArray = new ArrayList<>();
        for (int i = 0; i < instructions.length; i++) {
            instructionsArray.add(instructions[i].split(" "));
        }
        //READ FILE
        Map<String, Short> allData = new HashMap<>();
        while (allData.get("a") == null) {
        //for (int i = 0; i < 10; i++) {
            for (String[] instruction : instructionsArray) {
                switch (instruction.length) {
                    case 3:
                        try {
                            allData.put(instruction[2], Short.parseShort(instruction[0]));
                        } catch (NumberFormatException e) {
                            allData.put(instruction[2], allData.get(instruction[0]));
                        }
                        break;
                    case 4:
                        if (allData.get(instruction[1]) != null) {
                            allData.put(instruction[3], (short) ~allData.get(instruction[1]));
                        }
                        break;
                    case 5:
                        switch (instruction[1]) {
                            case "OR":
                                try {
                                    if (allData.get(instruction[2]) != null) {
                                        allData.put(instruction[4], (short) (Short.parseShort(instruction[0]) | allData.get(instruction[2])));
                                    }
                                } catch (NumberFormatException e) {
                                    if (allData.get(instruction[0]) != null && allData.get(instruction[2]) != null) {
                                        allData.put(instruction[4], (short) (allData.get(instruction[0]) | allData.get(instruction[2])));
                                    }
                                }
                                break;
                            case  "AND":
                                try {
                                    if (allData.get(instruction[2]) != null) {
                                        allData.put(instruction[4], (short) (Short.parseShort(instruction[0]) & allData.get(instruction[2])));
                                    }
                                } catch (NumberFormatException e){
                                    if (allData.get(instruction[0]) != null && allData.get(instruction[2]) != null) {
                                        allData.put(instruction[4], (short) (allData.get(instruction[0]) & allData.get(instruction[2])));
                                    }
                                }
                                break;
                            case "RSHIFT":
                                if (allData.get(instruction[0]) != null) {
                                    allData.put(instruction[4], (short) (allData.get(instruction[0]) >> Integer.parseInt(instruction[2])));
                                }
                                break;
                            case "LSHIFT":
                                if (allData.get(instruction[0]) != null) {
                                    allData.put(instruction[4], (short) (allData.get(instruction[0]) << Integer.parseInt(instruction[2])));
                                }
                                break;
                        }
                        break;
                }
            }
        }
        System.out.println(allData.get("a"));
    }
}