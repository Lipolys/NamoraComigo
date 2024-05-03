import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class NamoraComigo extends JFrame {
    private ImageIcon imagemIcone;
    private JButton btSim, btNao;
    private final Random sorteador = new Random();
    private static NamoraComigo frame;

    public NamoraComigo() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        setBounds(0, 0, 800, 600);
        imagemIcone = new ImageIcon("/home/lipe/Codigos e Faculdade/NamoraComigo/src/coracao.jpg");
        Image imagem = imagemIcone.getImage();
        imagem = imagem.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        imagemIcone = new ImageIcon(imagem);
        btSim = new JButton("Sim!");
        btSim.setBounds(50, 20, 140, 40);
        btNao = new JButton("Não!");
        btNao.setBounds(50, 70, 140, 40);
        btSim.setToolTipText("CLICA AQUI!!!");
        add(btSim);
        add(btNao);
        JOptionPane.showMessageDialog(null, "Quer namorar comigo?");
    }

    private void definirEventos() {
        ActionListener botao1Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Beleza, agora a gente namora!", "<3", JOptionPane.INFORMATION_MESSAGE, imagemIcone);
                System.exit(0);
            }
        };
        ActionListener botao2Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btSim.setBounds(btNao.getBounds());
                btNao.setBounds(sorteador.nextInt(100) + 50, sorteador.nextInt(100) + 40, 140, 40);
            }
        };

        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {}
            @Override
            public void mousePressed(MouseEvent mouseEvent) {}
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {}
            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                btNao.setBounds(sorteador.nextInt(700) + 50, sorteador.nextInt(500) + 40, 140, 40);
            }
            @Override
            public void mouseExited(MouseEvent mouseEvent) {}
        };

        btSim.addActionListener(botao1Listener);
        btNao.addActionListener(botao2Listener);
        btNao.addMouseListener(mouseListener);
    }

    public static void main (String[] args) {
        Runnable lancador = new Runnable() {
            @Override
            public void run() {
                frame = new NamoraComigo();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
                frame.setLocation((tela.width - frame.getSize().width) / 2, (tela.height - frame.getSize().height) / 2);
                frame.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(lancador);
    }
}
