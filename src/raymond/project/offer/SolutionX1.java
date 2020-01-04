package raymond.project.offer;

import java.util.*;

public class SolutionX1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine();
            char[] chr = str.toCharArray();
            List<Character> list = new LinkedList();
            for(Character ch : chr){
                if(Character.isLetter(ch))
                    list.add(ch);
            }

            Collections.sort(list, new Comparator<Character>(){
                public int compare(Character c1, Character c2){
                    return Character.toLowerCase(c1) - Character.toLowerCase(c2);
                }
            });
            int cnt = 0;
            for(int i = 0; i < chr.length; i++){
                if(Character.isLetter(chr[i])){
                    chr[i] = list.get(cnt);
                    cnt++;
                }
            }

            System.out.println(chr);
        }
    }
}