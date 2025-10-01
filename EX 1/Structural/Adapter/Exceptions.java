

// Invalid format exception
class InvalidFormatException extends Exception {
    public InvalidFormatException(String msg) {
        super(msg);
    }
}

// Temporary playback error
class TransientPlaybackException extends Exception {
    public TransientPlaybackException(String msg) {
        super(msg);
    }
}
