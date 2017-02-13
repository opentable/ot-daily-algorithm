public class DuplicateNumberFinder {

    public int findDuplicate(int[] numbers) {

        int sum = 0;
        for(int num : numbers) {
            sum = sum + num;
        }

        int n = numbers.length - 1;
        int sumToN = n * (n+1)/2;
        return sum - sumToN;
    }
}

public class DuplicateNumberFinderTest {

    @Test
    public void findDuplicateTest() {
        DuplicateNumberFinder obj = new DuplicateNumberFinder();
        assertEquals(3, obj.findDuplicate(new int[] {1,2,3,3,4,5}));
        assertEquals(2, obj.findDuplicate(new int[] {1,2,3,4,5,6,2}));
    }
}
