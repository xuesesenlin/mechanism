package org.ld.mechanism.admin.account.jpa;

import org.ld.mechanism.admin.account.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface AccountJpa extends JpaRepository<AccountModel, String>, JpaSpecificationExecutor<AccountModel> {

    List<AccountModel> findByAccount(String account);
}
