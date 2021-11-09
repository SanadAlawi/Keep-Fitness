package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignActivity extends AppCompatActivity {

    private static final String FIRSTNAME = "firstName";
    private static final String LASTNAME = "lastName";
    private static final String ADDRESS = "address";
    private static final String USERNAME = "userName";
    private static final String PASSWORD = "password";
    private static final String USERFILE = "User";
    private static final String FLAG = "flag";
    private static final String CHECKED = "checked";



    private EditText SignActivity_et_userName;
    private EditText SignActivity_et_firstName;
    private EditText SignActivity_et_lastName;
    private EditText SignActivity_et_address;
    private EditText SignActivity_et_password;
    private EditText SignActivity_et_rePassword;
    private TextView SignActivity_tv_login;


    private TextView SignActivity_tv_checkFN;
    private TextView SignActivity_tv_checkLN;
    private TextView SignActivity_tv_checkUN;
    private TextView SignActivity_tv_checkP;
    private TextView SignActivity_tv_checkRP;
    private TextView SignActivity_tv_checkA;

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        setUpViews();
        setUpPreference();

//        SignActivity_tv_login.setMovementMethod(LinkMovementMethod.getInstance());

        Intent intent = new Intent(this, LoginActivity.class);
        SignActivity_tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    private void setUpViews() {
        SignActivity_et_userName = findViewById(R.id.SignActivity_et_userName);
        SignActivity_et_firstName = findViewById(R.id.SignActivity_et_firstName);
        SignActivity_et_lastName = findViewById(R.id.SignActivity_et_lastName);
        SignActivity_et_address = findViewById(R.id.SignActivity_et_address);
        SignActivity_et_password = findViewById(R.id.SignActivity_et_password);
        SignActivity_et_rePassword = findViewById(R.id.SignActivity_et_rePassword);
        SignActivity_tv_login = findViewById(R.id.SignActivity_tv_login);

        SignActivity_tv_checkFN = findViewById(R.id.SignActivity_tv_checkFN);
        SignActivity_tv_checkLN = findViewById(R.id.SignActivity_tv_checkLN);
        SignActivity_tv_checkUN = findViewById(R.id.SignActivity_tv_checkUN);
        SignActivity_tv_checkP = findViewById(R.id.SignActivity_tv_checkP);
        SignActivity_tv_checkRP = findViewById(R.id.SignActivity_tv_checkRP);
        SignActivity_tv_checkA = findViewById(R.id.SignActivity_tv_checkA);
    }

    public void SignNewUser(View view) {
        String firstName = SignActivity_et_firstName.getText().toString().trim();
        String lastName = SignActivity_et_lastName.getText().toString().trim();
        String address = SignActivity_et_address.getText().toString().trim();
        String userName = SignActivity_et_userName.getText().toString().trim();
        String password = SignActivity_et_password.getText().toString().trim();
        String rePassword = SignActivity_et_rePassword.getText().toString().trim();
        fillFailed(firstName, lastName, address, userName, password, rePassword);
        flag = sp.getBoolean(String.valueOf(FLAG), false);
        if (!firstName.isEmpty() && !lastName.isEmpty() && !address.isEmpty() &&
                !userName.isEmpty() && !password.isEmpty() && !rePassword.isEmpty()) {
            if (!flag) {
                if (password.equals(rePassword)) {
                    editor.putString(USERNAME, userName);
                    editor.putString(FIRSTNAME, firstName);
                    editor.putString(LASTNAME, lastName);
                    editor.putString(ADDRESS, address);
                    editor.putString(PASSWORD, password);
                    editor.putBoolean(FLAG, true);
                    editor.putBoolean(CHECKED, false);
                    editor.apply();
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    clearFailed();
                } else
                    Toast.makeText(getBaseContext(), "Password not match!!!", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(getBaseContext(), "User Already Sign In", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(getBaseContext(), "Fill All The Failed!!!", Toast.LENGTH_SHORT).show();
    }

    private void fillFailed(String firstName, String lastName, String address, String userName, String password, String rePassword) {
        if(firstName.isEmpty()) SignActivity_tv_checkFN.setVisibility(View.VISIBLE);
        if(lastName.isEmpty()) SignActivity_tv_checkLN.setVisibility(View.VISIBLE);
        if(userName.isEmpty()) SignActivity_tv_checkUN.setVisibility(View.VISIBLE);
        if(address.isEmpty()) SignActivity_tv_checkA.setVisibility(View.VISIBLE);
        if(password.isEmpty()) SignActivity_tv_checkP.setVisibility(View.VISIBLE);
        if(rePassword.isEmpty()) SignActivity_tv_checkRP.setVisibility(View.VISIBLE);
    }

    private void clearFailed(){
        SignActivity_tv_checkFN.setVisibility(View.INVISIBLE);
        SignActivity_tv_checkLN.setVisibility(View.INVISIBLE);
        SignActivity_tv_checkUN.setVisibility(View.INVISIBLE);
        SignActivity_tv_checkA.setVisibility(View.INVISIBLE);
        SignActivity_tv_checkP.setVisibility(View.INVISIBLE);
        SignActivity_tv_checkRP.setVisibility(View.INVISIBLE);
    }


    private void setUpPreference() {
        sp = getSharedPreferences(USERFILE, MODE_PRIVATE);
        editor = sp.edit();
    }
}