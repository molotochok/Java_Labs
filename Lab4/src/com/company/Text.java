package com.company;

public class Text {
    private LinkedList<Sentence> sentences;
    private int size;
    //Constructors
    public Text(){
        sentences = new LinkedList<Sentence>();
        size      = sentences.size();
    }
    public Text(LinkedList<Sentence> sentences){
        setSentences(sentences);
    }

    // Public methods
    public void addSentence(Sentence sentence){
        sentences.pushBack(sentence);
    }
    @Override
    public String toString() {
        String out = "Text:" + sentences.toString();
        return out;
    }

    // Getter and setter
    public void setSentences(LinkedList<Sentence> sentences){
        this.sentences = sentences;
        this.size      = sentences.size();
    }
    public LinkedList<Sentence> getSentences(){
        return sentences;
    }
    public int getSize(){
        return size;
    }
}
