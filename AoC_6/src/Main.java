import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

public class Main {
    static class LightGrid {
        static int[][] grid = new int[1000][1000];

        static void followInstructions(String input) {

            String[] treatedinput = input.split("\n");

            for (String instruction : treatedinput) {
                String[] words = instruction.split(" ");
                if (words[0].equals("toggle")) {
                    String[] temp = words[1].split(",");
                    int[] startingPoint = {Integer.parseInt(temp[0]), Integer.parseInt(temp[1])};
                    temp = words[3].split(",");
                    int[] endPoint = {Integer.parseInt(temp[0]), Integer.parseInt(temp[1])};

                    for (int i = startingPoint[1]; i < endPoint[1] + 1; i++) {
                        for (int j = startingPoint[0]; j < endPoint[0] + 1; j++){
                            grid[i][j] += 2;
                        }
                    }

                } else if (words[0].equals("turn")) {
                    if (words[1].equals("on")) {
                        String[] temp = words[2].split(",");
                        int[] startingPoint = {Integer.parseInt(temp[0]), Integer.parseInt(temp[1])};
                        temp = words[4].split(",");
                        int[] endPoint = {Integer.parseInt(temp[0]), Integer.parseInt(temp[1])};

                        for (int i = startingPoint[1]; i < endPoint[1] + 1; i++) {
                            for (int j = startingPoint[0]; j < endPoint[0] + 1; j++){
                                grid[i][j] += 1;
                            }
                        }
                    } else {
                        String[] temp = words[2].split(",");
                        int[] startingPoint = {Integer.parseInt(temp[0]), Integer.parseInt(temp[1])};
                        temp = words[4].split(",");
                        int[] endPoint = {Integer.parseInt(temp[0]), Integer.parseInt(temp[1])};

                        for (int i = startingPoint[1]; i < endPoint[1] + 1; i++) {
                            for (int j = startingPoint[0]; j < endPoint[0] + 1; j++){
                                if (grid[i][j] == 0) {
                                    continue;
                                }
                                grid[i][j] -= 1;
                            }
                        }
                    }
                }
            }
            int totalBrightness = 0;
            for (int i = 0; i < 1000; i++) {
                for (int j = 0; j < 1000; j++) {
                    totalBrightness += grid[i][j];
                }
            }
            System.out.println(totalBrightness);
        }
    }

    public static void main(String[] args) {
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
        LightGrid.followInstructions(input.toString());
    }
}