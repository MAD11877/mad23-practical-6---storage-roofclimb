package sg.edu.np.mad.week4practical;


public class User {
    public String name;
    public String description;
    public int id;
    public boolean followed;
    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }

    public boolean getFollowed() {return followed;}

    public void setFollowed(boolean followed)
    {
        this.followed = followed;
    }

    public User(String name, String description, int id, boolean followed) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.followed = followed;
    }
}

