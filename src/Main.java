public class Main {
    public static void main(String[] args) {
        String[] examples = {
                "**Fruits:**\n1. Apples\n2. Bananas\n3. Cherries",
                "Random list of things:\n- Dogs\n- Cats\n- Hamsters",
                "**Cities:**\n1. New York (largest city in USA)\n2. Tokyo (capital of Japan)\n3. London (historic capital)"
        };

        System.out.println("DEBUG - INPUT: \n");
        for(String example : examples)
        {
            System.out.println(example);
        }
        System.out.println("\nOUTPUT:");

        String input = "**Classic Genres:**\n1. Romance\n2. Adventure\n**Sub-Genres:**\n1. Young Adult (YA) fiction:\n* Coming-of-age stories\n* Dystopian fiction\n* Magical realism";

        for (String example : examples) {
            System.out.println(ListParser.parseList(example).toString(5));
        }

        //System.out.println(ListParser.parseList(input).toString(5));
    }
}