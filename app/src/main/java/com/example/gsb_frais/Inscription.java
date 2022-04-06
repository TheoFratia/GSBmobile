package com.example.gsb_frais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.gsb_frais.databinding.ActivityHomeBinding;
import com.example.gsb_frais.databinding.ActivityInscriptionBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Inscription extends AppCompatActivity {
    private ActivityInscriptionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInscriptionBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String unNom = binding.createNom.getText().toString();
                String unPrenom = binding.createPrenom.getText().toString();
                String unmail = binding.createMail.getText().toString();
                String unMdp = binding.createMdp.getText().toString();
                String unTel = binding.createTel.getText().toString();

                GsbServices service = RetrofitClientInstance.getRetrofitInstance().create(GsbServices.class);
                Visiteur visiteur = new Visiteur(unNom, unPrenom, unmail, unMdp, unTel);
                Call<Visiteur> call = service.createVisiteur(visiteur);
                call.enqueue(new Callback<Visiteur>() {
                    @Override
                    public void onResponse(Call<Visiteur> call, Response<Visiteur> response) {

                        Visiteur visiteur = response.body();
                        Toast.makeText(Inscription.this, "inscription reussi", Toast.LENGTH_SHORT).show();
                        Intent inscription = new Intent(Inscription.this, MainActivity.class);
                        startActivity(inscription);
                    }

                    @Override
                    public void onFailure(Call<Visiteur> call, Throwable t) {
                        Toast.makeText(Inscription.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}