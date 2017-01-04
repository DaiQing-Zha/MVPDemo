package lvbu.wang.mvpdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import lvbu.wang.mvpdemo.ui.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, LoginActivity.class));
    }

    private void showMessage(String message){

        Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show();
    }
}
