package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.Arrays;

public class SportActivity extends AppCompatActivity {


    private static final String SPORT = "sport";
    private SharedPreferences sp;

    private ImageView SportActivity_im_sport;
    private TextView SportActivity_tv_sportName;
    private TextView SportActivity_sp_sportTime;
    private TextView SportActivity_tv_sportInformation;
//    private Spinner SportActivity_sp_sportSpinner;
    private Gson gson;

    private Sport selectedSport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);

        sp = PreferenceManager.getDefaultSharedPreferences(this);
        gson = new Gson();


        setUpViews();
        selectedSport = gson.fromJson(sp.getString(SPORT, ""), Sport.class);

        SportActivity_im_sport.setImageResource(selectedSport.getImagePath());
        SportActivity_tv_sportName.setText(selectedSport.getName());
        SportActivity_sp_sportTime.setText(selectedSport.getSportTime());
        SportActivity_tv_sportInformation.setText(selectedSport.getInformation());

    }

    private void setUpViews() {
        SportActivity_im_sport = findViewById(R.id.SportActivity_iv_sport);
        SportActivity_tv_sportName = findViewById(R.id.SportActivity_tv_sportName);
        SportActivity_sp_sportTime = findViewById(R.id.SportActivity_sp_sportTime);
        SportActivity_tv_sportInformation = findViewById(R.id.SportActivity_tv_sportInformation);
    }
}