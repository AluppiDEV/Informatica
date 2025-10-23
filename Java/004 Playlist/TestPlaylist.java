public class TestPlaylist {
    public static void main(String[] args) {

        Playlist p = new Playlist();

        p.aggiungiCanzone(new Canzone("DONNE RICCHE", "Tonypitony", 234));
        p.aggiungiCanzone(new Canzone("CULO", "Tonypitony", 211));
        p.aggiungiCanzone(new Canzone("Incoscent giovani", "Achille Lauro", 103));

        System.out.println(p.visualizzaPlaylist());

        p.rimuoviCanzone("CULO");

        System.out.println(p.visualizzaPlaylist());

    }
}
