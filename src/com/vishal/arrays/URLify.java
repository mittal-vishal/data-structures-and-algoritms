package com.vishal.arrays;

public class URLify {

    public char[] encode(char[] urlArray){
        int actualLength = urlArray.length - 1;
        int charLength = actualLength;

        while(urlArray[charLength] == ' '){
            charLength--;
        }

        while(charLength > -1){
            if(urlArray[charLength] != ' '){
                urlArray[actualLength] = urlArray[charLength];
                actualLength--;
                charLength--;
            }else{
                charLength--;
                urlArray[actualLength--] = '0';
                urlArray[actualLength--] = '2';
                urlArray[actualLength--] = '%';
            }
        }

        return urlArray;

    }

    public static void main(String[] args) {
        URLify urlify = new URLify();
        char[] url = {'w','o','r','k','s',' ', 'a', 't', ' ', 'g','o','o','g','l','e', ' ',' ', ' ', ' ',' '};
        System.out.print(urlify.encode(url));
    }

}
