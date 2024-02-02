package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.sharedpreferences.databinding.ActivityMainBinding;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sharedPreferences = getSharedPreferences("KisiselBilgiler",MODE_PRIVATE);
        SharedPreferences.Editor e = sharedPreferences.edit();

        binding.btnKaydet.setOnClickListener(v -> {

            e.putString("ad","samet");
            e.putInt("yas",23);
            e.putFloat("boy",1.76f);
            e.putBoolean("bekar",true);

            Set<String>arkadasListesi=new HashSet<>();
            arkadasListesi.add("zeynep");
            arkadasListesi.add("kadir");

            e.putStringSet("arkadasListesi",arkadasListesi);
            e.commit();



            startActivity(new Intent(getApplicationContext(), SecondActivity.class));
        });
    }
}