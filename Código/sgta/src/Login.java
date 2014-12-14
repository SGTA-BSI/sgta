

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jtcpf = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtsenha = new javax.swing.JPasswordField();
        jbentrar = new javax.swing.JButton();
        jbsair = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGTA - <Nome Academia>");
        setMinimumSize(new java.awt.Dimension(795, 451));
        setPreferredSize(new java.awt.Dimension(795, 451));
        setResizable(false);
        getContentPane().setLayout(null);

        jtcpf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtcpf.setToolTipText("");
        getContentPane().add(jtcpf);
        jtcpf.setBounds(50, 200, 170, 30);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("CPF:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 150, 40, 60);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Senha:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 250, 70, 40);
        getContentPane().add(jtsenha);
        jtsenha.setBounds(50, 290, 170, 30);

        jbentrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbentrar.setText("Entrar");
        getContentPane().add(jbentrar);
        jbentrar.setBounds(50, 360, 80, 23);

        jbsair.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbsair.setText("Sair");
        jbsair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbsairActionPerformed(evt);
            }
        });
        getContentPane().add(jbsair);
        jbsair.setBounds(170, 360, 70, 25);

        jLabel3.setFont(new java.awt.Font("Constantia", 3, 18)); // NOI18N
        jLabel3.setText("Login:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 120, 100, 40);

        jLabel4.setFont(new java.awt.Font("Vijaya", 1, 36)); // NOI18N
        jLabel4.setText("Seja Bem-Vindo!");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 30, 390, 60);

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Marco\\Desktop\\MMA LOGO.png")); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(280, 90, 500, 260);

        pack();
    }                        

    private void jbsairActionPerformed(java.awt.event.ActionEvent evt) {                                       
System.exit(0);
        
    }                                      

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }                    
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbentrar;
    private javax.swing.JButton jbsair;
    private javax.swing.JTextField jtcpf;
    private javax.swing.JPasswordField jtsenha;                
}