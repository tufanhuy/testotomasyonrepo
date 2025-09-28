import java.util.Scanner;

public class MaasHesaplama {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan gün sayısını al
        System.out.print("Lütfen çalıştığınız gün sayısını giriniz: ");
        int gunSayisi = scanner.nextInt();

        int gunlukUcret = 2000;

        int prim = (gunSayisi > 25)
                ? (5 * 1000 + (gunSayisi - 25) * 3000)
                : (gunSayisi > 20)
                ? (gunSayisi - 20) * 1000
                : 0;

        int toplamMaas2 = gunSayisi * gunlukUcret + prim;
        System.out.println("Toplam Maaş: " + toplamMaas2 + " TL");
    }
}