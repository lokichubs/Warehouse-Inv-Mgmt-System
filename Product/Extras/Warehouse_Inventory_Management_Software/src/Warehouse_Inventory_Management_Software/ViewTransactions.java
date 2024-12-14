package Warehouse_Inventory_Management_Software;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
public class ViewTransactions extends javax.swing.JFrame {
    public ViewTransactions() {
        initComponents();
        setISBN();
        transactionSearch();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("karadi.jpg")));
    }
    public void setISBN()
    {
        if(BookChoice.getSelectedItem().toString()!="Select")
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs_ia_data","root","xeno28972");
                String sql1= "Select ISBN from book_identification where Book_Name=?";
                PreparedStatement pst1= Conn.prepareStatement(sql1);
                pst1.setString(1,BookChoice.getSelectedItem().toString());
                ResultSet rs1= pst1.executeQuery();
                rs1.next();
                String Input_ISBN = rs1.getString(1);
                DisplayIsbn.setText(Input_ISBN);
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,e);    
            }
        }
        else
        {
            DisplayIsbn.setText("");
        }
    }
    /*The transactionSearch() function is used to retrieve all the details of all transactions made incoming from the transaction_repository table
    based on 2 search parameters: book name and date 
    */
    private void transactionSearch()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs_ia_data","root","xeno28972");
            //When both search paramaters are empty the entire list of transactions is returned
            if (BookChoice.getSelectedItem().toString()=="Select" && DateSearch.getText().trim().isEmpty() )
            {
                String sql= "Select * from transaction_repository";
                PreparedStatement pst= Conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                Display_Books.setModel(DbUtils.resultSetToTableModel(rs));
            }
            //When one of the search paramaters are entered, the list of transactions that match the date or book name is returned
            else if (BookChoice.getSelectedItem().toString()=="Select" && DateSearch.getText().trim().isEmpty()==false )
            {
                String sql= "Select * from transaction_repository where Dates=?";
                PreparedStatement pst= Conn.prepareStatement(sql);
                pst.setString(1,DateSearch.getText());
                ResultSet rs = pst.executeQuery();
                Display_Books.setModel(DbUtils.resultSetToTableModel(rs));
            }
            else if (BookChoice.getSelectedItem().toString()!="Select" && DateSearch.getText().trim().isEmpty()==true )
            {
                String sql= "Select * from transaction_repository where ISBN=?";
                PreparedStatement pst= Conn.prepareStatement(sql);
                pst.setString(1,DisplayIsbn.getText());
                ResultSet rs = pst.executeQuery();
                Display_Books.setModel(DbUtils.resultSetToTableModel(rs));
            }
            //When both the search paramaters are entered, the list of transactions that match the date and book name is returned
            else if (BookChoice.getSelectedItem().toString()!="Select" && DateSearch.getText().trim().isEmpty()==false )
            {
                String sql= "Select * from transaction_repository where ISBN=? and Dates=?";
                PreparedStatement pst= Conn.prepareStatement(sql);
                pst.setString(1,DisplayIsbn.getText());
                pst.setString(2,DateSearch.getText());
                ResultSet rs = pst.executeQuery();
                Display_Books.setModel(DbUtils.resultSetToTableModel(rs));
            }
            Conn.close();
            }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Display_Books = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        BookChoice = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        DisplayIsbn = new javax.swing.JLabel();
        DateSearch = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("View Transactions");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        Display_Books.setBackground(new java.awt.Color(153, 153, 153));
        Display_Books.setForeground(new java.awt.Color(255, 255, 255));
        Display_Books.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Display_Books);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Choose the name of the book and/ or date of transaction below (take note that the search is case sensitive)");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        BookChoice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "The Monkey King", "Birth of Krshna &Krishna Conquest / Young Hanuman & Hanuman the Mighty", "Hungry Caterpillar Billingual", "Tiny Seed Billingual", "Mixed Up Chameleon Billingual", "Little Vinayak", "Lizards Tail", "Monkeys on A Fast", "The Boy Who Drew Cats", "Whose lovely child can you be", "The Rumour", "The Last Bargain", "The Tallest Tale", "Book worm", "Tak tak", "The Moustache Man", "When the Earth Lost Its Shapes", "Dorje's Stripes", "Revenge of Puppets", "The Dancing Bear", "An Elephant in my backyard", "A Big Mouth", "Tit for tat", "The Tiger Eater's", "The Crocodile's Tail", "The Story and the song", "The Case of the Stolen Smells", "What Will I Be", "What Could It Be?", "What Will You Give Me", "Where Shall We Go", "Fetch That Colour", "Let's Roll Out a Circle", "The Wednesday Bazaar", "Bela Misses Her Train", "Thea's Tree", "A Pair of Twins", "The Fox and the Crow", "Whimsy", "The Dragon's Toothache", "Farmer Falgu Goes On A Trip", "Farmer Falgu Goes To The Market", "The Lions Feast", "The Night Monster", "What did the monster child eat today", "Princess Easy Pleasy", "Farmer Falgu Goes to the Kumbh Mela", "Farmer Falgu Goes kite Flying", "Dada's Useless Present", "A Tangle of Brungles", "The Insect Boy", "Fly Little Fish", "The Clever Tailor", "Sadiq Wants to Stitch", "Babban Hajjam", "Letter to Ammi", "Papa's Marathon", "Star Struck", "The Truth about the Tooth", "Thukpa for All", "The Brave Parrot", "Cat's Egg-Indian", "Daisy Doll", "Sion Misfortune", "One Rainy Day", "Mountain of Mumbai", "Get OFF that Camel", "Thatha's Pumpkin New Title 2020", "Rats Bigger than Cats New Title 2020" }));
        BookChoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookChoiceMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BookChoiceMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                BookChoiceMouseReleased(evt);
            }
        });
        BookChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookChoiceActionPerformed(evt);
            }
        });
        BookChoice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BookChoiceKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BookChoiceKeyReleased(evt);
            }
        });

        jLabel4.setText("Book Name:");

        jLabel6.setText("ISBN: ");

        jLabel2.setText("Date(yyyy-MM-dd)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BookChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DateSearch)
                            .addComponent(DisplayIsbn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(BookChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(DisplayIsbn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(DateSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Takes administrator to the update database menu:
        UpdateDatabase ud = new UpdateDatabase();
        ud.setVisible(true);
        setVisible(false);
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //The function is called when the "Search" button is pressed
        transactionSearch();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BookChoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookChoiceMouseClicked
        
    }//GEN-LAST:event_BookChoiceMouseClicked

    private void BookChoiceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookChoiceMousePressed
        
    }//GEN-LAST:event_BookChoiceMousePressed

    private void BookChoiceMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookChoiceMouseReleased
        
    }//GEN-LAST:event_BookChoiceMouseReleased

    private void BookChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookChoiceActionPerformed
        setISBN();
    }//GEN-LAST:event_BookChoiceActionPerformed

    private void BookChoiceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BookChoiceKeyPressed
        
    }//GEN-LAST:event_BookChoiceKeyPressed

    private void BookChoiceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BookChoiceKeyReleased
        
    }//GEN-LAST:event_BookChoiceKeyReleased

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
            java.util.logging.Logger.getLogger(ViewTransactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTransactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTransactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTransactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewTransactions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BookChoice;
    private javax.swing.JFormattedTextField DateSearch;
    private javax.swing.JLabel DisplayIsbn;
    private javax.swing.JTable Display_Books;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
