// Given two integer values n and r, the task is to find the value of Binomial Coefficient nCr

//     A binomial coefficient nCr can be defined as the coefficient of x^r in the expansion of (1 + x)^n that gives the number of ways, disregarding order, that r objects can be chosen from among n. 
//     The binomial coefficient nCr is calculated as : C(n,r) = n! / r! * (n-r) !

// Note: If r is greater than n, return 0.

// Examples:

// Input: n = 5, r = 2
// Output: 10
// Explaination: The value of 5C2 is calculated as 5!/(5−2)!*2! = 5!/3!*2! = 10.

// Input: n = 2, r = 4
// Output: 0
// Explaination: Since r is greater than n, thus 2C4 = 0

// Input: n = 5, r = 0
// Output: 1
// Explaination: The value of 5C0 is calculated as 5!/(5−0)!*0! = 5!/5!*0! = 1. 


class Solution {
    public int nCr(int n, int r) {
        // code here
        if(r > n) {
            return 0;
        }
        long ans = 1;
        for(int i = 1; i <= n - r; i++) {
            ans *= n - i + 1;
            ans /= i;
        }
        return (int)ans;
    }
}
// GPT ref - https://chatgpt.com/share/67ee843d-5f30-8008-b141-9cacd67cd64c
// 1. Permutations: P(n,r)P(n,r) (Order Matters)
// P(n,r)=n!(n−r)!
// P(n,r)=(n−r)!n!​

//     Meaning: The number of ways to choose and arrange rr elements from nn.

//     Why this formula?

//         n!n! counts all arrangements of nn elements.

//         Dividing by (n−r)!(n−r)! removes the arrangements of the n−rn−r elements we didn’t pick.

// Combinations: C(n,r)C(n,r) (Order Doesn't Matter)
// C(n,r)=n!r!(n−r)!
// C(n,r)=r!(n−r)!n!​

//     Meaning: The number of ways to choose rr elements from nn, ignoring order.

//     Why this formula?

//         Start with P(n,r)P(n,r) (which considers order).

//         Since order doesn’t matter, each selection is counted r!r! times (one for each arrangement).

//         We divide by r!r! to remove duplicate orderings.