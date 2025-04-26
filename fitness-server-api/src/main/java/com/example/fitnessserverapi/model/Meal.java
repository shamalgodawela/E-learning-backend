package com.example.fitnessserverapi.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Meal")

public class Meal {


    @Id
    private String _id;  // corrected variable name
    private String title;
    private String image;
    private String desc;
    private String ingredients;
    private String nutrition;

    public Meal(String _id, String title, String image, String desc, String ingredients, String nutrition) {
        this._id = _id;
        this.title = title;
        this.image = image;
        this.desc = desc;
        this.ingredients = ingredients;
        this.nutrition = nutrition;
    }

    public Meal() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getNutrition() {
        return nutrition;
    }

    public void setNutrition(String nutrition) {
        this.nutrition = nutrition;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "_id='" + _id + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", desc='" + desc + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", nutrition='" + nutrition + '\'' +
                '}';
    }


}
