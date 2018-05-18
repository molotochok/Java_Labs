package com.company;

import java.util.Scanner;

public class Main {

    public static boolean isVowel(char letter){
        letter = Character.toLowerCase(letter);
        switch (letter){
            case 'a':
            case 'e':
            case 'o':
            case 'i':
            case 'u':
            case 'y': return true;
            default: return false;
        }
    }

    public static void outputArray(String[] arr, String name){
        System.out.println(name);

        for (String word : arr) {
            System.out.print(word + ' ');
        }

        System.out.println();
    }

    public static  String[] getLowelWords(String[] words){
        String lowelString = "";

        for (String word: words) {
            if(isVowel(word.charAt(0)) && word.length() > 1){
                lowelString += word + " ";
            }
        }
        return lowelString.split(" ");
    }
    public static String[] sortByIndex(String[] arr){
        for(int i = 0; i < arr.length - 1;i++){
            for(int j = 0; j < arr.length - i - 1;j++){
                if(arr[j].charAt(1) > arr[j+1].charAt(1)){
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input text:");
	    String text = in.nextLine();
        String[] words = text.split("\\W+");

        outputArray(words, "Words");

        String[] lowelWords = getLowelWords(words);

        System.out.println("-------------------------");
        outputArray(lowelWords,"Words which length > 1 and start with lowel letter:");

        //Sort
        lowelWords = sortByIndex(lowelWords);

        System.out.println("-------------------------");

        outputArray(lowelWords, "Sorted by second letter:");
    }
}
