public class Permutations {

    public static List<String> ofString(String text) {
        List<String> permutations = new ArrayList<>();
        permutations("", text, permutations);
        return permutations;
    }

    private static void permutations(String soFar, String remaining, List<String> permutations) {
        if (remaining == "") {
            permutations.add(soFar);
        }

        for(int index = 0; index < remaining.length(); index++) {
            String newSoFar = soFar + remaining.charAt(index);
            String newRemaining = everythingExceptIndex(remaining, index);
            permutations(newSoFar, newRemaining, permutations);
        }
    }

    private static String everythingExceptIndex(String text, int excludeIndex) {
        String result = "";
        for(int index = 0; index < text.length(); index++) {
            if (index == excludeIndex) {
                continue;
            }

            result = result + text.charAt(index);
        }

        return result;
    }
}

public class PermutationsTest {

    @Test
    public void ofStringTest() {
        List<String> result = Permutations.ofString("abc");
        List<String> expected = Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba");
        Assert.assertEquals(expected, result);
    }
}
