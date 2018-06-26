package org.ld.mechanism.admin.role.controller;

import org.ld.mechanism.admin.role.model.RoleModel;
import org.ld.mechanism.admin.role.service.RoleService;
import org.ld.mechanism.util.responseResult.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Value("${page.pageSize}")
    private int pageSize;

    @Autowired
    private RoleService service;

    //    @RequiresRoles(value = "admin")
//    @RequiresPermissions(value = {"role:page"})
    @RequestMapping(value = "/role/{pageNow}", method = RequestMethod.GET)
    public ResponseResult<Page<RoleModel>> page(@PathVariable("pageNow") int pageNow) {
        return service.page(pageNow, pageSize, null);
    }

    //    @RequiresRoles(value = "admin")
//    @RequiresPermissions(value = {"role:save"})
    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public ResponseResult<RoleModel> save(@Valid @ModelAttribute("form") RoleModel model) {
        return service.save(model);
    }

    //    @RequiresRoles(value = "admin")
//    @RequiresPermissions(value = {"role:delete:id"})
    @RequestMapping(value = "/role/{uuid}", method = RequestMethod.DELETE)
    public ResponseResult<RoleModel> deleteById(@PathVariable("uuid") String uuid) {
        return service.delete(uuid);
    }

    //    @RequiresRoles(value = "admin")
//    @RequiresPermissions(value = {"role:find:id"})
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public ResponseResult<RoleModel> findById(@RequestParam("uuid") String uuid) {
        return service.findByUuid(uuid);
    }

    //    @RequiresRoles(value = "admin")
//    @RequiresPermissions(value = {"role:update"})
    @RequestMapping(value = "/role", method = RequestMethod.PUT)
    public ResponseResult<RoleModel> update(@Valid @ModelAttribute("form") RoleModel model) {
        return service.update(model);
    }
}
