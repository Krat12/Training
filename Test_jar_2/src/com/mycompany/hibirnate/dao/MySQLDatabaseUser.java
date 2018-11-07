package com.mycompany.hibirnate.dao;

public class MySQLDatabaseUser<User, String> extends AbstractObjectDao<User, String> {


    public MySQLDatabaseUser() {
        super("User");
    }

    @Override
    public boolean update(User model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(User model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
