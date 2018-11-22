package com.mycompany.hibirnate.filters;

import com.mycompany.hibirnate.gui.user.RealtySell;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class PhoneFilter extends DocumentFilter {

    private static final String DIGITS = "\\d+";
    private static final int FIRST_DELIMITER = 3;
    private static final int SECOND_DELIMITER = 7;
    private static final int THIRD_DELIMITER = 10;
    private static final String SIGN_DELIMITER = "-";
    private int currentLength = 0;
    private int maxLength;
    private String lastCharset;
    

    public PhoneFilter(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        currentLength -= length;
        fb.remove(offset, length);
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string.matches(DIGITS)) {
            if ((currentLength + string.length()) <= maxLength) {
                currentLength += string.length();
                fb.insertString(offset, string, attr);
            }
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attr) throws BadLocationException {
      
        if (string.matches(DIGITS)) {
            if ((currentLength - length + string.length()) <= maxLength) {
                
                lastCharset = string.substring(string.length() - 1);

                if (!lastCharset.equals(SIGN_DELIMITER) && offset == FIRST_DELIMITER || offset == SECOND_DELIMITER || offset == THIRD_DELIMITER) {
                    string = string + SIGN_DELIMITER;
                    string = swap(string);
                }
                
                currentLength += string.length() - length;
                fb.replace(offset, length, string, attr);
            }
        }
    }

    private String swap(String string) {
        char[] charset = string.toCharArray();

        char tmp = charset[0];
        charset[0] = SIGN_DELIMITER.charAt(0);
        charset[1] = tmp;

        String newString = new String(charset);
        return newString;
    }
}
