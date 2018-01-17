import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

    Partita partita;
    Evento evento;
    Panel p = new Panel();

    public Frame(Partita partita) {
        this.partita = partita;
        setSize(320,200);
        setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(p);

        p.b1.addActionListener(this::actionPerformed);
        partita.leggiPartita();

        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        evento = partita.leggiEvento();
        p.aggiornaDati(partita.toString());
        p.aggiornaEvento(evento.toString());
        this.repaint();
    }

}

class Panel extends JPanel {
    public Panel() {
        setSize(320,200);
        setLayout(new BorderLayout());
        add(b1, BorderLayout.SOUTH);
        add(l1, BorderLayout.NORTH);
        add(l2, BorderLayout.CENTER);
        l2.setLineWrap(true);
    }

    JButton b1 = new JButton("Prossimo evento");

    JTextArea l1 = new JTextArea("...");
    JTextArea l2 = new JTextArea("...");

    public void aggiornaDati(String data) {
        this.l1.setText(data);
    }

    public void aggiornaEvento(String dati) {
        this.l2.setText(dati);
    }
}