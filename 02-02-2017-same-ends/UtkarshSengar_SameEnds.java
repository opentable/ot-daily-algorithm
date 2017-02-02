public class UtkarshSengar_SameEnds {
    public static void main(String[] args){
        String input = "abXYab";
        String same = findSameEnds(input);
        assert same.equals("ab");
    }

    private static String findSameEnds(String input) {
        StringBuilder sb = new StringBuilder();
        String[] split = input.split("");
        int n = split.length;

        int j=n/2;
        for(int i=0; i<n/2; i++){
            while(j<n-1 && !split[i].equals(split[j])){
                j++;
            }

            if(split[i].equals(split[j])){
                sb.append(split[i]);
            }
        }

        return sb.toString();
    }
}