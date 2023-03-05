import java.time.LocalDateTime;
import java.util.Scanner;

public class BookingApp {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        NailAppointment appointment = new NailAppointment();
        NailSalon salon = new NailSalon();
        User user = new User();
        Notifier notif = new Notifier();

        System.out.println("Selamat Datang di Aplikasi Polished Perfection!\n");
        System.out.println("Silakan login untuk melanjutkan.");

        System.out.println("Masukkan nama Anda: ");
        String nama = scanner.nextLine();
        user.setNama(nama);
        System.out.println("Masukkan password: ");
        String password = scanner.nextLine();

        user.setLoggedIn(true);

        Thread.sleep(3000);
        System.out.println("\nBerhasil login!");
        Thread.sleep(2000);

        while (user.isLoggedIn()) {
            System.out.println("\nHalo " + user.getNama() + ", silakan pilih layanan yang diinginkan:\n a. Nail Care b. Nail Art");
            System.out.println("\nInsert: ");
            char serviceOption = scanner.next().charAt(0);


            if (serviceOption == 'a') {
                salon.setService("Nail Care");
                salon.setPrice(50000);
            } else if (serviceOption == 'b') {
                salon.setService("Nail Art");
                salon.setPrice(100000);
            }

            System.out.println("\nSilakan pilih Kakak Salon yang kamu mau:\n a. Jane b. Maria");
            System.out.println("\nInsert: ");
            char techOption = scanner.next().charAt(0);


            if (techOption == 'a') {
                salon.setTechnician("Jane");

                System.out.println("\nBerikut jadwal kosong untuk Jane:");
                System.out.println("a. Senin, 6 Maret 2023 (2 PM)");
                System.out.println("b. Rabu, 8 Maret 2023 (10 AM)");

                System.out.println("\nInsert: ");
                char dateOption = scanner.next().charAt(0);

                if (dateOption == 'a') {
                    appointment.setDate(LocalDateTime.of(2023, 3, 6, 14, 0));
                } else if (dateOption == 'b') {
                    appointment.setDate(LocalDateTime.of(2023, 3, 8, 10, 0));
                }

            } else if (techOption == 'b') {
                salon.setTechnician("Maria");

                System.out.println("\nBerikut jadwal kosong untuk Maria:");
                System.out.println("a. Senin, 6 Maret 2023 (11 AM)");
                System.out.println("b. Selasa, 7 Maret 2023 (2 PM)");

                System.out.println("\nInsert: ");
                char dateOption = scanner.next().charAt(0);

                if (dateOption == 'a') {
                    appointment.setDate(LocalDateTime.of(2023, 3, 6, 11, 00));
                } else if (dateOption == 'b') {
                    appointment.setDate(LocalDateTime.of(2023, 3, 7, 14, 00));
                }
            }

            System.out.println("\nTotal harga yang harus dibayarkan adalah sebesar " + salon.getPrice() + ". Silakan pilih metode pembayaran:\n a. m-Banking b. DANA");
            System.out.println("\nInsert: ");
            char paymentOption = scanner.next().charAt(0);

            if (paymentOption == 'a' ){
                MBanking mBanking = new MBanking();

                System.out.println("\n");
                mBanking.pay();

                Thread.sleep(2000);
                System.out.println("\nSedang memproses pembayaran..");
                Thread.sleep(2000);

                if (mBanking.getSaldo() < salon.getPrice() ) {
                    System.out.println("Maaf saldo anda tidak mencukupi.");
                } else {
                    mBanking.setSaldo(mBanking.getSaldo() - salon.getPrice());
                    appointment.setPayed(true);
                    System.out.println("\nPembayaran berhasil dilakukan!");
                    System.out.println("Sisa saldo mBanking Anda sekarang adalah sebesar " + mBanking.getSaldo());
                }
            } else if (paymentOption == 'b') {
                Dana dana = new Dana();

                System.out.println("\n");
                dana.pay();

                Thread.sleep(2000);
                System.out.println("\nSedang memproses pembayaran..");
                Thread.sleep(5000);

                if (dana.getSaldo() < salon.getPrice() ) {
                    System.out.println("Maaf saldo anda tidak mencukupi.");
                } else {
                    dana.setSaldo(dana.getSaldo() - salon.getPrice());
                    appointment.setPayed(true);
                    System.out.println("\nPembayaran berhasil dilakukan!");
                    Thread.sleep(1000);
                    System.out.println("Sisa saldo Dana Anda sekarang adalah sebesar " + dana.getSaldo() + "\n");
                }
            }

            if (appointment.isPayed()) {
                appointment.setConfirmed(true);

                Thread.sleep(2000);
                System.out.println("\n");
                appointment.appointmentProcess();

                Thread.sleep(7000);
                System.out.println("\n");
                appointment.confirmAppointment();

                System.out.println("Detail appointment akan dikirimkan melalui email!");

                Thread.sleep(5000);
                notif.emailNotif();
                Thread.sleep(2000);
                notif.notifAppointment(salon, appointment);
            }

            user.setLoggedIn(false);
        }


    }
}
