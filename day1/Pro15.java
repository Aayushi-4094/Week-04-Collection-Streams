import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Pro15{
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("myFile.txt");

        Map map = new HashMap();

        try (BufferedReader br = new BufferedReader(new FileReader("myFile.txt"))) {
            StringBuilder sb = new StringBuilder();
            StringBuffer content = new StringBuffer();
            String line = br.readLine();

            while (line != null) { 
                
                
                String[] words = line.split(" ");
                
                for (String word : words){
                    if(word == null || word.trim().equals("")){
                        continue;
                        
                    }                
                }
                
               
                for (int i = 0; i < words.length; i++) {
                    
                    if (map.get(words[i]) == null) {
                        map.put(words[i], 1);
                    } else {
                        int newValue = Integer.valueOf(String.valueOf(map.get(words[i])));
                        newValue++;
                        map.put(words[i], newValue);
                    }
                }
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        }
        Map<String, Integer> sorted = new TreeMap<String, Integer>(map);
        for (Object key : sorted.keySet()) {
            System.out.println(key + "\tCounts: " + map.get(key));
        }
    }
    
}
