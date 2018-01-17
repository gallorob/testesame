public abstract class Partita {

    private String nomeCasa;
    private String nomeOspite;
    private int puntiCasa;
    private int puntiOspite;

    public Partita(String nomeCasa, String nomeOspite) {
        this.nomeCasa = nomeCasa;
        this.nomeOspite = nomeOspite;
        this.puntiCasa = 0;
        this.puntiOspite = 0;
    }

    public int getPuntiCasa() {
        return puntiCasa;
    }

    public int getPuntiOspite() {
        return puntiOspite;
    }

    public String getNomeCasa() {
        return nomeCasa;
    }

    public String getNomeOspite() {
        return nomeOspite;
    }

    public void setPuntiCasa(int puntiCasa) {
        this.puntiCasa = puntiCasa;
    }

    public void setPuntiOspite(int puntiOspite) {
        this.puntiOspite = puntiOspite;
    }

    public abstract void eseguiEvento(Evento evento);

    public abstract void leggiPartita();

    public abstract Evento leggiEvento();
}
