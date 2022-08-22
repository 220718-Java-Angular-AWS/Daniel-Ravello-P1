package pojos;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Objects;

public class User {
        private Integer userID;
        private String firstName;
        private String lastName;
        private String username;
        private String email;
        private String password;
        private Boolean admin;

    public User() {
    }

public User(Integer userID, String first_name, String last_name, String username, String email, String password, Boolean admin) {
            this.userID = userID;
            this.firstName= first_name;
            this.lastName= last_name;
            this.username = username;
            this.email = email;
            this.password = password;
            this.admin = admin;

    }

    public User(String first_name, String last_name, String username, String email, String password, Boolean admin) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.admin= admin;
    }
    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
    // checking if both the object references are
    // referring to the same object.
    // it checks if the argument is of the
    // type by comparing the classes
    // of the passed argument and this object.
    // if(!(obj instanceof) return false; ---> avoid.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userID, user.userID) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(admin, user.admin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, firstName, lastName, username, email, password, admin);
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                '}';
    }
}
