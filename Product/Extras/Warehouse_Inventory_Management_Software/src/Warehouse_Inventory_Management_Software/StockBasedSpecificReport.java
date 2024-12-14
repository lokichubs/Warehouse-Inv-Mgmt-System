package Warehouse_Inventory_Management_Software;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
public class StockBasedSpecificReport extends javax.swing.JFrame {
    public StockBasedSpecificReport() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("karadi.jpg")));
        setDate();
        
    }
    public void CreateSBSR()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs_ia_data","root","xeno28972");
            String sql="select transaction_repository.ISBN,SUM(Number_Damaged) as \"No.Damaged\", SUM(Inventory_In) as \"Inventory In\","
            + "SUM(Inventory_Out) as \"Inventory Out\",(SUM(Inventory_In)-SUM(Number_Damaged)-SUM(Inventory_Out)) as \"Stock Flow\","
            + "((SUM(Number_Damaged)/SUM(Inventory_In))*100) as \"% Damaged\" from book_identification JOIN transaction_repository "
            + "ON book_identification.ISBN = transaction_repository.ISBN where book_identification.ISBN=? and transaction_repository.ISBN=? "
            + "and Dates between ? and ? group by transaction_repository.ISBN";
            PreparedStatement pst= Conn.prepareStatement(sql);
            pst.setString(1,IsbnDisplay.getText());
            pst.setString(2,IsbnDisplay.getText());
            pst.setString(3,DisplayStartDate.getText());
            pst.setString(4,DisplayEndDate.getText());
            ResultSet rs = pst.executeQuery();
            Display_Report.setModel(DbUtils.resultSetToTableModel(rs)); 
            if (Display_Report.getRowCount()==0)
            {
                JOptionPane.showMessageDialog(null,"There are no transactions in that date range for that book");
                CreateReports cr= new CreateReports();
                cr.setVisible(true);
                setVisible(false);
            }
        }                   
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }   
        
    }
    public void setDate()
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dateobj = new Date();
        DateDisplay.setText(df.format(dateobj)); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Report_Print = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        DisplayStartDate = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        DisplayEndDate = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        IsbnDisplay = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        DateDisplay = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Display_Report = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DisplayComments = new javax.swing.JTextArea();
        PrintButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stock Based Specific Report");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        Report_Print.setBackground(new java.awt.Color(255, 255, 255));
        Report_Print.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Report_Print.setPreferredSize(new java.awt.Dimension(660, 924));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Stock Based Specific Report");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Made By:");

        Name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Name.setText("Name");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Start Date: ");

        DisplayStartDate.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        DisplayStartDate.setText("DisplayStartDate");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("End Date:");

        DisplayEndDate.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        DisplayEndDate.setText("DisplayEndDate");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("ISBN:");

        IsbnDisplay.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        IsbnDisplay.setText("ISBN");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Current Date:");

        DateDisplay.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        DateDisplay.setText("DateDisplay");

        Display_Report.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Display_Report);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Comments:");

        DisplayComments.setColumns(20);
        DisplayComments.setRows(5);
        jScrollPane2.setViewportView(DisplayComments);

        javax.swing.GroupLayout Report_PrintLayout = new javax.swing.GroupLayout(Report_Print);
        Report_Print.setLayout(Report_PrintLayout);
        Report_PrintLayout.setHorizontalGroup(
            Report_PrintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Report_PrintLayout.createSequentialGroup()
                .addGroup(Report_PrintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Report_PrintLayout.createSequentialGroup()
                        .addGroup(Report_PrintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Report_PrintLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DisplayStartDate)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DisplayEndDate)
                                .addGap(23, 23, 23)
                                .addComponent(jLabel8)
                                .addGap(10, 10, 10)
                                .addComponent(IsbnDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Report_PrintLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Name)
                                .addGap(192, 192, 192)))
                        .addComponent(DateDisplay))
                    .addGroup(Report_PrintLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1)))
                .addGap(10, 10, 10))
            .addGroup(Report_PrintLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Report_PrintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Report_PrintLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Report_PrintLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(105, 105, 105))
        );
        Report_PrintLayout.setVerticalGroup(
            Report_PrintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Report_PrintLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Report_PrintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Report_PrintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Report_PrintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(DisplayStartDate)
                        .addComponent(jLabel6)
                        .addComponent(DisplayEndDate))
                    .addGroup(Report_PrintLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(IsbnDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addComponent(DateDisplay)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PrintButton.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        PrintButton.setText("Print");
        PrintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintButtonActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jButton4.setText("Fetch Data");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Report_Print, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PrintButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Report_Print, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrintButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PrintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintButtonActionPerformed
        //Printer Instance is created when the "Print" button is clicked
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName(" Print Data ");
        //The characteristics of the printable sheet are determined
        job.setPrintable (new Printable() 
        {    
            public int print(Graphics pg, PageFormat pf, int pageNum)
            {
                pf.setOrientation(PageFormat.LANDSCAPE);
                if (pageNum > 0)
                {
                    return Printable.NO_SUCH_PAGE;  
                }
                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                //Scaling of Report_Print Jframe to the A4 sheet size
                g2.scale(0.92641,0.85628);
                Report_Print.paint(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        //Checking whether the button "OK" is pressed in the print dialogue
        boolean ok= job.printDialog();
        if(ok)
        {
            try 
            {
                //Document is printed
                job.print();
            }    
            catch (PrinterException ex) 
            {
            
            }
        }    
    }//GEN-LAST:event_PrintButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CreateReports cr = new CreateReports();
        cr.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        CreateSBSR();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(StockBasedSpecificReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockBasedSpecificReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockBasedSpecificReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockBasedSpecificReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockBasedSpecificReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DateDisplay;
    public static javax.swing.JTextArea DisplayComments;
    public static javax.swing.JLabel DisplayEndDate;
    public static javax.swing.JLabel DisplayStartDate;
    private javax.swing.JTable Display_Report;
    public static javax.swing.JLabel IsbnDisplay;
    public static javax.swing.JLabel Name;
    private javax.swing.JButton PrintButton;
    private javax.swing.JPanel Report_Print;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
