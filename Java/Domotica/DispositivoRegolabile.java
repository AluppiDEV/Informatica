package Java.Domotica;

public abstract class DispositivoRegolabile extends Dispositivo{

    protected int livello;

    public abstract void impostaLivello(int livello);
}
