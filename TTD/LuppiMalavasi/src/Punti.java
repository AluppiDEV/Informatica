public enum Punti {
    ZERO,
    QUINDICI,
    TRENTA,
    QUARANTA,
    VANTAGGIO,
    VINTO;

    public String stringValue() {
        return switch (this) {
            case ZERO -> "zero";
            case QUINDICI -> "quindici";
            case TRENTA -> "trenta";
            case QUARANTA -> "quaranta";
            case VANTAGGIO -> "vantaggio";
            case VINTO -> "vinto";
        };
    }

    public int intValue() {
        return switch (this) {
            case ZERO -> 0;
            case QUINDICI -> 1;
            case TRENTA -> 2;
            case QUARANTA -> 3;
            case VANTAGGIO -> 4;
            case VINTO -> 5;
        };
    }
}