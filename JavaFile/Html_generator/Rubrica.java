package pkg002javaoffstream;

import java.util.ArrayList;

public class Rubrica {
    private ArrayList<Contatto> rubrica;

    public Rubrica(){
        rubrica = new ArrayList<>();
    }

    public void aggiungiContatto(String nome, String num){
        rubrica.add(new Contatto(nome, num));
    }

    public Contatto ricercaContatto(String nome){
        for(Contatto c : rubrica){
            if(c.getNome().equals(nome)){
                return c;
            }
        }
        return null;
    }

    public boolean rimuoviContatto(String nome){
        Contatto c = ricercaContatto(nome);
        if(c == null) {
            return false;
        } else {
            rubrica.remove(c);
            return true;
        }
    }

    public String visualizzaRubrica(){
        StringBuilder temp = new StringBuilder();
        for(Contatto c : rubrica){
            temp.append(c.toString()).append("\n");
        }
        return temp.toString();
    }

    public String visualizzaRubricaPerFile(){
        StringBuilder temp = new StringBuilder();
        for(Contatto c : rubrica){
            temp.append(c.getNome()).append(",").append(c.getNumero()).append("\n");
        }
        return temp.toString();
    }

    public String visualizzaContatto(String nome){
        return ricercaContatto(nome).toString();
    }

    public ArrayList<Contatto> getRubrica(){
        if(rubrica.isEmpty()) return null;
        return rubrica;
    }
}
