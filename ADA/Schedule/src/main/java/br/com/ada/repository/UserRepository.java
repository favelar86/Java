package br.com.ada.repository;

import br.com.ada.config.DataBase;
import br.com.ada.model.User;

public class UserRepository {

    DataBase dataBase =  DataBase.getInstance();

    public User findUserById(Long id){
        return dataBase.getUserById(id);
    }

    public void saveUser(User user){
        dataBase.addUser(user.getId(), user);
    }
}
