package object;

import java.util.Date;

public class Employee {
    private long id;

    private String userName;

    private String phone;

    private String userComp;

    private Date userBirth;

    private double currentRate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserComp() {
        return userComp;
    }

    public void setUserComp(String userComp) {
        this.userComp = userComp;
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    public double getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(double currentRate) {
        this.currentRate = currentRate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", currentRate=" + currentRate +
                ", company='" + userComp + '\'' +
                ", birthDate='" + userBirth + '\'' +
                '}';
    }


}
