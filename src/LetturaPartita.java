import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LetturaPartita {

    BufferedReader inputFile;

    public void letturaPartita(String nomefile) {
        try {
            inputFile = new BufferedReader(new FileReader(nomefile));
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    public Evento letturaEvento(Partita P) {
        Evento evento = new Evento("","","");
        try {
            String[] a = inputFile.readLine().split("\\t");
            evento = new Evento(a[0], a[1], a[2]);
            P.eseguiEvento(evento);
        } catch (IOException | NullPointerException e) {
            chiudiFile();
        }
        return evento;
    }

    public void chiudiFile() {
        try {
            System.err.println("FILE TERMINATO");
            inputFile.close();
            System.exit(0);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
