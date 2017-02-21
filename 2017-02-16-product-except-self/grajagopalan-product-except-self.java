public class ProductExceptSelfCalculator {

    public int[] calculate(int[] a) {

        if (a == null || a.length == 1) {
            return a;
        }

        int[] productFromLeft = new int[a.length];
        int[] productFromRight = new int[a.length];

        calculateProducts(a, productFromLeft, productFromRight);
        return calculateProductExceptSelf(a, productFromLeft, productFromRight);
    }

    private void calculateProducts(int[] a, int[] productFromLeft, int[] productFromRight) {

        int productFromLeftSoFar = 1;
        int productFromRightSoFar = 1;
        for(int index = 0; index < a.length; index++) {
            productFromLeftSoFar = productFromLeftSoFar * a[index];
            productFromRightSoFar = productFromRightSoFar * a[a.length - index -1];
            productFromLeft[index] = productFromLeftSoFar;
            productFromRight[a.length - index -1] = productFromRightSoFar;
        }
    }

    private int[] calculateProductExceptSelf(int[] a, int[] productFromLeft, int[] productFromRight) {

        int[] productExceptSelf = new int[a.length];
        productExceptSelf[0] = productFromRight[1];
        productExceptSelf[a.length - 1] = productFromLeft[a.length - 2];
        for(int index = 1; index < a.length - 1; index++) {
            productExceptSelf[index] = productFromLeft[index - 1] * productFromRight[index+1];
        }

        return productExceptSelf;
    }
}

public class ProductExceptSelfCalculatorTest {

    @Test
    public void calculateTest() {

        int[] a = new int[] {1,2,3,4};
        int[] result = new ProductExceptSelfCalculator().calculate(a);
        assertArrayEquals(new int[] {24, 12, 8, 6}, result);

    }

    @Test
    public void calculate2Test() {

        int[] a = new int[] {12, 10};
        int[] result = new ProductExceptSelfCalculator().calculate(a);
        assertArrayEquals(new int[] {10, 12}, result);

    }
}

