package com.revature.models;

public class User {

    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String horoscope;
    private String mood;
    private String birthday;

    private boolean isLogin;

    // > no args constructor
    public User() {
    }

    // > constructor with no id as it's generated from DB
    public User(String firstname, String lastname, String email, String password, String horoscope,
            String birthday) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.horoscope = horoscope;
        this.birthday = birthday;
        this.isLogin = false;

    }

    // > All args constructor
    public User(int id, String firstname, String lastname, String email, String password, String horoscope,
            String birthday, String mood, boolean isLogin) {

        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.horoscope = horoscope;
        this.birthday = birthday;
        this.mood = mood;
        this.isLogin = false;
    }

    // ! METHODS
    // Login
    public String login(String email, String password) {

        if (this.email == null) {
            return "Email entered incorrectly or doesn't exist, please check your email or contact HR";
        }

        if (this.email.equals(email) && this.password.equals(password)) {
            return "Success";
        } else {
            return "Email or password entered incorrectly!";
        }
    }

    public void setLogin(){
        this.isLogin = true;
    }

    // Logout
    public void setLogout() {
        this.isLogin = false;

    }

    // < Getter & Setter ID
    public int getId() {
        return id;
    }

    public void setId(int newId) {
        this.id = newId;
    }

    // < Getter & Setter firstname
    public String getfirstname() {
        return firstname;
    }

    public void setfirstname(String newfirstname) {
        this.firstname = newfirstname;
    }

    // < Getter & Setter lastname
    public String getlastname() {
        return lastname;
    }

    public void setlastname(String newlastname) {
        this.lastname = newlastname;
    }

    // < Getter & Setter EMAIL
    public String getEmail() {
        return email;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    // < Getter & Setter PASSWORD
    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    // < Getter & Setter horoscope

    public String getHoroscope() {
        return horoscope;
    }

    public void setHoroscope(String newHoroscope) {
        this.horoscope = newHoroscope;
    }

    // < Getter & Setter birthday

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    // > getter & setter mood

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    // < Getter & Setter isLogin

    public boolean getIsLogin() {
        return isLogin;
    }

    public void setLogin(boolean loginStatus){
        this.isLogin = loginStatus;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", horoscope='" + birthday + '\'' + 
                ", horoscope='" + mood + '\'' + 
                ", horoscope='" + horoscope + '\'' + '}';
    }
}
