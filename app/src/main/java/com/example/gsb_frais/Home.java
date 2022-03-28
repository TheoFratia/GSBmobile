package com.example.gsb_frais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gsb_frais.databinding.ActivityHomeBinding;
import com.example.gsb_frais.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity {

    ActivityHomeBinding binding;
    Visiteur leVisiteur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_home);
        View view = binding.getRoot();

        String token = getIntent().getExtras().getString("token");
        String mail = getIntent().getExtras().getString("mail");


        GsbServices service = RetrofitClientInstance.getRetrofitInstance().create(GsbServices.class);
        Call<Visiteurs> call = service.getAllVisiteurs("Bearer " + token);
        call.enqueue(new Callback<Visiteurs>() {
            @Override
            public void onResponse(Call<Visiteurs> call, Response<Visiteurs> response) {
                Visiteurs visiteurs = response.body();
                for (Visiteur visiteur : visiteurs.getVisiteurs()){
                    if(visiteur.getEmail().equals(mail)){
                        leVisiteur = visiteur;

                        TextView tvnom = findViewById(R.id.Nom);
                        tvnom.setText(visiteur.getVis_nom());

                        TextView tvprenom = findViewById(R.id.Prenom);
                        tvprenom.setText(visiteur.getVis_prenom());

                        TextView tvtel = findViewById(R.id.Tel);
                        tvtel.setText(visiteur.getVis_tel());

                    }
                }
            }

            @Override
            public void onFailure(Call<Visiteurs> call, Throwable t) {
                Toast.makeText(Home.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}