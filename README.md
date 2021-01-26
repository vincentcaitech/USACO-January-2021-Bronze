# USACO Bronze January 2021

## About

All three USACO Bronze problems from the January 2021 contest, in Java. All are complete solutions that passed all the test cases.

## Summary Explanations

Below are summary explanations for each problem. See each problem's code for a detailed breakdown of each step in the comments.

### Problem 1

For every letter in the desired string, in order, find it in the alphabet. For every letter after the first, pick up after the previous, and if the letter is not found, increment total count by 1 and start from beginning of the alphabet. Print out the total count;

### Problem 2

Start out with every photo in its own group. Count the number of even and odd groups (aka the number of even and odd numbers).

**Goal is to get same number of odds and evens or one more even than odd, with the maximum amount of groups.**

**Special case:** If there is one more odd than even, put together two odd groups to form one more even group, and this satisfies the goal.

**If there are too many odds,** repeat the following process: take two odd groups, add them, and place them into a separate even group. Repeat until reach goal (or special case)

**If there are too many evens,** repeat the following proccess: take two even groups and put them together into one group. Repeat until reach goal.

NOTE: These are both optional solutions because you decrease the total number of groups by the minimum amount, 1, while bringing you closer to the goal

## Problem 3:

Sort all the stalls by height, increasing. Then for each stall, starting from the shortest, find the number of cows that can possibly fit into that stall, that are not already used in a previously checked stall (fore each stall you check, that is one less cow you can use for all future stalls you check, which will either be same height or taller). Multiply the number of possible cows for each stall to get an answer.
