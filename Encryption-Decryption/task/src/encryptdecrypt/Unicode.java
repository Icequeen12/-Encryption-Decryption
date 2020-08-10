package encryptdecrypt;

public class Unicode extends Tactic {

    protected Unicode(String line, int number) {
        super(line, number);
    }

    @Override
    public String enc() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {

            int index = line.charAt(i);
            index += number;

            sb.append((char) index);
        }
        return sb.toString();

    }

    @Override
    public String dec() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {

            int index = line.charAt(i);
            index -= number;

            sb.append((char) index);
        }
        return sb.toString();
    }
}
