package lvbu.wang.mvpdemo.presenter;

/**
 * Created by DaiQing.Zha on 2016/11/21 0021.
 */
public interface ILoginPresenter {

    void clear();
    void doLogin(String userName,String password);
    void setProgressBarVisible(int visible);
}
