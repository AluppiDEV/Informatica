public class TechGadget extends Articolo{
    private boolean batteriaInclusa;
    private String marca;

    public TechGadget(String nome, float peso, float prezzo, boolean batteriaInclusa, String marca) {
        super(nome, peso, prezzo);
        this.batteriaInclusa = batteriaInclusa;
        this.marca = marca;
    }

    @Override
    public String stampaEtichetta() {
        return id + " | prodotto: " + nome + ", peso: " + peso + " grammi, prezzo: "
                + prezzo + ", batteria inclusa: "
                + (batteriaInclusa? "si" : "no") + ", marca: " + marca;
    }
}
