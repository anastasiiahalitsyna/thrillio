package dao;

import entities.User;
import thrillio.DataStore;

public class UserDao {
    public User[] getUsers() {
        return DataStore.getUsers();
    }
}
