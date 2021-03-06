package com.example.gsb_frais;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GsbServices {
    @GET("visiteurs")
    Call<Visiteurs> getAllVisiteurs(@Header("Authorization")String autorization);

    @POST("login_check")
    Call<Token> getToken(@Body Visiteur visiteur);

    @GET("visites/{id}")
    Call<Visites> getVisites(@Header("Authorization") String authorization, @Path("id") int id);

    @GET("praticiens/{id}")
    Call<Praticien> getPracticien(@Header("Authorization")String autorization, @Path("id") int id);

    @GET("praticiens/{id}")
    Call<Praticien> getPraticien(@Header("Authorization") String authorization, @Path("id") int id);

    @POST("visiteurs")
    Call<Visiteur> createVisiteur(@Body Visiteur visiteur);
}
