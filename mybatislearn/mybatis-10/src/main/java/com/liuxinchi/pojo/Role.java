package com.liuxinchi.pojo;

import java.util.Date;

public class Role {
    private Long id;

    private String rolecode;

    private String rolename;

    private Long createdby;

    private Date creationdate;

    private Long modifyby;

    private Date modifydate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Long getModifyby() {
        return modifyby;
    }

    public void setModifyby(Long modifyby) {
        this.modifyby = modifyby;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    @Override
    public String toString() {
        return "Role [createdby=" + createdby + ", creationdate=" + creationdate + ", id=" + id + ", modifyby="
                + modifyby + ", modifydate=" + modifydate + ", rolecode=" + rolecode + ", rolename=" + rolename + "]";
    }

    public Role() {
    }

    public Role(Long id, String rolecode, String rolename, Long createdby, Date creationdate, Long modifyby,
            Date modifydate) {
        this.id = id;
        this.rolecode = rolecode;
        this.rolename = rolename;
        this.createdby = createdby;
        this.creationdate = creationdate;
        this.modifyby = modifyby;
        this.modifydate = modifydate;
    }

}
