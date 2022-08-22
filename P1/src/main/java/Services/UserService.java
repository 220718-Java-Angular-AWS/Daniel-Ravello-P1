package Services;

import DAOs.UserDAO;
import pojos.User;

import java.util.List;

public class UserService {

    private UserDAO dao;

    public UserService(){
        this.dao = new UserDAO();
    }

    public void save (User user){
        dao.create(user);

    }

    public User getUser(int id){
        return dao.read(id);

    }

    public List <User> getAllUsers(){
        return dao.readAll();
    }

    public void update(User user){
        dao.update(user);

    }

    public void delete(int id){
        dao.delete(id);
    }

}
