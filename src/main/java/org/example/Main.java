package org.example;
import java.util.*;
public class Main {
    /*
       1. Є рядок із текстом англійською мовою. Виділити всі унікальні слова.
       Слова, які відрізняються лише регістром букв, вважати однаковими.
       Використовуйте клас HashSet.
       2. Є рядок із текстом англійською мовою. Виділити всі унікальні слова.
       Для кожного слова підрахувати частоту його входження в текст. Слова, які
       відрізняються регістром літер, вважати різними. Використовувати клас
       HashMap.
     */
    public static void main(String[] args) {

        String myText = "Can you can a canned can into an uncanned can like a canner can can a canned can into an uncanned can?";

        HashSet<String> myTextConverted = new HashSet<String>();
        HashMap<String, Integer> myTextWithStatistics = new HashMap<>();
          int repeatCount;

        char[] myDelimiters  = new char[] {',', '.', ':', ';', '!', '?', ' '};
        Arrays.sort(myDelimiters, 0,myDelimiters.length);

        char mySymbol;
        String myWord =  "";
        // creating HashSet and HashMap collection
        for (int myIndex = 0; myIndex < myText.length(); myIndex++) {
            mySymbol = myText.charAt(myIndex);
            if (Arrays.binarySearch(myDelimiters, mySymbol) >= 0){
                if (myWord.length() > 0){
                    repeatCount = 1;
                    // writing word into HashSet
                    myTextConverted.add(myWord.toLowerCase());

                    // writing word into HashMap
                    if (myTextWithStatistics.containsKey(myWord)){
                        repeatCount = myTextWithStatistics.get(myWord);
                        repeatCount++;
                    }
                    myTextWithStatistics.put(myWord, repeatCount);
                    myWord = "";
                }
            }else{
                myWord = myWord + mySymbol;
            }
        }

        System.out.println("Unique words: " + myTextConverted);
        System.out.println("Unique words and frequency of occurrence: " + myTextWithStatistics);

    }
}