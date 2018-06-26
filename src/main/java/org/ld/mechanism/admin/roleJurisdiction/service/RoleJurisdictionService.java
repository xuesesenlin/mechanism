package org.ld.mechanism.admin.roleJurisdiction.service;

import org.ld.mechanism.admin.roleJurisdiction.model.RoleJurisdictionModel;
import org.ld.mechanism.util.responseResult.ResponseResult;

import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface RoleJurisdictionService {

    ResponseResult<RoleJurisdictionModel> save(RoleJurisdictionModel model);

    ResponseResult<RoleJurisdictionModel> delete(String uuid);

    ResponseResult<RoleJurisdictionModel> update(RoleJurisdictionModel model);

    ResponseResult<List<RoleJurisdictionModel>> findByRole(String role);

    ResponseResult<List<RoleJurisdictionModel>> findByJurisdiction(String jurisdiction);

    ResponseResult<RoleJurisdictionModel> deleteByJurisdiction(String jurisdiction);

    ResponseResult<RoleJurisdictionModel> deleteByRole(String role);

}
