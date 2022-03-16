package com.example.gsb_frais;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GsbServices service = RetrofitClientInstance.getRetrofitInstance().create(GsbServices.class);
        Visiteur visiteur = new Visiteur("test2@test.com","password");
        Call<Token> call = service.getToken(visiteur);
        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if(response.code() == 200) {

                    Token token = response.body();
                    TextView TextviewToken = findViewById(R.id.textviewhelloword);
                    TextviewToken.setText(token.getToken());
                    Toast.makeText(MainActivity.this, token.getToken(), Toast.LENGTH_SHORT).show();
                }
                else if(response.code() == 401){
                    Toast.makeText(MainActivity.this, "Erreur de login/mot de passe", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                TextView TextviewToken = findViewById(R.id.textviewhelloword);
                TextviewToken.setText("erreur");
            }
        });
    }
}