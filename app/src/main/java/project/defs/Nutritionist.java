package project.defs;

import java.util.ArrayList;

public class Nutritionist extends Staff {
    private ArrayList<Member> members;

    public Nutritionist(int id, String name, String phno, int salary) {
        super(id, name, phno, salary);
        members = new ArrayList<Member>();
    }

    public Nutritionist(int id, String name, String phno, int salary, ArrayList<Member> members) {
        super(id, name, phno, salary);
        this.members = members;
    }

    public Nutritionist addMember(Member member) {
        members.add(member);
        return this;
    }

    public String getMembers() {
        int[] ids = new int[members.size()];
        String retString = "";
        for (int i = 0; i < members.size(); i++) {
            ids[i] = members.get(i).getId();
        }
        for (int i = 0; i < ids.length; i++) {
            retString += ids[i] + ", ";
        }
        return retString;
    }

    public int getId() {
        return id;
    }
}
