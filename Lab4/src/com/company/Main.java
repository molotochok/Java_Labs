package com.company;

import java.util.Scanner;

public class Main {

    // Finds all words which begins with vowel letter in the text and sores tham in the List<Word>
    public static LinkedList<Word> getVowelWords(Text text){
        LinkedList<Word> result = new LinkedList<Word>();

        LinkedList<Sentence>.Node<Sentence> tempSentence = text.getSentences().getHead();
        while(tempSentence != null){
            LinkedList<ILexem>.Node<ILexem> lexemNode = tempSentence.getData().getLexems().getHead();
            while(lexemNode != null){
                if(lexemNode.getData() instanceof Word){
                    LinkedList<Letter>.Node<Letter> letterNode = ((Word) lexemNode.getData()).getLetters().getHead();

                    if(letterNode.getData().isVowel()){
                        result.pushBack((Word)lexemNode.getData());
                    }

                }
                lexemNode = lexemNode.getNext();
            }
            tempSentence = tempSentence.getNext();
        }
        return result;
    }
    // Stores elements from list into array of type Word
    public static Word[] fromListToArray(LinkedList<Word> wordLinkedList){
        int k = 0;
        Word[] result = new Word[wordLinkedList.size()];
        LinkedList<Word>.Node<Word> temp = wordLinkedList.getHead();

        while (temp != null){
            result[k] = temp.getData();
            k++;
            temp = temp.getNext();
        }
        return result;
    }
    // Sorts Word arr by second letter (if letter is only one it stores it in the beginning of the array)
    public static Word[] sortWordArr(Word[] arr){
        for(int i = 0; i < arr.length - 1;i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                LinkedList<Letter>.Node<Letter> temp1 = arr[j].getLetters().getHead();

                LinkedList<Letter>.Node<Letter> temp2 = arr[j+1].getLetters().getHead();

                if(temp2.getNext() == null){
                    if(temp1.getNext() == null){
                        continue;
                    }
                    Word tempWord = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tempWord;
                    continue;
                }
                if(temp1.getNext() == null){
                    continue;
                }

                temp1 = temp1.getNext();
                temp2 = temp2.getNext();
                if (temp1.getData().getCharacter() > temp2.getData().getCharacter()){
                    Word tempWord = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tempWord;
                }
            }
        }
        return arr;
    }
    // Output array
    public static void outputArr(Word[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        // Get input string
        Scanner in = new Scanner(System.in);
        System.out.println("Input some text:");
        String inputString = in.nextLine();

        //Parse string
        Parser parser = new Parser(inputString);
        Text text = parser.parse();

        System.out.println(text.toString());

        // Find all words that begin with vowel letter
        LinkedList<Word> vowelWordList = getVowelWords(text);
        System.out.print("----------Words that begin with vowel letter----------");
        System.out.println(vowelWordList);

        // Sort vowel words by the second letter
        Word[] vowelWords = fromListToArray(vowelWordList);
        vowelWords = sortWordArr(vowelWords);
        System.out.print("----------Sorted by second letter----------");
        outputArr(vowelWords);
    }
}
