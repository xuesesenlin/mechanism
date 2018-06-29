package org.ld.mechanism.admin.role.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@Entity
@Table(name = "role_table")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleModel implements Serializable {

    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String uuid;

    @NotBlank(message = "角色名称不能为空")
    @Size(max = 200, message = "角色名称最大长度为200")
    @Column(name = "name", length = 200)
    private String name;

    //    备注
    @Size(max = 200, message = "备注最大长度为200")
    @Column(name = "remarks", length = 200)
    private String remarks;

    //    乐观锁
    @Version
    private int version;

    //    fetch=FetchType.LAZY 懒加载
//    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
//    @JoinColumn(name = "role_id")
//    private List<RoleAssociationModel> roleAssociationModels;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public RoleModel() {
        super();
    }

    public RoleModel(String uuid, @NotBlank(message = "角色名称不能为空") @Size(max = 200, message = "角色名称最大长度为200") String name, @Size(max = 200, message = "备注最大长度为200") String remarks, int version) {
        this.uuid = uuid;
        this.name = name;
        this.remarks = remarks;
        this.version = version;
    }

    @Override
    public String toString() {
        return "RoleModel{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", remarks='" + remarks + '\'' +
                ", version=" + version +
                '}';
    }
}
