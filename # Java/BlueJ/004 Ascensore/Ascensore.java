
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
            toggleBusy();
            toggleDoor();
            if (currentFloor < floor) {
                for (int i = currentFloor; i < floor; i++) {
                    elevatorMoveUp();
                }
            } else {
                for (int i = currentFloor; i > floor; i--) {
                    elevatorMoveDown();
                }
            }
            toggleDoor();
            toggleBusy();
        }
    }

    /**
     * Gestisce movimnto del singolo piano
     */
    private void elevatorMoveUp() throws InterruptedException {
        currentFloor++;
        System.out.println("Ascensore al piano " + currentFloor);
        Thread.sleep(2000);
    }

    private void elevatorMoveDown() throws InterruptedException {
        currentFloor--;
        System.out.println("Ascensore al piano " + currentFloor);
        Thread.sleep(2000);
    }

    /**
     * Gestione apertura e chiusura porte
     */
    private void toggleDoor() {
        openDoors = !openDoors;
        System.out.println("Porte " + (openDoors ? "aperte" : "chiuse"));
    }

    /**
     * Gestione apertura e chiusura porte
     */
    private void toggleBusy() {
        busy = !busy;
    }

    /**
     * Chiamata ascensore
     */
    public void callElevator(int floor) throws InterruptedException {
        if (!busy) {
            goToFloor(floor);
        } else {
            System.out.println("Ascensore occupato, attendere...");
        }
    }

}