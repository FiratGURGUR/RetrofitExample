package example.fgurgur.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Ogrenci> Ogrenciler = new ArrayList<>();
    private Ogrenci_Tekil tekil_ogrenci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final RecyclerView liste  = findViewById(R.id.liste);
        liste.setLayoutManager(new LinearLayoutManager(this));
        ApiInterface servis = ApiClient.getClient().create(ApiInterface.class);
        Call<Ogrenci[]> cagri = servis.OgrencileriAl();
        cagri.enqueue(new Callback<Ogrenci[]>() {
            @Override
            public void onResponse(Call<Ogrenci[]> call, Response<Ogrenci[]> response) {

                Ogrenciler = Arrays.asList(response.body());
                tekil_ogrenci = new Ogrenci_Tekil(Ogrenciler,R.layout.ogrenci,getApplicationContext());
                liste.setAdapter(tekil_ogrenci);
            }

            @Override
            public void onFailure(Call<Ogrenci[]> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Listeleme Yapılırken Hata Oluştu", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
