package com.company;

public class Letter {

    private char character;

    // Constructors
    public Letter(char character){
        setCharacter(character);
    }

    // Public methods
    public boolean isVowel(){
        if(     character == 'A' || character == 'a' ||
                character == 'E' || character == 'e' ||
                character == 'I' || character == 'i' ||
                character == 'O' || character == 'o' ||
                character == 'U' || character == 'u' ||
                character == 'Y' || character == 'y'
        ){
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        String out = "\n\t\t\tLetter: " + character;
        return out;
    }

    // Getter and Setter
    public void setCharacter(char letter){
        this.character = letter;
    }
    public char getCharacter(){
        return character;
    }
}
