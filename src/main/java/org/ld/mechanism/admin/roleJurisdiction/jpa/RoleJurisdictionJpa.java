package org.ld.mechanism.admin.roleJurisdiction.jpa;

import org.ld.mechanism.admin.roleJurisdiction.model.RoleJurisdictionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface RoleJurisdictionJpa extends JpaRepository<RoleJurisdictionModel, String>,
        JpaSpecificationExecutor<RoleJurisdictionModel> {

    List<RoleJurisdictionModel> findByRole(String role);

    List<RoleJurisdictionModel> findByJurisdiction(String jurisdiction);

    void deleteByJurisdiction(String jurisdiction);

    void deleteByRole(String role);
}
