package org.ld.mechanism.publics.login.controller;

import org.ld.mechanism.admin.account.model.AccountModel;
import org.ld.mechanism.admin.account.service.AccountService;
import org.ld.mechanism.config.shiro.jwt.JWTUtil;
import org.ld.mechanism.util.responseResult.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AccountService service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseResult<String> login(@Valid @RequestBody AccountModel model,
                                        HttpServletResponse response) {
        ResponseResult<AccountModel> result = service.findByAccount(model.getAccount());
        if (result.isSuccess()) {
            if (model.getPassword().equals(result.getData().getPassword())) {
                String sign = JWTUtil.sign(result.getData().getAccount(), result.getData().getPassword());
                response.setHeader("Authorization", sign);
                return new ResponseResult<>(true, "登录成功", null);
            } else
                return new ResponseResult<>(false, "账号或密码错误", null);
        } else
            return new ResponseResult<>(false, "账户不存在", null);
    }
}
