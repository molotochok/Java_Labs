package com.company;

public class Sentence {

    private LinkedList<ILexem> lexems;
    private int size;

    // Constructors
    public Sentence(){
        lexems = new LinkedList<ILexem>();
        size   = lexems.size();
    }
    public Sentence(LinkedList<ILexem> lexems){
        setLexems(lexems);
    }

    //Public methods
    public void addLexem(ILexem lexem){
        lexems.pushBack(lexem);
    }
    public void clear(){
        lexems.clear();
    }
    @Override
    public String toString() {
        String out = "\n\tSentence:" + lexems.toString();
        return out;
    }

    // Setter and getter
    public void setLexems(LinkedList<ILexem> lexems){
        this.lexems = lexems;
        this.size   = lexems.size();
    }
    public LinkedList<ILexem> getLexems(){
        return lexems;
    }
    public int getSize(){
        return size;
    }
}
