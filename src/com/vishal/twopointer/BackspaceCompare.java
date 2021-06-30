package com.vishal.twopointer;

class BackspaceCompare {

    public static boolean compare(String str1, String str2) {
        int ptr1 = str1.length() - 1, ptr2 = str2.length() - 1;
        while(ptr1 >= 0 && ptr2 >= 0){
            ptr1 = skipBackSpaces(str1, ptr1);
            ptr2 = skipBackSpaces(str2, ptr2);
            if(ptr1 < 0 && ptr2 < 0)
                return true;
            if(ptr1 < 0 || ptr2 < 0)
                return false;
            if(str1.charAt(ptr1) != str2.charAt(ptr2))
                return false;
            ptr1--;ptr2--;
        }
        return ptr1 == ptr2;
    }

    private static int skipBackSpaces(String str, int ptr){
        int runningCount = 0;
        while(str.charAt(ptr) == '#'){
            ptr--;
            runningCount++;
        }
        ptr = ptr - (runningCount - 1);
        return ptr;
    }

    public static void main(String[] args) {
        String str1 = "abc###";
        String str2 = "ab#bc##";
        System.out.print(compare(str1, str2));
    }
}

