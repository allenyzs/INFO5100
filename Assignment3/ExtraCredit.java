public class ExtraCredit {
    public static String reverse(String s){
        String[] temp = s.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = temp.length - 1; i >= 0; i--){
            sb.append(temp[i].toLowerCase() + " ");
        }
        return sb.toString().trim();
    }
    public static void main(String[] args){
        String input = "  The    sky is       blue";
        String output = reverse(input);
        System.out.println(output);
    }
}
