package com.vishal.atlassian;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
* 🧩 The Problem
You're playing a game on a linear board with numbered positions:

The board has positions from 0 to lastNumber (inclusive).

You start at some position: startPosition.

You can roll a die, which gives you a number from 1 to maxValue.

You move forward that many steps.

If your resulting position goes beyond lastNumber, you are placed at lastNumber instead.

Some board positions are teleporters — when you land on them, you are instantly moved to a different position.

🎯 Goal
After rolling the die once, find all possible final positions you can end up at, considering:

the possible die values (1 to maxValue),

the teleporters,

and the board boundaries.

🧪 Example
Let’s say:

lastNumber = 10

startPosition = 2

maxValue = 6

Teleporters: ["3,1", "5,10", "8,2"]
(meaning: land on 3 → teleport to 1, land on 5 → teleport to 10, land on 8 → teleport to 2)

🧮 Step-by-step Execution
From startPosition = 2, we try every possible die roll from 1 to 6:

Die Roll	Landed On	Teleport?	Final Position
1	3	Yes	1
2	4	No	4
3	5	Yes	10
4	6	No	6
5	7	No	7
6	8	Yes	2

So you could end up at: 1, 2, 4, 6, 7, 10.

But we should also handle the case where startPosition + dieRoll > lastNumber — then you land on lastNumber.

For example:

If startPosition = 9 and die = 3, you'd get to 12, but that’s beyond the board, so you'd land on lastNumber = 10.

✅ Your Task
Implement a function that returns all final positions you can reach after one die roll, taking teleporters and bounds into account.
*
* */
public class TelePorter {

    public static void main(String[] args) {
        int lastNumber = 10;
        int startPosition = 2;
        List<String> teleporters = Arrays.asList("3,1", "5,10", "8,2");
        int maxValue = 6;

        HashSet<Integer> result = getFinalPositions(lastNumber, startPosition, teleporters, maxValue);
        System.out.println("Reachable final positions: " + result);
    }

    private static HashSet<Integer> getFinalPositions(int lastNumber, int startPosition, List<String> teleporters, int maxValue) {
        HashMap<Integer,Integer> telePorters = new HashMap<>();
        for(String teleporter: teleporters){
            Integer telePorterFrom = Integer.valueOf(teleporter.split(",")[0]);
            Integer telePorterTo = Integer.valueOf(teleporter.split(",")[1]);
            telePorters.put(telePorterFrom, telePorterTo);
        }
        HashSet<Integer> result = new HashSet<>();
        for(int roll = 1; roll <= maxValue; roll++){
            int startPosWithRoll = startPosition + roll;
            if(startPosWithRoll > lastNumber){
                startPosWithRoll = lastNumber;
            }
            if(telePorters.containsKey(startPosWithRoll)){
                startPosWithRoll = telePorters.get(startPosWithRoll);
            }
            result.add(startPosWithRoll);
        }
        return result;
    }

}
