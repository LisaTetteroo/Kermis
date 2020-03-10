package nl.workingtalent.asopos.model;

public class Boat {

    private long boatID;
    private String name;
    private String type;
    private String weightClass;
    private boolean topTeamBoat;
    private boolean privateBoat;
    private boolean available = true;

    public long getBoatID() {
        return boatID;
    }

    public void setBoatID(long boatID) {
        this.boatID = boatID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWeightClass() {
        return weightClass;
    }

    public void setWeightClass(String weightClass) {
        this.weightClass = weightClass;
    }

    public boolean isTopTeamBoat() {
        return topTeamBoat;
    }

    public void setTopTeamBoat(boolean topTeamBoat) {
        this.topTeamBoat = topTeamBoat;
    }

    public boolean isPrivateBoat() {
        return privateBoat;
    }

    public void setPrivateBoat(boolean privateBoat) {
        this.privateBoat = privateBoat;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "boatID=" + boatID +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", weightClass='" + weightClass + '\'' +
                ", topTeamBoat=" + topTeamBoat +
                ", privateBoat=" + privateBoat +
                ", available=" + available +
                '}';
    }
}
