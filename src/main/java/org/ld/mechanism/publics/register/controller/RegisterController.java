package org.ld.mechanism.publics.register.controller;

import org.ld.mechanism.admin.account.model.AccountModel;
import org.ld.mechanism.admin.account.service.AccountService;
import org.ld.mechanism.util.responseResult.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private AccountService service;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseResult<AccountModel> register(@Valid @RequestBody AccountModel model,
                                                 BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors())
            return new ResponseResult<>(false, bindingResult.getFieldError().getDefaultMessage(), null);

        return service.save(model);
    }
}
