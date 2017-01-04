package lvbu.wang.mvpdemo.model;

import android.support.annotation.NonNull;

/**
 * Created by DaiQing.Zha on 2016/11/21 0021.
 */
public interface IUser {

    int checkUserValidity(@NonNull String userName, @NonNull String password);
}
