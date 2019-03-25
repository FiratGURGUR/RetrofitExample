package example.fgurgur.retrofitexample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ogrenci {
    @SerializedName("AdSoyad")
    @Expose
    public String adSoyad;
    @SerializedName("Email")
    @Expose
    public String email;
    @SerializedName("Cinsiyet")
    @Expose
    public String cinsiyet;
    @SerializedName("Yas")
    @Expose
    public String yas;
    @SerializedName("Bolum")
    @Expose
    public String bolum;
    @SerializedName("Resim")
    @Expose
    public String resim;
    @SerializedName("GNA")
    @Expose
    public Float gNA;
    @SerializedName("OgrenciID")
    @Expose
    public String ogrenciID;
}
