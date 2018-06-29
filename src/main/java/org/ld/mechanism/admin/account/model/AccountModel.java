package org.ld.mechanism.admin.account.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @author ld
 * @name 账户
 * @table
 * @remarks
 */
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Slf4j
@Entity
@Table(name = "account_table")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountModel implements Serializable {
    //    主键
    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String uuid;
    //    账户
    @NotBlank(message = "账户不能为空")
    @Email(message = "不是标准的email格式")
    @Size(min = 6, max = 100, message = "账户长度为6-100位")
    @Column(name = "account", length = 200)
    private String account;
    //    密码
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, max = 30, message = "密码长度为6-30位")
    @Pattern(regexp = "^\\w+$",
            message = "密码需包含字母和数字以及_")
//    @JsonIgnore//生成json时忽略此字段
    @Column(name = "password", length = 200)
    private String password;
    //    类型 1:超级管理员 2：管理员 3：普通用户
    @NotBlank(message = "账户类型不能为空")
    @Min(value = 1, message = "账户类型不能小于1")
    @Max(value = 3, message = "账户类型不能大于3")
    @Size(max = 1, message = "账户类型长度为1")
    @Column(name = "type", length = 10)
    private String type = "3";
    //    是否允许登录 Y：是 N：否
    @NotBlank(message = "是否允许登录不能为空")
    @Pattern(regexp = "Y|N", message = "是否允许登录可选值为 'Y' or 'N'")
    @Size(max = 1, message = "是否允许登录长度为1")
    @Column(name = "is_login", length = 10)
    private String isLogin = "N";
    //    标记字段
    @NotBlank(message = "标记字段不能为空")
    @Column(name = "flag", length = 10)
    private String flag = "0";
    //    乐观锁
    @Version
    private int version;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(String isLogin) {
        this.isLogin = isLogin;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public AccountModel() {
        super();
    }

    public AccountModel(String uuid,
                        @NotBlank(message = "账户不能为空")
                        @Email(message = "不是标准的email格式")
                        @Size(min = 6, max = 100, message = "账户长度为6-100位")
                                String account,
                        @NotBlank(message = "密码不能为空")
                        @Size(min = 6, max = 30, message = "密码长度为6-30位")
                        @Pattern(regexp = "^\\w+$",
                                message = "密码需包含字母和数字以及_") String password, @NotBlank(message = "账户类型不能为空") @Min(value = 1, message = "账户类型不能小于1") @Max(value = 3, message = "账户类型不能大于3") @Size(max = 1, message = "账户类型长度为1") String type, @NotBlank(message = "是否允许登录不能为空") @Pattern(regexp = "Y|N", message = "是否允许登录可选值为 'Y' or 'N'") @Size(max = 1, message = "是否允许登录长度为1") String isLogin, @NotBlank(message = "标记字段不能为空") String flag, int version) {
        this.uuid = uuid;
        this.account = account;
        this.password = password;
        this.type = type;
        this.isLogin = isLogin;
        this.flag = flag;
        this.version = version;
    }

    @Override
    public String toString() {
        return "AccountModel{" +
                "uuid='" + uuid + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", isLogin='" + isLogin + '\'' +
                ", version='" + version + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
