package lvbu.wang.mvpdemo.ui;

/**
 * Created by DaiQing.Zha on 2016/11/21 0021.
 */
public interface ILoginView {

    public void onClearText();
    public void onLoginResult(boolean result,int code);
    public void onSetProgressBarVisibility(int visibility);
}
