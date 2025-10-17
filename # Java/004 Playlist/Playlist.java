import java.util.ArrayList;

public class Playlist {
    
    private ArrayList<Canzone> playlist;

    public Playlist() {

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

    public String visualizzaPlaylist() {
        String out = "";
        int totalTime = 0;

        for (Canzone c : playlist) {
            out += c.toString() + "\n";
            totalTime += c.getDurata();
        }

        return out + totalTime;
    }

}
