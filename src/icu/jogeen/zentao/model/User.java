package icu.jogeen.zentao.model;

public class User {
    private String id;
    private String company;
    private String type;
    private String dept;
    private String account;
    private String role;
    private String realname;
    private String pinyin;
    private String nickname;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", company='" + company + '\'' +
                ", type='" + type + '\'' +
                ", dept='" + dept + '\'' +
                ", account='" + account + '\'' +
                ", role='" + role + '\'' +
                ", realname='" + realname + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
