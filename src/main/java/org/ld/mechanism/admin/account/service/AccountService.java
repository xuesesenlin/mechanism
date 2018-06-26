package org.ld.mechanism.admin.account.service;

import org.ld.mechanism.admin.account.model.AccountModel;
import org.ld.mechanism.util.responseResult.ResponseResult;
import org.springframework.data.domain.Page;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface AccountService {

    ResponseResult<AccountModel> save(AccountModel model);

    ResponseResult<AccountModel> delete(String uuid);

    ResponseResult<AccountModel> update(AccountModel model);

    ResponseResult<AccountModel> findByAccount(String account);

    ResponseResult<Page<AccountModel>> page(int pageNow, int pageSize, AccountModel model);
}
