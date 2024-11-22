import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class ListParser {
    public static JSONObject parseList(String input) {
        // Remove leading phrases and formatting
        String cleanedInput = input
                .replaceAll("\\*\\*", "")       // Remove double asterisks
                .replaceAll("\\*", "")          // Remove single asterisks
                .trim();

        // Split input into lines and clean each line
        List<String> lines = new ArrayList<>();
        String[] rawLines = cleanedInput.split("\n");
        for (String line : rawLines) {
            line = line.replaceFirst("^\\d+\\.\\s*", "").trim();
            if (!line.isEmpty()) {
                lines.add(line);
            }
        }

        // Organize into a nested JSON structure
        JSONObject result = new JSONObject();
        String currentCategory = null;

        for (String line : lines) {
            if (line.endsWith(":")) {
                // New category
                currentCategory = line.substring(0, line.length() - 1);
                result.put(currentCategory.replace(" ", "_"), new JSONArray());
            } else if (currentCategory != null) {
                // Add item to current category
                String categoryKey = currentCategory.replace(" ", "_");
                if (!result.has(categoryKey)) {
                    result.put(categoryKey, new JSONArray());
                }
                result.getJSONArray(categoryKey).put(line);
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
