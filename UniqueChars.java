/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        String new_string = "";
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' '){
                new_string += s.charAt(i);
            } else {
                if (new_string.indexOf(s.charAt(i)) == -1){
                    new_string += s.charAt(i);
                }
            }

        }

        return new_string;
    }
}
