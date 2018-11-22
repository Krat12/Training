package com.mycompany.hibirnate.filters;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class LengFilter extends DocumentFilter {

    private int currentLength = 0;
    private int maxLength;

    public LengFilter(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attr) throws BadLocationException {

        if ((currentLength - length + string.length()) <= maxLength) {
            currentLength += string.length() - length;
            fb.replace(offset, length, string, attr);
        }

    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {

        if ((currentLength + string.length()) <= maxLength) {
            currentLength += string.length();
            fb.insertString(offset, string, attr);
        }
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        currentLength -= length;
        fb.remove(offset, length);
    }

}
