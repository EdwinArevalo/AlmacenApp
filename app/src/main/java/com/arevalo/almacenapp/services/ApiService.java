package com.arevalo.almacenapp.services;

import java.util.List;

import com.arevalo.almacenapp.ApiMessage;
import com.arevalo.almacenapp.models.Producto;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ApiService {


    String API_BASE_URL = "http://10.0.2.2:8080";

    @GET("/productos")  // http://10.0.2.2:8080/productos
    Call<List<Producto>> findAll();

    @FormUrlEncoded
    @POST("/productos")
    Call<Producto> createProducto(@Field("nombre") String nombre,
                                  @Field("precio") String precio,
                                  @Field("detalles") String detalles
    );

    @Multipart
    @POST("/productos")
    Call<Producto> createProducto(@Part("nombre") RequestBody nombre,
                                  @Part("precio") RequestBody precio,
                                  @Part("detalles") RequestBody detalles,
                                  @Part MultipartBody.Part imagen
    );

    @DELETE("/productos/{id}")
    Call<ApiMessage> destroyProducto(@Path("id") Long id);

    @GET("/productos/{id}")
    Call<Producto> showProducto(@Path("id") Long id);

}
