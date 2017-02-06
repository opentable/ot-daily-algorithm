package bunnyears;
/**
 * @author syip
 * We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies 
 * (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say 
 * have 3 ears, because they each have a raised foot. Recursively return the 
 * number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).
 * 
 * bunnyEars2(0) → 0
 * bunnyEars2(1) → 2
 * bunnyEars2(2) → 5
 * Solution: Recursive counter O(n)
 */
public class BunnyEars {
    public static int countEars(int placeInLine) {
            if (placeInLine == 0) return 0;
            int currentBunnyCount = (placeInLine%2 == 0) ? 3 : 2;
            return currentBunnyCount + countEars(placeInLine - 1);
    }

    public static void main(String[] args) {
        assert countEars(0)==0;
        assert countEars(1)==2;
        assert countEars(2)==5;
        assert countEars(10)==25;
    }
}
