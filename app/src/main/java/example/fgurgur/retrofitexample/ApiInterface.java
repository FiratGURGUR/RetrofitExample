package example.fgurgur.retrofitexample;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("Veri")
    Call<Ogrenci[]> OgrencileriAl();

}
