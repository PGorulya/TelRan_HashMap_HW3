package org.example;

public class PhoneNum {
    private String phoneNum;

    public PhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "PhoneNum{" +
                "phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
