
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author yisus
 */
public class Compilador extends javax.swing.JFrame {

    private String title;
    private Directory directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;
    private HashMap<String, String> tablaSimbolos;
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
        identificadores = new HashMap<>();
        tablaSimbolos = new HashMap<>();
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
                System.out.println(codeBlock);
                ArrayList<String> blocksOfCode = codeBlock.getBlocksOfCodeInOrderOfExec();
                System.out.println(blocksOfCode);

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
                System.out.println(codeBlock);
                ArrayList<String> blocksOfCode = codeBlock.getBlocksOfCodeInOrderOfExec();
                System.out.println(blocksOfCode);

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
        gramatica.group("variable", "IDENTIFICADOR ASIGNACION (BOOL | STRING_LITERAL | NUMERO) FINLINEA", 103, "Falta colocar el tipo de variable a definir [#,%]");
        gramatica.group("variable", "(BOOLEANO | TEXTO | DECIMAL | ENTERO) ASIGNACION ( CADENA | NUMERO|NDECIMAL|FALSO|VERDADERO) FINLINEA", 104, "Falta colocar el identificador de la variable a definir [#,%]");
        gramatica.group("variable", "(BOOLEANO | TEXTO | DECIMAL | ENTERO) IDENTIFICADOR ( CADENA | NUMERO|NDECIMAL|FALSO|VERDADERO) FINLINEA", 105, "Falta colocar la asignacion --> '='  [#,%]");
        gramatica.group("variable", "(BOOLEANO | TEXTO | DECIMAL | ENTERO) IDENTIFICADOR ASIGNACION FINLINEA", 106, "Falta colocar el valor a asignar [#,%]");
        gramatica.group("variable", "(BOOLEANO | TEXTO | DECIMAL | ENTERO) IDENTIFICADOR ASIGNACION (CADENA | NUMERO|NDECIMAL|FALSO|VERDADERO)", 107, "Falta colocar el fin de linea --> ; [#,%]");

        // Definición de comparaciones
        gramatica.group("comparacion", "(IDENTIFICADOR | NUMERO) (IGUALDAD | DESIGUALDAD | MENORQUE | MAYORIGUALQUE | MENORIGUALQUE | MAYORQUE | ANDLOGICO | ORLOGICO | NOTLOGICO) (IDENTIFICADOR | NUMERO)");
        gramatica.group("comparacion", "(IGUALDAD | DESIGUALDAD | MENORQUE | MAYORIGUALQUE | MENORIGUALQUE | MAYORQUE | ANDLOGICO | ORLOGICO | NOTLOGICO) (IDENTIFICADOR | NUMERO)", 100, "Falta colocar el primer valor [#,%]");
        gramatica.group("comparacion", "(IDENTIFICADOR | NUMERO) (IDENTIFICADOR | NUMERO)", 101, "Falta colocar la operacion de comparacion [#,%]");
        gramatica.group("comparacion", "(IDENTIFICADOR | NUMERO) (IGUALDAD | DESIGUALDAD | MENORQUE | MAYORIGUALQUE | MENORIGUALQUE | MAYORQUE | ANDLOGICO | ORLOGICO | NOTLOGICO)", 102, "Falta colocar el valor a comparar [#,%]");

        // Definición de operaciones avanzadas
        gramatica.group("potencia", "POTENCIA PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA");
        gramatica.group("raiz_cua", "RAIZ_CUADRADA PARCUAA IDENTIFICADOR PARCUAC ASIGNACION IDENTIFICADOR FINLINEA");
        gramatica.group("raiz_ene", "RAIZ_ENESIMA PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA");
        gramatica.group("loga_nat", "LOGARITMO_NATURAL PARCUAA IDENTIFICADOR PARCUAC ASIGNACION IDENTIFICADOR FINLINEA");
        gramatica.group("log_b10", "LOGARITMO_BASE_10 PARCUAA IDENTIFICADOR PARCUAC ASIGNACION IDENTIFICADOR FINLINEA");
        gramatica.group("exponencial", "EXPONENCIAL PARCUAA IDENTIFICADOR PARCUAC ASIGNACION IDENTIFICADOR FINLINEA");
        gramatica.group("val_abso", "VALOR_ABSOLUTO PARCUAA IDENTIFICADOR PARCUAC ASIGNACION IDENTIFICADOR FINLINEA");
        gramatica.group("facto", "FACTORIAL PARCUAA IDENTIFICADOR PARCUAC ASIGNACION IDENTIFICADOR FINLINEA");
        gramatica.group("redondeo", "REDONDEO PARCUAA IDENTIFICADOR PARCUAC ASIGNACION IDENTIFICADOR FINLINEA");
        gramatica.group("redon_abajo", "REDONDEO_HACIA_ABAJO PARCUAA IDENTIFICADOR PARCUAC ASIGNACION IDENTIFICADOR FINLINEA");
        gramatica.group("mcd", "MAXIMO_COMUN_DIVISOR PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA");
        gramatica.group("mcm", "MINIMO_COMUN_MULTIPLO PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA");

        // Definición de grupos de operaciones
        gramatica.group("operaciones_avanzadas", "potencia | raiz_cua | raiz_ene | loga_nat | log_b10 | exponencial | val_abso | facto | redondeo | redon_abajo | mcd | mcm");
        gramatica.group("operaciones_trigonometricas", "SENO PARCUAA IDENTIFICADOR PARCUAC ASIGNACION IDENTIFICADOR FINLINEA | COSENO PARCUAA IDENTIFICADOR PARCUAC ASIGNACION IDENTIFICADOR FINLINEA | TANGENTE PARCUAA IDENTIFICADOR PARCUAC ASIGNACION IDENTIFICADOR FINLINEA");
        gramatica.group("operaciones_basicas", "(SUMA | RESTA | MULTIPLICACION | DIVISION | MODULO) PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA");
        gramatica.group("operaciones_estadisticas", "MEDIANA PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA | VAR PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA | DESVESTA PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA | PROMEDIO PARCUAA IDENTIFICADOR (SEPARADOR IDENTIFICADOR)+ PARCUAC ASIGNACION IDENTIFICADOR FINLINEA");
        gramatica.group("operaciones", "(operaciones_basicas | operaciones_avanzadas | operaciones_trigonometricas | operaciones_comparacion | operaciones_estadisticas)*");

        // Definición de estructuras de control
        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("estructura_si", "SI PARA (comparacion)? PARC CORA (operaciones | estructura_si | estructura_mientras)* CORC");
        });

        // Estructura SI
        gramatica.group("estructura_si", "SI (comparacion)? PARC CORA (operaciones | estructura_si | estructura_mientras)* CORC", 414, "Error Sintactico {}: Falta el paréntesis de apertura [#,%]");
        gramatica.group("estructura_si", "SI PARA (comparacion)? CORA (operaciones | estructura_si | estructura_mientras)* CORC", 415, "Error Sintactico {}: Falta el paréntesis de cierre [#,%]");
        gramatica.group("estructura_si", "SI PARA (comparacion)? PARC (operaciones | estructura_si | estructura_mientras)* CORC", 416, "Error Sintactico {}: Falta la llave de apertura [#,%]");
        gramatica.group("estructura_si", "SI PARA (comparacion)? PARC CORA (operaciones | estructura_si | estructura_mientras)*", 417, "Error Sintactico {}: Falta la llave de cierre [#,%]");
        gramatica.group("estructura_si", "SI PARA PARC CORA (operaciones | estructura_si | estructura_mientras)* CORC", 418, "Error Sintactico {}: Falta la operación de comparación [#,%]");
        gramatica.group("estructura_si", "SI PARA (comparacion)? PARC CORA CORC", 418, "Error Sintactico {}: Falta las operaciones [#,%]");

        // Estructura MIENTRAS
        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("estructura_mientras", "MIENTRAS PARA (comparacion)? PARC CORA (operaciones | estructura_si | estructura_mientras)* CORC");
        });
        // Estructura MIENTRAS
        gramatica.group("estructura_mientras", "MIENTRAS PARA (comparacion)? PARC CORA (operaciones | estructura_si | estructura_mientras)* CORC", 424, "Error Sintactico {}: Falta el paréntesis de apertura [#,%]");
        gramatica.group("estructura_mientras", "MIENTRAS (comparacion)? PARC CORA (operaciones | estructura_si | estructura_mientras)* CORC", 425, "Error Sintactico {}: Falta el paréntesis de cierre [#,%]");
        gramatica.group("estructura_mientras", "MIENTRAS PARA (comparacion)? CORA (operaciones | estructura_si | estructura_mientras)* CORC", 426, "Error Sintactico {}: Falta la llave de apertura [#,%]");
        gramatica.group("estructura_mientras", "MIENTRAS PARA (comparacion)? PARC (operaciones | estructura_si | estructura_mientras)* CORC", 427, "Error Sintactico {}: Falta la llave de cierre [#,%]");
        gramatica.group("estructura_mientras", "MIENTRAS PARA PARC CORA (operaciones | estructura_si | estructura_mientras)* CORC", 428, "Error Sintactico {}: Falta la operación de comparación [#,%]");
        gramatica.group("estructura_mientras", "MIENTRAS PARA (comparacion)? PARC CORA CORC", 429, "Error Sintactico {}: Falta las operaciones [#,%]");

        // Bloques de procesos y variables
        gramatica.group("bloque_procesos", "PROCESOS CORA (operaciones | estructura_si | estructura_mientras)* CORC");
        gramatica.group("bloque_procesos", "PROCESOS (operaciones | estructura_si | estructura_mientras)* CORC", 9, "Error Sintactico {}: Falta abrir el corchete inicial bloque procesos[#,%]");
        gramatica.group("bloque_procesos", "PROCESOS CORA (operaciones | estructura_si | estructura_mientras)*", 10, "Error Sintactico {}: Falta cerrar el corchete bloque procesos [#,%]");

        gramatica.group("bloque_variables", "VARIABLES CORA (variable)* CORC ");
        gramatica.group("bloque_variables", "VARIABLES (variable)* CORC", 6, "Error Sintactico {}: Falta abrir el corchete inicial bloque variables [#,%]");
        gramatica.group("bloque_variables", "VARIABLES CORA (variable)*", 7, "Error Sintactico {}: Falta cerrar el corchete bloque variables [#,%]");

        //Bloque main
        gramatica.group("main", "(bloque_variables) (bloque_procesos)");
        gramatica.group("main", "(bloque_procesos)", 2, "Error Sintactico {}: Falta abrir el bloque variables [#,%]");
        gramatica.group("main", "(bloque_variables)", 3, "Error Sintactico {}: Falta abrir el bloque procesos [#,%]");

        // jtaOutputConsole.append(gramatica.toString());
        gramatica.initialLineColumn();

        jtaOutputConsole.append(gramatica.toString());
        gramatica.show();
    }

    private void semanticAnalysis() {
            DefaultTableModel tablaS = (DefaultTableModel) TblSimbolos.getModel();
        HashMap<String, String> identDataType = new HashMap<>();
        // Definición de tipos de datos
        identDataType.put("BOOLEANO", "BOOLEANO");
        identDataType.put("TEXTO", "TEXTO");
        identDataType.put("DECIMAL", "DECIMAL");
        identDataType.put("ENTERO", "ENTERO");
        identDataType.put("SUMA", "SUMA");

        for (Production id : identProd) {
            String tipoDato = id.lexemeRank(0);
            String valorAsignado = id.lexemeRank(3);
            String tipoEsperado = identDataType.get(tipoDato);
            System.out.println(tipoDato);
            // Errores Tipos de datos incompatibles con las variables
            if (!tipoEsperado.equals(id.lexicalCompRank(0))) {
                errors.add(new ErrorLSSL(1, "Error semántico {}: valor no compatible con el tipo de dato [#,%]", id, true));
            } else if (tipoDato.equals("ENTERO") && !valorAsignado.matches("[0-9]+")) {
                errors.add(new ErrorLSSL(2, "Error semántico {}: el valor no es un número entero [#,%]", id, false));
            } else if (tipoDato.equals("TEXTO") && !valorAsignado.matches("\"[0-9]*[a-zA-Z]+\"")) {
                errors.add(new ErrorLSSL(3, "Error semántico {}: el valor no es una cadena [#,%]", id, false));
            } else if (tipoDato.equals("DECIMAL") && !valorAsignado.matches("[+-]?([0-9]*[.])?[0-9]+([eE][+-]?[0-9]+)?")) {
                errors.add(new ErrorLSSL(4, "Error semántico {}: el valor no es un número flotante [#,%]", id, false));
            } else if (tipoDato.equals("BOOLEANO") && !valorAsignado.matches("verdadero|falso")) {
                errors.add(new ErrorLSSL(5, "Error semántico {}: solo se acepta 'verdadero' o 'falso' [#,%]", id, false));
            } else {
                identificadores.put(id.lexemeRank(1), valorAsignado);
                tablaSimbolos.put(id.lexemeRank(1), valorAsignado);
                tablaS.addRow(new Object[]{id.lexemeRank(1), tipoEsperado, valorAsignado});
                System.out.println("Agregado a la tabla de simbolos : "+identificadores.toString());
            }
//            System.out.println("\nSemantico:\n " + "LEXEMAS: " + id.lexemeRank(0, -1) + "\n  COMPONENTES LEXICOS: " + id.lexicalCompRank(0, -1));
        }
    }

    private void fillTableTokens() {
        tokens.forEach(token -> {
            Object[] data = new Object[]{token.getLexicalComp(), token.getLexeme(), "[" + token.getLine() + ", " + token.getColumn() + "]"};
            Functions.addRowDataInTable(tblTokens, data);
        });
    }

    private void printConsole() {
        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
            }
            jtaOutputConsole.append("Compilación terminada...\n" + strErrors + "\nLa compilación terminó con errores...");
        } else {
            jtaOutputConsole.append("Compilación terminada...");
        }
        jtaOutputConsole.setCaretPosition(0);
    }

    private void clearFields() {
        Functions.clearDataInTable(tblTokens);
        jtaOutputConsole.setText("");
        tokens.clear();
        errors.clear();
        identProd.clear();
        identificadores.clear();
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
