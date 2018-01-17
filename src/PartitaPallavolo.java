public class PartitaPallavolo extends Partita implements IPartite {

    private int setCasa;
    private int setOspite;
    private int setCorrente;
    private int timeOutCasa;
    private int timeOutOspite;

    LetturaPartita lp;
    Frame f;

    public PartitaPallavolo(String nomeCasa, String nomeOspite) {
        super(nomeCasa, nomeOspite);
        this.setCorrente = 0;
        lp = new LetturaPartita();
    }

    public void aggiornaPuntiCasa() {
        this.setPuntiCasa(this.getPuntiCasa() + 1);
    }

    public void aggiornaPuntiOspite() {
        this.setPuntiOspite(this.getPuntiOspite() + 1);
    }

    @Override
    public void eseguiEvento(Evento evento) {
        try {
            switch(evento.getEventCode()) {
                case "V-00":
                    System.out.println("Inizio partita");
                    break;
                case "V-01":
                    System.out.println("Inizio nuovo set");
                    this.setCorrente++;
                    break;
                case "V-02":
                    System.out.println("Fine set corrente");
                    this.resetTimeOut();
                    break;
                case "V-03":
                    System.out.println("Punto per la squadra di casa");
                    this.setCasa++;
                    break;
                case "V-04":
                    System.out.println("Punto per la squadra in trasferta");
                    this.setOspite++;
                    break;
                case "V-05":
                    System.out.println("Time-out per la squadra di casa");
                    this.timeOutCasa++;
                    break;
                case "V-06":
                    System.out.println("Time-out per la squadra in trasferta");
                    this.timeOutOspite++;
                    break;
                case "V-98":
                    System.out.println("Generico commento");
                    break;
                case "V-99":
                    System.out.println("Fine partita");
                    break;
                default:
                    throw new EventException();
            }
        }
        catch(EventException e) {
            System.err.println(e.getMessage());
        }
    }

    public void creaGUI() {
        f = new Frame(this);
    }

    public void leggiPartita() {
        lp.letturaPartita("volley.txt");
    }

    public Evento leggiEvento() {
        Evento ev = lp.letturaEvento(this);
        return ev;
    }

    public void resetTimeOut() {
        this.timeOutCasa = 0;
        this.timeOutOspite = 0;
        if(this.setCasa>this.setOspite) aggiornaPuntiCasa();
        else aggiornaPuntiOspite();
        this.setCasa = 0;
        this.setOspite = 0;
    }

    @Override
    public String toString() {
        return ("\n\n" + super.getNomeCasa() + " VS. " + super.getNomeOspite() + "\n" + "Set corrente: " + this.setCorrente + "\n" +
                super.getPuntiCasa() + " - " + super.getPuntiOspite() + "\n" + this.timeOutCasa + " -- " + this.timeOutOspite);
    }
}
