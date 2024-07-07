
import com.formdev.flatlaf.FlatIntelliJLaf;
import compilerTools.CodeBlock;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Grammar;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 *
 * @author Allydocket
 */
public class Compilador extends javax.swing.JFrame {

    private String title;
    private Directory directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private ArrayList<Production> mainProd;
    private ArrayList<Production> compProd;
    private ArrayList<Production> asigProd;
    private ArrayList<Production> asigProdConID;
    private ArrayList<Production> opProd;
    private ArrayList<Production> diviProd;
    private ArrayList<Production> mientrasProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;
    private HashMap<String, String[]> tablaSimbolos;
    DefaultTableModel tablaS;
    Grammar gramatica;

    /**
     * Creates new form Compilador
     */
    public Compilador() {
        initComponents();
        init();
        setImageLabel(TxtLogo, "src/Imagenes/Logo.png");
        setImageLabel(TxtTec, "src/Imagenes/LogoITT.png");

    }

    public void setImageLabel(JLabel labelName, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth() - 105, labelName.getHeight() - 50, Image.SCALE_AREA_AVERAGING));
        labelName.setIcon(icon);
        this.repaint();
    }

    private void init() {
        jtpCode.setEnabled(false);
        title = "AllyDocket";
        setLocationRelativeTo(null);
        setTitle(title);
        directorio = new Directory(this, jtpCode, title, ".Docket");
        addWindowListener(new WindowAdapter() {// Cuando presiona la "X" de la esquina superior derecha
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);
            }
        });
        Functions.setLineNumberOnJTextComponent(jtpCode);
        timerKeyReleased = new Timer((int) (10), (ActionEvent e) -> {
            timerKeyReleased.stop();
//            colorAnalysis();
        });
        Functions.insertAsteriskInName(this, jtpCode, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        mainProd = new ArrayList<>();
        identificadores = new HashMap<>();
        tablaSimbolos = new HashMap<>();
        asigProd = new ArrayList<>();
        asigProdConID = new ArrayList<>();
        compProd = new ArrayList<>();
        opProd = new ArrayList<>();
        diviProd = new ArrayList<>();
        mientrasProd = new ArrayList<>();
        tablaS = (DefaultTableModel) TblSimbolos.getModel();
        Functions.setAutocompleterJTextComponent(new String[]{"VAR { \n  \n }"}, jtpCode, () -> {
            timerKeyReleased.restart();
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        buttonsFilePanel = new javax.swing.JPanel();
        btnAbrir = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnGuardarC = new javax.swing.JButton();
        btnCompilar = new javax.swing.JButton();
        btnEjecutar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpCode = new javax.swing.JTextPane();
        jPanel2 = new javax.swing.JPanel();
        TabbedPane = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TblSimbolos = new javax.swing.JTable();
        PnlLogos = new javax.swing.JPanel();
        TxtLogo = new javax.swing.JLabel();
        TxtTec = new javax.swing.JLabel();
        PnlLogos1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaOutputConsole = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuNuevoArchivo = new javax.swing.JMenuItem();
        jMenuAbrirArchivo = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuGuardarArchivo = new javax.swing.JMenuItem();
        jMenuGuardarArchivoComo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuSalir = new javax.swing.JMenuItem();
        mEjecutar = new javax.swing.JMenu();
        jMenuCompilar = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        AcercaDe = new javax.swing.JMenu();
        BtnIntegrantes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        rootPanel.setBackground(new java.awt.Color(44, 62, 80));

        buttonsFilePanel.setBackground(new java.awt.Color(44, 62, 80));
        buttonsFilePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnAbrir.setBackground(new java.awt.Color(44, 62, 80));
        btnAbrir.setForeground(new java.awt.Color(200, 195, 199));
        btnAbrir.setText("Abrir");
        btnAbrir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(52, 73, 94));
        btnNuevo.setForeground(new java.awt.Color(200, 195, 199));
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(44, 62, 80));
        btnGuardar.setForeground(new java.awt.Color(200, 195, 199));
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnGuardarC.setBackground(new java.awt.Color(44, 62, 80));
        btnGuardarC.setForeground(new java.awt.Color(200, 195, 199));
        btnGuardarC.setText("Guardar como");
        btnGuardarC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCActionPerformed(evt);
            }
        });

        btnCompilar.setBackground(new java.awt.Color(52, 73, 94));
        btnCompilar.setForeground(new java.awt.Color(200, 195, 199));
        btnCompilar.setText("Compilar");
        btnCompilar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        btnEjecutar.setBackground(new java.awt.Color(52, 73, 94));
        btnEjecutar.setForeground(new java.awt.Color(200, 195, 199));
        btnEjecutar.setText("Ejecutar");
        btnEjecutar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Compilador para un lenguaje de control de gastos financieros");

        javax.swing.GroupLayout buttonsFilePanelLayout = new javax.swing.GroupLayout(buttonsFilePanel);
        buttonsFilePanel.setLayout(buttonsFilePanelLayout);
        buttonsFilePanelLayout.setHorizontalGroup(
            buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardarC)
                .addGap(109, 109, 109)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCompilar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btnEjecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        buttonsFilePanelLayout.setVerticalGroup(
            buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsFilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonsFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrir)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnGuardarC)
                    .addComponent(btnCompilar)
                    .addComponent(btnEjecutar)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(108, 122, 137));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtpCode.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(200, 195, 199)));
        jScrollPane1.setViewportView(jtpCode);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel2.setBackground(new java.awt.Color(108, 122, 137));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TabbedPane.setBackground(new java.awt.Color(52, 73, 94));
        TabbedPane.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(200, 195, 199)));
        TabbedPane.setForeground(new java.awt.Color(200, 195, 199));
        TabbedPane.setFocusable(false);

        tblTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Componente léxico", "Lexema", "[Línea, Columna]"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTokens.setFocusable(false);
        tblTokens.setRowSelectionAllowed(false);
        tblTokens.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblTokens);

        TabbedPane.addTab("Tabla de tokens", jScrollPane3);

        TblSimbolos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Token", "Tipo de dato", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblSimbolos.setFocusable(false);
        TblSimbolos.setRowSelectionAllowed(false);
        TblSimbolos.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(TblSimbolos);

        TabbedPane.addTab("Tabla de simbolos", jScrollPane4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabbedPane)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                .addContainerGap())
        );

        PnlLogos.setBackground(new java.awt.Color(108, 122, 137));
        PnlLogos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(200, 195, 199)));

        TxtLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        TxtTec.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout PnlLogosLayout = new javax.swing.GroupLayout(PnlLogos);
        PnlLogos.setLayout(PnlLogosLayout);
        PnlLogosLayout.setHorizontalGroup(
            PnlLogosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlLogosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TxtLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtTec, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnlLogosLayout.setVerticalGroup(
            PnlLogosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlLogosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlLogosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtTec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        PnlLogos1.setBackground(new java.awt.Color(108, 122, 137));
        PnlLogos1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtaOutputConsole.setEditable(false);
        jtaOutputConsole.setBackground(new java.awt.Color(255, 255, 255));
        jtaOutputConsole.setColumns(20);
        jtaOutputConsole.setRows(5);
        jtaOutputConsole.setFocusable(false);
        jScrollPane2.setViewportView(jtaOutputConsole);

        javax.swing.GroupLayout PnlLogos1Layout = new javax.swing.GroupLayout(PnlLogos1);
        PnlLogos1.setLayout(PnlLogos1Layout);
        PnlLogos1Layout.setHorizontalGroup(
            PnlLogos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlLogos1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        PnlLogos1Layout.setVerticalGroup(
            PnlLogos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlLogos1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonsFilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PnlLogos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PnlLogos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonsFilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PnlLogos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PnlLogos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(rootPanel);

        jMenuBar1.setBackground(new java.awt.Color(153, 153, 153));
        jMenuBar1.setBorder(null);

        jMenu1.setText("Archivo");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuNuevoArchivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuNuevoArchivo.setText("Nuevo archivo");
        jMenuNuevoArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuNuevoArchivoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuNuevoArchivo);

        jMenuAbrirArchivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuAbrirArchivo.setText("Abrir archivo");
        jMenuAbrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAbrirArchivoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuAbrirArchivo);
        jMenu1.add(jSeparator6);

        jMenuGuardarArchivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuGuardarArchivo.setText("Guardar archivo");
        jMenuGuardarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGuardarArchivoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuGuardarArchivo);

        jMenuGuardarArchivoComo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuGuardarArchivoComo.setText("Guardar como...");
        jMenuGuardarArchivoComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGuardarArchivoComoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuGuardarArchivoComo);
        jMenu1.add(jSeparator1);

        jMenuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuSalir.setText("Salir");
        jMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuSalir);

        jMenuBar1.add(jMenu1);

        mEjecutar.setText("Ejecutar");

        jMenuCompilar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuCompilar.setText("Compilar");
        jMenuCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCompilarActionPerformed(evt);
            }
        });
        mEjecutar.add(jMenuCompilar);

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem15.setText("Ejecutar");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        mEjecutar.add(jMenuItem15);

        jMenuBar1.add(mEjecutar);

        AcercaDe.setText("Acerca de");

        BtnIntegrantes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        BtnIntegrantes.setText("Integrantes");
        BtnIntegrantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIntegrantesActionPerformed(evt);
            }
        });
        AcercaDe.add(BtnIntegrantes);

        jMenuBar1.add(AcercaDe);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        directorio.New();
        clearFields();
        jtpCode.setEnabled(true);
        jtpCode.setText("VARIABLES {\n\n}\n\nPROCESOS {\n\n}");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        if (directorio.Open()) {
//            colorAnalysis();
            jtpCode.setEnabled(true);
            clearFields();
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCActionPerformed
        if (directorio.SaveAs()) {
            clearFields();
        }
    }//GEN-LAST:event_btnGuardarCActionPerformed

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        compile();
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        btnCompilar.doClick();
        if (codeHasBeenCompiled) {
            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se puede ejecutar el código ya que se encontró uno o más errores",
                        "Error en la compilación", JOptionPane.ERROR_MESSAGE);
            } else {
                CodeBlock codeBlock = Functions.splitCodeInCodeBlocks(tokens, "{", "}", ";");
                //  System.out.println(codeBlock);
                ArrayList<String> blocksOfCode = codeBlock.getBlocksOfCodeInOrderOfExec();
                //   System.out.println(blocksOfCode);

            }
        }
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void jMenuNuevoArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuNuevoArchivoActionPerformed
        directorio.New();
        clearFields();
    }//GEN-LAST:event_jMenuNuevoArchivoActionPerformed

    private void jMenuAbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAbrirArchivoActionPerformed
        if (directorio.Open()) {
//            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_jMenuAbrirArchivoActionPerformed

    private void jMenuGuardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGuardarArchivoActionPerformed
        if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_jMenuGuardarArchivoActionPerformed

    private void jMenuGuardarArchivoComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGuardarArchivoComoActionPerformed

        if (directorio.SaveAs()) {
            clearFields();
        }
    }//GEN-LAST:event_jMenuGuardarArchivoComoActionPerformed

    private void jMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuSalirActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        //hola
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        btnCompilar.doClick();
        if (codeHasBeenCompiled) {
            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se puede ejecutar el código ya que se encontró uno o más errores",
                        "Error en la compilación", JOptionPane.ERROR_MESSAGE);
            } else {
                CodeBlock codeBlock = Functions.splitCodeInCodeBlocks(tokens, "{", "}", ";");
                // System.out.println(codeBlock);
                ArrayList<String> blocksOfCode = codeBlock.getBlocksOfCodeInOrderOfExec();
                // System.out.println(blocksOfCode);

            }
        }
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCompilarActionPerformed
        compile();
    }//GEN-LAST:event_jMenuCompilarActionPerformed

    private void BtnIntegrantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIntegrantesActionPerformed
        JOptionPane.showMessageDialog(null, "Este compilador fue realizado por:\n- Arath De Jesus Cortez Salinas.\n- Hannia Ali Ortega De Luna.\n- Alan Daniel Rodriguez Godinez.\n- Jose Fernando Ruiz Campos.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_BtnIntegrantesActionPerformed

    private void compile() {
        clearFields();
        lexicalAnalysis();
        fillTableTokens();
        syntacticAnalysis();
        semanticAnalysis();
        printConsole();
        codeHasBeenCompiled = true;
    }

    private void lexicalAnalysis() {
        // Extraer tokens
        Lexer lexer;
        try {
            File codigo = new File("code.encrypter");
            int a = 0;

            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new Lexer(entrada);
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }
                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
    }

    public static String removeSubstring(String originalString, String substringToRemove) {
        if (originalString == null || substringToRemove == null) {
            return originalString;
        }
        return originalString.replace(substringToRemove, "");
    }

    private void syntacticAnalysis() {
        gramatica = new Grammar(tokens, errors);

        gramatica.delete(new String[]{"ERROR", "ERROR_1", "Error_2"}, 1);

        // Gramática para definición de variables
        gramatica.group("variable", "(BOOLEANO | TEXTO | DECIMAL | ENTERO) IDENTIFICADOR ASIGNACION ( CADENA |NDECIMAL|NUMERO|FALSO|VERDADERO) FINLINEA", identProd);
        gramatica.group("variable", "IDENTIFICADOR ASIGNACION ( CADENA |NDECIMAL|NUMERO|FALSO|VERDADERO) FINLINEA", 103, "Error Sintactico {}: Falta colocar el tipo de dato a definir [#,%]");
        gramatica.group("variable", "(BOOLEANO | TEXTO | DECIMAL | ENTERO) ASIGNACION ( CADENA | NUMERO|NDECIMAL|FALSO|VERDADERO) FINLINEA", 104, "Error Sintactico {}: Falta colocar el identificador de la variable a definir [#,%]");
        gramatica.group("variable", "(BOOLEANO | TEXTO | DECIMAL | ENTERO) IDENTIFICADOR ( CADENA | NUMERO|NDECIMAL|FALSO|VERDADERO) FINLINEA", 105, "Error Sintactico {}: Falta colocar la asignacion --> '='  [#,%]");
        gramatica.group("variable", "(BOOLEANO | TEXTO | DECIMAL | ENTERO) IDENTIFICADOR ASIGNACION FINLINEA", 106, "Error Sintactico {}: Falta colocar el valor a asignar [#,%]");
        gramatica.group("variable", "(BOOLEANO | TEXTO | DECIMAL | ENTERO) IDENTIFICADOR ASIGNACION (CADENA | NUMERO|NDECIMAL|FALSO|VERDADERO)", 107, "Error Sintactico {}: Falta colocar el fin de linea --> ; [#,%]");

        // Gramática para asignación
        gramatica.group("asignar", "ASIGNAR PARCUAA IDENTIFICADOR PARCUAC ASIGNACION (IDENTIFICADOR|VERDADERO|FALSO) FINLINEA");
        gramatica.group("asignar", "ASIGNAR IDENTIFICADOR PARCUAC ASIGNACION (IDENTIFICADOR|VERDADERO|FALSO)  FINLINEA", 300, "Error Sintactico {}: Falta parentesis cuadrado de apertura [#,%]");
        gramatica.group("asignar", "ASIGNAR PARCUAA PARCUAC ASIGNACION (IDENTIFICADOR|VERDADERO|FALSO)  FINLINEA", 301, "Error Sintactico {}: Falta identificador que brindara el valor [#,%]");
        gramatica.group("asignar", "ASIGNAR PARCUAA IDENTIFICADOR ASIGNACION (IDENTIFICADOR|VERDADERO|FALSO)  FINLINEA", 302, "Error Sintactico {}: Falta parentesis cuadrado de cierre [#,%]");
        gramatica.group("asignar", "ASIGNAR PARCUAA IDENTIFICADOR PARCUAC (IDENTIFICADOR|VERDADERO|FALSO)  FINLINEA", 303, "Error Sintactico {}: Falta signo de asignacion -> = [#,%]");
        gramatica.group("asignar", "ASIGNAR PARCUAA IDENTIFICADOR PARCUAC ASIGNACION FINLINEA", 304, "Error Sintactico {}: Falta identificador donde se almacenara el valor [#,%]");
        gramatica.group("asignar", "ASIGNAR PARCUAA IDENTIFICADOR PARCUAC ASIGNACION (IDENTIFICADOR|VERDADERO|FALSO) ", 305, "Error Sintactico {}: Falta el fin de línea [#,%]");

        // Gramática para imprimir
        gramatica.group("imprimir", "IMPRIMIR PARCUAA  (IDENTIFICADOR|CADENA|NUMERO|NDECIMAL)* PARCUAC");
        gramatica.group("imprimir", "IMPRIMIR IDENTIFICADOR (IDENTIFICADOR|CADENA|NUMERO|NDECIMAL)* PARCUAC", 306, "Error Sintactico {}: Falta parentesis cuadrado de apertura [#,%]");
        gramatica.group("imprimir", "IMPRIMIR PARCUAA PARCUAC", 307, "Error Sintactico {}: Falta el identificador a imprimir [#,%]");
        gramatica.group("imprimir", "IMPRIMIR PARCUAA IDENTIFICADOR (IDENTIFICADOR|CADENA|NUMERO|NDECIMAL)* PARCUAC", 308, "Error Sintactico {}: Falta parentesis cuadrado de apertura [#,%]");

        // Gramática para comparaciones
        gramatica.group("comparacion", "(IDENTIFICADOR | NUMERO) (IGUALDAD | DESIGUALDAD | MENORQUE | MAYORIGUALQUE | MENORIGUALQUE | MAYORQUE | ANDLOGICO | ORLOGICO | NOTLOGICO) (IDENTIFICADOR | NUMERO)", compProd);
        gramatica.group("comparacion", "(IGUALDAD | DESIGUALDAD | MENORQUE | MAYORIGUALQUE | MENORIGUALQUE | MAYORQUE | ANDLOGICO | ORLOGICO | NOTLOGICO) (IDENTIFICADOR | NUMERO)", 100, "Error Sintactico {}: Falta colocar el primer valor [#,%]");
        gramatica.group("comparacion", "(IDENTIFICADOR | NUMERO) (IDENTIFICADOR | NUMERO)", 101, "Error Sintactico {}: Falta colocar la operacion de comparacion [#,%]");
        gramatica.group("comparacion", "(IDENTIFICADOR | NUMERO) (IGUALDAD | DESIGUALDAD | MENORQUE | MAYORIGUALQUE | MENORIGUALQUE | MAYORQUE | ANDLOGICO | ORLOGICO | NOTLOGICO)", 102, "Error Sintactico {}: Falta colocar el valor a comparar [#,%]");

        // Definición de operaciones avanzadas
        gramatica.group("potencia", "POTENCIA PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA");
        gramatica.group("potencia", "POTENCIA IDENTIFICADOR (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA", 201, "Error Sintactico {}: Falta el paréntesis cuadrado de apertura [#,%]");
        gramatica.group("potencia", "POTENCIA PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ ASIGNACION IDENTIFICADOR FINLINEA", 202, "Error Sintactico {}: Falta el paréntesis cuadrado de cierre [#,%]");
        gramatica.group("potencia", "POTENCIA PARCUAA (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA", 203, "Error Sintactico {}: Falta el identificador después de POTENCIA [#,%]");
        gramatica.group("potencia", "POTENCIA PARCUAA IDENTIFICADOR IDENTIFICADOR PARCUAC ASIGNACION IDENTIFICADOR FINLINEA", 204, "Error Sintactico {}: Falta el separador entre identificadores [#,%]");
        gramatica.group("potencia", "POTENCIA PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ PARCUAC IDENTIFICADOR FINLINEA", 205, "Error Sintactico {}: Falta la asignación [#,%]");
        gramatica.group("potencia", "POTENCIA PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ PARCUAC ASIGNACION FINLINEA", 206, "Error Sintactico {}: Falta el identificador después de la asignación [#,%]");
        gramatica.group("potencia", "POTENCIA PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ PARCUAC ASIGNACION IDENTIFICADOR", 207, "Error Sintactico {}: Falta el fin de línea [#,%]");

        gramatica.group("raiz_cua", "RAIZ_CUADRADA PARCUAA IDENTIFICADOR PARCUAC ASIGNACION IDENTIFICADOR FINLINEA");
        gramatica.group("raiz_cua", "RAIZ_CUADRADA IDENTIFICADOR PARCUAC ASIGNACION IDENTIFICADOR FINLINEA", 301, "Error Sintactico {}: Falta el paréntesis cuadrado de apertura [#,%]");
        gramatica.group("raiz_cua", "RAIZ_CUADRADA PARCUAA IDENTIFICADOR ASIGNACION IDENTIFICADOR FINLINEA", 302, "Error Sintactico {}: Falta el paréntesis cuadrado de cierre [#,%]");
        gramatica.group("raiz_cua", "RAIZ_CUADRADA PARCUAA PARCUAC ASIGNACION IDENTIFICADOR FINLINEA", 303, "Error Sintactico {}: Falta el identificador después de RAIZ_CUADRADA [#,%]");
        gramatica.group("raiz_cua", "RAIZ_CUADRADA PARCUAA IDENTIFICADOR PARCUAC IDENTIFICADOR FINLINEA", 304, "Error Sintactico {}: Falta la asignación [#,%]");
        gramatica.group("raiz_cua", "RAIZ_CUADRADA PARCUAA IDENTIFICADOR PARCUAC ASIGNACION FINLINEA", 305, "Error Sintactico {}: Falta el identificador después de la asignación [#,%]");
        gramatica.group("raiz_cua", "RAIZ_CUADRADA PARCUAA IDENTIFICADOR PARCUAC ASIGNACION IDENTIFICADOR", 306, "Error Sintactico {}: Falta el fin de línea [#,%]");

        // Definición de otras operaciones
        gramatica.group("operaciones_basicas", "(SUMA | RESTA | DIVISION | MULTIPLICACION | MODULO) PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA");
        gramatica.group("operaciones_basicas", "PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA", 1501, "Error Sintactico {}: Falta colocar la operación básica a realizar [#,%]");
        gramatica.group("operaciones_basicas", "(SUMA | RESTA | DIVISION | MULTIPLICACION | MODULO) IDENTIFICADOR (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA", 1502, "Error Sintactico {}: Falta el paréntesis cuadrado de apertura [#,%]");
        gramatica.group("operaciones_basicas", "(SUMA | RESTA | DIVISION | MULTIPLICACION | MODULO) PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ ASIGNACION IDENTIFICADOR FINLINEA", 1503, "Error Sintactico {}: Falta el paréntesis cuadrado de cierre [#,%]");
        gramatica.group("operaciones_basicas", "(SUMA | RESTA | DIVISION | MULTIPLICACION | MODULO) PARCUAA (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA", 1504, "Error Sintactico {}: Falta el identificador después del paréntesis cuadrado de apertura [#,%]");
        gramatica.group("operaciones_basicas", "(SUMA | RESTA | DIVISION | MULTIPLICACION | MODULO) PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ PARCUAC IDENTIFICADOR FINLINEA", 1505, "Error Sintactico {}: Falta la asignación después del paréntesis cuadrado de cierre [#,%]");
        gramatica.group("operaciones_basicas", "(SUMA | RESTA | DIVISION | MULTIPLICACION | MODULO) PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ PARCUAC ASIGNACION FINLINEA", 1506, "Error Sintactico {}: Falta el identificador después de la asignación [#,%]");
        gramatica.group("operaciones_basicas", "(SUMA | RESTA | DIVISION | MULTIPLICACION | MODULO) PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ PARCUAC ASIGNACION IDENTIFICADOR", 1507, "Error Sintactico {}: Falta el fin de línea [#,%]");
        gramatica.group("operaciones_basicas", "(SUMA | RESTA | DIVISION | MULTIPLICACION | MODULO) PARCUAA  PARCUAC ASIGNACION IDENTIFICADOR FINLINEA", 1508, "Error Sintactico {}: Faltan los operandos [#,%]");

        gramatica.group("operaciones_estadisticas", "MEDIANA PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA | VAR PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA | DESVESTA PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA | PROMEDIO PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA");
        gramatica.group("operaciones_estadisticas", "PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA", 1601, "Error Sintactico {}: Falta colocar la operación estadística (MEDIANA, VAR, DESVESTA, PROMEDIO) [#,%]");
        gramatica.group("operaciones_estadisticas", "(MEDIANA | VAR | DESVESTA | PROMEDIO) IDENTIFICADOR (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA", 1602, "Error Sintactico {}: Falta el paréntesis cuadrado de apertura [#,%]");
        gramatica.group("operaciones_estadisticas", "(MEDIANA | VAR | DESVESTA | PROMEDIO) PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ ASIGNACION IDENTIFICADOR FINLINEA", 1603, "Error Sintactico {}: Falta el paréntesis cuadrado de cierre [#,%]");
        gramatica.group("operaciones_estadisticas", "(MEDIANA | VAR | DESVESTA | PROMEDIO) PARCUAA (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA", 1604, "Error Sintactico {}: Falta el identificador después del paréntesis cuadrado de apertura [#,%]");
        gramatica.group("operaciones_estadisticas", "(MEDIANA | VAR | DESVESTA | PROMEDIO) PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ PARCUAC IDENTIFICADOR FINLINEA", 1605, "Error Sintactico {}: Falta la asignación después del paréntesis cuadrado de cierre [#,%]");
        gramatica.group("operaciones_estadisticas", "(MEDIANA | VAR | DESVESTA | PROMEDIO) PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ PARCUAC ASIGNACION FINLINEA", 1606, "Error Sintactico {}: Falta el identificador después de la asignación [#,%]");
        gramatica.group("operaciones_estadisticas", "(MEDIANA | VAR | DESVESTA | PROMEDIO) PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR|NUMERO|NDECIMAL)+ PARCUAC ASIGNACION IDENTIFICADOR", 1607, "Error Sintactico {}: Falta el fin de línea [#,%]");

        gramatica.group("operaciones", "(operaciones_basicas | operaciones_avanzadas | operaciones_trigonometricas | operaciones_comparacion | operaciones_estadisticas | asignar | imprimir)*", opProd);

        // Definición de estructuras de control
        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("estructura_si", "SI PARA (comparacion)? PARC CORA (operaciones | estructura_si | estructura_mientras)* CORC");
        });

        // Estructura SI
        gramatica.group("estructura_si", "SI (comparacion)? PARC CORA (operaciones | estructura_si | estructura_mientras)* CORC ", 414, "Error Sintactico {}: Falta el paréntesis de apertura [#,%]");
        gramatica.group("estructura_si", "SI PARA (comparacion)? CORA (operaciones | estructura_si | estructura_mientras)* CORC", 415, "Error Sintactico {}: Falta el paréntesis de cierre [#,%]");
        gramatica.group("estructura_si", "SI PARA (comparacion)? PARC (operaciones | estructura_si | estructura_mientras)* CORC", 416, "Error Sintactico {}: Falta la llave de apertura [#,%]");
        gramatica.group("estructura_si", "SI PARA (comparacion)? PARC CORA (operaciones | estructura_si | estructura_mientras)*", 417, "Error Sintactico {}: Falta la llave de cierre [#,%]");
        gramatica.group("estructura_si", "SI PARA PARC CORA (operaciones | estructura_si | estructura_mientras)* CORC  ", 418, "Error Sintactico {}: Falta la operación de comparación [#,%]");
        gramatica.group("estructura_si", "SI PARA (comparacion)? PARC CORA CORC  ", 418, "Error Sintactico {}: Falta las operaciones [#,%]");

        // Estructura MIENTRAS
        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            //0        1        2         3     4                           5                            6
            gramatica.group("estructura_mientras", "MIENTRAS PARA (comparacion)? PARC CORA (operaciones | estructura_si | estructura_mientras)* CORC", mientrasProd);
        });
        // Estructura MIENTRAS
        gramatica.group("estructura_mientras", "MIENTRAS PARA (comparacion)? PARC CORA (operaciones | estructura_si | estructura_mientras)* CORC", 424, "Error Sintactico {}: Falta el paréntesis de apertura [#,%]");
        gramatica.group("estructura_mientras", "MIENTRAS (comparacion)? PARC CORA (operaciones | estructura_si | estructura_mientras)* CORC", 425, "Error Sintactico {}: Falta el paréntesis de cierre [#,%]");
        gramatica.group("estructura_mientras", "MIENTRAS PARA (comparacion)? CORA (operaciones | estructura_si | estructura_mientras)* CORC", 426, "Error Sintactico {}: Falta la llave de apertura [#,%]");
        gramatica.group("estructura_mientras", "MIENTRAS PARA (comparacion)? PARC (operaciones | estructura_si | estructura_mientras)* CORC", 427, "Error Sintactico {}: Falta la llave de cierre [#,%]");
        gramatica.group("estructura_mientras", "MIENTRAS PARA PARC CORA (operaciones | estructura_si | estructura_mientras)* CORC", 428, "Error Sintactico {}: Falta la operación de comparación [#,%]");
        gramatica.group("estructura_mientras", "MIENTRAS PARA (comparacion)? PARC CORA CORC", 429, "Error Sintactico {}: Falta las operaciones [#,%]");

        // Bloques de procesos y variables
        gramatica.group("bloque_procesos", "PROCESOS CORA (operaciones | estructura_si | estructura_mientras)* CORC", mainProd);
        gramatica.group("bloque_procesos", "PROCESOS (operaciones | estructura_si | estructura_mientras)* CORC", 9, "Error Sintactico {}: Falta abrir el corchete inicial bloque procesos [#,%]");
        gramatica.group("bloque_procesos", "PROCESOS CORA (operaciones | estructura_si | estructura_mientras)*", 10, "Error Sintactico {}: Falta cerrar el corchete bloque procesos [#,%]");

        gramatica.group("bloque_variables", "VARIABLES CORA (variable)* CORC ");
        gramatica.group("bloque_variables", "VARIABLES (variable)* CORC", 6, "Error Sintactico {}: Falta abrir el corchete inicial bloque variables [#,%]");
        gramatica.group("bloque_variables", "VARIABLES CORA (variable)*", 7, "Error Sintactico {}: Falta cerrar el corchete bloque variables [#,%]");

        // Bloque main
        gramatica.group("main", "(bloque_variables) (bloque_procesos)");
        gramatica.initialLineColumn();

        // Mostrar la gramática generada (opcional)
        // jtaOutputConsole.append(gramatica.toString());
        // gramatica.show();
    }

    //Metodo para recorrer el HashMap de la Tabla de Simbolos
    private void semanticAnalysis() {
        tipoDatoIncompatibleyAsignacion();
    }//metodo semantico

    private void tipoDatoIncompatibleyAsignacion() {
        HashMap<String, String> identDataType = new HashMap<>();
        // Definición de tipos de datos--------------------------------------------------------------------------------------------------------------
        //llave    //valor
        identDataType.put("BOOLEANO", "BOOLEANO");
        identDataType.put("TEXTO", "TEXTO");
        identDataType.put("DECIMAL", "DECIMAL");
        identDataType.put("ENTERO", "ENTERO");
        // Errores Tipos de datos incompatibles con las variables
        for (Production id : identProd) {
            String tipoDato = id.lexemeRank(0);
            String valorAsignado = id.lexemeRank(3);
            String tipoEsperado = identDataType.get(tipoDato);
            System.out.println(tipoDato);
            //SI NO ES EL TIPO ESPERADO
            if (!tipoEsperado.equals(id.lexicalCompRank(0))) {
                errors.add(new ErrorLSSL(1, "Error semántico {}: valor no compatible con el tipo de dato [#,%]", id, true));
            } else if (tipoDato.equals("ENTERO") && !valorAsignado.matches("[0-9]+")) {
                errors.add(new ErrorLSSL(2, "Error semántico {}: el valor no es un número entero [#,%]", id, false));
            } else if (tipoDato.equals("TEXTO") && !valorAsignado.matches("\"[0-9]*[a-zA-Z]+\"")) {
                errors.add(new ErrorLSSL(2, "Error semántico {}: el valor no es una cadena [#,%]", id, false));
            } else if (tipoDato.equals("DECIMAL") && !valorAsignado.matches("[+-]?([0-9]*[.])?[0-9]+([eE][+-]?[0-9]+)?")) {
                errors.add(new ErrorLSSL(2, "Error semántico {}: el valor no es un número flotante [#,%]", id, false));
            } else if (tipoDato.equals("BOOLEANO") && !valorAsignado.matches("verdadero|falso")) {
                errors.add(new ErrorLSSL(2, "Error semántico {}: solo se acepta 'verdadero' o 'falso' [#,%]", id, false));
            } else {
                // Verificar si la variable ya está en el conjunto de identificadores
                String variable = id.lexemeRank(1); //Almacenar variable temporal con el lexema osease el identificador como tal Ejemplo #C3
                if (identificadores.containsKey(variable))//Utilizamos el identificador para buscar duplicados en el HashMap de iidentificadores ya guardados
                {
                    //Si encuentra duplicados emite el error y lo almacena tambien
                    System.out.println("Error: Variable duplicada = " + variable);
                    errors.add(new ErrorLSSL(3, "Error semántico {}: declaracion de variable duplicada [#,%] = " + variable.concat(""), id, false));
                } else {
                    //Cuando no se detecta ningun error se agregan a los respectivos HashMap y Tabla de Simbolos
                    identificadores.put(id.lexemeRank(1), tipoDato);
                    //LLAVE       VALOR[tipoDato, valor]
                    String[] datos = {tipoDato, valorAsignado};
                    tablaSimbolos.put(id.lexemeRank(1), datos);
                    identificadores.put(id.lexemeRank(1), datos[0]);
                    String[] getDatos = tablaSimbolos.get(id.lexemeRank(1));
                    tablaS.addRow(new Object[]{id.lexemeRank(1), getDatos[0], getDatos[1]});//tambien se mandan a la tabla en la GUI
                    System.out.println("Agregado a la tabla de simbolos : " + identificadores.toString());

                }
            }
        }//for identProd
        variableNoDeclarada();
    }

    private void variableNoDeclarada() {
        // Error de variable siendo usada sin declararse------------------------------------------------------------------------------
        if (!mainProd.isEmpty()) {
            // Recorrer la producción principal en búsqueda de una variable
            for (Token token : mainProd.get(0).getTokens()) {
                if ("IDENTIFICADOR".equals(token.getLexicalComp())) {
                    String lexema = token.getLexeme();
                    if (!tablaSimbolos.containsKey(lexema)) {
                        System.out.println("NO ESTA DECLARADA ESTA VARIABLE!!!= " + token.getLexeme());
                        errors.add(new ErrorLSSL(4, "Error semántico {}: este identificador no está declarado [#,%] = " + token.getLexeme(), token));
                    } else {
                        divsion0yOperaciones();
                        tiposIncommpatibles();
                    }
                }//if
            }//for
        }//if
    }

    private void divsion0yOperaciones() {
        if (!opProd.isEmpty()) {
            Production currentOp = opProd.get(0);
            int j = 0;
            List<String> valoresValidos = Arrays.asList("IDENTIFICADOR", "NUMERO", "NDECIMAL");

            while (j < currentOp.getSizeTokens()) {
                Token token = currentOp.getTokens().get(j);
                switch (token.getLexeme()) {
                    case "DIVISION":
                    case "MULTIPLICACION":
                    case "SUMA":
                    case "RESTA":
                        boolean esDecimal = false;
                        int k = j + 2;
                        boolean errorEncontrado = false;
                        String operacion = token.getLexeme();
                        String identificadorAlmacen = currentOp.lexemeRank(currentOp.getSizeTokens() - 2);
                        String almacen = identificadores.get(identificadorAlmacen);

                        if (almacen == null) {
                            errors.add(new ErrorLSSL(4, "Error semántico {}: Identificador de almacenamiento no encontrado en la tabla de símbolos [#,%]", currentOp, false));
                            j++;
                            continue;
                        }

                        String tipoResultado = almacen.equals("DECIMAL") ? "DECIMAL" : "ENTERO";

                        while (k < currentOp.getSizeTokens() && !currentOp.lexicalCompRank(k).equals("ASIGNACION")) {
                            if (valoresValidos.contains(currentOp.lexicalCompRank(k))) {
                                double valorOperando = getValor(currentOp.lexemeRank(k), currentOp.lexicalCompRank(k), currentOp);
                                if (valorOperando == Double.MIN_VALUE) {
                                    errorEncontrado = true;
                                    break;
                                }

                                if (!almacen.equals(currentOp.lexicalCompRank(k))
                                        && !currentOp.lexicalCompRank(k).equals("NUMERO")
                                        && !currentOp.lexicalCompRank(k).equals("NDECIMAL")) {
                                    errors.add(new ErrorLSSL(6, "Error semántico {}: Operacion de tipos incompatibles [#,%]", currentOp, false));
                                    errorEncontrado = true;
                                    break;
                                }

                                if (currentOp.lexicalCompRank(k).equals("NDECIMAL")) {
                                    esDecimal = true;
                                }

                                if (operacion.equals("DIVISION") && valorOperando == 0) {
                                    errors.add(new ErrorLSSL(5, "Error semántico {}: No se puede dividir entre 0 [#,%]", currentOp, false));
                                    errorEncontrado = true;
                                    break;
                                }
                            }
                            k++;
                        }

                        if (errorEncontrado) {
                            j++;
                            continue;
                        }

                        if (tipoResultado.equals("ENTERO") && esDecimal) {
                            errors.add(new ErrorLSSL(6, "Error semántico {}: Resultado debe ser ENTERO pero hay operandos DECIMAL [#,%]", currentOp, false));
                        } else if (tipoResultado.equals("DECIMAL") && !esDecimal) {
                            errors.add(new ErrorLSSL(6, "Error semántico {}: Resultado debe ser DECIMAL pero hay operandos ENTERO [#,%]", currentOp, false));
                        }

                        j = k + 2;
                        break;

                    default:
                        j++;
                        break;
                }
            }
        }
    }

    private double getValor(String lexema, String tipo, Production currentOp) {
        try {
            switch (tipo) {
                case "IDENTIFICADOR":
                    String[] datos = tablaSimbolos.get(lexema);
                    if (datos == null) {
                        errors.add(new ErrorLSSL(4, "Error semántico {}: Identificador no encontrado en la tabla de símbolos [#,%]", currentOp, false));
                        return Double.MIN_VALUE;
                    }
                    return Double.parseDouble(datos[1]);
                case "NUMERO":
                    return Integer.parseInt(lexema);
                case "NDECIMAL":
                    return Double.parseDouble(lexema);
                default:
                    return Double.MIN_VALUE;
            }
        } catch (NumberFormatException e) {
            errors.add(new ErrorLSSL(6, "Error semántico {}: Formato de número inválido [#,%]", currentOp, false));
            return Double.MIN_VALUE;
        }
    }

    private void tiposIncommpatibles() {
        //comparacion de tipos Incompatibles-------------------------------------------------------------------------------
        if (!compProd.isEmpty()) {
            // Recorrer la producción de comparacion 
            int i = 0;
            for (Production comp : compProd) {
                i++;
                //EJEMPLO ILUSTRATIVO ---> #id1 == #id2
                String comparador1 = comp.lexemeRank(0);//#id1
                String operador = comp.lexemeRank(1);// operador de comparación (==, !=, <, >, <=, >=)
                String comparador2 = comp.lexemeRank(2);//#id2
                // Verificar si ambos comparadores están en la tabla de identificadores
                if (!identificadores.containsKey(comparador1) || !identificadores.containsKey(comparador2)) {
                    errors.add(new ErrorLSSL(5, "Error semántico {}: uno de los identificadores no está declarado [#,%] = [" + comparador1 + "] o [" + comparador2 + "]", comp, false));
                    continue; // Saltar esta comparación si uno de los identificadores no está declarado
                }

                // Obtener los tipos de datos de los comparadores
                String tipo1 = identificadores.get(comparador1);
                String tipo2 = identificadores.get(comparador2);

                // si #id1 --> tipo de dato != #id2 --> tipo de dato
                if (!tipo1.equals(tipo2)) {
                    errors.add(new ErrorLSSL(5, "Error semántico {}: comparacion de tipos Incompatibles [#,%] = [" + tipo1 + "] y [" + tipo2 + "]", comp, false));
                } else {
                    // Obtener los valores reales de los comparadores
                    String[] valor1 = tablaSimbolos.get(comparador1);
                    String[] valor2 = tablaSimbolos.get(comparador2);
                    String valor1Real = valor1[1];
                    String valor2Real = valor2[1];
                    String[] valorIF = {"BOOLEANO", "verdadero"};
                    String[] valorIFalse = {"BOOLEANO", "falso"};
                    // Condicion No Booleana--------------------------------------------------------------------------------------------------
                    try {
                        switch (operador) {
                            case "==":
                                if (!valor1Real.equals(valor2Real)) {
                                    errors.add(new ErrorLSSL(8, "Error semántico {}: los valores no son iguales [#,%] = [" + valor1Real + "] y [" + valor2Real + "]", comp, false));
                                    tablaSimbolos.put(comp.getName() + i, valorIFalse);
                                    tablaS.addRow(new Object[]{comp.getName() + i, valorIFalse[0], valorIFalse[1]});
                                } else {
                                    tablaSimbolos.put(comp.getName() + i, valorIF);
                                    tablaS.addRow(new Object[]{comp.getName() + i, valorIF[0], valorIF[1]});
                                }
                                break;
                            case "!=":
                                if (valor1Real.equals(valor2Real)) {
                                    errors.add(new ErrorLSSL(8, "Error semántico {}: los valores son iguales [#,%] = [" + valor1Real + "] y [" + valor2Real + "]", comp, false));
                                    tablaSimbolos.put(comp.getName() + i, valorIFalse);
                                    tablaS.addRow(new Object[]{comp.getName() + i, valorIFalse[0], valorIFalse[1]});
                                } else {
                                    tablaSimbolos.put(comp.getName() + i, valorIF);
                                    tablaS.addRow(new Object[]{comp.getName() + i, valorIF[0], valorIF[1]});
                                }
                                break;
                            case "<<":
                                if (Float.parseFloat(valor1Real) >= Float.parseFloat(valor2Real)) {
                                    errors.add(new ErrorLSSL(8, "Error semántico {}: el valor no es menor [#,%] = [" + valor1Real + "] y [" + valor2Real + "]", comp, false));
                                    tablaSimbolos.put(comp.getName() + i, valorIFalse);
                                    tablaS.addRow(new Object[]{comp.getName() + i, valorIFalse[0], valorIFalse[1]});
                                } else {
                                    tablaSimbolos.put(comp.getName() + i, valorIF);
                                    tablaS.addRow(new Object[]{comp.getName() + i, valorIF[0], valorIF[1]});
                                }
                                break;
                            case ">>":
                                if (Float.parseFloat(valor1Real) <= Float.parseFloat(valor2Real)) {
                                    errors.add(new ErrorLSSL(8, "Error semántico {}: el valor no es mayor [#,%] = [" + valor1Real + "] y [" + valor2Real + "]", comp, false));
                                    tablaSimbolos.put(comp.getName() + i, valorIFalse);
                                    tablaS.addRow(new Object[]{comp.getName() + i, valorIFalse[0], valorIFalse[1]});
                                } else {
                                    tablaSimbolos.put(comp.getName() + i, valorIF);
                                    tablaS.addRow(new Object[]{comp.getName() + i, valorIF[0], valorIF[1]});
                                }
                                break;
                            case "<=":
                                if (Float.parseFloat(valor1Real) > Float.parseFloat(valor2Real)) {
                                    errors.add(new ErrorLSSL(8, "Error semántico {}: el valor no es menor o igual [#,%] = [" + valor1Real + "] y [" + valor2Real + "]", comp, false));
                                    tablaSimbolos.put(comp.getName() + i, valorIFalse);
                                    tablaS.addRow(new Object[]{comp.getName() + i, valorIFalse[0], valorIFalse[1]});
                                } else {
                                    tablaSimbolos.put(comp.getName() + i, valorIF);
                                    tablaS.addRow(new Object[]{comp.getName() + i, valorIF[0], valorIF[1]});
                                }
                                break;
                            case ">=":
                                if (Float.parseFloat(valor1Real) < Float.parseFloat(valor2Real)) {
                                    errors.add(new ErrorLSSL(8, "Error semántico {}: el valor no es mayor o igual [#,%] = [" + valor1Real + "] y [" + valor2Real + "]", comp, false));
                                    tablaSimbolos.put(comp.getName() + i, valorIFalse);
                                    tablaS.addRow(new Object[]{comp.getName() + i, valorIFalse[0], valorIFalse[1]});
                                } else {
                                    tablaSimbolos.put(comp.getName() + i, valorIF);
                                    tablaS.addRow(new Object[]{comp.getName() + i, valorIF[0], valorIF[1]});
                                }
                                break;
                            default:
                                errors.add(new ErrorLSSL(10, "Error semántico {}: operador de comparación no reconocido [#,%] = " + operador, comp, false));
                                break;
                        }
                    } catch (NumberFormatException e) {
                        errors.add(new ErrorLSSL(9, "Error semántico {}: formato de número inválido [#,%]", comp, false));
                    }
                    //Condicion No Booleana--------------------------------------------------------------------------------------------------
                }
            }//For
        }//If
    }

//errores semanticos------
// Método para actualizar la JTable
    private void actualizarJTable(String identificador, String[] datosActualizados) {
        for (int row = 0; row < tablaS.getRowCount(); row++) {
            if (tablaS.getValueAt(row, 0).equals(identificador)) {
                tablaS.setValueAt(datosActualizados[0], row, 1);
                tablaS.setValueAt(datosActualizados[1], row, 2);
                break;
            }
        }
    }

    private void fillTableTokens() {
        tokens.forEach(token -> {
            Object[] data = new Object[]{token.getLexicalComp(), token.getLexeme(), "[" + token.getLine() + ", " + token.getColumn() + "]"};
            Functions.addRowDataInTable(tblTokens, data);
        });
    }

    private void printConsole() {
        if (!errors.isEmpty()) {
            System.out.println("AUN HAY ERRORRES");
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
            }
            jtaOutputConsole.append("Compilación terminada...\n" + strErrors + "\nLa compilación terminó con errores...");
        } else {
            jtaOutputConsole.setText("Compilación terminada...");
        }
        jtaOutputConsole.setCaretPosition(0);
    }

    private void clearFields() {
        errors.clear();
        Functions.clearDataInTable(tblTokens);
        Functions.clearDataInTable(TblSimbolos);
        jtaOutputConsole.setText("");
        tokens.clear();
        identProd.clear();
        identificadores.clear();
        mainProd.clear();
        asigProd.clear();
        asigProdConID.clear();
        opProd.clear();
        compProd.clear();
        tablaSimbolos.clear();
        diviProd.clear();
        mientrasProd.clear();
        codeHasBeenCompiled = false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                System.out.println("LookAndFeel no soportado: " + ex);
            }
            new Compilador().setVisible(true);
        });
    }

    //Getters and Setters
    public Grammar getGramatica() {
        return gramatica;
    }

    public void setGramatica(Grammar gramatica) {
        this.gramatica = gramatica;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu AcercaDe;
    private javax.swing.JMenuItem BtnIntegrantes;
    private javax.swing.JPanel PnlLogos;
    private javax.swing.JPanel PnlLogos1;
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JTable TblSimbolos;
    private javax.swing.JLabel TxtLogo;
    private javax.swing.JLabel TxtTec;
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarC;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JPanel buttonsFilePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuAbrirArchivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCompilar;
    private javax.swing.JMenuItem jMenuGuardarArchivo;
    private javax.swing.JMenuItem jMenuGuardarArchivoComo;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuNuevoArchivo;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JTextArea jtaOutputConsole;
    private javax.swing.JTextPane jtpCode;
    private javax.swing.JMenu mEjecutar;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tblTokens;
    // End of variables declaration//GEN-END:variables
}
