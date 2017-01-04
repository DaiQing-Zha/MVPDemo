package lvbu.wang.mvpdemo.ui;

import android.opengl.Visibility;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import lvbu.wang.mvpdemo.R;
import lvbu.wang.mvpdemo.presenter.ILoginPresenter;
import lvbu.wang.mvpdemo.presenter.LoginPresenterCompl;

/**
 * Created by DaiQing.Zha on 2016/11/21 0021.
 */
public class LoginActivity extends AppCompatActivity implements ILoginView,View.OnClickListener {

    private EditText et_userName,et_password;
    private Button btn_login,btn_clear;
    private ILoginPresenter iLoginPresenter;
    private ProgressBar pb_progress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_userName = (EditText) findViewById(R.id.et_userName);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_loign);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        pb_progress = (ProgressBar) findViewById(R.id.pb_progress);

        btn_login.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        iLoginPresenter = new LoginPresenterCompl(this);
    }

    @Override
    public void onClearText() {

        et_userName.setText("");
        et_password.setText("");

    }

    @Override
    public void onLoginResult(boolean result, int code) {

        iLoginPresenter.setProgressBarVisible(View.INVISIBLE);
        btn_login.setEnabled(true);
        btn_clear.setEnabled(true);
        if (result){

            Toast.makeText(this,"success",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"fail",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {


        pb_progress.setVisibility(visibility);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn_loign:
                iLoginPresenter.setProgressBarVisible(View.VISIBLE);
                btn_login.setEnabled(false);
                btn_clear.setEnabled(false);
                iLoginPresenter.doLogin(et_userName.getText().toString(),et_password.getText().toString());
                break;
            case R.id.btn_clear:
                iLoginPresenter.clear();
                break;
        }
    }
}
