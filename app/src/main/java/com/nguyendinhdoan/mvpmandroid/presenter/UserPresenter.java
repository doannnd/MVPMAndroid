package com.nguyendinhdoan.mvpmandroid.presenter;

import com.nguyendinhdoan.mvpmandroid.manger.UserManager;

public class UserPresenter {

    public UserPresenter() {
        UserManager.getInstance().addUser("doannd", "123");
    }

    public boolean login(String userName, String password) {
        return UserManager.getInstance().validateLogin(userName, password);
    }
}
