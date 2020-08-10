package encryptdecrypt;

public abstract class Tactic {

    protected String line;
    protected int number;

    protected Tactic(String line, int number) {
        this.line = line;
        this.number = number;
    }

    public abstract String dec();

    public abstract String enc();

}
