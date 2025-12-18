package Java.Html_parser;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validatore di tag HTML che verifica se i tag di apertura e chiusura sono bilanciati.
 * Utilizza uno Stack per tracciare i tag aperti e Pattern/Matcher per l'estrazione.
 *
 * @author Nome
 * @version 1.0
 */
public class HtmlValidator {

    /**
     * Stack che mantiene i tag di apertura trovati durante la scansione.
     * Viene utilizzato per verificare che ogni tag di chiusura corrisponda
     * all'ultimo tag di apertura non ancora chiuso (struttura LIFO).
     */
    private static Stack<String> inputTag = new Stack<>();

    /**
     * Verifica se una stringa HTML ha tag bilanciati e correttamente annidati.
     * <p>
     * Il metodo utilizza Pattern e Matcher per estrarre tutti i tag HTML dalla stringa.
     * Per ogni tag trovato:
     * - Se è un tag di apertura (es. &lt;div&gt;), viene aggiunto allo Stack
     * - Se è un tag di chiusura (es. &lt;/div&gt;), viene confrontato con l'ultimo tag aperto
     *
     * @param input la stringa HTML da validare
     * @return true se tutti i tag sono bilanciati e correttamente annidati, false altrimenti
     */
    public static boolean isValid(String input) {
        inputTag.clear();

        /*
         * Pattern.compile() crea un oggetto Pattern dalla regex "<.*?>".
         * Questa regex cerca sequenze che iniziano con '<', contengono zero o più caratteri,
         * e terminano con '>'. Il '?' rende il quantificatore '*' non-greedy (pigro),
         * cioè si ferma al primo '>' trovato invece di cercare l'ultimo.
         * Esempio: in "<div><span>" trova "<div>" poi "<span>", non "<div><span>"
         */
        Pattern pattern = Pattern.compile("<.*?>");

        /*
         * pattern.matcher(input) crea un oggetto Matcher che applica il Pattern alla stringa input.
         * Il Matcher è come un "cursore intelligente" che può scorrere la stringa
         * cercando tutte le occorrenze che corrispondono al Pattern.
         */
        Matcher matcher = pattern.matcher(input);

        /*
         * matcher.find() cerca la prossima occorrenza del Pattern nella stringa.
         * Ritorna true se trova una corrispondenza, false se non ce ne sono più.
         * Ad ogni chiamata, il Matcher avanza automaticamente nella stringa,
         * posizionandosi sulla prossima corrispondenza trovata.
         */
        while (matcher.find()) {
            /*
             * matcher.group() restituisce il testo che corrisponde al Pattern
             * nell'ultima ricerca eseguita da find().
             * Senza parametri (o con group(0)), restituisce l'intera corrispondenza.
             * In questo caso restituisce il tag HTML completo, es. "<div>" o "</span>"
             */
            String tag = matcher.group();

            if (tag.startsWith("</")) {
                if (inputTag.isEmpty()) {
                    return false;
                }

                String last = inputTag.pop();

                String lastType = last.substring(1, last.length() - 1);
                String currentType = tag.substring(2, tag.length() - 1);

                if (!lastType.equals(currentType)) {
                    return false;
                }
            } else if (tag.startsWith("<")) {
                inputTag.push(tag);
            }
        }

        return inputTag.isEmpty();
    }
}
