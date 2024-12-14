package Warehouse_Inventory_Management_Software;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CreateReports extends javax.swing.JFrame {
    public CreateReports() {
        initComponents();
        setISBN();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("karadi.jpg")));
        
    }
    public void setISBN()
    {
        if(BookChoice.getSelectedItem().toString()!="Select" && BookChoice.getSelectedItem().toString()!="General" )
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        BookChoice = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        StartDate = new javax.swing.JFormattedTextField();
        EndDate = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        ReportChoice = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        DisplayIsbn = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        NameChoice = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        Comments = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Create Reports");

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jButton6.setText("Menu");
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
            .addGap(0, 578, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Create Report");

        jLabel4.setText("Book Name:");

        jLabel5.setText("Start Date: ");

        jLabel7.setText("End Date: ");

        BookChoice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "General", "The Monkey King", "Birth of Krshna &Krishna Conquest / Young Hanuman & Hanuman the Mighty", "Hungry Caterpillar Billingual", "Tiny Seed Billingual", "Mixed Up Chameleon Billingual", "Little Vinayak", "Lizards Tail", "Monkeys on A Fast", "The Boy Who Drew Cats", "Whose lovely child can you be", "The Rumour", "The Last Bargain", "The Tallest Tale", "Book worm", "Tak tak", "The Moustache Man", "When the Earth Lost Its Shapes", "Dorje's Stripes", "Revenge of Puppets", "The Dancing Bear", "An Elephant in my backyard", "A Big Mouth", "Tit for tat", "The Tiger Eater's", "The Crocodile's Tail", "The Story and the song", "The Case of the Stolen Smells", "What Will I Be", "What Could It Be?", "What Will You Give Me", "Where Shall We Go", "Fetch That Colour", "Let's Roll Out a Circle", "The Wednesday Bazaar", "Bela Misses Her Train", "Thea's Tree", "A Pair of Twins", "The Fox and the Crow", "Whimsy", "The Dragon's Toothache", "Farmer Falgu Goes On A Trip", "Farmer Falgu Goes To The Market", "The Lions Feast", "The Night Monster", "What did the monster child eat today", "Princess Easy Pleasy", "Farmer Falgu Goes to the Kumbh Mela", "Farmer Falgu Goes kite Flying", "Dada's Useless Present", "A Tangle of Brungles", "The Insect Boy", "Fly Little Fish", "The Clever Tailor", "Sadiq Wants to Stitch", "Babban Hajjam", "Letter to Ammi", "Papa's Marathon", "Star Struck", "The Truth about the Tooth", "Thukpa for All", "The Brave Parrot", "Cat's Egg-Indian", "Daisy Doll", "Sion Misfortune", "One Rainy Day", "Mountain of Mumbai", "Get OFF that Camel", "Thatha's Pumpkin New Title 2020", "Rats Bigger than Cats New Title 2020" }));
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

        jButton7.setText("Create Report");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        StartDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        StartDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                StartDateKeyPressed(evt);
            }
        });

        EndDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        jLabel6.setText("ISBN: ");

        ReportChoice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Stock-Based", "Price-Based" }));
        ReportChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportChoiceActionPerformed(evt);
            }
        });

        jLabel1.setText("Type of Report");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Choose the :");

        jLabel9.setText("1) Type of report you would like to produced");

        jLabel10.setText("2) Would you like a specific report(one book) or a general report(all books). ");

        jLabel11.setText("If you would choose the latter, select \"general\".");

        DisplayIsbn.setText("jLabel12");

        jLabel12.setText("Otherwise choose the book you would like to produce the report for.");

        jLabel13.setText("3) Enter the start and end date for the report(yyyy-MM-dd)");

        jLabel14.setText("5) Enter any comments you would like ");

        jLabel15.setText("4) Choose your name:");

        jLabel16.setText("Name:");

        NameChoice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Abubucker. M", "Gopinath. D", "Kripakaran. P", "Sathiskumar. M" }));

        Comments.setColumns(20);
        Comments.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Comments.setRows(5);
        jScrollPane1.setViewportView(Comments);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(StartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(EndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel15))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ReportChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7)
                        .addGap(100, 100, 100))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BookChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DisplayIsbn)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NameChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(72, 72, 72)
                                .addComponent(jLabel10))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ReportChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)))
                .addGap(5, 5, 5)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(BookChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(DisplayIsbn))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(NameChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //Takes administrator to the main menu:
        MainMenu menu= new MainMenu();
        menu.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        //Carried out when the "Create Report" button is pressed
        try 
        {
            //Converting text to date in the yyyy-MM-dd format
            
            //Validation to make sure that none of the fields are empty
            if(ReportChoice.getSelectedItem().toString()=="Select"||NameChoice.getSelectedItem().toString()=="Select"||BookChoice.getSelectedItem().toString()=="Select"||StartDate.getText().trim().isEmpty()||EndDate.getText().trim().isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Please ensure all fields are filled");
            }
            String sDate1 =StartDate.getText();
            String eDate1= EndDate.getText();
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
            Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(eDate1);
            //Valudation to make sure that the start date entered is before the end date entered
            if(date1.after(date2)==true || date1.compareTo(date2)==0)
            {
                JOptionPane.showMessageDialog(null,"Please make sure that start date is before end date");
            }
            /*Nested if conditions to direct the user to the correct report page
            In each if condition, paramater passing is used to transfer data from this Jframe to the 
            corresponding Report Jframe*/
            else if (ReportChoice.getSelectedItem().toString()=="Stock-Based" && BookChoice.getSelectedItem().toString()=="General")
            {
                StockBasedGeneralReport sbgr= new StockBasedGeneralReport();
                StockBasedGeneralReport.Name.setText(CreateReports.NameChoice.getSelectedItem().toString());
                StockBasedGeneralReport.DisplayStartDate.setText(CreateReports.StartDate.getText());
                StockBasedGeneralReport.DisplayEndDate.setText(CreateReports.EndDate.getText());
                StockBasedGeneralReport.DisplayComments.setText(CreateReports.Comments.getText());
                sbgr.setVisible(true);
                setVisible(false);
                
            }
            else if (ReportChoice.getSelectedItem().toString()=="Stock-Based" && BookChoice.getSelectedItem().toString()!="General")
            {
                StockBasedSpecificReport sbcr= new StockBasedSpecificReport();
                StockBasedSpecificReport.Name.setText(CreateReports.NameChoice.getSelectedItem().toString());
                StockBasedSpecificReport.DisplayStartDate.setText(CreateReports.StartDate.getText());
                StockBasedSpecificReport.DisplayEndDate.setText(CreateReports.EndDate.getText());
                StockBasedSpecificReport.DisplayComments.setText(CreateReports.Comments.getText());
                StockBasedSpecificReport.IsbnDisplay.setText(CreateReports.DisplayIsbn.getText());
                sbcr.setVisible(true);
                setVisible(false);
            }
            else if (ReportChoice.getSelectedItem().toString()=="Price-Based" && BookChoice.getSelectedItem().toString()=="General")
            {
                PriceBasedGeneralReport pbgr= new PriceBasedGeneralReport();
                PriceBasedGeneralReport.Name.setText(CreateReports.NameChoice.getSelectedItem().toString());
                PriceBasedGeneralReport.DisplayStartDate.setText(CreateReports.StartDate.getText());
                PriceBasedGeneralReport.DisplayEndDate.setText(CreateReports.EndDate.getText());
                PriceBasedGeneralReport.DisplayComments.setText(CreateReports.Comments.getText());
                pbgr.setVisible(true);
                setVisible(false);
            }
            //Checking whether the user wants a price based specific report
            else if (ReportChoice.getSelectedItem().toString()=="Price-Based" && BookChoice.getSelectedItem().toString()!="General")
            {
                //Creating object to help pass variable values to the next JFrame
                PriceBasedSpecificReport pbsr= new PriceBasedSpecificReport();
                //Passing the name, start date, comments, and ISBN to the report layout
                PriceBasedSpecificReport.Name.setText(CreateReports.NameChoice.getSelectedItem().toString());
                PriceBasedSpecificReport.DisplayStartDate.setText(CreateReports.StartDate.getText());
                PriceBasedSpecificReport.DisplayEndDate.setText(CreateReports.EndDate.getText());
                PriceBasedSpecificReport.DisplayComments.setText(CreateReports.Comments.getText());
                PriceBasedSpecificReport.IsbnDisplay.setText(CreateReports.DisplayIsbn.getText());
                //Making the report visible 
                pbsr.setVisible(true);
                setVisible(false);
            }
        } 
        catch (ParseException ex)
        {
            Logger.getLogger(CreateReports.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void StartDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StartDateKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_StartDateKeyPressed

    private void ReportChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportChoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReportChoiceActionPerformed

    private void BookChoiceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BookChoiceKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_BookChoiceKeyReleased

    private void BookChoiceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BookChoiceKeyPressed
        // TODO add yosetISBN();ur handling code here:
    }//GEN-LAST:event_BookChoiceKeyPressed

    private void BookChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookChoiceActionPerformed
        setISBN();
    }//GEN-LAST:event_BookChoiceActionPerformed

    private void BookChoiceMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookChoiceMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_BookChoiceMouseReleased

    private void BookChoiceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookChoiceMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_BookChoiceMousePressed

    private void BookChoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookChoiceMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BookChoiceMouseClicked

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
            java.util.logging.Logger.getLogger(CreateReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateReports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateReports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BookChoice;
    public static javax.swing.JTextArea Comments;
    public static javax.swing.JLabel DisplayIsbn;
    public static javax.swing.JFormattedTextField EndDate;
    public static javax.swing.JComboBox<String> NameChoice;
    private javax.swing.JComboBox<String> ReportChoice;
    public static javax.swing.JFormattedTextField StartDate;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
