package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author long
 */
public class EnvironLoader {
    /* HOW TO USE:
        // put env vars in /src/assets/env.txt
        var env = new EnvironLoader();
        System.out.println(env.get("password"));
    */

    final static HashMap envDict = new HashMap<String, String>();

    public EnvironLoader() {
        try {
            File myObj = new File("./src/assets/env.txt");
            try ( Scanner myReader = new Scanner(myObj)) {
                while (myReader.hasNextLine()) {
                    String line = myReader.nextLine();
                    int eqlInd = line.indexOf("=");
                    if (eqlInd != -1) {
                        String key = line.substring(0, eqlInd);
                        key = key.toLowerCase().trim();
                        String value = line.substring(eqlInd+1, line.length());
                        value = value.trim();

                        EnvironLoader.envDict.put(key, value);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("NO env.txt FOUND!!!");
        }
    }

    public static String get(String key) {
        return (String) EnvironLoader.envDict.get(key.toLowerCase().trim());
    }

}
