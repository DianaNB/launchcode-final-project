package com.launchcode.adrienne.FinalProjectTest.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Post {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Please enter a name")
    private String snakeName;

    @NotBlank(message = "Please enter a title")
    private String title;

    @NotBlank(message = "Please enter a description")
    @Size(max =65535)
    private String description;

    @NotBlank(message = "Please enter male or female")
    private String sex;

    private int age;

    private Snake snake;

    public Post() {
    }

    public Post(int id, String snakeName, String title, String description, String sex, int age) {

        this.id = id;
        this.snakeName = snakeName;
        this.title = title;
        this.description = description;
        this.sex = sex;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSnakeName() {
        return snakeName;
    }

    public void setSnakeName(String snakeName) {
        this.snakeName = snakeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }
}
