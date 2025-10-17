import components.queue.Queue;
import components.queue.Queue1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * {@code Playlist} represented as a queue
 *
 * First-in-first-out queue modeled by String of String
 *
 * ex) this = <song1, song2, song3, song4> this.front is at the left of the
 * String and this.back is at the right of the String
 */
public class Playlist extends Queue1L<String> {

    /**
     * Elements included in {@code this}.
     */
    private Queue<String> Playlist;

    /**
     * Length of playlist
     */
    private int length = 0;

    /*
     * Kernel methods ---------------------------------------------------------
     */
    public final boolean hasSong(String song) {
        assert this != null : "violation of: this is not null";
        boolean hasSong = false;

        for (int i = 0; i < this.length; i++) {
            if (this.front().equals(song)) {
                hasSong = true;
            }
            this.rotate(1);
        }

        return hasSong;
    }

    public final void addSong(String song) {
        assert this != null : "violation of: this is not null";
        assert !this.hasSong(song) : "violation of: song is not in this";

        this.enqueue(song);
        this.length += 1;
    }

    public final String removeSong(String song) {
        assert this != null : "violation of: this is not null";
        assert this.hasSong(song) : "violation of: song is not in this";

        for (int i = 0; i < this.length; i++) {
            if (this.front().equals(song)) {
                this.dequeue();
            } else {
                this.rotate(1);
            }
        }

        this.length -= 1;

        return song;
    }

    public final int playlistLength() {
        return this.length;
    }

    /*
     * Standard methods -------------------------------------------------------
     */
    public final void shuffle() {
        assert this != null : "violation of: this is not null";
        assert this.length > 1 : "playlists of length 1 or smaller cannot be shuffled";
        this.flip();

    }

    public static void main(String[] args) {
        Playlist testPlaylist = new Playlist();

        SimpleWriter out = new SimpleWriter1L();
        //SimpleReader in = new SimpleReader1L();

        for (int i = 1; i <= 10; i++) {
            testPlaylist.addSong("Song " + i + " - Artist " + i);
        }

        out.println("Ten songs being added to a playlist: ");
        for (int i = 0; i < testPlaylist.length; i++) {
            out.println(testPlaylist.front());
            testPlaylist.rotate(1);
        }
        out.println('\n' + "Length of playlist: " + testPlaylist.length);

        out.println('\n' + "Removing songs 4-6:");
        for (int i = 4; i <= 6; i++) {
            testPlaylist.removeSong("Song " + i + " - Artist " + i);
        }

        for (int i = 0; i < testPlaylist.length; i++) {
            out.println(testPlaylist.front());
            testPlaylist.rotate(1);
        }

        out.println('\n' + "Length of playlist: " + testPlaylist.length);

        out.println('\n' + "Shuffled playlist: ");
        testPlaylist.shuffle();
        for (int i = 0; i < testPlaylist.length; i++) {
            out.println(testPlaylist.front());
            testPlaylist.rotate(1);
        }
    }
}
