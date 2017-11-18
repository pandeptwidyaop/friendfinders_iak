package id.pandeptwidyaop.friendfinders.Models;

/**
 * Created by John Doe on 11/18/2017.
 */

public class User {
    private String name;
    private String imageUrl;

    public User() {

    }

    public User(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}
