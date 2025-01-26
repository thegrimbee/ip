public class Kyrie {
    public static void main(String[] args) {
        String logo = "Kyrie";
        String separator = "\n____________________________________________________________";
        System.out.println("Shalom aleikhim, I am " + logo +"\nTell me what you desire" + separator);
        System.out.println("Farewell, my friend!" + separator);
        Scanner sc = new Scanner(System.in);
        String input;
        while (true) {
            input = sc.nextLine();
            if (input.equals("bye")) {
                break;
            }
            System.out.println(separator + '\n' + input);
        }
    }
}
