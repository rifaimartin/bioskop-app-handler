package com.bioskop.app.model;

public class Film {
    private String title;
    private String description;
    private String imagePath;

    public Film(String title, String description, String imagePath) {
        this.title = title;
        this.description = description;
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public String toString() {
        return title;
    }
}
