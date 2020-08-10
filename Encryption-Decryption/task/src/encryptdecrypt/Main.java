package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        String command = "enc";
        String line = "";
        int number = 0;
        String in = "";
        String out = "";
        String alg = "shift";

        for (int i = 0; i < args.length - 1; i++) {
            switch (args[i]) {
                case "-key":
                    number = Integer.parseInt(args[i + 1]);
                    break;
                case "-mode":
                    command = args[i + 1];
                    break;
                case "-data":
                    line = args[i + 1];
                    break;
                case "-alg":
                    alg = args[i + 1];
                    break;
                case "-in":
                    in = args[i + 1];
                    break;
                case "-out":
                    out = args[i + 1];
                    break;
            }
        }

        if (line.equals("")) {
            line = readFileAsString(in);
        }

        if (alg.equals("shift")) {
            Shift shift = new Shift(line, number);
            if (command.equals("enc")) {
                line = shift.enc();
            } else {
                line = shift.dec();
            }
        } else {
            Unicode unicode = new Unicode(line, number);
            if (command.equals("enc")) {
                line = unicode.enc();
            } else {
                line = unicode.dec();
            }
        }

        if (!out.equals("")) {
            write(out, line);
        }

    }

    public static String readFileAsString(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void write(String path, String line) {
        File file = new File(path);
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(line);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
