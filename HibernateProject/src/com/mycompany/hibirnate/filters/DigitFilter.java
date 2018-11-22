package com.mycompany.hibirnate.filters;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class DigitFilter extends DocumentFilter {

    private static final String DIGITS = "\\d+";
    private int currentLength = 0;
    private int maxLength;

    public DigitFilter(int maxLength) {
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

                currentLength += string.length() - length;
                fb.replace(offset, length, string, attr);
            }
        }
    }
}
