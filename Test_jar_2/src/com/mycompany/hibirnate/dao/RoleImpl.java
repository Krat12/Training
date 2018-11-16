package com.mycompany.hibirnate.dao;

import com.mycompany.hibirnate.dao.interfaces.AbstractObjectDao;


public class RoleImpl <Role,String> extends AbstractObjectDao<Role, String>{

    public RoleImpl() {
        super("Role");
    }

}
