package org.ld.mechanism.admin.jurisdiction.service;

import org.ld.bt2.jurisdiction.jurisdiction.model.JurisdictionModel;
import org.ld.mechanism.util.responseResult.ResponseResult;
import org.springframework.data.domain.Page;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public interface JurisdictionService {

    ResponseResult<JurisdictionModel> save(JurisdictionModel model);

    ResponseResult<JurisdictionModel> delete(String uuid);

    ResponseResult<JurisdictionModel> update(JurisdictionModel model);

    ResponseResult<JurisdictionModel> findByUuid(String uuid);

    ResponseResult<Page<JurisdictionModel>> page(int pageNow, int pageSize, JurisdictionModel model);

}
