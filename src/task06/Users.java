package task06;

import java.util.Date;

public class Users {
    private String name, password, email,phoneNumber;
    private Date birthday;

    public Users(String name, String password, String email, Date birthday, String phoneNumber) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int hashCode(){      //why?
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj){    //why?
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        Users others = (Users) obj;

        if (name == null) {
            return others.name == null;
        } else {
            return name.equals(others.name);
        }

    }
}
