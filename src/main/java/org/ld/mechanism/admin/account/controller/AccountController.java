package org.ld.mechanism.admin.account.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.ld.mechanism.admin.account.model.AccountModel;
import org.ld.mechanism.admin.account.service.AccountService;
import org.ld.mechanism.util.responseResult.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {

    @Value("${page.pageSize}")
    private int pageSize;

    @Autowired
    private AccountService service;

    //    @RequiresAuthentication
//    @RequiresPermissions(value = {"account:page"}, logical = Logical.AND)
    @RequestMapping(value = "/account/{pageNow}", method = RequestMethod.GET)
    public ResponseResult<Page<AccountModel>> page(@PathVariable("pageNow") int pageNow,
                                                   @RequestParam(value = "account", required = false) String account) {
        AccountModel model = new AccountModel();
        model.setAccount(account);
//        此处非必须model，也可以单独条件写，此处为了演示model的写法所以用的model
        return service.page(pageNow, pageSize, model);
    }

    @RequestMapping(value = "/account/account", method = RequestMethod.GET)
    public ResponseResult<AccountModel> findByAccount(@RequestParam(value = "account") String account) {
        return service.findByAccount(account);
    }

    @RequiresAuthentication
    @RequiresPermissions(value = {"account:save"}, logical = Logical.AND)
    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public ResponseResult<AccountModel> save(@Valid @ModelAttribute("form") AccountModel model,
                                             BindingResult result) {
        if (result.hasErrors())
            return new ResponseResult<>(false, result.getFieldError().getDefaultMessage(), null);
        return service.save(model);
    }

    @RequiresAuthentication
    @RequiresPermissions(value = {"account:delete"}, logical = Logical.AND)
    @RequestMapping(value = "/account/{uuid}", method = RequestMethod.DELETE)
    public ResponseResult<AccountModel> delete(@PathVariable("uuid") String uuid) {
        return service.delete(uuid);
    }

    //    此方法需调整，验证等其它
    @RequestMapping(value = "/account/{account}", method = RequestMethod.PUT)
    public ResponseResult<AccountModel> updatePWD(@PathVariable("account") String account,
                                                  @RequestParam("password") String password,
                                                  @RequestParam("password2") String password2) {
        if (password.equals(password2) && !password.isEmpty()) {
            AccountModel model = new AccountModel();
            model.setAccount(account);
            model.setPassword(password);
            return service.update(model);
        } else {
            return new ResponseResult<>(false, "两次输入的密码不一致", null);
        }
    }
}
