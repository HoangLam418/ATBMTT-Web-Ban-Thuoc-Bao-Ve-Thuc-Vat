package Service;//package Service;


import bean.User;
import dao.UserDAO;
import java.util.List;



public class UserService {

    private static UserService instance;

    public static UserService getInstance(){
        if(instance ==null ) instance=new UserService();
        return instance;
    }
    public User checkLogin(String email, String pass){
        User userByEmail = UserDAO.getUserByEmail(email);
        if(userByEmail != null && userByEmail.getEmail().equals(email) && userByEmail.getPassword().equals(pass))
            return  userByEmail;
        return null;
    }
    public List<User> getDSUsers(){
        return UserDAO.dsUsers();
    }
    public void deleteUser(int id){
        UserDAO.deleteUser(id);
    }
    public void insertUser(String email,String pass,String username,int role,String surname,String lastname,String phone,String hash,int active){
        UserDAO.insertUser(email, pass,username,role,surname,lastname,phone,hash,active);
    }
    public User selectUser(int a){
        return UserDAO.selectUser(a);
    }

    // lấy ra số lượng khách hàng
    public int numOfRole(int role,String search){
        return UserDAO.numOfRole(role,search);
    }

    public List<User> listOfRole(int role,int index){
        return UserDAO.listOfRole(role, index);
    }
    public void updateUser(String surname,String lastname,String username,String phone,int active,int id){
        UserDAO.updateUser(surname, lastname, username, phone, active, id);
    }
    public List<User> listOfRoleWithSearch(int role, int index, String search){
        return UserDAO.listOfRoleWithSearch(role, index, search);
    }
    public static void main(String[] args) {
        for(User a: UserService.getInstance().listOfRoleWithSearch(0,1,"Tai")){
            System.out.println(a);
        }
}
}
