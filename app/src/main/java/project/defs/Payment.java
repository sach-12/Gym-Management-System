package project.defs;

public class Payment {
    public int id;
    public PMethods method;
    public int amount;
    public String date;
    public String gstno;

    public Payment(int id, PMethods method, int amount, String date, String gstno) {
        this.id = id;
        this.method = method;
        this.amount = amount;
        this.date = date;
        this.gstno = gstno;
    }

    public int getId() {
        return id;
    }
}
