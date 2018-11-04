/*
package controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    */
/**Test af 'getCurrentRollScore()'
     * Tests if Random() class gives random numbers within an approximated failure rate of 5% of what is estimated.
     * Tests this by trying it 100.000 times
     *//*

    @Test
    void testRandomNumberGenerated() {
        // Arrange
        Game roll = new Game();
        int count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, count7 = 0,
                count8 = 0, count9 = 0, count10 = 0, count11 =0, count12 = 0;
        //Expected result of dice rolls, calculated by number of dice rolls times theoretical odds of hitting the numbers
        int expect2and12 = 100000*(1/36);
        int expect3and11 = 100000*(2/36);
        int expect4and10 = 100000*(3/36);
        int expect5and9 = 100000*(4/36);
        int expect6and8 = 100000*(5/36);
        int expect7 = 100000*(6/36);
        //Expected deviation on 5% of expected result
        int dExpect2and12 = (100000*1/36)*5/100;
        int dExpect3and11 = (100000*2/36)*5/100;
        int dExpect4and10 = (100000*3/36)*5/100;
        int dExpect5and9 = (100000*4/36)*5/100;
        int dExpect6and8 = (100000*5/36)*5/100;
        int dExpect7 = (100000*6/36)*5/100;

        // Act
        for(int i = 0; i < 100000; i++) {
            roll.playRound();
            int num = roll.getCurrentRollScore();

            assertTrue(num > 1 && num < 13);
            switch (num) {
                case 2:
                    count2++;
                    break;
                case 3:
                    count3++;
                    break;
                case 4:
                    count4++;
                    break;
                case 5:
                    count5++;
                    break;
                case 6:
                    count6++;
                    break;
                case 7:
                    count7++;
                    break;
                case 8:
                    count8++;
                    break;
                case 9:
                    count9++;
                    break;
                case 10:
                    count10++;
                    break;
                case 11:
                    count11++;
                    break;
                case 12:
                    count12++;
                    break;
            }
        }
        // Assert
        assertEquals(expect2and12, count2, dExpect2and12);
        assertEquals(expect3and11, count3, dExpect3and11);
        assertEquals(expect4and10, count4, dExpect4and10);
        assertEquals(expect5and9, count5, dExpect5and9);
        assertEquals(expect6and8, count6, dExpect6and8);
        assertEquals(expect7, count7, dExpect7);
        assertEquals(expect6and8, count8, dExpect6and8);
        assertEquals(expect5and9, count9, dExpect5and9);
        assertEquals(expect4and10, count10, dExpect4and10);
        assertEquals(expect3and11, count11, dExpect3and11);
        assertEquals(expect2and12, count12, dExpect2and12);
    }

    */
/**
     * Test case: TC2
     *
     * Tests if the time from rolling the dices to printing out the result is faster than 50ms.
     * First diceroll will take longer, so is tested for 100ms
     *//*

    @Test
    void timePerformanceTest(){
        // Arrange
        Game game = new Game();
        long startTime;
        long endTime;
        long timeResultForFirstRoll;
        long timeResultForAnotherRolls;

        //Act
        startTime = System.currentTimeMillis();
        game.playRound();
        System.out.println(game.getCurrentplayer().getNumber() + " har slået: " + game.getCurrentRollScore());
        endTime = System.currentTimeMillis();
        timeResultForFirstRoll = endTime - startTime;

        //Assert
        for (int i = 0; i<1000; i++){
            startTime = System.currentTimeMillis();

            game.playRound();
            System.out.println(game.getCurrentplayer().getNumber() + " har slået: " + game.getCurrentRollScore());
            endTime = System.currentTimeMillis();
            timeResultForAnotherRolls =  endTime - startTime;

            assertTrue(timeResultForAnotherRolls<50, "Time took: " + timeResultForAnotherRolls);
        }
        assertTrue(timeResultForFirstRoll<100, "Time took: " + timeResultForFirstRoll);
    }
}*/
