/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {

        // init the string that given from the user
        String str = args[0];

        // call the function and return the given answer
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {

        // init the variable that holds the new string
        String new_string = "";

        // for each char of the string do the loop
        for (int i = 0; i < s.length(); i++) {


            // check if the current letter is space
            if (s.charAt(i) == ' '){
                new_string += s.charAt(i);
            } else {

                // add the current char if it is not already in the new string
                if (new_string.indexOf(s.charAt(i)) == -1){
                    new_string += s.charAt(i);
                }
            }

        }

        // return the final string
        return new_string;
    }
}
