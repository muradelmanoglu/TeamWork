package Mentor.Ayliq;

import java.util.Random;
import java.util.Scanner;

public class ErpSimulyasiyasi {
    public static void main(String[] args) {

        double ilkinBüdcə = 0.0;
        int komandaPerformansı = 0;
        int layihəMərhələsi = 1;
        double texnikiBorc = 0.0;
        String layihəMeneceriAd = "";
        boolean layihəUğursuz = false;
        int kritikModulXətası = 0;


        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Layihə Menecerinin adı: ");
        layihəMeneceriAd = sc.nextLine();
        System.out.println("\nSalam, Menecer " + layihəMeneceriAd + "!");
        ilkinBüdcə = 100000 + (Math.random() * 100000.0);
        System.out.printf("Layihənin ilkin büdcəsi: %.2f Azn", ilkinBüdcə);

        komandaPerformansı = random.nextInt(50) + 50;
        System.out.println("\nKomanda Performansı: " + komandaPerformansı);

        if (komandaPerformansı < 65) {
            System.out.println("Komandanın Təlimə Ehtiyacı var!");
        } else {
            System.out.println("Komanda Performansı yaxşıdır.");
        }

        double ilkinTəhcizatXərci = ilkinBüdcə * 0.05;
        ilkinBüdcə -= ilkinTəhcizatXərci;
        System.out.printf("İlkin təhcizat Xərci: %.2f Azn, \nQalan büdcə: %.2f Azn\n", ilkinTəhcizatXərci, ilkinBüdcə);

        System.out.println("- - - - - 2. ERP Tətbiqi Fazaları (5 Modul) - - - - -");
        int toplamModulSayı = 5;

        for (int i = 0; i < 5; i++) {
            System.out.println("Modul: " + (i + 1) + " icra edilir." + " (Mərhələ " + layihəMərhələsi + ")");
            System.out.println("-------------------------------------------------------------------------------");

            double mərhələXərci = ilkinBüdcə * 0.05 * (1 + (layihəMərhələsi * 0.05));
            ilkinBüdcə -= mərhələXərci;
            System.out.printf("Mərhələ Xərci: %.2f AZN \nQalan Büdcə: %.2f AZN\n", mərhələXərci, ilkinBüdcə);
            layihəMərhələsi++;

            komandaPerformansı -= random.nextDouble(3) + 1;
            if (komandaPerformansı > 1) komandaPerformansı = 1;

            if (random.nextDouble() < 0.20) {
                texnikiBorc += 8000.0;

                System.out.printf("Texniki Problem baş verdi: %.2f Azn\n", texnikiBorc);
            }

            if (ilkinBüdcə < 100000) {
                layihəUğursuz = true;
                System.out.println("Büdcə həddi aşıldı (<100000 Azn). Layihə Uğursuz!");
                System.out.println("-------------------------------------------------------------------------------\n");
                break;
            }

            if (texnikiBorc > 15000) {
                komandaPerformansı -= 10;
                if (komandaPerformansı > 1) komandaPerformansı = 1;
                System.out.println("\nTexniki Borc yüksəkdir (> 20000.0 AZN). Performans azaldı.");
            }
            System.out.println("-------------------------------------------------------------------------------\n");
        }
    }
}
