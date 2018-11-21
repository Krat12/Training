package com.mycompany.hibirnate.servise;

import com.mycompany.hibirnate.dao.interfaces.RealtyDAO;
import com.mycompany.hibirnate.dao.mysql.RealtyDB;
import com.mycompany.hibirnate.model.City;
import com.mycompany.hibirnate.model.Realty;
import java.util.List;


public class RealtorService {
    
    private RealtyDAO realtyDAO = RealtyDB.getInstance();

    public RealtorService() {
    }
    
    public List<Realty> getRealtyByTypeAndCity(String type,City city){
         List<Realty> realtys = realtyDAO.getRealtyByTypeAndCity(type, city);
        return realtys;
    }
    
    public List<Realty>getAllRealty(){
         List<Realty> allRealtys = realtyDAO.getAllObject();
         return allRealtys;
    }

}
