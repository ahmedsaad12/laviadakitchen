package com.laviadakitchen.activities_fragments.activity_splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.laviadakitchen.R;
import com.laviadakitchen.activities_fragments.activity_currentorder.CurrentOrderActivity;

import com.laviadakitchen.databinding.ActivitySplashBinding;
import com.laviadakitchen.language.Language;
import com.laviadakitchen.preferences.Preferences;

import io.paperdb.Paper;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;
    private Preferences preferences;

    @Override
    protected void attachBaseContext(Context newBase) {
        Paper.init(newBase);
        super.attachBaseContext(Language.updateResources(newBase, Paper.book().read("lang", "ar")));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        preferences = Preferences.getInstance();

        new Handler()
                .postDelayed(() -> {

                        Intent intent;

                            intent = new Intent(this, CurrentOrderActivity.class);

                        startActivity(intent);
                        finish();
                    }
                , 2000);

    }
}
