import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = stringCalc(input);


        System.out.println("\"" + input + "\"");

    }

    public static String stringCalc(String input) {

        String[] strings;                                        // массив для сплита
        int u = 34;                                              // юникод кавычек
        int length;                                              // инт для длины строки


        if (input.contains("+")) {

            strings = input.split("\\+");

            length = strings[0].length();
            if (length>10) throw new RuntimeException();
            int stings0F = strings[0].codePointAt(0);
            int strings0S = strings[0].codePointAt(length - 1);

            if (u == stings0F && u == strings0S) {
                strings[0] = strings[0].replace("\"", "");      // убирает кавычки
            } else throw new RuntimeException();

            length = strings[1].length();
            if (length>10) throw new RuntimeException();
            int stings1F = strings[1].codePointAt(0);
            int strings1S = strings[1].codePointAt(length - 1);

            if (u == stings1F && u == strings1S) {
                strings[1] = strings[1].replace("\"", "");
            } else throw new RuntimeException();


            input = (strings[0].concat(strings[1]));                             // +


        } else if (input.contains("-")) {

            strings = input.split("-");

            length = strings[0].length();
            if (length>10) throw new RuntimeException();
            int stings0F = strings[0].codePointAt(0);
            int strings0S = strings[0].codePointAt(length - 1);

            if (u == stings0F && u == strings0S) {
                strings[0] = strings[0].replace("\"", "");
            } else throw new RuntimeException();

            length = strings[1].length();
            if (length>10) throw new RuntimeException();
            int stings1F = strings[1].codePointAt(0);
            int strings1S = strings[1].codePointAt(length - 1);

            if (u == stings1F && u == strings1S) {
                strings[1] = strings[1].replace("\"", "");
            } else throw new RuntimeException();


            int index  = strings[0].indexOf(strings[1]);                          // -
            if (index == -1){
                input = strings[0];
            }
            else {
                input = strings[0].substring(0, index);
                input+=strings[0].substring(index+strings[1].length());
            }
        }


        else if (input.contains("*")) {

            strings = input.split("\\*");

            length = strings[0].length();
            if (length>10) throw new RuntimeException();
            int stings0F = strings[0].codePointAt(0);
            int strings0S = strings[0].codePointAt(length - 1);

            if (u == stings0F && u == strings0S) {
                strings[0] = strings[0].replace("\"", "");
            } else throw new RuntimeException();

            length = strings[1].length();
            int stings1F = strings[1].codePointAt(0);
            int strings1S = strings[1].codePointAt(length - 1);

            if (u == stings1F || u == strings1S) {
                throw new RuntimeException();
            }


            int stringRepeat = Integer.parseInt(strings[1]);                       // *
            if (stringRepeat>10 || stringRepeat<1) throw new RuntimeException();
            String extra = ("");
            for (int i = 0; i < stringRepeat; i++) {
                input = (strings[0] + extra);
                extra = input;
            }
            if (input.length()>40){
                input = input.substring(40);
                input = input + ("...");

            }
        }


        else if (input.contains("/")) {

            strings = input.split("/");

            length = strings[0].length();
            if (length>10 || length<1) throw new RuntimeException();
            int stings0F = strings[0].codePointAt(0);
            int strings0S = strings[0].codePointAt(length - 1);

            if (u == stings0F && u == strings0S) {
                strings[0] = strings[0].replace("\"", "");
            } else throw new RuntimeException();

            length = strings[1].length();
            int stings1F = strings[1].codePointAt(0);
            int strings1S = strings[1].codePointAt(length - 1);

            if (u == stings1F || u == strings1S) {
                throw new RuntimeException();
            }

            strings[0] = strings[0].replace("\"", "");
            int stringRepeat = Integer.parseInt(strings[1]);
            if (stringRepeat>10 || stringRepeat<1) throw new RuntimeException();
            String extra = ("");
            for (int i = 0; i < stringRepeat; i++) {
                input = (strings[0] + extra);
                extra = input;
            }

            int newLen = strings[0].length()/Integer.parseInt(strings[1]);      // /
            input = strings[0].substring(0,newLen);

        }


        return input;
    }
}