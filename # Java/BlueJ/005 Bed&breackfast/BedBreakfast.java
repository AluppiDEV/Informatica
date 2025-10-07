
/**
 * Aggiungi qui una descrizione della classe BedBreakfast
 * 
 * @author (il tuo nome)
 * @version (un numero di versione o una data)
 */
public class BedBreakfast {
    private int maxRooms;
    private Bedroom[] rooms;
    private int currentRooms;

    /*
     * Costruttore
     */
    public BedBreakfast(int maxRooms) {
        this.maxRooms = (maxRooms >= 1) ? maxRooms : 1;
        rooms = new Bedroom[this.maxRooms];
        currentRooms = 0;
    }

    /*
     * "Costruisci" una stanza
     */
    public void instantiateRoom(float tarif) {
        if (currentRooms < maxRooms) {
            rooms[currentRooms] = new Bedroom(currentRooms + 1, tarif);
            currentRooms++;
        } else {
            System.out.println("Numero massimo di camere raggiunto.");
        }
    }

    /*
     * Affitta la camera
     */
    public void rent(int number, int numberOfDays, String clientName, String clientSurname, String clientTaxID) {
        int index = number - 1;
        if (number > 0 && number <= maxRooms && number <= currentRooms) {
            if (!rooms[index].getBusy()) {
                int count = 0;
                for (int i=0; i<currentRooms; i++) {
                    if (rooms[i].getSecurityCheck().equals(clientTaxID) && rooms[i].getId() != number) {
                        count++;
                    }
                }
                if (count == 0) {
                    rooms[index].rentBedroom(numberOfDays, clientName, clientSurname, clientTaxID);
                } else {
                    System.out.println("Il cliente ha già una camera in affitto.");
                }
            } else {
                System.out.println("Camera già in affitto.");
            }
        } else {
            System.out.println("Numero di stanza non valido.");
        }
    }

    /*
     * Ottieni i dettagli del noleggio
     */
    public void getRentDetail(int number) {
        int index = number - 1;
        if (number > 0 && number <= maxRooms && number <= currentRooms) {
            rooms[index].getBedroomData();
        } else {
            System.out.println("Numero di stanza non valido.");
        }
    }
}
