package com.vishal.google;


// The game Babylon is a two-player alternating-moves game - like tic-tac-toe, or chess, or go.
// It's played with twelve tiles: three each of four colors.
//
// The tiles start out in 12 stacks of height 1.
// A move consists of combining two stacks: putting one whole stack on top of another.
// You are allowed to combine two stacks if either the heights match, or the top tile colors match.
// You win if you are the last player to move. You lose if it's your turn and there are no moves.
// Write a program to answer the question: who wins, with perfect play? (The first or the second player?)

/*

Move Criteria -> either the height matches, or color of top of tile matches
        12 tiles


        Initially 12 stacks

        int[] stack = new int[12]

        color - [0-3]
        tiles = [0,1,2,3,2,3,1,0,0,1,2,3.....],
        int isPlayer1



[0,1,2,3,2,3,1,0,0,1,2,3.....]

        0,1 2,3

 */

/**
 * class Stack{
 *         int tileNo;
 *         boolean isAvailable;
 *         int color;
 *         int size;
 *         public Stack(int tileNo){
 *             this.tileNo = tileNo;
 *         }
 *     }
 *
 *     private int babylon(int[] tiles){
 *         HashSet<Stack> stacks = new HashSet<>();
 *         for(int i = 0; i < tiles.length; i++){
 *             stacks.add(new Stack(i));
 *         }
 *         babylon(stacks, 0);
 *     }
 *
 *     private int babylon(HashSet<Stack> stacks, int player){
 *         for(int i = 0; i < stacks.size(); i++){
 *             for(int j = i+1; j < stacks.size(); j++){
 *                 Stack stack1 = stacks.get(i);
 *                 Stack stack2 = stacks.get(j);
 *                 boolean isValid = isValidMove(stacks.get(i), stacks.get(j));
 *                 if(isValid){
 *                     stacks.remove(stack1);
 *                     stack1.size += stack2.size;
 *                     stack1.color = stack2.color;
 *                     stacks.add(stack1);
 *                     return babylon(stacks, player == 0? 1: 0);
 *                 }else{
 *                     return player == 0? 1: 0;
 *                 }
 *             }
 *         }
 *     }
 *
 *     private boolean isValidMove(Stack s1, Stack s2){
 *         if(s1.size() == s2.size() || s1.color == s2.color){
 *             return true;
 *         }
 *         return false;
 *     }
 */


