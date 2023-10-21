package com.example.crm.domain;

//@Data
//@Entity
public class Students {

//    @Id
//    @GeneratedValue
    private String fullName;
    private String yearEntry;
    private String statement;
    private String phoneNumber;
    private String group;

    public String getFullName() {
        return "Повне ім'я";
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getYearEntry() {
        return "Рік вступу";
    }

    public void setYearEntry(String yearEntry) {
        this.yearEntry = yearEntry;
    }

    public String getStatement() {
        return "Вид довідки";
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getPhoneNumber() {
        return "Номер телефону";
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroup() {
        return "Група";
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
