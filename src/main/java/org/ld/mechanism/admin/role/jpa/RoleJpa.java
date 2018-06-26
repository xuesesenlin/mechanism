package org.ld.mechanism.admin.role.jpa;

import org.ld.mechanism.admin.role.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface RoleJpa extends JpaRepository<RoleModel, String>,
        JpaSpecificationExecutor<RoleModel> {

    List<RoleModel> findByName(String name);

}
