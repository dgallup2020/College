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


    private Service aItem; 
    private ItemList list;
    private final DefaultListModel<Service> listModel;
    Boolean asObjects = true;
    
    public CheckOut_GUI() {
        initComponents();
        clear();
        list = new ItemList();
        listModel = new DefaultListModel<>();
        lstItems.setModel(listModel); //why are these things????
    }
    private void showDetails() {
        if (lstItems.getSelectedIndex() != -1) {
            aItem = lstItems.getSelectedValue(); //have no clue what this is???
            txtDetails.setText(aItem.getDetails());
        }
    }
    private void setSummary() {
        txtSummary.setText(list.getSummary());
    }
    private void clear() {
        aItem = new Service();
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
            valid = getServiceName();
        }
        if(valid) {
            valid = getHardWareCost();
        }
        if(valid) {
            valid = getSoftWareCost();
        }
        
        if(valid) {
            valid = getPersonnelCost();
        }
        
        if (valid) {
            getDescription();
            aItem.setServiceCost();
            list.add(aItem);
            listModel.addElement(aItem);
            setSummary();
            
            OutputHelpers.showStandardDialog(aItem.getDetails(), "Service Details");
        }
        
        
    //all service person stuff for verification
    }
    private boolean getFirstName() {
        boolean valid = true;
        String tmpStr = InputHelpers.getStringField(txtFirstName1, "First Name");
        if (!StringHelpers.IsNullOrEmpty(tmpStr)) {
            aItem.getPerson().setFirstName(tmpStr);
        }
        else {
            valid = false;
            txtFirstName1.requestFocus();
        }
        return valid;
    }
    private boolean getLastName() {
        boolean valid = true;
        String tmpStr = InputHelpers.getStringField(txtLastName1, "Last Name");
        if (!StringHelpers.IsNullOrEmpty(tmpStr)) {
            aItem.getPerson().setLastName(tmpStr);
        }
        else {
            valid = false;
            txtLastName1.requestFocus();
        }
        return valid;
    }
    private boolean getEmail() {
        boolean valid = true;
        String tmpStr = InputHelpers.getStringField(txtEmail1, "Email");
         if (!StringHelpers.IsNullOrEmpty(tmpStr)) {
            if (StringHelpers.validateEmail(tmpStr)) {
                aItem.getPerson().setEmail(tmpStr);
            }
            else {
                valid = false;
                OutputHelpers.showExceptionDialog("Invalid email", "Invalid Email");
                txtEmail1.selectAll();
                txtEmail1.requestFocus();
            }
        }
        else {
            valid = false;
            txtEmail1.requestFocus();
        }
        return valid;
    }
    private boolean getPhone() {
        boolean valid = true;
        String tmpStr = InputHelpers.getStringField(txtPhone1, "Phone");
         if (!StringHelpers.IsNullOrEmpty(tmpStr)) {
            if (StringHelpers.validatePhoneNumber(tmpStr)) {
                aItem.getPerson().setPhone(tmpStr);
            }
            else {
                valid = false;
                OutputHelpers.showExceptionDialog("Invalid Phone", "Invalid Phone");
                txtPhone1.selectAll();
                txtPhone1.requestFocus();
            }
        }
        else {
            valid = false;
            txtPhone1.requestFocus();
        }
        return valid;
    }
    
    private boolean getServiceName() {
        boolean valid = true;
        String tmpStr = InputHelpers.getStringField(txtItemName, "Service Name");
         if (!StringHelpers.IsNullOrEmpty(tmpStr)) {
            aItem.setItemName(tmpStr);
        }
        else {
            valid = false;
            txtItemName.requestFocus();
        }
        return valid;
    }
    /*
    this one is for the Service Person type
    private boolean getServiceManagerType() {
        boolean valid = true;
        String tmpStr = InputHelpers.getStringField(txtItemName, "Service Name");
         if (!StringHelpers.IsNullOrEmpty(tmpStr)) {
            aItem.setItemName(tmpStr);
        }
        else {
            valid = false;
            txtItemName.requestFocus();
        }
        return valid;
    }
    */
    //make a setter for each cost
    /*
    private boolean getCost() {
        boolean valid = true;
        double value;
        value = InputHelpers.parseDoubleField(txtCost, "Item Cost", Service.MIN_COST, Service.MAX_COST);
        if (value != InputHelpers.CANCEL_FLAG){
            aItem.setCost(value); //do one of these for a personal cost, hardware cost, and software cost possible override to constructor
        }
        else {
            valid = false;
            txtCost.requestFocus();
        }
        return valid;
    }
    */
    //software cost
    private boolean getSoftWareCost() {
        boolean valid = true;
        double value;
        double value1;
        
        value = InputHelpers.parseDoubleField(txtSoftInitCost, "Software Initial Cost", Service.SOFTWARE_MIN_COST, Service.SOFTWARE_MAX_COST);
        if (value != InputHelpers.CANCEL_FLAG){
            aItem.SWcost.setSWinitCost(value); //do one of these for a personal cost, hardware cost, and software cost possible override to constructor
            
        }
        else {
            valid = false;
            txtSoftInitCost.requestFocus();
        }
        
        value1 = InputHelpers.parseDoubleField(txtSoftLinceCost, "Software Lincensing Cost", Service.SOFTWARE_MIN_COST, Service.SOFTWARE_MAX_COST);
        if (value1 != InputHelpers.CANCEL_FLAG){
            aItem.SWcost.setLincensingCost(value1);//Cost(value); //do one of these for a personal cost, hardware cost, and software cost possible override to constructor
        }
        else {
            valid = false;
            txtSoftLinceCost.requestFocus();
        }
        
        if(valid)
            aItem.SWcost.setTotalCost(aItem.SWcost.getSWinitCost(),aItem.SWcost.getLincensingCost());
            
        
        return valid;
    }
    
    
    private boolean getHardWareCost() {
        boolean valid = true;
        double value;
        double value1;
        
        
        value = InputHelpers.parseDoubleField(txtHardInitCost, "Hardware Initial Cost", Service.HARDWARE_MIN_COST, Service.HARDWARE_MAX_COST);
        if (value != InputHelpers.CANCEL_FLAG){
            aItem.HWcost.setHWinitCost(value); //do one of these for a personal cost, hardware cost, and software cost possible override to constructor
            
        }
        else {
            valid = false;
            txtHardInitCost.requestFocus();
        }
        
        value1 = InputHelpers.parseDoubleField(txtHardInstallCost, "Hardware Installation Cost", Service.HARDWARE_MIN_COST, Service.HARDWARE_MAX_COST);
        if (value1 != InputHelpers.CANCEL_FLAG){
            aItem.HWcost.setInstallationCost(value1);//Cost(value); //do one of these for a personal cost, hardware cost, and software cost possible override to constructor
        }
        
        else {
            valid = false;
            txtHardInstallCost.requestFocus();
        }
        
        if(valid)
            aItem.HWcost.setTotalCost();
        
        return valid;
    }
    
    //personnel cost
    
    private boolean getPersonnelCost() {
        boolean valid = true;
        double value;
        
        
        
        value = InputHelpers.parseDoubleField(txtPersonHours, "Service Manager Hours", aItem.person.aCost.MINHOURS, aItem.person.aCost.MAXHOURS);
        if (value != InputHelpers.CANCEL_FLAG){
            aItem.person.aCost.setHours(value);    
        }
        
        else {
            valid = false;
            txtPersonHours.requestFocus();
        }
        
        if(valid)
            aItem.person.aCost.setCharge();
        
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
        btnPersonGroup = new javax.swing.ButtonGroup();
        lblWelcome = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlCheckout = new javax.swing.JPanel();
        pnlItem = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtItemName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        pnlPerson = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtHardInstallCost = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtHardInitCost = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtSoftLinceCost = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtSoftInitCost = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtPersonHours = new javax.swing.JTextField();
        labeltype = new javax.swing.JLabel();
        btnStudentWorker = new javax.swing.JRadioButton();
        btnFullTimeStaff = new javax.swing.JRadioButton();
        btnITsupervisor = new javax.swing.JRadioButton();
        btnDirector = new javax.swing.JRadioButton();
        btnSubmit = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        pnlPerson1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtFirstName1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtLastName1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtEmail1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtPhone1 = new javax.swing.JTextField();
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

        lblWelcome.setFont(new java.awt.Font("Arial", 3, 48)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(0, 0, 255));
        lblWelcome.setText("Service Catalog");
        lblWelcome.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblWelcome.setName("lblWelcome"); // NOI18N

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 80));

        pnlItem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Item to Checkout", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel5.setText("Item Name");

        txtItemName.setToolTipText("Enter your first name");

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
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtItemName)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pnlPerson.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Checked out to", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Hardware Cost");
        jLabel7.setToolTipText("");

        txtHardInstallCost.setToolTipText("Enter your first name");

        jLabel8.setText("Initial Cost");

        txtHardInitCost.setToolTipText("");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setText("Software Cost");
        jLabel10.setToolTipText("");

        txtSoftLinceCost.setToolTipText("");

        jLabel11.setText("Lincensing Cost");

        txtSoftInitCost.setToolTipText("");

        jLabel16.setText("Installation Cost");

        jLabel17.setText("Initial Cost");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel18.setText("Personnel Cost");

        jLabel19.setText("Hours");

        txtPersonHours.setFocusCycleRoot(true);

        labeltype.setText("Personnel Type");

        btnPersonGroup.add(btnStudentWorker);
        btnStudentWorker.setText("IT Student Worker");
        btnStudentWorker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentWorkerActionPerformed(evt);
            }
        });

        btnPersonGroup.add(btnFullTimeStaff);
        btnFullTimeStaff.setText("IT Full Time Staff");
        btnFullTimeStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFullTimeStaffActionPerformed(evt);
            }
        });

        btnPersonGroup.add(btnITsupervisor);
        btnITsupervisor.setText("IT Supervisor/Manager");
        btnITsupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnITsupervisorActionPerformed(evt);
            }
        });

        btnPersonGroup.add(btnDirector);
        btnDirector.setText("IT Director/PM");
        btnDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDirectorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPersonLayout = new javax.swing.GroupLayout(pnlPerson);
        pnlPerson.setLayout(pnlPersonLayout);
        pnlPersonLayout.setHorizontalGroup(
            pnlPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPersonLayout.createSequentialGroup()
                        .addGroup(pnlPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPersonLayout.createSequentialGroup()
                                .addComponent(txtHardInitCost, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))
                            .addGroup(pnlPersonLayout.createSequentialGroup()
                                .addComponent(txtHardInstallCost, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnlPersonLayout.createSequentialGroup()
                        .addGroup(pnlPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPersonLayout.createSequentialGroup()
                                .addGroup(pnlPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPersonHours, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlPersonLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addGroup(pnlPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoftInitCost, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoftLinceCost, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlPersonLayout.createSequentialGroup()
                                .addComponent(labeltype)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnFullTimeStaff)
                                    .addComponent(btnStudentWorker)
                                    .addComponent(btnITsupervisor)
                                    .addComponent(btnDirector))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlPersonLayout.setVerticalGroup(
            pnlPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHardInstallCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtHardInitCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(4, 4, 4)
                .addGroup(pnlPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoftLinceCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoftInitCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtPersonHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeltype)
                    .addComponent(btnStudentWorker))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFullTimeStaff)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnITsupervisor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDirector)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnNew.setText("New Service");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        pnlPerson1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Checked out to", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel12.setText("First Name");

        txtFirstName1.setToolTipText("Enter your first name");

        jLabel13.setText("Last Name");

        txtLastName1.setToolTipText("Enter your last name");

        jLabel14.setText("Email");
        jLabel14.setToolTipText("");

        txtEmail1.setToolTipText("Enter your last name");

        jLabel15.setText("Phone");

        txtPhone1.setToolTipText("Enter your last name");

        javax.swing.GroupLayout pnlPerson1Layout = new javax.swing.GroupLayout(pnlPerson1);
        pnlPerson1.setLayout(pnlPerson1Layout);
        pnlPerson1Layout.setHorizontalGroup(
            pnlPerson1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPerson1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPerson1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPerson1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFirstName1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPerson1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlPerson1Layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPerson1Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtLastName1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlPerson1Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 22, Short.MAX_VALUE))
        );
        pnlPerson1Layout.setVerticalGroup(
            pnlPerson1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPerson1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlPerson1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirstName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPerson1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtLastName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPerson1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPerson1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout pnlCheckoutLayout = new javax.swing.GroupLayout(pnlCheckout);
        pnlCheckout.setLayout(pnlCheckoutLayout);
        pnlCheckoutLayout.setHorizontalGroup(
            pnlCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCheckoutLayout.createSequentialGroup()
                .addGroup(pnlCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCheckoutLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCheckoutLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(pnlPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(pnlCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCheckoutLayout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(pnlPerson1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(404, Short.MAX_VALUE)))
        );
        pnlCheckoutLayout.setVerticalGroup(
            pnlCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCheckoutLayout.createSequentialGroup()
                .addGroup(pnlCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCheckoutLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlPerson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCheckoutLayout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(pnlItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSubmit)
                            .addComponent(btnNew))))
                .addGap(61, 61, 61))
            .addGroup(pnlCheckoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCheckoutLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(pnlPerson1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(330, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Services", pnlCheckout);

        lstItems.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstItemsValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstItems);

        txtDetails.setColumns(20);
        txtDetails.setRows(5);
        jScrollPane3.setViewportView(txtDetails);

        jLabel2.setText("Services List");

        jLabel3.setText("Service Details");

        jLabel4.setText("Service Summary");

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
                    .addGroup(pnlSummaryLayout.createSequentialGroup()
                        .addGroup(pnlSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                        .addGroup(pnlSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(pnlSummaryLayout.createSequentialGroup()
                        .addGroup(pnlSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlSummaryLayout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(radObjects))
                            .addGroup(pnlSummaryLayout.createSequentialGroup()
                                .addComponent(btnGetList, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(radStream)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlSummaryLayout.setVerticalGroup(
            pnlSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSummaryLayout.createSequentialGroup()
                .addGroup(pnlSummaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSummaryLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2))
                    .addGroup(pnlSummaryLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Services Summary", pnlSummary);

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 874, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblWelcome)
                .addGap(269, 269, 269))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExit)
                .addContainerGap())
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

    private void btnStudentWorkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentWorkerActionPerformed
        // TODO add your handling code here:
        aItem.person.setType("IT Student Worker");
        aItem.person.setRate("IT Student Worker");
    }//GEN-LAST:event_btnStudentWorkerActionPerformed

    private void btnFullTimeStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFullTimeStaffActionPerformed
        // TODO add your handling code here:
        aItem.person.setType("IT Full Time Staff");
        aItem.person.setRate("IT Full Time Staff");
    }//GEN-LAST:event_btnFullTimeStaffActionPerformed

    private void btnITsupervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnITsupervisorActionPerformed
        // TODO add your handling code here:
        aItem.person.setType("IT Supervisor/Manager");
        aItem.person.setRate("IT Supervisor/Manager");
    }//GEN-LAST:event_btnITsupervisorActionPerformed

    private void btnDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDirectorActionPerformed
        // TODO add your handling code here:
        aItem.person.setType("IT Director/Program Manager");
        aItem.person.setRate("IT Director/Program Manager");
    }//GEN-LAST:event_btnDirectorActionPerformed

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
    private javax.swing.JRadioButton btnDirector;
    private javax.swing.JButton btnExit;
    private javax.swing.JRadioButton btnFullTimeStaff;
    private javax.swing.JButton btnGetList;
    private javax.swing.JRadioButton btnITsupervisor;
    private javax.swing.JButton btnNew;
    private javax.swing.ButtonGroup btnPersonGroup;
    private javax.swing.JButton btnSave;
    private javax.swing.JRadioButton btnStudentWorker;
    private javax.swing.JButton btnSubmit;
    private javax.swing.ButtonGroup grpFileType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labeltype;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JList<Service> lstItems;
    private javax.swing.JPanel pnlCheckout;
    private javax.swing.JPanel pnlItem;
    private javax.swing.JPanel pnlPerson;
    private javax.swing.JPanel pnlPerson1;
    private javax.swing.JPanel pnlSummary;
    private javax.swing.JRadioButton radObjects;
    private javax.swing.JRadioButton radStream;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextArea txtDetails;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtFirstName1;
    private javax.swing.JTextField txtHardInitCost;
    private javax.swing.JTextField txtHardInstallCost;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtLastName1;
    private javax.swing.JTextField txtPersonHours;
    private javax.swing.JTextField txtPhone1;
    private javax.swing.JTextField txtSoftInitCost;
    private javax.swing.JTextField txtSoftLinceCost;
    private javax.swing.JTextArea txtSummary;
    // End of variables declaration//GEN-END:variables
}
