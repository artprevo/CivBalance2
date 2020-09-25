package Tool;

import java.util.ArrayList;

public class Civ {
    private String name;
    private ArrayList<Integer> tierList;

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    private int civ_id;
    private String leader;

    public int getCiv_id() {
        return civ_id;
    }

    public void setCiv_id(int civ_id) {
        this.civ_id = civ_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getTierList() {
        return tierList;
    }

    public void setTierList(ArrayList<Integer> tierList) {
        this.tierList = tierList;
    }

    public void addToTierList(int x) {
        this.tierList.add(x);
    }
}
