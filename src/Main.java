import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Main extends JFrame {
    private JTextField enderecoTxt;
    private JEditorPane editorPagina;
    private JButton abrirBtn, sairBtn;

    public Main() {
        super("Leitor de Página HTML");

        enderecoTxt = new JTextField("http://example.com", 30);
        editorPagina = new JEditorPane();
        editorPagina.setEditable(false);
        abrirBtn = new JButton("Abrir Página");
        sairBtn = new JButton("Fechar");

        JPanel painelSuperior = new JPanel();
        painelSuperior.add(new JLabel("Endereço:"));
        painelSuperior.add(enderecoTxt);
        painelSuperior.add(abrirBtn);

        JScrollPane scroll = new JScrollPane(editorPagina);

        JPanel painelInferior = new JPanel();
        painelInferior.add(sairBtn);

        add(painelSuperior, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(painelInferior, BorderLayout.SOUTH);

        abrirBtn.addActionListener(e -> {
            try {
                editorPagina.setPage(new URL(enderecoTxt.getText()));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao carregar a página: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        sairBtn.addActionListener(e -> System.exit(0));

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
