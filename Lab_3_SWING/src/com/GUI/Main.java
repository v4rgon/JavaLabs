package com.GUI;
/**
 * Класс <b>Мейн</b>, необходимый для создания окошка
 * @author v4rgon
 * @version 1.0
 */
public class Main {
    /**
     * Функция входа в программу
     * @param args
     */
    public static void main(String[] args) {
        GUI myGUI = new GUI("Game");
        myGUI.setVisible(true);
    }
}