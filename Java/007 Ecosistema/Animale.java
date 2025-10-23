public class Animale {

    private String specie;
    private static int contatoreId = 1;
    private int id;

    public Animale(String specie) {
        this.specie = specie;
        this.id = contatoreId;
        contatoreId++;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[" + id + "] Specie: \'" + specie + "\'").append("\n");
        return str.toString();
    }
}
