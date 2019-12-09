package com.launchcode.adrienne.FinalProjectTest.models;

public enum Snake {
    BALL_PYTHON("Ball Python", "Python"),
    RETICULATED_PYTHON("Reticulated Python", "Python"),
    BURMESE_PYTHON("Burmese Python","Python"),
    SAND_BOA("Sand Boa","Boa"),
    BOA_CONSTRICTOR("Boa Constrictor","Boa"),
    AMAZON_TREE_BOA("Amazon Tree Boa","Boa"),
    EMERALD_GREEN_TREE_BOA("Emerald Green Tree Boa","Boa"),
    CORN_SNAKE("Corn Snake","Colubrid"),
    RAT_SNAKE("Rat Snake","Colubrid"),
    INDIGO_SNAKE("Indigo Snake","Colubrid"),
    KING_SNAKE("Kingsnake","Colubrid"),
    GRASS_SNAKE("Grass Snake", "Colubrid"),
    LADDER_SNAKE("Ladder Snake", "Colubrid"),
    EGG_EATING_SNAKE("Egg Eating Snake","Colubrid");


    String name;
    String category;


    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    Snake(String name, String category) {
            this.name = name;
            this.category = category;
    }
}
