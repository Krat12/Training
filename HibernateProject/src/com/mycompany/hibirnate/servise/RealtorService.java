package com.mycompany.hibirnate.servise;

import com.mycompany.hibirnate.dao.interfaces.AbstractObjectDao;
import com.mycompany.hibirnate.dao.interfaces.ObjectDAO;
import com.mycompany.hibirnate.dao.interfaces.RealtyDAO;
import com.mycompany.hibirnate.dao.mysql.EntryDB;
import com.mycompany.hibirnate.dao.mysql.RealtyDB;
import com.mycompany.hibirnate.model.City;
import com.mycompany.hibirnate.model.Entry;
import com.mycompany.hibirnate.model.Realty;
import com.mycompany.hibirnate.utill.HibernateSessionFactoryUtill;
import java.util.List;

public class RealtorService {

    private RealtyDAO realtyDAO = RealtyDB.getInstance();
    private ObjectDAO entryDAO = EntryDB.getInstance();
    private static List<Entry> allEntry;

    public RealtorService() {
    }

    public List<Realty> getRealtyByType(String type, String cityName) {
        List<Realty> realtys = realtyDAO.getRealtyByTypeRealty(type, cityName);
        return realtys;
    }

    public List<Entry> getAllEntry() {
        if (allEntry == null) {
            allEntry = entryDAO.getAllObject();
        }
        return allEntry;
    }
    
    public Entry getEntryById(int id) {
        return (Entry) entryDAO.getObjectByID(id, Entry.class);
    }
}
