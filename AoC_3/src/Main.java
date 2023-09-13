import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.*;

class Pair {
    int x;
    int y;
    public Pair (int nx, int ny) {
        x = nx;
        y = ny;
    }
    public Pair (Pair pair) {
        x = pair.x;
        y = pair.y;
    }
    public Pair (int[] pos) {
        x = pos[0];
        y = pos[1];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair intPair = (Pair) o;
        return x == intPair.x && y == intPair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class Main {
    public static void main(String[] args) {
        Map<Pair, Boolean> map = new Hashtable<Pair, Boolean>();
        String input = "";
        Pair posSanta = new Pair(0,0);
        Pair posRoboSanta = new Pair(0,0);
        int delivered = 0;
        int already_passed = 0;
        boolean roboSantaMode = true;

        try {
            File inputFile = new File("res/input.txt");
            Scanner myReader = new Scanner(inputFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                input += data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        if (roboSantaMode) {
            boolean alternator = true;
            for (char i : input.toCharArray()) {
                if (i == '^') {
                    if (alternator) {
                        posSanta.y += 1;
                        if (null == map.put(new Pair(posSanta), true)) {
                            delivered += 1;
                        } else {
                            already_passed += 1;
                        }
                        alternator = !alternator;
                    } else {
                        posRoboSanta.y += 1;
                        if (null == map.put(new Pair(posRoboSanta), true)) {
                            delivered += 1;
                        } else {
                            already_passed += 1;
                        }
                        alternator = !alternator;
                    }
                } else if (i == 'v') {
                    if (alternator) {
                        posSanta.y -= 1;
                        if (null == map.put(new Pair(posSanta), true)) {
                            delivered += 1;
                        } else {
                            already_passed += 1;
                        }
                        alternator = !alternator;
                    } else {
                        posRoboSanta.y -= 1;
                        if (null == map.put(new Pair(posRoboSanta), true)) {
                            delivered += 1;
                        } else {
                            already_passed += 1;
                        }
                        alternator = !alternator;
                    }
                } else if (i == '>') {
                    if (alternator) {
                        posSanta.x += 1;
                        if (null == map.put(new Pair(posSanta), true)) {
                            delivered += 1;
                        } else {
                            already_passed += 1;
                        }
                        alternator = !alternator;
                    } else {
                        posRoboSanta.x += 1;
                        if (null == map.put(new Pair(posRoboSanta), true)) {
                            delivered += 1;
                        } else {
                            already_passed += 1;
                        }
                        alternator = !alternator;
                    }
                } else {
                    if (alternator) {
                        posSanta.x -= 1;
                        if (null == map.put(new Pair(posSanta), true)) {
                            delivered += 1;
                        } else {
                            already_passed += 1;
                        }
                        alternator = !alternator;
                    } else {
                        posRoboSanta.x -= 1;
                        if (null == map.put(new Pair(posRoboSanta), true)) {
                            delivered += 1;
                        } else {
                            already_passed += 1;
                        }
                        alternator = !alternator;
                    }
                }
            }
        } else {
            for (char i : input.toCharArray()) {
                if (i == '^') {

                    posSanta.y += 1;
                    if (null == map.put(new Pair(posSanta), true)) {
                        delivered += 1;
                    } else {
                        already_passed += 1;
                    }
                } else if (i == 'v') {

                    posSanta.y -= 1;
                    if (null == map.put(new Pair(posSanta), true)) {
                        delivered += 1;
                    } else {
                        already_passed += 1;
                    }
                } else if (i == '>') {

                    posSanta.x += 1;
                    if (null == map.put(new Pair(posSanta), true)) {
                        delivered += 1;
                    } else {
                        already_passed += 1;
                    }
                } else {

                    posSanta.x -= 1;
                    if (null == map.put(new Pair(posSanta), true)) {
                        delivered += 1;
                    } else {
                        already_passed += 1;
                    }
                }
            }
        }

        System.out.println(delivered);
        System.out.println(already_passed);

    }
}
