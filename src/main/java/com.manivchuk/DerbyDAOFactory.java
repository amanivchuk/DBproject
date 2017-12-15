package com.manivchuk;

/**
 * Created by nec on 15.12.17.
 */
public class DerbyDAOFactory extends DAOFactory {
    public RoleDAO getRoleDAO() {
        return new DerbyRoleDAO();
    }
}
