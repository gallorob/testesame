public class PartitaCalcio extends Partita implements IPartite {

    private int tempo;
    LetturaPartita lp;
    Frame f;

    public PartitaCalcio(String nomeCasa, String nomeOspite) {
        super(nomeCasa, nomeOspite);
        this.tempo = 1;
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
                case "C-00":
                   System.out.println("Inizio partita");
                    break;
                case "C-01":
                    System.out.println("Fine primo tempo");
                    break;
                case "C-02":
                    System.out.println("Inizio secondo tempo");
                    this.tempo += 1;
                    break;
                case "C-04":
                    System.out.println("Gol per la squadra di casa");
                    this.aggiornaPuntiCasa();
                    break;
                case "C-05":
                    System.out.println("Gol per la squadra in trasferta");
                    this.aggiornaPuntiOspite();
                    break;
                case "C-98":
                    System.out.println("Generico commento");
                    break;
                case "C-99":
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
        lp.letturaPartita("calcio.txt");
    }

    public Evento leggiEvento() {
        Evento ev = lp.letturaEvento(this);
        return ev;
    }

    @Override
    public String toString() {
        return ("\n\n" + super.getNomeCasa() + " VS. " + super.getNomeOspite() + "\n" + super.getPuntiCasa() + " - " + super.getPuntiOspite() +
        "\n" + this.tempo + "' tempo");
    }

}