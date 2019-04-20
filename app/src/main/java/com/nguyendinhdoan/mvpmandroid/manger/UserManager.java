package com.nguyendinhdoan.mvpmandroid.manger;

import com.nguyendinhdoan.mvpmandroid.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private List<User> userList;
    private static UserManager instance;

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public void addUser(String userName, String password) {
        if (userList == null) {
            userList = new ArrayList<>();
        }
        userList.add(new User(userName, password));
    }

    public boolean validateLogin(String userName, String password) {
        for (User user : userList) {
            if (user.getUserName().equals(userName) &&
                    user.getPassword().equals(password)) return true;
        }
        return false;
    }
}
