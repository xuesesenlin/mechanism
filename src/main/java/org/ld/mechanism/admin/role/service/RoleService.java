package org.ld.mechanism.admin.role.service;

import org.ld.mechanism.admin.role.model.RoleModel;
import org.ld.mechanism.util.responseResult.ResponseResult;
import org.springframework.data.domain.Page;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface RoleService {

    ResponseResult<RoleModel> save(RoleModel model);

    ResponseResult<RoleModel> delete(String uuid);

    ResponseResult<RoleModel> update(RoleModel model);

    ResponseResult<RoleModel> findByUuid(String uuid);

    ResponseResult<Page<RoleModel>> page(int pageNow, int pageSize, RoleModel model);
}
