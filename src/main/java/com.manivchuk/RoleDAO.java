package com.manivchuk;

import java.util.List;

/**
 * Created by nec on 15.12.17.
 */
public interface RoleDAO {
    Role findRoleById(Integer id);
    List<Role> findAllRoles();
}
