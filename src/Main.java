import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Örnek personeller
        Personel lider = new Erkek("Ahmet", "Yılmaz", LocalDate.of(1988, 3, 14));
        Personel p1 = new Kadin("Ayşe", "Demir", LocalDate.of(1995, 7, 2));
        Personel p2 = new Erkek("Mehmet", "Kara", LocalDate.of(1992, 1, 20));

        // Departman
        Department yazilim = new Department("Yazılım", lider);
        yazilim.personelEkle(p1);
        yazilim.personelEkle(p2);

        yazilim.liderDegistir(p2); // yeni lider: Mehmet

        // Görevler
        int g1 = yazilim.gorevEkle("Yeni sürüm planı çıkar");
        int g2 = yazilim.gorevEkle("Müşteri bug fix");
        yazilim.gorevTamamla(g2);

        // Çıktı
        System.out.println("Departman: " + yazilim.getAd());
        System.out.println("Takım Lideri: " + yazilim.getTakimLideri());
        System.out.println("Personeller:");
        for (int i = 0; i < yazilim.getPersoneller().size(); i++) {
            Personel p = yazilim.getPersoneller().get(i);
            System.out.printf("- %s, Emekliliğe kalan yıl: %d%n", p, p.emekliligeKalanYil());
        }

        System.out.println("\nGörevler:");
        for (int i = 0; i < yazilim.getGorevler().size(); i++) {
            String metin = yazilim.getGorevler().get(i);
            boolean done = yazilim.gorevTamamlandiMi(i);
            System.out.printf("%d) %s %s%n", i, metin, done ? "(TAMAMLANDI)" : "");
        }
    }
}