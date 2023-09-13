import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        final String key = "yzbqklnj";
        int number = 0;
        String hash = "11111111111111111111111111111111";
        String testHash = hash.substring(0, 6);
        MessageDigest MD5Instance = MessageDigest.getInstance("MD5");

        while (!testHash.equals("000000")) {
            number++;
            hash = Hex.encodeHexString(MD5Instance.digest((key + number).getBytes()));
            testHash = hash.substring(0, 6);
        }
        System.out.println(key + number + " : " + hash + " testHash : " + testHash);
        System.out.println(number);
    }
}