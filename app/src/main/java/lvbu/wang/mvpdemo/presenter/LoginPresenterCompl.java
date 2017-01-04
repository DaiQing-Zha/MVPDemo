package lvbu.wang.mvpdemo.presenter;

import android.os.Handler;
import android.os.Looper;

import lvbu.wang.mvpdemo.model.IUser;
import lvbu.wang.mvpdemo.model.UserModel;
import lvbu.wang.mvpdemo.ui.ILoginView;

/**
 * Created by DaiQing.Zha on 2016/11/21 0021.
 */
public class LoginPresenterCompl implements ILoginPresenter{

    ILoginView iLoginView;
    Handler handler;
    private IUser iUser;

    public LoginPresenterCompl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        initUser();
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void clear() {

        iLoginView.onClearText();
    }

    @Override
    public void doLogin(String userName, String password) {

        boolean isLoginSuccess = true;
        final int code = iUser.checkUserValidity(userName,password);
        if (code != 0) isLoginSuccess = false;
        final boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                iLoginView.onLoginResult(result,code);
            }
        },3000);
    }

    @Override
    public void setProgressBarVisible(int visible) {

        iLoginView.onSetProgressBarVisibility(visible);
    }

    /**
     * 初始化user
     */
    private void initUser(){

        iUser = new UserModel("jack","123456");
    }
}
