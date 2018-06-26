package org.ld.mechanism.admin.roleAccount.service;

import org.ld.mechanism.admin.roleAccount.model.RoleAccountModel;
import org.ld.mechanism.util.responseResult.ResponseResult;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface RoleAccountService {

    ResponseResult<RoleAccountModel> save(RoleAccountModel model);

    ResponseResult<RoleAccountModel> delete(String uuid);

    ResponseResult<RoleAccountModel> update(RoleAccountModel model);

    ResponseResult<List<RoleAccountModel>> findByAccount(String account);

    ResponseResult<List<RoleAccountModel>> findByRole(String account);

    ResponseResult<RoleAccountModel> deleteByAccount(String account);

    ResponseResult<RoleAccountModel> deleteByRole(String role);

}
