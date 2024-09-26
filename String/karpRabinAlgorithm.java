public class karpRabinAlgorithm {
    private static int PRIME = 101;
    public static void main(String[] args) {
        String s = "Vij";
        long oldHash = calculateHash(s);
        long updatedHash = updateHash('V', 'a', oldHash, s.length());
        search("ja", "Vijay");
    }
    public static long calculateHash(String s) {
        long hash = 0;
        for(int i = 0; i < s.length(); i++) {
            hash = (long) (hash + s.charAt(i)*Math.pow(PRIME, i));
        }
        return hash;
    }
    public static long updateHash(char oldChar, char newChar, long oldHash, int patternLength) {
        long newHash = (oldHash - oldChar)/PRIME;
        newHash = (long) (newHash + newChar*Math.pow(PRIME, patternLength - 1));
        return newHash;
    }
    public static void search(String pattern, String text) {
        int patternLength = pattern.length();
        long patternHash = calculateHash(pattern);
        long textHash = calculateHash(text.substring(0, patternLength));

        for(int i = 0; i <= text.length() - patternLength; i++) {

            if(textHash == patternHash) {
                if(text.substring(i, i + patternLength).equals(pattern)) {
                    System.out.println("Pattern found at " + i);
                }
            }

            if(i < text.length() - patternLength) {
                char oldChar = text.charAt(i), newChar = text.charAt(i+patternLength);
                textHash = updateHash(oldChar, newChar, textHash, patternLength);
            }
        }
    }
}
