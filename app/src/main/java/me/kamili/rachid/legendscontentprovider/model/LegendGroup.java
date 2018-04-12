package me.kamili.rachid.legendscontentprovider.model;

public class LegendGroup {
    private int id;
    private String name;
    private String slogan;
    private String description;
    private String logo;
    private String image;

    public LegendGroup(String name, String slogan, String description, String logo, String image) {
        this.name = name;
        this.slogan = slogan;
        this.description = description;
        this.logo = logo;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
