

import java.util.EnumMap;
import java.util.Map;
import java.util.logging.Level;

// Target interface
interface MediaPlayer {
    void play(String fileName, MediaType type) throws InvalidFormatException;
}

// Adapter + Player
public class AudioPlayer implements MediaPlayer {
    private final MediaAdapter adapter = new MediaAdapter();

    @Override
    public void play(String fileName, MediaType type) throws InvalidFormatException {
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new IllegalArgumentException("fileName cannot be empty");
        }

        switch (type) {
            case MP3:
                LoggerUtil.getLogger().info("Playing mp3 file: " + fileName);
                System.out.println("[MP3 PLAYER] Now playing: " + fileName);
                break;
            case MP4:
            case VLC:
                adapter.play(fileName, type);
                break;
            default:
                throw new InvalidFormatException("Unsupported type: " + type);
        }
    }

    // Inner adapter class
    private static class MediaAdapter implements MediaPlayer {
        private final Map<MediaType, AdvancedMediaPlayer> cache = new EnumMap<>(MediaType.class);

        @Override
        public void play(String fileName, MediaType type) throws InvalidFormatException {
            AdvancedMediaPlayer player = cache.computeIfAbsent(type, AdvancedPlayers::createPlayer);
            if (player == null) {
                throw new InvalidFormatException("No player found for " + type);
            }
            try {
                player.playAdvanced(fileName);
            } catch (TransientPlaybackException e) {
                LoggerUtil.getLogger().log(Level.WARNING, "Transient error: " + e.getMessage());
                throw new InvalidFormatException("Failed to play " + fileName);
            }
        }
    }
}

// Enum for supported types
enum MediaType {
    MP3, MP4, VLC
}
