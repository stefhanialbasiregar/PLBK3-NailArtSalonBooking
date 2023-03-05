import java.time.LocalDateTime;

public class NailAppointment {
    private LocalDateTime date;
    private boolean payed;
    private boolean confirmed;

    public NailAppointment() {
        confirmed = false;
        payed = false;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public void appointmentProcess() {
        System.out.println("Appointment sedang dibuat.. Mohon menunggu.");
    }

    public void confirmAppointment() {
        System.out.println("Appointment berhasil dibuat!");
    }

}
