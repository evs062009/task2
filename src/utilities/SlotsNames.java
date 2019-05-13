package utilities;

public enum SlotsNames {
    FROM("slot_a"), TO("slot_c"), TRANSIT("slot_b");

    private String name;

    SlotsNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
