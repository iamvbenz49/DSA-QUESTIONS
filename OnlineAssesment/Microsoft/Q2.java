package MSFT;

public class Q2 {
    public static void main(String[] args) {
        System.out.println(Solution("29162", "10524"));
    }
    public static int Solution(String S, String T) {
        int swaps = 0, LENGTH = S.length();
        if(S.charAt(0) < T.charAt(0)) {
           String temp = S;
           S = T;
           T = temp;
        }
        for(int i = 1; i < LENGTH; i++) {
            char firstDigit = S.charAt(i);
            char secondDigit = T.charAt(i);
            if(firstDigit > secondDigit) {
                swaps++;
            }
        }
        return swaps;
    }
}

// Challenge 1 Description: In this task you are given two strings of digits that represent (possibly very large) 
// integers. Your goal is to make those numbers as close to one another as possible. In other words, you want
// to minimize the absolute value of their difference. You can swap some of the corresponding digits (eg. the first
// digit of the first number with the first digit of the second number, the second digit of the first number with the second 
// digit of the second number, etc.). Swapping the digits is an extremely tiring task, so you want to make as few swaps as
//  possible. Write a function int solution(char *S, char *T); that, given two strings S and T, both of length N, retums the 
//  minimum number of swaps needed to minimize the difference between the two numbers represented by the input strings. For 
//  example, given S="29162" and T="10524" your function should retum 2. We can swap the second and the fourth digits and 
//  obtain "20122" and "19564" The difference between the numbers is 558 and the number of swaps is 2. One can easily c
//  heck that the difference is the smallest possible. Note that we could obtain the same difference by swapping the first, 
//  third and fifth digits, but this solution requires three swaps. Write an efficient algorithm for the following assumptions: 
//  lengths of S and T are equal and within the range [1..100,000] Sand T consist only of digits and no other characters neither S nor T contain leading zeroes. 