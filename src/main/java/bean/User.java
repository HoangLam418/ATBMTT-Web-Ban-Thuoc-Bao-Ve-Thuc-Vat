package bean;

public class User {

    private int id, role,active;
    private String username, password, phone, email, surname, lastname, hash;

    public User(){}
    public User(int id, String username, String password, String phone, String email, String surname, String lastname, int role, String hash) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.surname = surname;
        this.lastname = lastname;
    }

    public User(int id, String username, String password, String phone, String surname, String lastname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.surname = surname;
        this.lastname = lastname;
    }

    public User(int id, int active, String username, String phone, String surname, String lastname) {
        this.id = id;
        this.active = active;
        this.username = username;
        this.phone = phone;
        this.surname = surname;
        this.lastname = lastname;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + role +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", surname='" + surname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }
    // Phương thức dưới để xác định vai trò của người theo role
    public String roleString(){
        if(this.role ==0){
            return "User";
        }else{
            return "Admin";
        }
    }
    // phương thức xác định trạng thái tài khoản.
    public String activeString(){
        if(this.active==1){
            return "Kích hoạt tài khoản";
        }else{
            return "Khóa tài khoản";
        }
    }
}

