/** String processing exercise 1. */
public class LowerCase {
    public static void main(String[] args) {  

        // init the stirng that given from the user
        String str = args[0];

        // call the function and return the given answer
        System.out.println(lowerCase(str));
    }

   /**
    * Returns a string which is identical to the original string, 
    * except that all the upper-case letters are converted to lower-case letters.
    * Non-letter characters are left as is.
    */
    public static String lowerCase(String s) {

        // init variable that holds the new string
        String lower_string  = "";

        // for each char at the string convert every capital letter to small letter
        for (int i = 0; i < s.length(); i++) {

            // get the current i char
            char new_lower = (char) (s.charAt(i));

            // convert to small letter if the letter is capital
            if (new_lower >= 'A' && new_lower <= 'Z'){
               new_lower = (char) (s.charAt(i) + 32);
            }

            // add to the new string the current char
            lower_string += new_lower;
        }

        // return the final string
        return lower_string;
    }
}
