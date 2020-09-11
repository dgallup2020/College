/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;
 

import business.*;
import helpers.ApplicationHelpers;
import helpers.GUIUtilities;
import helpers.InputHelpers;
import helpers.OutputHelpers;
import helpers.StringHelpers;
import java.awt.event.ItemEvent;

/**
 *CHANGE ALL MAIN PERSON TO PAYCALCULATOR. WE MAKING AN EMPLOYEE NOT A PERSON
 * @author dgallup14
 */
public class Main_Person extends javax.swing.JFrame {

    /**
     * Creates new form Main_Person
     */
    private Employee aEmployee;
    
    public Main_Person() {
        initComponents();
        enableControls(false);
    }
    
    public void enableControls(boolean enable){
        GUIUtilities.enableInputFields(pnlInput, enable);
        GUIUtilities.enableInputFields(pnlRbuttons, enable);
        GUIUtilities.enableInputFields(pnlOutput,enable);
    }
    
    private void createNewEmployee(){
        aEmployee = new Employee();
        enableControls(true);
        clearFields();
    }

    private void clearFields(){
        GUIUtilities.clearInputFields(pnlInput);
        GUIUtilities.clearInputFields(pnlOutput);
        GUIUtilities.clearInputFields(pnlRbuttons);
    }
    /*
    private void setPayType(PayTypes.PayType type){
        aEmployee.aPay;
        
    }
    */
    private void exitApplication() {
        ApplicationHelpers.terminateGUIApplication("Circle Program");
    }
    
    private void setOutput(){
        txtareaPayInformation.setText(aEmployee.toString());
    }
    
    private boolean getFirstName(){
        boolean valid =false;
        String str = InputHelpers.getStringField(txtFirstName, "First Name");
        if(!StringHelpers.IsNullOrEmpty(str)){
            valid = true;
            aEmployee.setFirstName(str);
        }
        return valid;
    }
    
    private boolean getLastName(){
        boolean valid =false;
        String str = InputHelpers.getStringField(txtLastName, "Last Name");
        if(!StringHelpers.IsNullOrEmpty(str)){
            valid = true;
            aEmployee.setLastName(str);
        }
        return valid;
    }
    
    private boolean getEmail(){
        boolean valid = false;
        String str = InputHelpers.getStringField(txtEmail, "Email");
        valid = StringHelpers.validateEmail(str);
        if(valid){
            aEmployee.setEmail(str);
        }
        else{
            OutputHelpers.showExceptionDialog("Invalid Email", "Invalid Email");
            txtEmail.setText("");
            txtEmail.requestFocus();
        }
        return valid;
    }
    
    private boolean getPhone(){
        boolean valid = false;
        String str = InputHelpers.getStringField(txtPhone, "Phone");
        valid = StringHelpers.validateEmail(str);
        if(valid){
            aEmployee.setPhoneNumber(str);
        }
        else{
            OutputHelpers.showExceptionDialog("Invalid Phone Number", "Invalid Phone");
            txtEmail.setText("");
            txtEmail.requestFocus();
        }
        return valid;
    }
    
    private boolean getPayRate(){
        boolean valid = false;
        double RATE = InputHelpers.parseDoubleField(txtPayRate,"Pay Rate",PayTypes.MIN_RATE,PayTypes.MAX_RATE);
        if(RATE != InputHelpers.CANCEL_FLAG){
            aEmployee.aPay.setPayRate(RATE);
            valid = true;
        }
        else{
            valid = false;
        }
        return valid;
    }
    
    private boolean getHours(){
        boolean valid = false;
        double hours = InputHelpers.parseDoubleField(txtHoursWorked,"Hours Worked",PayTypes.MIN_HOURS,PayTypes.MAX_HOURS);
        if(hours != InputHelpers.CANCEL_FLAG){
            aEmployee.aPay.setHours(hours);
            valid = true;
        }
        else{
            valid = false;
        }
        return valid;
    }
    
    
    private boolean getSalaryLevel(){//spin button to set salarylevel
        boolean valid = false;
        try {
            spnLevel.commitEdit();
            valid = true;
            aEmployee.setSalaryLevel((PayTypes.SalaryLevel)(spnLevel.getValue()));
        }
        
        catch (java.text.ParseException e) {
            valid = false;
        }
        return valid;
    }
    
    //figure out why it won't print and error when run
    private void calculateData(){
        boolean valid;
        valid = getFirstName();
        if(valid)
            valid = getLastName();
        if(valid)
            valid = getEmail();
        if(valid)
            valid = getPhone();
        
        aEmployee = new Employee(aEmployee.aBtype,aEmployee.aPtype);
        
        if(valid){
            boolean valid1, valid2;
            if(aEmployee.aPtype == PayTypes.PayType.HOURLY){
                valid1 = getHours();
                valid2 = getPayRate();
                valid = valid1 && valid2;
            }
            else
                valid = getSalaryLevel();
        //valid = true;
        
        }
        
        if(valid)
            setOutput();
    }
    
       
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlInput = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pnlRbuttons = new javax.swing.JPanel();
        rbtnHourly = new javax.swing.JRadioButton();
        rbtnSalaried = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtPayRate = new javax.swing.JTextField();
        txtHoursWorked = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        spnLevel = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        rbtnSmokerYes = new javax.swing.JRadioButton();
        rbtnSmokerNo = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rbtnStandardPackage = new javax.swing.JRadioButton();
        rbtnFullPackage = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnNewEmployee = new javax.swing.JButton();
        pnlOutput = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtareaPayInformation = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Welcome to the Employee Inheritance Program");

        jLabel2.setText("Select the type of employee and provide the requested information");

        pnlInput.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel7.setText("First Name");

        jLabel8.setText("Last Name");

        jLabel9.setText("Email");

        jLabel10.setText("Phone");

        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInputLayout = new javax.swing.GroupLayout(pnlInput);
        pnlInput.setLayout(pnlInputLayout);
        pnlInputLayout.setHorizontalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addComponent(txtLastName)
                    .addComponent(txtEmail)
                    .addComponent(txtPhone))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlInputLayout.setVerticalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel3.setText("EMPLOYEE INFORMATION");

        pnlRbuttons.setBorder(new javax.swing.border.MatteBorder(null));

        buttonGroup1.add(rbtnHourly);
        rbtnHourly.setText("Hourly");
        rbtnHourly.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtnHourlyItemStateChanged(evt);
            }
        });
        rbtnHourly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnHourlyActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtnSalaried);
        rbtnSalaried.setText("Salaried");
        rbtnSalaried.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtnSalariedItemStateChanged(evt);
            }
        });
        rbtnSalaried.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSalariedActionPerformed(evt);
            }
        });

        jLabel11.setText("Pay Rate");

        jLabel12.setText("Hours Worked");

        txtPayRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPayRateActionPerformed(evt);
            }
        });

        jLabel13.setText("Level");

        spnLevel.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));

        jLabel14.setText("Smoker");

        buttonGroup4.add(rbtnSmokerYes);
        rbtnSmokerYes.setText("YES");
        rbtnSmokerYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSmokerYesActionPerformed(evt);
            }
        });

        buttonGroup4.add(rbtnSmokerNo);
        rbtnSmokerNo.setText("NO");
        rbtnSmokerNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnSmokerNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRbuttonsLayout = new javax.swing.GroupLayout(pnlRbuttons);
        pnlRbuttons.setLayout(pnlRbuttonsLayout);
        pnlRbuttonsLayout.setHorizontalGroup(
            pnlRbuttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRbuttonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRbuttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnHourly)
                    .addComponent(rbtnSalaried, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(pnlRbuttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRbuttonsLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txtPayRate, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHoursWorked)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRbuttonsLayout.createSequentialGroup()
                        .addGroup(pnlRbuttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRbuttonsLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(spnLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRbuttonsLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addGap(28, 28, 28)))
                        .addGroup(pnlRbuttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnSmokerNo)
                            .addComponent(rbtnSmokerYes))
                        .addGap(62, 62, 62))))
        );
        pnlRbuttonsLayout.setVerticalGroup(
            pnlRbuttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRbuttonsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlRbuttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnHourly)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(txtPayRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoursWorked, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlRbuttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRbuttonsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlRbuttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRbuttonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rbtnSalaried, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13)
                                .addComponent(spnLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rbtnSmokerYes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                        .addComponent(rbtnSmokerNo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRbuttonsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addContainerGap())))
        );

        jLabel4.setText("EMPLOYEE TYPE");

        jPanel3.setBorder(new javax.swing.border.MatteBorder(null));

        buttonGroup3.add(rbtnStandardPackage);
        rbtnStandardPackage.setSelected(true);
        rbtnStandardPackage.setText("Standard Package");
        rbtnStandardPackage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnStandardPackageActionPerformed(evt);
            }
        });

        buttonGroup3.add(rbtnFullPackage);
        rbtnFullPackage.setText("Full Package");
        rbtnFullPackage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnFullPackageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbtnStandardPackage)
                .addGap(34, 34, 34)
                .addComponent(rbtnFullPackage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnStandardPackage)
                    .addComponent(rbtnFullPackage))
                .addContainerGap())
        );

        jLabel5.setText("BENEFITS PACKAGE");

        jButton1.setText("Calculate Pay");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnNewEmployee.setText("New Employee");
        btnNewEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewEmployeeActionPerformed(evt);
            }
        });

        pnlOutput.setBorder(new javax.swing.border.MatteBorder(null));

        txtareaPayInformation.setColumns(20);
        txtareaPayInformation.setRows(5);
        jScrollPane1.setViewportView(txtareaPayInformation);

        javax.swing.GroupLayout pnlOutputLayout = new javax.swing.GroupLayout(pnlOutput);
        pnlOutput.setLayout(pnlOutputLayout);
        pnlOutputLayout.setHorizontalGroup(
            pnlOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOutputLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlOutputLayout.setVerticalGroup(
            pnlOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOutputLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setText("PAY INFORMATION");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlRbuttons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(133, 133, 133)
                        .addComponent(btnNewEmployee)
                        .addGap(73, 73, 73))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRbuttons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(btnNewEmployee))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(3, 3, 3)))
                .addComponent(pnlOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void btnNewEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewEmployeeActionPerformed
        // TODO add your handling code here:
        createNewEmployee();
    }//GEN-LAST:event_btnNewEmployeeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        calculateData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rbtnHourlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnHourlyActionPerformed
        // TODO add your handling code here:
        aEmployee.aPay.setPayType(PayTypes.PayType.HOURLY);
    }//GEN-LAST:event_rbtnHourlyActionPerformed

    private void rbtnHourlyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtnHourlyItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == ItemEvent.SELECTED){
            aEmployee.aPay.setPayType(PayTypes.PayType.HOURLY);
        }
    }//GEN-LAST:event_rbtnHourlyItemStateChanged

    private void rbtnSalariedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnSalariedActionPerformed
        // TODO add your handling code here:
        
        aEmployee.aPay.setPayType(PayTypes.PayType.SALARIED);
    }//GEN-LAST:event_rbtnSalariedActionPerformed

    private void txtPayRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPayRateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPayRateActionPerformed

    private void rbtnStandardPackageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnStandardPackageActionPerformed
        // TODO add your handling code here:
        aEmployee.aBenefits.setBenefitsTypes(BenefitsTypes.BenefitPackages.STANDARD);
    }//GEN-LAST:event_rbtnStandardPackageActionPerformed

    private void rbtnFullPackageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnFullPackageActionPerformed
        // TODO add your handling code here:
        aEmployee.aBenefits.setBenefitsTypes(BenefitsTypes.BenefitPackages.FULL);
    }//GEN-LAST:event_rbtnFullPackageActionPerformed

    private void rbtnSmokerYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnSmokerYesActionPerformed
        // TODO add your handling code here:
        aEmployee.aBenefits.setNonSmoker(true);
    }//GEN-LAST:event_rbtnSmokerYesActionPerformed

    private void rbtnSmokerNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnSmokerNoActionPerformed
        // TODO add your handling code here:
        aEmployee.aBenefits.setNonSmoker(false);
    }//GEN-LAST:event_rbtnSmokerNoActionPerformed

    private void rbtnSalariedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtnSalariedItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == ItemEvent.SELECTED){
            aEmployee.aPay.setPayType(PayTypes.PayType.SALARIED);
        }
    }//GEN-LAST:event_rbtnSalariedItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        exitApplication();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Main_Person.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Person.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Person.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Person.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Person().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewEmployee;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlInput;
    private javax.swing.JPanel pnlOutput;
    private javax.swing.JPanel pnlRbuttons;
    private javax.swing.JRadioButton rbtnFullPackage;
    private javax.swing.JRadioButton rbtnHourly;
    private javax.swing.JRadioButton rbtnSalaried;
    private javax.swing.JRadioButton rbtnSmokerNo;
    private javax.swing.JRadioButton rbtnSmokerYes;
    private javax.swing.JRadioButton rbtnStandardPackage;
    private javax.swing.JSpinner spnLevel;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtHoursWorked;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPayRate;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextArea txtareaPayInformation;
    // End of variables declaration//GEN-END:variables
}
