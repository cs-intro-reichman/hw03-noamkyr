/** String processing exercise 1. */
public class lowerCase {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(lowerCase(str));
    }

   /**
    * Returns a string which is identical to the original string, 
    * except that all the upper-case letters are converted to lower-case letters.
    * Non-letter characters are left as is.
    */
    public static String lowerCase(String s) {
        // Replace the following statement with your code
        String lower_string  = "";

        for (int i = 0; i < s.length(); i++) {
            char new_lower = (char) (s.charAt(i));
            if (new_lower >= 'A' && new_lower <= 'Z'){
               new_lower = (char) (s.charAt(i) + 32);
            }
            lower_string += new_lower;
        }

        return lower_string;
    }
}
