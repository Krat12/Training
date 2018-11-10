/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparabletest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ComparableMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Country indiaCountry = new Country(1, "India");
        Country russiaCountry = new Country(4, "Russia");
        Country englandCountry = new Country(3, "England");
        Country germanyCountry = new Country(2, "Germany");

        List listOfCountries = new ArrayList();
        listOfCountries.add(indiaCountry);
        listOfCountries.add(russiaCountry);
        listOfCountries.add(englandCountry);
        listOfCountries.add(germanyCountry);

        System.out.println("Before Sort  : ");
        for (int i = 0; i < listOfCountries.size(); i++) {
            Country country = (Country) listOfCountries.get(i);
            System.out.println("Country Id: " + country.getId() + "||" + "Country name: " + country.getName());
        }

        Collections.sort(listOfCountries);

        System.out.println("After Sort  : ");
        for (int i = 0; i < listOfCountries.size(); i++) {
            Country country = (Country) listOfCountries.get(i);
            System.out.println("Country Id: " + country.getId() + "|| " + "Country name: " + country.getName());
        }
    }

}
