package com.DAM1.Blackjack.utils;

public class Menu {
    private final int maxOptions;
    private final String[] options;
    private final String menuTtile;

    public Menu(int maxOptions, String menuTtile , String[] options) {
        this.maxOptions = maxOptions;
        this.options = options;
        this.menuTtile = menuTtile;
    }

    public int execute() {
        int optionChoosed;
        boolean valid;
        System.out.println("************************");
        System.out.println("***" + this.menuTtile + "***");
        System.out.println("************************");
        do {
            for (int i = 0; i < maxOptions; i++) {
                System.out.println(options[i]);
            }
            System.out.println("-------------------------");
            System.out.println("0. Exit");
            optionChoosed = IO.readNumber("Choose an option", 0);
            valid = optionChoosed >= 0 && optionChoosed <= maxOptions;
            if (!valid) {
                System.out.println("Number out of range. Try again");
            }
        }while(!valid);
        return optionChoosed;
    }
}
