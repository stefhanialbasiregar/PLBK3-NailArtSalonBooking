public class Notifier {
    private NailSalon salon;
    private NailAppointment appointment;

    public void emailNotif() {
        System.out.println("\nSatu email masuk diterima!");
    }

    public void notifAppointment(NailSalon salon, NailAppointment appointment) {
        System.out.println("\n====================");
        System.out.println("Berikut adalah detil appointment: ");
        System.out.println("Appointment ID: 001");
        System.out.println("Jadwal: " + appointment.getDate());
        System.out.println("Salon Technician: " + salon.getTechnician());
        System.out.println("Service: " + salon.getService());
        System.out.println("\n====================");
    }
}
