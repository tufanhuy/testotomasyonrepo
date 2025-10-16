import java.time.LocalDate;

public class Erkek extends Personel{
    public Erkek(String ad, String soyad, LocalDate dogumTarihi){
        super(ad, soyad, dogumTarihi);
    }

    @Override
    protected int emeklilikYasi() { return 65; }
}