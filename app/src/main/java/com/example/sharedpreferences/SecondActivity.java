package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.sharedpreferences.databinding.ActivitySecondBinding;

import java.util.Set;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;
    private SharedPreferences sp;
    private SharedPreferences.Editor e;
    private String ad;
    private int yas;
    private float boy;
    private boolean bekar;
    private Set<String>arkadasListesi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        sp = getSharedPreferences("KisiselBilgiler",MODE_PRIVATE);

        e=sp.edit();

        ad=sp.getString("ad","isim yok");
        yas =sp.getInt("yas",0);
        boy=sp.getFloat("boy",0.0f);
        bekar=sp.getBoolean("bekar",false);

        arkadasListesi=sp.getStringSet("arkadasListesi",null);

        StringBuilder sb=new StringBuilder();

        for (String s :arkadasListesi){
            sb.append(s+"  ");
        }
        binding.textViewCikti.setText("AD :"+ad+"\nYAŞ :"+yas+"\nBOY :"+boy+"\nBEKAR:"+bekar+"\nARKADAŞLAR:"+sb.toString());

        binding.btnSil.setOnClickListener(v -> {
            e.remove("ad");
            e.commit();

            ad=sp.getString("ad","isim yok");
            binding.textViewCikti.setText("AD :"+ad+"\nYAŞ :"+yas+"\nBOY :"+boy+"\nBEKAR:"+bekar+"\nARKADAŞLAR:"+sb.toString());
        });
        binding.btnGuncelle.setOnClickListener(v -> {
            e.putInt("yas",56);
            e.commit();

            yas =sp.getInt("yas",0);
            binding.textViewCikti.setText("AD :"+ad+"\nYAŞ :"+yas+"\nBOY :"+boy+"\nBEKAR:"+bekar+"\nARKADAŞLAR:"+sb.toString());
        });

    }
}