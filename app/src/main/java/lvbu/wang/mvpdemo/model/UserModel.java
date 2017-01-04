package lvbu.wang.mvpdemo.model;

import android.support.annotation.NonNull;

/**
 * Created by DaiQing.Zha on 2016/11/21 0021.
 */
public class UserModel implements IUser{

    private String userName;
    private String password;

    public UserModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int checkUserValidity(@NonNull String userName, @NonNull String password) {

        if (userName.length() >= 4 && userName.length() < 10 && password.length() >= 6 && password.length() <= 15){
            return 0;
        }
        return 1;
    }
}
