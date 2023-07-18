/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

/**
 *
 * @author Pedro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {     
        String[] mensagem1 = {"init", "stop_words.txt"};
        String[] mensagem2 = {"run"};
        WordFrequencyController wfController = new WordFrequencyController();
        wfController.dispatch(mensagem1);
        wfController.dispatch(mensagem2);
    }
}