package com.nosbielc.estudos.aws;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cleibson Gomes (https://github.com/Nosbielc) ON 05/01/2020
 * @project EstudosJDK8
 */
public class Desafio1 {

    public static void main(String[] args) {
        int[] array1 = new int[]{1,0,0,0,0,1,0,0};
        //expected 0 1 0 0 1 0 1 0

        System.out.println(cellCompete(array1, 1));

        int[] array2 = new int[]{1,1,1,0,1,1,1,1};
        //expected 0 0 0 0 0 1 1 0
        System.out.println(cellCompete(array2, 2));

    }

        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static List<Integer> cellCompete(int[] states, int days)
    {
        List<Integer> inteiros = new ArrayList<>();
        int internalDay = 1;
        do {
            int[] statesNew = states;

            if (internalDay > 1) {
                statesNew = new int[8];
                for(int i = 0; i <= 7; i++) {
                    statesNew[i] = inteiros.get(i);
                }
            }

            inteiros = new ArrayList<>();
            inteiros.add((statesNew[1] == statesNew[7]) ? 0 : 1);//0
            inteiros.add((statesNew[0] == statesNew[2]) ? 0 : 1);//1
            inteiros.add((statesNew[1] == statesNew[3]) ? 0 : 1);//2
            inteiros.add((statesNew[2] == statesNew[4]) ? 0 : 1);//3
            inteiros.add((statesNew[3] == statesNew[5]) ? 0 : 1);//4
            inteiros.add((statesNew[4] == statesNew[6]) ? 0 : 1);//5
            inteiros.add((statesNew[5] == statesNew[7]) ? 0 : 1);//6
            if (days == 1 || internalDay > 1) {
                inteiros.add((statesNew[6] == inteiros.get(0)) ? 0 : 1);//7
            } else {
                inteiros.add((statesNew[6] == statesNew[0]) ? 0 : 1);//7
            }

            internalDay++;
        } while (internalDay <= days );

        return inteiros;
    }

}
