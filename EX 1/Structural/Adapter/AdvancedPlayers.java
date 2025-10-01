import java.util.Random;
import java.util.logging.Level;   // <<--- add this


// Advanced interface
interface AdvancedMediaPlayer {
    void playAdvanced(String fileName) throws TransientPlaybackException;
}

// Factory for advanced players
public class AdvancedPlayers {
    public static AdvancedMediaPlayer createPlayer(MediaType type) {
        switch (type) {
            case MP4: return new Mp4Player();
            case VLC: return new VlcPlayer();
            default: return null;
        }
    }
}

// MP4 player
class Mp4Player implements AdvancedMediaPlayer {
    private final Random random = new Random();

    @Override
    public void playAdvanced(String fileName) throws TransientPlaybackException {
        if (!fileName.toLowerCase().endsWith(".mp4")) {
            throw new TransientPlaybackException("Invalid MP4 file");
        }
        if (random.nextDouble() < 0.1) {
            LoggerUtil.getLogger().log(Level.WARNING, "Transient MP4 error");
            throw new TransientPlaybackException("MP4 decoding error");
        }
        System.out.println("[MP4 PLAYER] Now playing: " + fileName);
    }
}

// VLC player
class VlcPlayer implements AdvancedMediaPlayer {
    private final Random random = new Random();

    @Override
    public void playAdvanced(String fileName) throws TransientPlaybackException {
        if (!fileName.toLowerCase().endsWith(".vlc")) {
            throw new TransientPlaybackException("Invalid VLC file");
        }
        if (random.nextDouble() < 0.2) {
            LoggerUtil.getLogger().log(Level.WARNING, "Transient VLC error");
            throw new TransientPlaybackException("VLC codec error");
        }
        System.out.println("[VLC PLAYER] Now playing: " + fileName);
    }
}
