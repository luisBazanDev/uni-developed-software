package pe.edu.utp.dwi.s01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class Counter {
    private static HashMap<String, Integer> counter;
    private static File file;

    public Counter(String path) {
        this.counter = new HashMap<>();
        this.file = new File(path);
    }

    public void count() {
        String content = readFile();
        String[] words = content.split(" ");
        for (String word : words) {
            counter.put(word, counter.getOrDefault(word, 0) + 1);
        }
    }

    public String readFile() {
        StringBuilder text = new StringBuilder();

        // Read file
        try {
            FileReader fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line);
            }
            bufferedReader.close();
            fileReader.close();

            return text.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public HashMap<String, Integer> getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();

        for(String word : counter.keySet()) {
            text.append(word);
            text.append(" ");
            text.append(counter.get(word));
            text.append("\n");
        }

        return text.toString();
    }
}
