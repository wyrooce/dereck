package chixa.ir;

/**
 * Created by MORTEZA.UM on 9/8/2015.
 */
public class Partaker {
    private int id;
    private float amount;
    private float quota = 100;

    public float getQuota() {
        return quota;
    }

    public void setQuota(float quota) {
        this.quota = quota;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public Partaker(int id, int amount, int quota) {
        this.id = id;
        this.amount = amount;
        this.quota = quota;
    }
}
