package raymond.project.offer;

import java.util.*;

public class SolutionX {

    static String dict1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    static String dict2 = "bcdefghijklmnopqrstuvwxyza222333444555666777788899990123456789";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Map<Character, Character> m = new HashMap<>();
        for(int i = 0;i < dict1.length(); ++i) {
            m.put(dict1.toCharArray()[i], dict2.toCharArray()[i]);
        }

        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0;i < str.length(); ++i) {
            stringBuffer.append(m.get(str.toCharArray()[i]));
        }

        System.out.print(stringBuffer.toString());
    }
}