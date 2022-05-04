package project.defs;

public class Member {
    public int id;
    public String name;
    public int phone;
    public String address;
    public MPlans plan;

    public Member(int id, String name, int phone, String address, MPlans plan) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.plan = plan;
    }

    public int getId() {
        return id;
    }
}
