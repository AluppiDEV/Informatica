public class ProdottoFresco extends Articolo{
    private double temperaturaConservazione;
    private String dataScadenza;

    public ProdottoFresco(String nome, float peso, float prezzo, double temperaturaConservazione, String dataScadenza){
        super(nome, peso, prezzo);
        this.temperaturaConservazione = temperaturaConservazione;
        this.dataScadenza = dataScadenza;
    }

    @Override
    public String stampaEtichetta() {
        return id + " | prodotto: " + nome + ", peso: " + peso + " grammi, prezzo: " + prezzo
                + ", temperatura di conservazione: " + temperaturaConservazione
                + ", data di scadenza: " + dataScadenza;
    }
}
