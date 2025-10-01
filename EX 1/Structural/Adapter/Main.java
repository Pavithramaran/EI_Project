import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;

public class Main {
    public static void main(String[] args) {
        LoggerUtil.init();
        LoggerUtil.getLogger().info("Starting Media Player Application");

        AudioPlayer audioPlayer = new AudioPlayer();
        AtomicBoolean running = new AtomicBoolean(true);
        Scanner scanner = new Scanner(System.in);

        while (running.get()) {
            try {
                System.out.println("\n=== Media Player Menu ===");
                System.out.println("1. Play MP3");
                System.out.println("2. Play MP4");
                System.out.println("3. Play VLC");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                String input = scanner.nextLine().trim();

                switch (input) {
                    case "1":
                        audioPlayer.play("song.mp3", MediaType.MP3);
                        break;
                    case "2":
                        audioPlayer.play("video.mp4", MediaType.MP4);
                        break;
                    case "3":
                        audioPlayer.play("movie.vlc", MediaType.VLC);
                        break;
                    case "4":
                        running.set(false);
                        break;
                    default:
                        System.out.println("Invalid choice. Please select 1–4.");
                }
            } catch (Exception e) {
                LoggerUtil.getLogger().log(Level.SEVERE, "Error in main loop", e);
                System.out.println("An error occurred. Please try again.");
            }
        }

        LoggerUtil.getLogger().info("Application exiting. Goodbye!");
        scanner.close();
    }
}
