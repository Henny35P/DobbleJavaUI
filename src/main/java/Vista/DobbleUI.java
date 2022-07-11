package Vista;

import Model.Dobble;
import Model.DobbleGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DobbleUI {
    private JPanel DobbleUiPanel;
    private JButton crearMazo;
    private JButton registrarUser;
    private JButton jugarJuego;
    private JTabbedPane seccionInfo;
    private JTextArea NumCards;
    private JTextArea NumE;
    private JButton botonCrearJuego;
    private JTextField stringNumC;
    private JTextField stringNumE;
    private JTextArea numP;
    private JTextField StringNumP;
    private JTextArea infoJuego;
    private JTextArea NumC;
    private JTextArea stringJugadores;
    private JButton botonRegistrar;
    private JTextArea inputJugador;
    private JScrollPane ScrollInfo;
    private JTextArea stringTextoEleccion;
    private JPanel generacionMazo;
    private JPanel registroJugadores;
    private JPanel seccionJugar;
    private JButton botonEnviarEleccion;
    private JTextArea inputSelectCard;
    private JTextArea stringShowCards;
    private JButton botonSkip;
    private JButton botonMostrarCard;
    private JButton botonTerminar;
    private DobbleGame DobbleJuego;


    public DobbleUI() {
        crearMazo.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                seccionInfo.setSelectedIndex(0);


            }
        });
        registrarUser.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                seccionInfo.setSelectedIndex(1);

            }
        });
        jugarJuego.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                seccionInfo.setSelectedIndex(2);

            }
        });
        botonCrearJuego.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                actionCreateSet();

            }
        });
        botonRegistrar.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                actionRegistrarUser();

            }
        });
        botonMostrarCard.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                actionIniciarJuego();
            }
        });
        botonSkip.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                actionSaltarTurno();
                actionIniciarJuego();

            }
        });
        botonEnviarEleccion.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                actionJugarTurno(inputSelectCard.getText());
                actionIniciarJuego();


            }
        });
    }

    public void actionCreateSet() {
        int numeroCards = Integer.parseInt(NumC.getText());
        int elemCards = Integer.parseInt(NumE.getText());
        int cantJugadores = Integer.parseInt(numP.getText());
        Dobble mazo = new Dobble(elemCards, numeroCards);
        mazo.generacionMazo(mazo.getNumE());
        DobbleGame game = new DobbleGame(mazo, cantJugadores);
        this.setDobbleJuego(game);
        this.infoJuego.setText(this.getDobbleJuego().toString());
    }

    public void actionRegistrarUser() {
        String X = this.inputJugador.getText();
        boolean y = this.getDobbleJuego().register(X);
        if (!y) {
            JOptionPane.showMessageDialog(null, "Error, Nombre repetido o maximo de jugadores excedido.");
        }
        this.stringJugadores.setText(this.getDobbleJuego().playersToString());

    }

    public void actionSaltarTurno() {
        String X = this.getDobbleJuego().play("pass", "");
        stringTextoEleccion.setText(X);
    }

    public void actionIniciarJuego() {
        String X = this.getDobbleJuego().play("null", "");
        stringShowCards.setText(X);
        stringTextoEleccion.setText("Es el turno de :" + this.getDobbleJuego().getPlayers().get(0).toString());
    }

    public void actionJugarTurno(String Y) {
        String W = this.getDobbleJuego().play("spotit", Y);
        this.getDobbleJuego().play("null", "");
        this.infoJuego.setText(this.getDobbleJuego().toString());
        JOptionPane.showMessageDialog(null, W);


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DobbleUI");
        frame.setContentPane(new DobbleUI().DobbleUiPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public DobbleGame getDobbleJuego() {
        return DobbleJuego;
    }

    public void setDobbleJuego(DobbleGame dobbleJuego) {
        DobbleJuego = dobbleJuego;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        DobbleUiPanel = new JPanel();
        DobbleUiPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 2, new Insets(0, 0, 0, 0), -1, -1));
        crearMazo = new JButton();
        crearMazo.setActionCommand("Button");
        crearMazo.setLabel("Crear Mazo");
        crearMazo.setText("Crear Mazo");
        DobbleUiPanel.add(crearMazo, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        registrarUser = new JButton();
        registrarUser.setLabel("Registrar");
        registrarUser.setText("Registrar");
        DobbleUiPanel.add(registrarUser, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        seccionInfo = new JTabbedPane();
        seccionInfo.setAlignmentY(0.5f);
        seccionInfo.setEnabled(false);
        seccionInfo.setFocusable(true);
        seccionInfo.setInheritsPopupMenu(false);
        seccionInfo.setName("Mazo");
        seccionInfo.setOpaque(false);
        seccionInfo.setTabPlacement(4);
        seccionInfo.setToolTipText("Mazo");
        seccionInfo.setVisible(true);
        seccionInfo.putClientProperty("html.disable", Boolean.FALSE);
        DobbleUiPanel.add(seccionInfo, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 5, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(400, 200), new Dimension(400, -1), 0, false));
        generacionMazo = new JPanel();
        generacionMazo.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(7, 2, new Insets(0, 0, 0, 0), -1, -1));
        seccionInfo.addTab("", generacionMazo);
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        generacionMazo.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        NumE = new JTextArea();
        generacionMazo.add(NumE, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 50), null, 0, false));
        NumC = new JTextArea();
        NumC.setText("");
        NumC.setToolTipText("");
        generacionMazo.add(NumC, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        botonCrearJuego = new JButton();
        botonCrearJuego.setLabel("Crear Mazo");
        botonCrearJuego.setText("Crear Mazo");
        generacionMazo.add(botonCrearJuego, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        stringNumC = new JTextField();
        stringNumC.setColumns(10);
        stringNumC.setEditable(false);
        stringNumC.setEnabled(true);
        stringNumC.setText("Ingrese el Numero de Cartas (-1 para el predeterminado)");
        generacionMazo.add(stringNumC, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, -1), null, 0, false));
        stringNumE = new JTextField();
        stringNumE.setEditable(false);
        stringNumE.setText("Ingrese el Numero de elementos por carta");
        generacionMazo.add(stringNumE, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        numP = new JTextArea();
        generacionMazo.add(numP, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        StringNumP = new JTextField();
        StringNumP.setEditable(false);
        StringNumP.setText("Ingrese el numero de jugadores maximo");
        generacionMazo.add(StringNumP, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        registroJugadores = new JPanel();
        registroJugadores.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 3, new Insets(0, 0, 0, 0), -1, -1));
        seccionInfo.addTab("", registroJugadores);
        stringJugadores = new JTextArea();
        stringJugadores.setEditable(false);
        stringJugadores.setText("No hay jugadores registrados");
        registroJugadores.add(stringJugadores, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        registroJugadores.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        botonRegistrar = new JButton();
        botonRegistrar.setText("Registrar Usuario");
        registroJugadores.add(botonRegistrar, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        inputJugador = new JTextArea();
        registroJugadores.add(inputJugador, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        seccionJugar = new JPanel();
        seccionJugar.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 3, new Insets(0, 0, 0, 0), -1, -1));
        seccionInfo.addTab("", seccionJugar);
        seccionInfo.setEnabledAt(2, false);
        stringTextoEleccion = new JTextArea();
        seccionJugar.add(stringTextoEleccion, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        botonEnviarEleccion = new JButton();
        botonEnviarEleccion.setLabel("Spot it!");
        botonEnviarEleccion.setText("Spot it!");
        seccionJugar.add(botonEnviarEleccion, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        inputSelectCard = new JTextArea();
        seccionJugar.add(inputSelectCard, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        stringShowCards = new JTextArea();
        seccionJugar.add(stringShowCards, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        botonSkip = new JButton();
        botonSkip.setLabel("Saltar Turno");
        botonSkip.setText("Saltar Turno");
        seccionJugar.add(botonSkip, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        botonMostrarCard = new JButton();
        botonMostrarCard.setLabel("Iniciar Juego");
        botonMostrarCard.setText("Iniciar Juego");
        seccionJugar.add(botonMostrarCard, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        botonTerminar = new JButton();
        botonTerminar.setLabel("Terminar Juego");
        botonTerminar.setText("Terminar Juego");
        seccionJugar.add(botonTerminar, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jugarJuego = new JButton();
        jugarJuego.setLabel("Jugar");
        jugarJuego.setText("Jugar");
        DobbleUiPanel.add(jugarJuego, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ScrollInfo = new JScrollPane();
        DobbleUiPanel.add(ScrollInfo, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        infoJuego = new JTextArea();
        infoJuego.setEditable(false);
        infoJuego.setEnabled(true);
        infoJuego.setMargin(new Insets(10, 10, 10, 10));
        ScrollInfo.setViewportView(infoJuego);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return DobbleUiPanel;
    }

}
