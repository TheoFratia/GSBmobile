package com.example.gsb_frais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.gsb_frais.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = binding.username.getText().toString();
                String password = binding.password.getText().toString();
                GsbServices service = RetrofitClientInstance.getRetrofitInstance().create(GsbServices.class);
                Call<Token> call = service.getToken(new Visiteur(username,password));
                call.enqueue(new Callback<Token>() {
                    @Override
                    public void onResponse(Call<Token> call, Response<Token> response) {
                        if(response.code() == 200) {

                            Token token = response.body();
                            Intent home = new Intent(MainActivity.this, Home.class);
                            home.putExtra("token",token.getToken());
                            home.putExtra("mail",username);
                            startActivity(home);
                            //Toast.makeText(MainActivity.this, token.getToken(), Toast.LENGTH_SHORT).show();
                        }
                        else if(response.code() == 401){
                            Toast.makeText(MainActivity.this, "Erreur de login/mot de passe", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                    }
                });

                }
        });
    }
}