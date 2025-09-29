
/**
 * Aggiungi qui una descrizione della classe Libro
 * 
 * @author Luppi
 * @version 29/09/2025
 * 
 * Attributi: titolo, autore, pagine, ISBN, inPrestito
 *
 * Definire il costruttore, i setter e i getter.
 *
 * Definire i metodi: stampaAutore, stampaTitolo, stampaDettagli, prendiPrestito
 */
public class Libro 
{
    // Titolo del libro
    private String title;
    // Autore del libro
    private String author;
    // Numero di pagine del libro
    private int pages;
    // Codice ISBN del libro
    private int ISBN;
    // Libro in prestito o no
    private boolean loan;

    /**
     * Costruttore degli oggetti di classe Libro
     */
    public Libro(String titolo, String autore, int pagine, int codice) 
    {
        title = titolo;
        author = autore;
        pages = pagine;
        ISBN = codice;
        loan = false;

    }

    /**
     * Metodi getter
     */
    public String getTitle()
    {
        return title;
    }
    public String getAuthor()
    {
        return author;
    }
    public int getPages()
    {
        return pages;
    }
    public int getISBN()
    {
        return ISBN;
    }
    public boolean getLoan()
    {
        return loan;
    }

    /**
     * Metodi setter
     */
    public void setTitle(String title)
    {
        title = this.title;
    }
    public void setAuthor(String author)
    {
        author = this.author;
    }
    public void setPages(int pages)
    {
        pages = this.pages;
    }
    public void setISBN(int ISBN)
    {
        ISBN = this.ISBN;
    }
    public void setLoan(boolean loan)
    {
        loan = this.loan;
    }

    /**
     * Metodo per visulizzare l'autore del libro
     */
    public void stampaAutore()
    {
        System.out.println("l'autore del libro è: " + getAuthor() + ".");
    }

    /**
     * Metodo per visualizzare il titolo del libro
     */
    public void stampaTitolo()
    {
        System.out.println("Il titolo del libro è: " + getTitle() + ".");
    }

    /**
     * Metodo per visualizzare i dettagli del libro
     */
    public void stampaDettagli()
    {
        System.out.println("##############################");
        System.out.println("# Il libro ha : " + getPages() + " pagine.");
        System.out.println("# Il codice ISBN del libro è : " + getISBN() + ".");
        System.out.println("# Il libro " + (getLoan() ? "è" : "non è") + " in prestito");
        System.out.println("##############################");
    }

    /**
     * Metodo per prendere in prestito o restituire il libro
     */
    public void prendiPrestito()
    {
        System.out.println("#######################################");
        if (!getLoan())
        {
            setLoan(!loan);
            System.out.println("# Libro preso in prestito correttamente");
        }
        else
        {
            System.out.println("# Libro attualmente in prestito");
        }
        System.out.println("#######################################");
    }

    /**
     * Metodo per restituire un libro preso in prestito
     */
    public void restituisciPrestito()
    {
        System.out.println("################################");
        if (getLoan())
        {
            setLoan(!loan);
            System.out.println("# Libro restituito correttamente");
        }
        else
        {
            System.out.println("# Libro non in prestito");
        }
        System.out.println("################################");
    }

}