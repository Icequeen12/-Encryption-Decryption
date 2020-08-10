package encryptdecrypt;

public class Shift extends Tactic {

    private String alphabet = "abcdefghijklmnopqrstuvwxyz";

    protected Shift(String line, int number) {
        super(line, number);
    }

    @Override
    public String dec() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {

            if (line.charAt(i) == ' ') {
                sb.append(line.charAt(i));
            } else {
                int index = alphabet.indexOf(line.charAt(i));
                index -= number;
                if (index < 0) {
                    index = 26 + index;
                }

                sb.append(alphabet.charAt(index));
            }
        }
        return sb.toString();
    }

    @Override
    public String enc() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {

            if (line.charAt(i) == ' ') {
                sb.append(line.charAt(i));
            } else {
                int index = alphabet.indexOf(line.charAt(i));
                index += number;
                if (index > 26) {
                    index -= 26;
                }

                sb.append(alphabet.charAt(index));
            }
        }
        return sb.toString();
    }
}
