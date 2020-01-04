package raymond.project.leetcode;

public class S125 {
    public boolean isPalindrome(String s) {
        if(s == null) {
            return false;
        }
        if(s.equals("") || s.equals(" ")) {
            return true;
        }

        int length = s.length();
        int i = 0, j = length - 1;
        while(i < j) {
            while(i < j && !isAlpha(s.charAt(i))) {
                i++;
            }
            while(i < j && !isAlpha(s.charAt(j))) {
                j--;
            }
            if(!isEqual(s.charAt(i), s.charAt(j))) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    private boolean isEqual(char a, char b) {
        int distance = 'A'-'a';
        if(Character.isLetter(a) && Character.isLetter(b)) {
            return a == b || a-b ==distance || b-a == distance;
        } else {
            return a == b;
        }

    }

    private boolean isAlpha(char c) {
        if(c >= 'a' && c <= 'z') {
            return true;
        }
        if(c >= 'A' && c <= 'Z') {
            return true;
        }
        if(c >= '0' && c <= '9' ) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "0P";
        S125 s = new S125();
        s.isPalindrome(str);
    }
}
