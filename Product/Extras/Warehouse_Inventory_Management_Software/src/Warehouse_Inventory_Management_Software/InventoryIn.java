package Warehouse_Inventory_Management_Software;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
public class InventoryIn extends javax.swing.JFrame {
    public InventoryIn() {
        initComponents();
        setISBN();
        setDate();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("karadi.jpg")));
    }
    // The setDate() function is used to retrieve and display the current date in a yyyy-MM-dd format
    public void setDate()
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dateobj = new Date();
        DateDisplay.setText(df.format(dateobj));
        
    }
    // The setISBN() function is used to retrieve and display the ISBN of the chosen book
    public void setISBN()
    {
        //Checking whether the combobox BookChoice is empty
        if(BookChoice.getSelectedItem().toString()!="Select")
        {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs_ia_data","root","xeno28972");
                //Querying the database to return back the ISBN of the chosen book
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
    //The addDataIn() function is used to insert details regarding an incoming transaction into the transaction_repository table
    public void addDataIn()
    {
        //The below code is used to check whether any of the text fields or combo boxes are empty
        if(InvenIn.getText().trim().isEmpty() || NumDmg.getText().trim().isEmpty()||BookChoice.getSelectedItem().toString()=="Select"||Source.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please ensure all fields are filled");
            InvenIn.setText("");
            NumDmg.setText("");
        } 
        //The if condition below is to validate the entered data by making sure that the number of books damaged is not more than the number of books that arrived
        else if(Integer.parseInt(InvenIn.getText())<Integer.parseInt(NumDmg.getText()))
        {
            JOptionPane.showMessageDialog(null,"Number of books damaged cannot be greater than total number of books in");
            InvenIn.setText("");
            NumDmg.setText("");
        }
        else 
        {
            /*The below code uses MySql and JDBC concepts to insert the number of books that arrived, number of books damaged, 
            the date, and the source of a single incoming transaction into the transaction_repository table*/
            try
            {   
                //Inserting the number of books in and the number of books damaged as entered by the user
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs_ia_data","root","xeno28972");
                String sql= "insert into transaction_repository(Dates,ISBN,Inventory_In,Inventory_Out,Number_Damaged,Source,Destination) values(?,?,?,?,?,?,?)";
                PreparedStatement pst= Conn.prepareStatement(sql);
                pst.setString(1,DateDisplay.getText());
                pst.setString(2,DisplayIsbn.getText());
                pst.setInt(3,Integer.parseInt(InvenIn.getText()));
                pst.setInt(4,0);
                pst.setInt(5,Integer.parseInt(NumDmg.getText()));
                pst.setString(6,Source.getText());
                pst.setString(7,"-");
                pst.executeUpdate();
                //Increasing the stock of the book in the warehouse based on inventory in 
                //and number damaged entered by the user
                int midStock= Integer.parseInt(InvenIn.getText())-Integer.parseInt(NumDmg.getText());
                String sql2="update book_identification set Stock=Stock+? where ISBN=?";
                PreparedStatement pst2= Conn.prepareStatement(sql2);
                pst2.setInt(1,midStock);
                pst2.setString(2,DisplayIsbn.getText());
                pst2.execute();
                JOptionPane.showMessageDialog(null,"The data has been sucessfully added");  
                InvenIn.setText("");
                NumDmg.setText("");
                Source.setText("");
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,e);    
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        DateDisplay = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        BookChoice = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        InvenIn = new javax.swing.JFormattedTextField();
        NumDmg = new javax.swing.JFormattedTextField();
        DisplayIsbn = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Source = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventory In");

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Inventory In");

        jLabel1.setText("Date:");

        jLabel4.setText("Book Name:");

        jLabel5.setText("Inventory_In");

        jLabel7.setText("Number Damaged");

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

        jButton7.setText("Add Data");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        InvenIn.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        InvenIn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                InvenInKeyPressed(evt);
            }
        });

        NumDmg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        jLabel6.setText("ISBN: ");

        Source.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SourceActionPerformed(evt);
            }
        });

        jLabel8.setText("Source for books");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Source)
                                    .addComponent(NumDmg, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DisplayIsbn, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                            .addComponent(BookChoice, 0, 1, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2))
                                    .addComponent(InvenIn, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DateDisplay))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(DateDisplay))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(BookChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DisplayIsbn)
                            .addComponent(jLabel6))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(InvenIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(NumDmg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Source, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // Takes administrator to the update database menu :
        UpdateDatabase UD= new UpdateDatabase();
        UD.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // The function is called when the "Add Data" button is pressed
        addDataIn();      
    }//GEN-LAST:event_jButton7ActionPerformed

    private void BookChoiceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BookChoiceKeyPressed

    }//GEN-LAST:event_BookChoiceKeyPressed

    private void BookChoiceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BookChoiceKeyReleased

    }//GEN-LAST:event_BookChoiceKeyReleased

    private void InvenInKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InvenInKeyPressed

    }//GEN-LAST:event_InvenInKeyPressed

    private void BookChoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookChoiceMouseClicked

    }//GEN-LAST:event_BookChoiceMouseClicked

    private void BookChoiceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookChoiceMousePressed


    }//GEN-LAST:event_BookChoiceMousePressed

    private void BookChoiceMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookChoiceMouseReleased
 
    }//GEN-LAST:event_BookChoiceMouseReleased

    private void BookChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookChoiceActionPerformed
        //The function is called when a book from the "BookChoice" combobox is chosen
        setISBN();   
    }//GEN-LAST:event_BookChoiceActionPerformed

    private void SourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SourceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SourceActionPerformed

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
            java.util.logging.Logger.getLogger(InventoryIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventoryIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BookChoice;
    private javax.swing.JLabel DateDisplay;
    private javax.swing.JLabel DisplayIsbn;
    private javax.swing.JFormattedTextField InvenIn;
    private javax.swing.JFormattedTextField NumDmg;
    private javax.swing.JFormattedTextField Source;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
