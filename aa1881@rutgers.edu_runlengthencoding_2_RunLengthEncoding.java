/*************************************************************************
 *  Compilation:  javac RunLengthEncoding.java
 *  Execution:    java RunLengthEncoding
 *
 *  @author:Aswathy Aji, aa1881@scarletmail.rutgers.edu, aa1881
 *
 *************************************************************************/

public class RunLengthEncoding {

    /* 
     * Encode the original string by finding sequences in the string
     * where the same character repeats. Replace each such sequence
     * by a token consisting of: the number of characters in the sequence
     * followed by the repeating character.
     * Return the encoded string.
     */
    public static String encode (String original)  {

	// WRITE YOUR CODE HERE
        if (original == null || original.isEmpty())
        return "";

        StringBuilder builder = new StringBuilder();
        char[] chars = original.toCharArray();
        char current = chars[0];
        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            if (current == chars[i]) {
                count++;
            } 
            else {
                if (count > 1)
                    builder.append(count);
                builder.append(current);
                current = chars[i];
                count = 1;
                
            }
        }
        if (count > 1)
        builder.append(count);
            
        builder.append(current);
        return builder.toString();
    }

    /*
     * Decodes the original string encoded with the encode method.
     * Returns the decoded string.
     *
     * YOUR decode METHOD MUST BE RECURSIVE, do not use while, do/while, 
     * or for loops
     */
    public static String decode (String original)  {
	
	// WRITE YOUR RECURSIVE CODE HERE
        if (original == null || original.isEmpty())
        return "";

        StringBuilder builder = new StringBuilder();
        char[] chars = original.toCharArray();
        boolean preIsDigit = false;
        String digitString = "";
    for (char current : chars) {
        if (!Character.isDigit(current)) {
            if (preIsDigit) {
            String multipleString = new String(new char[Integer.valueOf(digitString)]).replace("\0",
            current + "");
            builder.append(multipleString);
            preIsDigit = false;
            digitString = "";
            } 
            else {
            builder.append(current);
            }
        } 
        else {
            digitString += current;
            preIsDigit = true;
        }
    }
        return builder.toString();

    }

    public static void main (String[] args) {

	// WRITE YOUR TEST CASES HERE to test your methods
        System.out.println((RunLengthEncoding.encode("qwwwwwwwwweeeeerrtyyyyyqqqqwEErTTT")));

    }
}
