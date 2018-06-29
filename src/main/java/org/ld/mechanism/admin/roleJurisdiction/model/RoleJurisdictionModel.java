package org.ld.mechanism.admin.roleJurisdiction.model;

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
@Table(name = "role_jurisdiction_table")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleJurisdictionModel implements Serializable {

    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String uuid;

    @NotBlank(message = "角色不能为空")
    @Column(name = "role", length = 200)
    private String role;

    @NotBlank(message = "权限不能为空")
    @Column(name = "jurisdiction", length = 200)
    private String jurisdiction;

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

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public RoleJurisdictionModel() {
        super();
    }

    public RoleJurisdictionModel(String uuid, @NotBlank(message = "角色不能为空") String role, @NotBlank(message = "权限不能为空") String jurisdiction, int version) {
        this.uuid = uuid;
        this.role = role;
        this.jurisdiction = jurisdiction;
        this.version = version;
    }

    @Override
    public String toString() {
        return "RoleJurisdictionModel{" +
                "uuid='" + uuid + '\'' +
                ", role='" + role + '\'' +
                ", jurisdiction='" + jurisdiction + '\'' +
                ", version=" + version +
                '}';
    }
}
