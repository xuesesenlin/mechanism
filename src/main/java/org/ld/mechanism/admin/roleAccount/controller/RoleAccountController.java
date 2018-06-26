package org.ld.mechanism.admin.roleAccount.controller;

import org.ld.mechanism.admin.roleAccount.model.RoleAccountModel;
import org.ld.mechanism.admin.roleAccount.service.RoleAccountService;
import org.ld.mechanism.util.responseResult.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@RestController
@RequestMapping("/roleAccount")
public class RoleAccountController {

    @Value("${page.pageSize}")
    private int pageSize;

    @Autowired
    private RoleAccountService service;

    //    @RequiresRoles(value = "admin")
//    @RequiresPermissions(value = {"roleAccount:save"})
    @RequestMapping(value = "/roleAccount", method = RequestMethod.POST)
    public ResponseResult<RoleAccountModel> save(@Valid @ModelAttribute("form") RoleAccountModel model) {
        return service.save(model);
    }

    //    @RequiresRoles(value = "admin")
//    @RequiresPermissions(value = {"roleAccount:delete:id"})
    @RequestMapping(value = "/roleAccount/{uuid}", method = RequestMethod.DELETE)
    public ResponseResult<RoleAccountModel> deleteById(@PathVariable("uuid") String uuid) {
        return service.delete(uuid);
    }

    //    @RequiresRoles(value = "admin")
//    @RequiresPermissions(value = {"roleAccount:find:account"})
    @RequestMapping(value = "/roleAccount/account", method = RequestMethod.GET)
    public ResponseResult<List<RoleAccountModel>> findByAccount(@RequestParam("account") String account) {
        return service.findByAccount(account);
    }

    //    @RequiresRoles(value = "admin")
//    @RequiresPermissions(value = {"roleAccount:find:role"})
    @RequestMapping(value = "/roleAccount/role", method = RequestMethod.GET)
    public ResponseResult<List<RoleAccountModel>> findByRole(@RequestParam("role") String role) {
        return service.findByRole(role);
    }

    //    @RequiresRoles(value = "admin")
//    @RequiresPermissions(value = {"roleAccount:update"})
    @RequestMapping(value = "/roleAccount", method = RequestMethod.PUT)
    public ResponseResult<RoleAccountModel> update(@Valid @ModelAttribute("form") RoleAccountModel model) {
        return service.update(model);
    }
}
