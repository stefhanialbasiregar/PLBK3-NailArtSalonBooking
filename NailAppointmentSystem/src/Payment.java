public interface Payment {

    public void pay() throws InterruptedException;
    public int getSaldo();
    public void setSaldo(int saldo);
}
