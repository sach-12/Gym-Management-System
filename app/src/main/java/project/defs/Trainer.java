package project.defs;

import java.util.ArrayList;

public class Trainer extends Staff {
    // arraylist of members
    private ArrayList<Member> members;

    public Trainer(int id, String name, String phone, int salary) {
        super(id, name, phone, salary);
        members = new ArrayList<Member>();
    }

    public Trainer(int id, String name, String phno, int salary, ArrayList<Member> members) {
        super(id, name, phno, salary);
        this.members = members;
    }

    public Trainer addMember(Member member) {
        members.add(member);
        return this;
    }

    public String getMembers() {
        int[] ids = new int[members.size()];
        for (int i = 0; i < members.size(); i++) {
            ids[i] = members.get(i).getId();
        }
        String retString = "";
        for (int i = 0; i < ids.length; i++) {
            retString += ids[i] + ", ";
        }
        return retString;
    }

    public int getId() {
        return id;
    }
}
