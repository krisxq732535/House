package com.xq.util;

public class UsersCondition extends PageUtil{
    private String name;
    private String telephone;

    public UsersCondition() {
    }

    public UsersCondition(String name, String telephone) {
        this.name = name;
        this.telephone = telephone;
    }

    public UsersCondition(Integer page, Integer rows, String name, String telephone) {
        super(page, rows);
        this.name = name;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "UsersCondition{" +
                "name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
