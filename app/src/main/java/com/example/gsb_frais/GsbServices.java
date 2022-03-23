package com.example.gsb_frais;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface GsbServices {
    @GET("visiteurs")
    Call<Visiteurs> getAllVisiteurs(@Header("Authorization")String autorization);

    @POST("login_check")
    Call<Token> getToken(@Body Visiteur visiteur);

    @POST("visiteurs")
    Call<Visiteur> creatVisiteur(@Body Visiteur visiteur);

    @GET("visiteurs/{id}")
    Call<Visiteurs> getVisiteur(@Header("Authorization")String autorization);
}
