package br.com.ese.esgManager.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UtilsDotEnv {
    Map<String, String> values;

    public UtilsDotEnv(String path) {
        try {
            String currPath = new java.io.File(path).getCanonicalPath();
            File file = new File(currPath);

            Map<String, String> map = new HashMap<>();

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                //process the line
                String[] split = line.split("=");
                map.put(split[0], split[1]);
            }

            //close resources
            br.close();
            fr.close();

            values = map;
        } catch (IOException e) {
            System.out.println("Not able to find file in path");
            e.printStackTrace();
        }
    }

    public String getEnv(String s) {
        if (values.get(s) == null) {
            System.out.println("No current key in .env file");
            return null;
        }

        return values.get(s);
    }
}
