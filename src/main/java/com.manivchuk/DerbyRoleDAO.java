package com.manivchuk;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nec on 15.12.17.
 */
public class DerbyRoleDAO implements RoleDAO {
    private static final String SQL_SELECT_FROM_ROLE_BY_ID = "select * from roles where id = ?";
    private static final String SQL_SELECT_FROM_ROLE = "select * from roles";

    public Role findRoleById(Integer id) {
        Connection connection = null;
        Role role = null;

        connection = DAOFactory.getConnection();
        try {
            PreparedStatement pstm = connection.prepareStatement(SQL_SELECT_FROM_ROLE_BY_ID);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                role = extractorRole(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return role;
    }

    public List<Role> findAllRoles() {
        List<Role> roleList = new ArrayList<Role>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        connection = DAOFactory.getConnection();
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(SQL_SELECT_FROM_ROLE);
            while (rs.next()){
                roleList.add(extractorRole(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleList;
    }

    private Role extractorRole(ResultSet rs) throws SQLException {
        Role role = new Role();
        role.setId(rs.getInt("id"));
        role.setName(rs.getString("name"));
        return role;
    }
}
