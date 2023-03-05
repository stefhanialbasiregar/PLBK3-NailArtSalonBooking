public class MBanking implements Payment {
    private int saldo = 200000;

    @Override
    public void pay() throws InterruptedException {
        System.out.println("menghubungkan dengan akun mBanking Anda..");
        Thread.sleep(2000);
        System.out.println("\nterhubung!");
        System.out.println("Sisa saldo Anda adalah sebesar: " + saldo);
    }

    @Override
    public int getSaldo() {
        return saldo;
    }

    @Override
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
