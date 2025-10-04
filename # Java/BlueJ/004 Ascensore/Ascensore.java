
/**
 * Aggiungi qui una descrizione della classe Ascensore
 * 
 * @author Luppi
 * @version 1.0
 */
public class Ascensore {
    private int currentFloor;
    private int maxFloor;
    private int minFloor;
    private boolean openDoors;
    private boolean busy;

    /**
     * Costruttore
     */
    public Ascensore(int maxFloor, int minFloor) {
        this.maxFloor = maxFloor;
        this.minFloor = minFloor;
        currentFloor = minFloor;
        openDoors = true;
        busy = false;
    }

    /**
     * Vai al piano N
     */
    public void goToFloor(int floor) throws InterruptedException {
        if (floor <= maxFloor && floor >= minFloor && !busy) {
            useBusy();
            useDoor();
            if (currentFloor < floor) {
                for (int i = currentFloor; i < floor; i++) {
                    elevatorMove(true);
                }
            } else {
                for (int i = currentFloor; i < floor; i--) {
                    elevatorMove(false);
                }
            }
            useDoor();
            useBusy();
        }
    }

    /**
     * Gestisce movimnto del singolo piano
     */
    private void elevatorMove(boolean direction) throws InterruptedException {
        if (direction) {
            currentFloor++;
        } else {
            currentFloor--;
        }
        Thread.sleep(2000);
    }

    /**
     * Gestione apertura e chiusura porte
     */
    private void useDoor() {
        openDoors = !openDoors;
    }

    /**
     * Gestione apertura e chiusura porte
     */
    private void useBusy() {
        busy = !busy;
    }

    /**
     * Chiamata ascensore
     */
    public void callElevator(int floor) throws InterruptedException {
        if (!busy) {
            goToFloor(floor);
        }
    }

}