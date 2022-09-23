import java.util.Scanner;

public class Cipher {

    public static int getNumber(char letter) {
        return letter - 'A';
    }

    public static int getLetter(int num) {
        return 'A' + num;
    }

    public static String encrpyt(String plain, String key) {
        String cipher = "";
        int keyLength = key.length();
        int j = 0;

        for (int i = 0; i < plain.length(); i++) {
            int let = (getNumber(plain.charAt(i)) + getNumber(key.charAt(j))) % 26;
            cipher += (char) getLetter(let);
            if (j < keyLength - 1) {
                j++;
            } else {
                j = 0;
            }
        }
        return cipher;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text, key;

        if (args.length != 0) {
           key = args[0];
           text = args[1];
           for (int i = 2; i < args.length; i++) {
                text += " " + args[i];
           }
        } else {
            System.out.println("Enter Plain Text: ");
            text = scan.nextLine();

            System.out.println("Enter Key:");
            key = scan.nextLine();
        }

        String[] words = text.split(" ");
        String sentence = "";
        for (String e : words) {
            sentence += encrpyt(e, key) + " ";
        }

        System.out.println("Encrypted: " + sentence);

        scan.close();
    }
}