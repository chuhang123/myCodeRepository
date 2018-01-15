package com.mengyunzhi.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chuhang on 17-11-29
 * 用户
 */
@Entity
public class User implements Serializable {
    // 实现了Serializable接口，用于序列化
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@ApiModelProperty("名称")
    private String name;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // 在进行json转换时，忽略本字段
    //@ApiModelProperty("密码")
    private String password;
    //@ApiModelProperty("用户名")
    @Column(unique = true)
    private String username;
    //@ApiModelProperty("手机号")
    private String mobile;
    //@ApiModelProperty("拼音")
    private String pinyin;
    //@ApiModelProperty("创建时间")
    @CreationTimestamp
    private Calendar createTime;
    //@ApiModelProperty("修改时间")
    @UpdateTimestamp
    private Calendar updateTime;
    //@ApiModelProperty("状态:-1未审核; 0已审核；1已冻结；2其它")
    private Integer status = -1;
    //@ApiModelProperty("新密码")
    @Transient		//该字段并不存在数据表中
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String rePassword;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //@ApiModelProperty(value = "对应的角色列表", notes = "参考:<<Hibernate 实战>> P172")
    @ManyToMany
    @Lazy
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<Role>();

    @ManyToOne
    //@ApiModelProperty("创建用户")
    @Lazy()    //自关联需要延迟加载
    protected User createUser;

    //@ApiModelProperty("更新用户")
    @ManyToOne
    @Lazy()
    protected User updateUser;


    public User() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public Calendar getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Calendar createTime) {
        this.createTime = createTime;
    }

    public Calendar getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Calendar updateTime) {
        this.updateTime = updateTime;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    public User getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(User updateUser) {
        this.updateUser = updateUser;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
