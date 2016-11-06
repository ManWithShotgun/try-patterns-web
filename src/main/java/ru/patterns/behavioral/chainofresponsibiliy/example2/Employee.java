package ru.patterns.behavioral.chainofresponsibiliy.example2;

/**
 * Created by Lenovo-PC on 01.11.2016.
 */
public class Employee {
    private int id;
    private String password, login;

    public Employee(int id, String password, String login) {
        this.id = id;
        this.password = password;
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public void print() {
        System.out.printf("User: %d %s %s\n",id,password,login);
    }

    @Override
    public int hashCode() {
        int result = id + ((login == null) ? 0 : login.hashCode());
        result = 31 * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (id != other.id)
            return false;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        if (password == null) {
            if (other.password != null) {
                return false;
            }
        } else if (!password.equals(other.password)) {
            return false;
        }
        return true;
    }
}
