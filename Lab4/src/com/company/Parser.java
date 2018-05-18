package com.company;

public class Parser {
    private String inputText;

    // Constructors
    public Parser(String inputText){
        setInputText(inputText);
    }

    // Private methods
    private boolean isPunctuation(char c){
        if(c == ',' || c == '.' ||
           c == '!' || c == '?' ||
           c == ';' || c == ':' ||
           c == '\''|| c == '\"'||
           c == '(' || c == ')')
            return true;
        return false;
    }
    // Public methods
    public Text parse() {
        Word word         = new Word();
        Sentence sentence = new Sentence();
        Text text         = new Text();

        for (int i = 0; i < inputText.length(); i++) {
            if(!isPunctuation(inputText.charAt(i))){
                if(inputText.charAt(i) == ' '){
                    if(word.getSize() > 0){
                        sentence.addLexem(word);
                    }
                    word = new Word();
                }else{
                    Letter letter = new Letter(inputText.charAt(i));
                    word.addLetter(letter);
                }
            }else{
                Punctuation punctuation = new Punctuation(inputText.charAt(i));

                if(word.getSize() != 0){
                    sentence.addLexem(word);
                }
                sentence.addLexem(punctuation);
                word = new Word();
                if(inputText.charAt(i) == '.' || inputText.charAt(i) == '?' || inputText.charAt(i) == '!') {
                    text.addSentence(sentence);
                    sentence = new Sentence();
                }
            }
        }

        return text;
    }
    // Setters and getters
    public void setInputText(String inputText){
        this.inputText = inputText;
    }
    public String getInputText(){
        return inputText;
    }
}
