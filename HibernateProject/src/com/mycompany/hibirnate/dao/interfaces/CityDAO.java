/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibirnate.dao.interfaces;
import com.mycompany.hibirnate.model.City;

/**
 *
 * @author WSR
 */
public interface CityDAO extends ObjectDAO<City, Integer>{
    City getCityByName(String name);
}
