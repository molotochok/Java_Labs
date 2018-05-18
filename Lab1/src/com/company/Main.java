package com.company;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        byte i = 0,j = 0;
        byte n, m;
        final byte c = 2;
        Scanner in = new Scanner(System.in);

        try{
            //Get n
            System.out.print("n= ");
            if(!in.hasNextByte()){
                throw new Exception("n must be of type: byte");
            }
            n = in.nextByte();
            if(n < 0){
                throw new Exception("n can't be less than 0");
            }
            //Get m
            System.out.print("m= ");
            if(!in.hasNextByte()){
                throw new Exception("m must be of type: byte");
            }
            m = in.nextByte();
            if(m < 0){
                throw new Exception("m can't be less than 0");
            }

            float s = 0;
            //Find s
            for(i = 0;i <= n;i++){
                if(i == -128)
                    break;
                for(j=0;j <= m;j++){
                    if(j == -128)
                        break;
                    float tempDifference = (float)(i - j);
                    float tempSum        = (float)(i + c);
                    if(tempSum == 0){
                        throw new Exception("Can't divide by zero");
                    }
                    s += tempDifference / tempSum;
                }
            }
            System.out.println(s);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}