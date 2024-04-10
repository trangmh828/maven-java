package org.example.connectdb;

public class Customers {
    private int id;
    private String name;
    private String phone;
    private int point;
    private String address;
    private String birthday;
    private String created_at;

    public Customers(int id, String name, String phone, int point,
                     String address, String birthday, String created_at) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.point = point;
        this.address = address;
        this.birthday = birthday;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
