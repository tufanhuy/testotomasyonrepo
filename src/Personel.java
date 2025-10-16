import java.time.LocalDate;
import java.time.Period;

public abstract class Personel {
    private String ad;
    private String soyad;
    private LocalDate dogumTarihi;

    protected Personel(String ad, String soyad, LocalDate dogumTarihi) {
        if (ad == null || ad.isBlank()) throw new IllegalArgumentException("Ad zorunlu");
        if (soyad == null || soyad.isBlank()) throw new IllegalArgumentException("Soyad zorunlu");
        if (dogumTarihi == null || dogumTarihi.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Doğum tarihi geçersiz");
        this.ad = ad;
        this.soyad = soyad;
        this.dogumTarihi = dogumTarihi;
    }

    public String getAd() { return ad; }
    public String getSoyad() { return soyad; }
    public LocalDate getDogumTarihi() { return dogumTarihi; }

    public int getYas() {
        return Period.between(dogumTarihi, LocalDate.now()).getYears();
    }

    protected abstract int emeklilikYasi();

    public int emekliligeKalanYil() {
        int kalan = emeklilikYasi() - getYas();
        return Math.max(0, kalan);
    }

    @Override
    public String toString() {
        return ad + " " + soyad + " (" + getYas() + ")";
    }
}