/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibirnate.dao.interfaces;

import com.mycompany.hibirnate.model.City;
import com.mycompany.hibirnate.model.Realty;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface RealtyDAO extends ObjectDAO<Realty, Integer>{
    
    List<Realty> getRealtyByTypeRealty(String type);
    
}
