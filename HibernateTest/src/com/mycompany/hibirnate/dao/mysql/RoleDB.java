package com.mycompany.hibirnate.dao.mysql;

import com.mycompany.hibirnate.dao.interfaces.AbstractObjectDao;


public class RoleDB <Role,String> extends AbstractObjectDao<Role, String>{

    public RoleDB() {
        super("Role");
    }

}
