package com.mycompany.hibirnate.servise;

import com.mycompany.hibirnate.dao.interfaces.ObjectDAO;
import com.mycompany.hibirnate.dao.interfaces.RealtyDAO;
import com.mycompany.hibirnate.dao.mysql.EntryDB;
import com.mycompany.hibirnate.dao.mysql.RealtyDB;
import com.mycompany.hibirnate.model.Entry;
import com.mycompany.hibirnate.model.Realty;
import java.util.List;

public class RealtorService {

    private RealtyDAO realtyDAO = RealtyDB.getInstance();
    private ObjectDAO EntryDAO = EntryDB.getInstance();
    private static List<Realty> allRealtys;

    public RealtorService() {
    }

    public List<Realty> getRealtyByType(String type,String cityName) {
        List<Realty> realtys = realtyDAO.getRealtyByTypeRealty(type,cityName);
        return realtys;
    }

    public List<Realty> getAllRealty() {
        if (allRealtys == null) {
            allRealtys = realtyDAO.getAllObject();
        }
        return allRealtys;
    }
    public Entry getEntryById(Integer id){
        return (Entry) EntryDAO.getObjectByID(id, Entry.class);
    }

}
