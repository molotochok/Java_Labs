package com.company;

public class Word implements ILexem{

    private LinkedList<Letter> letters;
    private int size;

    // Constructor
    public Word(){
        letters = new LinkedList<>();
        size    = letters.size();
    }
    public Word(LinkedList<Letter> letters){
        setLetters(letters);
        size = letters.size();
    }

    // Public methods
    public void addLetter(Letter letter){
        letters.pushBack(letter);
        size++;
    }
    @Override
    public String toString() {
        String out = "\n\t\tWord:" + letters.toString();
        return out;
    }
    // Getter and setter
    public void setLetters(LinkedList<Letter> letters){
        this.letters = letters;
        size = letters.size();
    }
    public LinkedList<Letter> getLetters(){
        return letters;
    }
    public int getSize(){
        return size;
    }
}
