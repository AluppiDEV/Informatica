import java.util.ArrayList;

public class Playlist {

    private ArrayList<Canzone> playlist;

    public Playlist() {
        playlist = new ArrayList<>();
    }

    public void aggiungiCanzone(Canzone c) {
        playlist.add(c);
    }

    public void rimuoviCanzone(String titolo) {
        int index = 0;
        for (Canzone c : playlist) {
            if (c.getTitolo().equals(titolo)) {
                index = playlist.indexOf(c);
            }
        }
        playlist.remove(index);
    }

    public static String formatTime(int totalSeconds) {
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public String visualizzaPlaylist() {
        String out = "";
        int totalTime = 0;

        for (Canzone c : playlist) {
            out += c.toString() + "\n";
            totalTime += c.getDurata();
        }

        return out + "Durata totale playlist: " + formatTime(totalTime) + "\n";
    }

}
