package com.example.gsb_frais;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    private RecyclerView recyclerViewPraticiens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


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
                        TextView tvmail = findViewById(R.id.Mail);
                        tvmail.setText(mail);
                        for (String praticien : visiteur.getPraticien()){
                            praticien = praticien.substring(16);
                            int unPraticien = Integer.parseInt(praticien);
                            GsbServices service = RetrofitClientInstance.getRetrofitInstance().create(GsbServices.class);
                            Call<Praticien> call1 = service.getPraticien("Bearer " + token ,unPraticien);
                            call1.enqueue(new Callback<Praticien>() {
                                @Override
                                public void onResponse(Call<Praticien> call, Response<Praticien> response) {
                                    Praticien praticien = response.body();
                                    leVisiteur.add(praticien);
                                    if (leVisiteur != null){
                                        if (leVisiteur.getLesPraticiens().size() == leVisiteur.getPraticien().size()){
                                            binding.Praticiens.setHasFixedSize(true);
                                            LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                                            binding.Praticiens.setLayoutManager(layoutManager);
                                            binding.Praticiens.setFocusable(false);
                                            GsbRvAdapter myAdapter = new GsbRvAdapter(leVisiteur.getLesPraticiens());
                                            binding.Praticiens.setAdapter(myAdapter);
                                        }
                                    }
                                }

                                @Override
                                public void onFailure(Call<Praticien> call, Throwable t) {

                                }
                            });
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<Visiteurs> call, Throwable t) {
                Toast.makeText(Home.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

        binding.Praticiens.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), binding.Praticiens, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent praticien = new Intent(Home.this, PraticienActivity.class);
                Praticien lePraticien = leVisiteur.getLesPraticiens().get(position);
                praticien.putExtra("praticien", lePraticien);
                praticien.putExtra("token", token);
                startActivity(praticien);
            }
        }));
    }
}