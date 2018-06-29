package org.ld.mechanism.admin.roleAccount.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@Entity
@Table(name = "role_account_table")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleAccountModel implements Serializable {

    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String uuid;

    @NotBlank(message = "角色不能为空")
    @Column(name = "role", length = 200)
    private String role;

    @NotBlank(message = "账户不能为空")
    @Column(name = "account", length = 200)
    private String account;

    //    乐观锁
    @Version
    private int version;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public RoleAccountModel() {
        super();
    }

    public RoleAccountModel(String uuid, @NotBlank(message = "角色不能为空") String role, @NotBlank(message = "账户不能为空") String account, int version) {
        this.uuid = uuid;
        this.role = role;
        this.account = account;
        this.version = version;
    }

    @Override
    public String toString() {
        return "RoleAccountModel{" +
                "uuid='" + uuid + '\'' +
                ", role='" + role + '\'' +
                ", account='" + account + '\'' +
                ", version=" + version +
                '}';
    }
}
