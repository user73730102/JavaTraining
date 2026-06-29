package asign5;

public class Team {
    private String key;
    private String name;
    private String city;

    public Team(String key, String name, String city) {
        this.key = key;
        this.name = name;
        this.city = city;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return name + " (" + city + ") [" + key.toUpperCase() + "]";
    }
}
