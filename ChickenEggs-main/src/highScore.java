import java.io.*;

public class highScore {
    private static final String FILE_PATH = "C:\\Users\\AM\\IdeaProjects\\Chicken1\\src\\Animation\\highScore.txt";
    public void totalScores(String playerName, int score){

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH, true))) {
            writer.println(playerName + ":" + score);
        } catch (IOException e) {
            e.printStackTrace(); // Consider using a logging framework for better error tracking
        }
    }

    public void saveHighScore(String playerName, int score) {
        try {
            // Read the current highest score from the file
            int currentHighestScore = readHighestScore();

            // Check if the new score is higher than the current highest score
            if (score > currentHighestScore) {
                // Update the highest score and write it back to the file
                try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
                    writer.println(playerName + ":" + score);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     public int readHighestScore() throws IOException {
        int currentHighestScore = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Parse each line to get the score
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    int score = Integer.parseInt(parts[1]);
                    // Update the current highest score if the parsed score is higher
                    if (score > currentHighestScore) {
                        currentHighestScore = score;
                    }
                }
            }
        }

        return currentHighestScore;
    }
}


