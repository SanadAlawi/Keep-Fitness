package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mainactivity.MainActivity;
import com.example.mainactivity.SignActivity;

public class LoginActivity extends AppCompatActivity {

    private static final String FLAG = "flag";
    private static final String CHECKED = "checked";
    private static final String USERNAME = "userName";
    private static final String PASSWORD = "password";
    private static final String USERFILE = "User";

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private boolean flag = false;

    private EditText LoginActivity_et_username;
    private EditText LoginActivity_et_password;
    private CheckBox LoginActivity_cb_remember;
    private Button LoginActivity_btn_login;
    private Button LoginActivity_btn_sign;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setUpViews();
        setUpPreference();
        setData();
    }

    private void setData() {
        String userName = sp.getString(USERNAME, "");
        String password = sp.getString(PASSWORD, "");
        boolean f = sp.getBoolean(String.valueOf(FLAG), false);
        boolean check = sp.getBoolean(String.valueOf(CHECKED), false);
        if(f && check){
            LoginActivity_et_username.setText(userName);
            LoginActivity_et_password.setText(password);
            LoginActivity_cb_remember.setChecked(true);
//            LoginActivity_btn_sign.setVisibility(View.INVISIBLE);
        }
    }

    private void setUpPreference() {
        sp = getSharedPreferences(USERFILE, MODE_PRIVATE);
        editor = sp.edit();
    }

    private void setUpViews() {
        LoginActivity_et_username = findViewById(R.id.LoginActivity_et_username);
        LoginActivity_et_password = findViewById(R.id.LoginActivity_et_password);
        LoginActivity_cb_remember = findViewById(R.id.LoginActivity_cb_remember);
        LoginActivity_btn_login = findViewById(R.id.LoginActivity_btn_login);
    }

    public void loginUser(View view) {
        String userName = LoginActivity_et_username.getText().toString().trim();
        String password = LoginActivity_et_password.getText().toString().trim();
        flag = sp.getBoolean(FLAG, false);
        if( !userName.isEmpty() && !password.isEmpty() ){
            if(flag){
                if( sp.getString(USERNAME, "").equals(userName) ){
                    if( sp.getString(PASSWORD, "").equals(password) ){
                        if(LoginActivity_cb_remember.isChecked()){
                            editor.putBoolean(CHECKED, true);
                            editor.apply();
                        }
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                    }else
                        Toast.makeText(getBaseContext(), "Password not match your user account!!!", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(getBaseContext(), "User Not Found!!!", Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(getBaseContext(), "User Not Found, Sign In First!!!", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(getBaseContext(), "Fill USER NAME AND PASSWORD failed!!!", Toast.LENGTH_SHORT).show();
    }

    public void SignUser(View view) {
        Intent intent = new Intent(this, SignActivity.class);
        startActivity(intent);
    }
}