import java.util.*;

public class Department {
    private final String ad;
    private Personel takimLideri;
    private final List<Personel> personeller = new ArrayList<>();
    private final List<String> gorevler = new ArrayList<>();
    private final Set<Integer> tamamlananGorevIndeksleri = new HashSet<>();

    public Department(String ad, Personel takimLideri) {
        if (takimLideri == null) throw new IllegalArgumentException("Takım lideri zorunludur");
        if (ad == null || ad.isBlank()) throw new IllegalArgumentException("Departman adı zorunludur");
        this.ad = ad;
        this.takimLideri = takimLideri;
        this.personeller.add(takimLideri);
    }

    public String getAd() { return ad; }
    public Personel getTakimLideri() { return takimLideri; }
    public List<Personel> getPersoneller() { return Collections.unmodifiableList(personeller); }
    public List<String> getGorevler() { return Collections.unmodifiableList(gorevler); }

    public void liderDegistir(Personel yeniLider) {
        if (yeniLider == null) throw new IllegalArgumentException("Lider boş olamaz");
        if (!personeller.contains(yeniLider)) {
            personelEkle(yeniLider);
        }
        this.takimLideri = yeniLider;
    }

    public void personelEkle(Personel p) {
        if (p == null) throw new IllegalArgumentException("Personel boş olamaz");
        personeller.add(p);
    }

    public boolean personelCikar(Personel p) {
        if (p == null) return false;
        if (p.equals(takimLideri)) {
            throw new IllegalStateException("Takım lideri doğrudan çıkarılamaz. Önce lideri değiştirin.");
        }
        return personeller.remove(p);
    }

    public void personelDegistir(int index, Personel yeni) {
        if (yeni == null) throw new IllegalArgumentException("Yeni personel boş olamaz");
        if (index < 0 || index >= personeller.size()) throw new IndexOutOfBoundsException();
        Personel eski = personeller.get(index);
        personeller.set(index, yeni);
        if (eski.equals(takimLideri)) {
            this.takimLideri = yeni;
        }
    }

    public int gorevEkle(String gorevMetni) {
        if (gorevMetni == null || gorevMetni.isBlank())
            throw new IllegalArgumentException("Görev metni boş olamaz");
        gorevler.add(gorevMetni);
        return gorevler.size() - 1;
    }

    public void gorevTamamla(int gorevIndeksi) {
        if (gorevIndeksi < 0 || gorevIndeksi >= gorevler.size()) throw new IndexOutOfBoundsException();
        tamamlananGorevIndeksleri.add(gorevIndeksi);
    }

    public boolean gorevTamamlandiMi(int gorevIndeksi) {
        return tamamlananGorevIndeksleri.contains(gorevIndeksi);
    }
}