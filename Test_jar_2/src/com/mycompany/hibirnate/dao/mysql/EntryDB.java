/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibirnate.dao.mysql;

import com.mycompany.hibirnate.dao.interfaces.AbstractObjectDao;
import com.mycompany.hibirnate.model.Entry;

/**
 *
 * @author WSR
 */
public class EntryDB extends AbstractObjectDao<Entry, Integer>{

    public EntryDB() {
        super("Entry");
    }
    
    
    
}
