# Puzzles-BoardDistance

Calculate maximum board distance

## Problem Description (Codility)

You are given an array board of length N, describing subsequent positions on a game
board from left to right. Every position is either empty (represented by 0 in the array)
or contains a single game piece (represented by 1). Each game piece can be moved at
most once. A move means going one or more positions to either the left or the right.
Pieces cannot capture (occupy another piece's position) or jump over each other.
When the game piece is moved by X positions (either left or right), we say it travels
distance X. Also, pieces can be moved in any order, but they must be moved only one
at a time.

What is the maximum possible distance that the game pieces can travel altogether?

Write a function:

class Solution { public int solution(int [] board); }

that, given an array board consisting of N integers (0s and/or 1s), returns the
maximum total distance the game pieces can travel altogether, under the constraint
that each of them is moved at most once.

Examples:

1. Given board = [1,1,0,0,1], your function should return 4. The piece at position 0
cannot be moved at first, but after moving the piece at position 1 to position 3, the
former can be moved to position 2. The row ends in the following configuration:
[0,0,1,1,1]. Total traveled distance is 2 + 2 = 4. There are no combinations of moves that
would produce a larger total.

2. Given board = [0,1], your function should return 1. The only piece can be moved one
position to the left.

3. Given board = [0,0,0], your function should return 0. There are no pieces, so nothing
can be moved.

Write an efficient algorithm for the following assumptions:

- N is within the range of [0..40,000]
- array board contains only 1 and/or 0
