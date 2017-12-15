package com.manivchuk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by nec on 15.12.17.
 */
public abstract class DAOFactory {
    private static DAOFactory instance = null;

    public static synchronized DAOFactory getInstance(){
        if(instance == null){
            try{
                Class.forName(Constance.DRIVER_CLASS_NAME);
                Class clazz = Class.forName(Constance.DAO_FACTORY_CLASS_NAME);
                instance = (DAOFactory) clazz.newInstance();

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public abstract RoleDAO getRoleDAO();

    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(Constance.DB_URL, Constance.LOGIN, Constance.PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
