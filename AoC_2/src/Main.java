import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] getDimensions (String sdimensions) {
        int[] dimensions = new int[3];
        String[] temp = sdimensions.split("x");
        for (int i = 0; i < temp.length; i++) {
            dimensions[i] = Integer.parseInt(temp[i]);
        }
        return dimensions;
    }

    static int wrapperArea (int[] dimensions) {
        int area = 0;
        int[] sides = new int[3];
        sides[0] = dimensions[0]*dimensions[1];
        sides[1] = dimensions[0]*dimensions[2];
        sides[2] = dimensions[1]*dimensions[2];

        if (sides[0] <= sides[1]){
            if (sides[0] <= sides[2]) {
                area += sides[0];
            } else {
                area += sides[2];
            }
        } else if (sides[1] <= sides[2]){
            area += sides[1];
        } else {
            area += sides[2];
        }

        area += 2*(sides[0]+sides[1]+sides[2]);

        return area;
    }

    static int ribbonLength (int[] dimensions) {
        int length = 0;
        length += dimensions[0]*dimensions[1]*dimensions[2];
        if (dimensions[0] <= dimensions[1]) {
            if (dimensions[0] <= dimensions[2]) {
                if (dimensions[1] <= dimensions[2]) {
                    length += 2*(dimensions[0]+dimensions[1]);
                } else {
                    length += 2*(dimensions[0]+dimensions[2]);
                }
            } else {
                length += 2*(dimensions[0]+dimensions[2]);
            }
        } else if (dimensions[0] <= dimensions[2]) {
            length += 2*(dimensions[0]+dimensions[1]);
        } else {
            length += 2*(dimensions[1]+dimensions[2]);
        }
        return length;
    }


    static public void main(String[] args) {
        int full_area = 0;
        int full_ribbon_length = 0;

        String Code = "";
        try {
            File myFile = new File("res/code.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                int[] temp = getDimensions(data);
                System.out.println(Arrays.toString(temp));
                full_area += wrapperArea(temp);
                full_ribbon_length += ribbonLength(temp);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println(Code);

        System.out.println("\nFinal answer :" + full_area + " " + full_ribbon_length);
    }
}

