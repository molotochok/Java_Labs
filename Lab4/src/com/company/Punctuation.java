package com.company;

public class Punctuation implements ILexem {
    private char punctuation;

    // Constructors
    public Punctuation(char punctuation){
        setPunctuation(punctuation);
    }

    // Public methods
    @Override
    public String toString() {
        String out = "\n\t\tPunctuation: " + punctuation;
        return out;
    }

    // Getter and setter
    public void setPunctuation(char punctuation){
        this.punctuation = punctuation;
    }
    public  char getPunctuation(){
        return punctuation;
    }
}
