package com.mycompany.hibirnate.utill;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;


public class DigitFilter  extends DocumentFilter{
    
    private static final String DIGITS = "\\d";

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string.matches(DIGITS)){
        super.insertString(fb, offset, string, attr); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
         if (text.matches(DIGITS)){
        super.replace(fb, offset, length, text, attrs); //To change body of generated methods, choose Tools | Templates.
         }
    }
    
    

}
