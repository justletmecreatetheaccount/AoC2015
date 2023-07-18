import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner Input = new Scanner(System.in);
        int floor = 0;
        boolean found = false;
        System.out.println("Please intput code to be translated");

        String TbT_code = Input.nextLine();
        for (int i = 0; i < TbT_code.length(); i++) {
            switch (TbT_code.charAt(i)) {
                case '(' :
                    floor++;
                    break;
                case ')' :
                    floor--;
                    break;
            }
            if (floor == -1 && !found) {
                int temp = i + 1;
                System.out.println("First = " + temp);
                found = true;
            }
        }
        System.out.println("Iterations : " + TbT_code.length());
        System.out.println("Floor : " + floor);
    }
}
