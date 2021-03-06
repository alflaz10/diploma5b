package Skoda;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author krenarujkaj
 */
public class print extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet re = null;
    PreparedStatement pst = null;

    String PrintFatura(String data, String garancia, String kmh, String kmd, String klienti, String telefoni, String totali) {
        String fatura;
        fatura = "<html><body><table cellspacing='1' cellpadding='1' style='border:1px;'>";
        fatura = fatura + "<tr><th colspan='5' align='center'><h3>Skoda</h3></th></tr>";

        fatura = fatura + "<tr><td colspan='2'<p>Data : </p></td>";
        fatura = fatura + "<td colspan='3' align='right'><p>" + data + "</p></td></tr>";

        fatura = fatura + "<tr><td colspan='2'<p>Garancia : </p></td>";
        fatura = fatura + "<td colspan='3' align='right'><p>" + garancia + "</p></td></tr>";

        fatura = fatura + "<tr><td colspan='2'<p>KM Hyrje : </p></td>";
        fatura = fatura + "<td colspan='3' align='right'><p>" + kmh + " KM</p></td></tr>";

        fatura = fatura + "<tr><td colspan='2'<p>KM Dalje : </p></td>";
        fatura = fatura + "<td colspan='3' align='right'><p>" + kmd + " KM</p></td></tr>";

        fatura = fatura + "<tr><td colspan='2'<p>Klienti : </p></td>";
        fatura = fatura + "<td colspan='3' align='right'><p>" + klienti + "</p></td></tr>";

        fatura = fatura + "<tr><td colspan='2'<p>Telefoni : </p></td>";
        fatura = fatura + "<td colspan='3' align='right'><p>" + telefoni + "</p></td></tr>";

        fatura = fatura + "<tr style='border-bottom: thin solid black'><th width='300px'align='center'>Kodi</th>";
        fatura = fatura + "<th width='50px' align='left'>Produkti</th><th width='50px' align='center'>Sasia</th>";
        fatura = fatura + "<th width='50px' align='right'>Cmimi</th><th width='50px' align='right'>Vlera</th></tr>";
        try {

            conn = DB_Connection.ConnectDb();
            pst = conn.prepareStatement("select * from fatura");
            re = pst.executeQuery();
            while (re.next()) {
                fatura = fatura + "<tr><td align='center'>"
                        + re.getInt(1) + "</td><td align='left'>"
                        + re.getString(2) + "</td><td align='center'>"
                        + re.getInt(3) + "</td><td align='right'>"
                        + re.getDouble(4) + "</td><td align='right'>"
                        + re.getDouble(5) + "</td></tr>";
            }
            conn.close();
        } catch (Exception e) {

        }
        fatura = fatura + "<tr style='border-top: thin solid black'><td></td><td align='center'><p>Totali : </p></td><th colspan='3'align='right'><p>" + totali + " L</p></th></tr>";
        fatura = fatura + "<tr style='border-bottom: thin solid black;'><td colspan='5' align='center'><p>Faleminderit!!</p></td></tr>";
        fatura = fatura + "<tr><td colspan='5' align='center'><p>&#0169 N&G Tel:0673769404 | 0688319895 </p></td></tr>";
        fatura = fatura + "<tr><td colspan='5' align='center'><p>E-Mail: ng.entwicklers@gmail.com</p></td></tr>";
        fatura = fatura + "</table></body></html>";
        return fatura;

    }

    boolean printimi() {
        PrinterJob job = PrinterJob.getPrinterJob();

        job.setJobName(
                "Fatura");
        job.setPrintable(new Printable() {

            public int print(Graphics pg, PageFormat pf, int pageNum) {
                if (pageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());

               // jPanelPrint.printComponents(g2);
                jLabelPrint.printAll(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (PrinterException ex) {
            }
        }
        return ok;
    }

    /**
     * Creates new form print
     */
    public print() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrint = new javax.swing.JPanel();
        jLabelPrint = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Porosia");
        setResizable(false);

        jPanelPrint.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPrint.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabelPrint.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanelPrintLayout = new javax.swing.GroupLayout(jPanelPrint);
        jPanelPrint.setLayout(jPanelPrintLayout);
        jPanelPrintLayout.setHorizontalGroup(
            jPanelPrintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
            .addGroup(jPanelPrintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPrintLayout.createSequentialGroup()
                    .addComponent(jLabelPrint, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanelPrintLayout.setVerticalGroup(
            jPanelPrintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
            .addGroup(jPanelPrintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabelPrint, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(233, 474));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new print().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel jLabelPrint;
    private javax.swing.JPanel jPanelPrint;
    // End of variables declaration//GEN-END:variables
}
