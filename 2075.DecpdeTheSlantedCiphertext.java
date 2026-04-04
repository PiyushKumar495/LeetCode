public class Solution {

    private static final String NO_TEXT = "";

    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) {
            return encodedText;
        }
        if (encodedText.isEmpty()) {
            return NO_TEXT;
        }

        int lastNonSpaceIndexInOriginalText = 0;
        int columns = encodedText.length() / rows;
        StringBuilder originalText = new StringBuilder();

        for (int column = 0; column < columns; ++column) {
            int index = column;

            while (index < encodedText.length()) {
                if (encodedText.charAt(index) != ' ') {
                    lastNonSpaceIndexInOriginalText = originalText.length();
                }
                originalText.append(encodedText.charAt(index));
                index += columns + 1;
            }
        }

        return originalText.toString().substring(0, lastNonSpaceIndexInOriginalText + 1);
    }
}