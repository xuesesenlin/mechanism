package org.ld.mechanism.config.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.ld.mechanism.admin.account.model.AccountModel;
import org.ld.mechanism.admin.account.service.AccountService;
import org.ld.mechanism.config.shiro.jwt.JWTUtil;
import org.ld.mechanism.config.shiro.token.JWTToken;
import org.ld.mechanism.util.responseResult.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@Service
public class MyRealm extends AuthorizingRealm {

    private AccountService accountService;

    @Autowired
    public void setUserService(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = JWTUtil.getUsername(principals.toString());
        ResponseResult<AccountModel> result = accountService.findByAccount(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        if (result.isSuccess())
            simpleAuthorizationInfo.addRole("admin");
//        Set<String> permission = new HashSet<>(Arrays.asList(user.getPermission().split(",")));
//        simpleAuthorizationInfo.addStringPermissions(permission);
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        if (username == null)
            throw new AuthenticationException("账户不能为空");
        ResponseResult<AccountModel> result = accountService.findByAccount(username);
        if (!result.isSuccess())
            throw new AuthenticationException("账户不存在");

        if (!JWTUtil.verify(token, username, result.getData().getPassword())) {
            throw new AuthenticationException("账户或密码错误");
        }
//        此处用相同的token只是做登陆用，密码的正确与否上边已经判断
        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
