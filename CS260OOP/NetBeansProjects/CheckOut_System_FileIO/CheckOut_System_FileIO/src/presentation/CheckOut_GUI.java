/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;
import helpers.*;
import business.*;
import javax.swing.DefaultListModel;

public class CheckOut_GUI extends javax.swing.JFrame {


    private Item aItem; 
    private ItemList list;
    private final DefaultListModel<Item> listModel;
    Boolean asObjects = true;
    
    public CheckOut_GUI() {
        initComponents();
        clear();
        list = new ItemList();
        listModel = new DefaultListModel<>();
        lstItems.setModel(listModel);
    }
    private void showDetails() {
        if (lstItems.getSelectedIndex() != -1) {
            aItem = lstItems.getSelectedValue();
            txtDetails.setText(aItem.getDetails());
        }
    }
    private void setSummary() {
        txtSummary.setText(list.getSummary());
    }
    private void clear() {
        aItem = new Item();
        GUIUtilities.clearInputFields(pnlPerson);
        GUIUtilities.clearInputFields(pnlItem);
    }
    private void submit() {
        boolean valid;
        if (aItem == null) {
            clear();
        }
        valid = getFirstName();
        if (valid) {
            valid = getLastName();
        }
        if (valid) {
            valid = getEmail();
        }
        if (valid) {
           valid =  getPhone();
        }
        if (valid) {
            valid = getItemName();
        }
        if (valid) {
            valid = getCost();
        }
        if (valid) {
            getDescription();
            list.add(aItem);
            listModel.addElement(aItem);
            setSummary();
            OutputHelpers.showStandardDialog(aItem.getDetails(), "Item Details");
        }
    }
    private boolean getFirstName() {
        boolean valid = true;
        String tmpStr = InputHelpers.getStringField(txtFirstName, "First Name");
        if (!StringHelpers.IsNullOrEmpty(tmpStr)) {
            aItem.getPerson().setFirstName(tmpStr);
        }
        else {
            valid = false;
            txtFirstName.requestFocus();
        }
        return valid;
    }
    private boolean getLastName() {
        boolean valid = true;
        String tmpStr = InputHelpers.getStringField(txtLastName, "Last Name");
        if (!StringHelpers.IsNullOrEmpty(tmpStr)) {
            aItem.getPerson().setLastName(tmpStr);
        }
        else {
            valid = false;
            txtLastName.requestFocus();
        }
        return valid;
    }
    private boolean getEmail() {
        boolean valid = true;
        String tmpStr = InputHelpers.getStringField(txtEmail, "Email");
         if (!StringHelpers.IsNullOrEmpty(tmpStr)) {
            if (StringHelpers.validateEmail(tmpStr)) {
                aItem.getPerson().setEmail(tmpStr);
            }
            else {
                valid = false;
                OutputHelpers.showExceptionDialog("Invalid email", "Invalid Email");
                txtEmail.selectAll();
                txtEmail.requestFocus();
            }
        }
        else {
            valid = false;
            txtEmail.requestFocus();
        }
        return valid;
    }
    private boolean getPhone() {
        boolean valid = true;
        String tmpStr = InputHelpers.getStringField(txtPhone, "Phone");
         if (!StringHelpers.IsNullOrEmpty(tmpStr)) {
            if (StringHelpers.validatePhoneNumber(tmpStr)) {
                aItem.getPerson().setPhone(tmpStr);
            }
            else {
                valid = false;
                OutputHelpers.showExceptionDialog("Invalid Phone", "Invalid Phone");
                txtPhone.selectAll();
                txtPhone.requestFocus();
            }
        }
        else {
            valid = false;
            txtEmail.requestFocus();
        }
        return valid;
    }
    private boolean getItemName() {
        boolean valid = true;
        String tmpStr = InputHelpers.getStringField(txtItemName, "Item Name");
         if (!StringHelpers.IsNullOrEmpty(tmpStr)) {
            aItem.setItemName(tmpStr);
        }
        else {
            valid = false;
            txtItemName.requestFocus();
        }
        return valid;
    }
    private boolean getCost() {
        boolean valid = true;
        double value;
        value = InputHelpers.parseDoubleField(txtCost, "Item Cost", Item.MIN_COST, Item.MAX_COST);
        if (value != InputHelpers.CANCEL_FLAG){
            aItem.setCost(value);
        }
        else {
            valid = false;
            txtCost.requestFocus();
        }
        return valid;
    }
    private void getDescription() {
        aItem.setDescription(txtDescription.getText());
    }
    /********** FILE OPERATIONS ***********************/
    private void saveList() {
        int count = 0;
        String message;
        count = list.saveList(asObjects);
        message = count + " Items stored";
        OutputHelpers.showStandardDialog(message, "Checkout Items Stored");
    }
    private void getList() {
        int count = 0;
        String message;
        listModel.clear();
        count = list.getList(listModel, asObjects); 
        message = count + " checkout item records retrieved";
        OutputHelpers.showStandardDialog(message, "Checkout Items Retrieved");
        setSummary();
        
    }
    
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        grpFileType = new javax.swing.ButtonGroup();
        lblWelcome = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlCheckout = new javax.swing.JPanel();
        pnlItem = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtItemName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCost = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        pnlPerson = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        pnlSummary = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstItems = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDetails = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtSummary = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        btnGetList = new javax.swing.JButton();
        radObjects = new javax.swing.JRadioButton();
        radStream = new javax.swing.JRadioButton();
        btnExit = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblWelcome.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(0, 0, 255));
        lblWelcome.setText("Checkout Service");
        lblWelcome.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblWelcome.setName("lblWelcome"); // NOI18N

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 80));

        pnlItem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Item to Checkout", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel5.setText("Item Name");

        txtItemName.setToolTipText("Enter your first name");

        jLabel6.setText("Item Cost");

        txtCost.setToolTipText("Enter your last name");

        jLabel9.setText("Description");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        javax.swing.GroupLayout pnlItemLayout = new javax.swing.GroupLayout(pnlItem);
        pnlItem.setLayout(pnlItemLayout);
        pnlItemLayout.setHorizontalGroup(
            pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtItemName)
                    .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlItemLayout.setVerticalGroup(
            pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPerson.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Checked out to", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel7.setText("First Name");

        txtFirstName.setToolTipText("Enter your first name");

        jLabel8.setText("Last Name");

        txtLastName.setToolTipText("Enter your last name");

        jLabel10.setText("Email");
        jLabel10.setToolTipText("");

        txtEmail.setToolTipText("Enter your last name");

        jLabel11.setText("Phone");

        txtPhone.setToolTipText("Enter your last name");

        javax.swing.GroupLayout pnlPersonLayout = new javax.swing.GroupLayout(pnlPerson);
        pnlPerson.setLayout(pnlPersonLayout);
        pnlPersonLayout.setHorizontalGroup(
            pnlPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPersonLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlPersonLayout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPersonLayout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlPersonLayout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        pnlPersonLayout.setVerticalGroup(
            pnlPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(57, 57, 57))
        );

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnNew.setText("New Item");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCheckoutLayout = new javax.swing.GroupLayout(pnlCheckout);
        pnlCheckout.setLayout(pnlCheckoutLayout);
        pnlCheckoutLayout.setHorizontalGroup(
            pnlCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCheckoutLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCheckoutLayout.createSequentialGroup()
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pnlItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlPerson, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 27, Short.MAX_VALUE))
        );
        pnlCheckoutLayout.setVerticalGroup(
            pnlCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCheckoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSubmit)
                    .addComponent(btnNew))
                .addGap(61, 61, 61))
        );

        jTabbedPane1.addTab("Item Checkout", pnlCheckout);

        lstItems.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstItemsValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstItems);

        txtDetails.setColumns(20);
        txtDetails.setRows(5);
        jScrollPane3.setViewportView(txtDetails);

        jLabel2.setText("Item List");

        jLabel3.setText("Item Details");

        jLabel4.setText("Checkout Summary");

        txtSummary.setColumns(20);
        txtSummary.setRows(5);
        jScrollPane4.setViewportView(txtSummary);

        btnSave.setText("Save List");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnGetList.setText("Get List");
        btnGetList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetListActionPerformed(evt);
            }
        });

        grpFileType.add(radObjects);
        radObjects.setSelected(true);
        radObjects.setText("Use Object File");
        radObjects.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radObjectsItemStateChanged(evt);
            }
        });

        grpFileType.add(radStream);
        radStream.setText("Use Stream File");
        radStream.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radStreamItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlSummaryLayout = new javax.swing.GroupLayout(pnlSummary);
        pnlSummary.setLayout(pnlSummaryLayout);
        pnlSummaryLayout.setHorizontalGroup(
            pnlSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSummaryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnlSummaryLayout.createSequentialGroup()
                            .addGroup(pnlSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(pnlSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel4)
                        .addComponent(jScrollPane4))
                    .addGroup(pnlSummaryLayout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(radObjects))
                    .addGroup(pnlSummaryLayout.createSequentialGroup()
                        .addComponent(btnGetList, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(radStream)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSummaryLayout.setVerticalGroup(
            pnlSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSummaryLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(pnlSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(radObjects))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGetList)
                    .addComponent(radStream))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Checkout Summary", pnlSummary);

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblWelcome)
                        .addGap(253, 253, 253))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(btnExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        ApplicationHelpers.terminateGUIApplication("Check out System");
    }//GEN-LAST:event_btnExitActionPerformed

    private void lstItemsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstItemsValueChanged
        showDetails();
    }//GEN-LAST:event_lstItemsValueChanged

    private void radStreamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radStreamItemStateChanged
        if (radStream.isSelected()) {
            asObjects = false;
        }
    }//GEN-LAST:event_radStreamItemStateChanged

    private void radObjectsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radObjectsItemStateChanged
         if (radObjects.isSelected()) {
            asObjects = true;
        }
    }//GEN-LAST:event_radObjectsItemStateChanged

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        submit();
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clear();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        saveList();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnGetListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetListActionPerformed
        getList();
    }//GEN-LAST:event_btnGetListActionPerformed

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
            java.util.logging.Logger.getLogger(CheckOut_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckOut_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckOut_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckOut_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CheckOut_GUI mainForm = new CheckOut_GUI();
                mainForm.setVisible(true);
                GUIUtilities.centerForm(mainForm);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGetList;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSubmit;
    private javax.swing.ButtonGroup grpFileType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JList<Item> lstItems;
    private javax.swing.JPanel pnlCheckout;
    private javax.swing.JPanel pnlItem;
    private javax.swing.JPanel pnlPerson;
    private javax.swing.JPanel pnlSummary;
    private javax.swing.JRadioButton radObjects;
    private javax.swing.JRadioButton radStream;
    private javax.swing.JTextField txtCost;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextArea txtDetails;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextArea txtSummary;
    // End of variables declaration//GEN-END:variables
}
