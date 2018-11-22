package com.mycompany.hibirnate.servise;

import com.mycompany.hibirnate.dao.interfaces.RealtyDAO;
import com.mycompany.hibirnate.dao.mysql.RealtyDB;
import com.mycompany.hibirnate.model.City;
import com.mycompany.hibirnate.model.Realty;
import java.util.List;

public class RealtorService {

    private RealtyDAO realtyDAO = RealtyDB.getInstance();
    private static List<Realty> allRealtys;

    public RealtorService() {
    }

    public List<Realty> getRealtyByType(String type) {
        List<Realty> realtys = realtyDAO.getRealtyByTypeRealty(type);
        return realtys;
    }

    public List<Realty> getAllRealty() {
        if (allRealtys == null) {
            allRealtys = realtyDAO.getAllObject();
        }
        return allRealtys;
    }

}
