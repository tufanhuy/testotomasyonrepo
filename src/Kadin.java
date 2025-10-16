import java.time.LocalDate;

public class Kadin extends Personel {
    public Kadin(String ad, String soyad, LocalDate dogumTarihi) {
        super(ad, soyad, dogumTarihi);
    }

    @Override
    protected int emeklilikYasi() { return 60; }
}