package example.fgurgur.retrofitexample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.List;

public class Ogrenci_Tekil extends RecyclerView.Adapter<Ogrenci_Tekil.OgrenciYerleskesi>
{

    private List<Ogrenci> ogrenciler;
    private int siraLayout;
    private Context context;

    public static class OgrenciYerleskesi extends RecyclerView.ViewHolder
    {

        TextView ogrAd,ogrMail,ogrBolum,ogrYas,ogrCinsiyet,ogrGNA,ogrID;
        ImageView ogrResim;

        public OgrenciYerleskesi(View v) {
            super(v);
            ogrAd = v.findViewById(R.id.ogrAd);
            ogrMail = v.findViewById(R.id.ogrMail);
            ogrBolum = v.findViewById(R.id.ogrBolum);
            ogrYas = v.findViewById(R.id.ogrYas);
            ogrCinsiyet = v.findViewById(R.id.ogrCinsiyet);
            ogrGNA = v.findViewById(R.id.ogrGNA);
            ogrID = v.findViewById(R.id.ogrID);
            ogrResim = v.findViewById(R.id.ogrResim);


        }
    }

    public Ogrenci_Tekil (List<Ogrenci> ogrenciler , int siraLayout, Context context)
    {
        this.ogrenciler = ogrenciler;
        this.siraLayout = siraLayout;
        this.context = context;
    }

    @NonNull
    @Override
    public OgrenciYerleskesi onCreateViewHolder(@NonNull ViewGroup v, int viewType) {
        View view = LayoutInflater.from(v.getContext()).inflate(siraLayout,v,false);
        return new OgrenciYerleskesi(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OgrenciYerleskesi tutucu, int sira) {



        tutucu.ogrAd.setText(ogrenciler.get(sira).adSoyad);
        tutucu.ogrMail.setText(ogrenciler.get(sira).email);
        tutucu.ogrBolum.setText(ogrenciler.get(sira).bolum);
        tutucu.ogrCinsiyet.setText(ogrenciler.get(sira).cinsiyet);
        tutucu.ogrYas.setText(ogrenciler.get(sira).yas);
        tutucu.ogrGNA.setText(String.valueOf(ogrenciler.get(sira).gNA));
        tutucu.ogrID.setText(ogrenciler.get(sira).ogrenciID);

        String resimUrl = ogrenciler.get(sira).resim;

        Picasso.with(context.getApplicationContext())
                .load(resimUrl)
                .placeholder(R.drawable.yukleniyor)
                .error(R.drawable.hata)
                .into(tutucu.ogrResim);


    }

    @Override
    public int getItemCount() {
        return ogrenciler.size();
    }




}
