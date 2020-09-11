/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *///better versoin of this posted online

package presentation;

import business.Car;
import business.CarTypes;
import business.Engine;
import business.HotRod;
import business.RaceCar;
import business.StreetTuned;
import helpers.ApplicationHelpers;
import helpers.GUIUtilities;
import helpers.InputHelpers;
import helpers.OutputHelpers;
import helpers.StringHelpers;
import java.awt.event.ItemEvent;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author dgallup14
 */
public class Car_Tabbed extends javax.swing.JFrame {

    /**
     * Creates new form Car_Tabbed
     */
    public Car_Tabbed() {
        initComponents();
    }
 private Car aCar;
 private DefaultListModel<Car> listModel;
 private ArrayList<Car> carList;
    
    public Car_GUI {
        initComponents();
        setNumberCars();
        enableControls(false);
        enableBrakeAccelerate(false);
        
        listModel = new DefaultListModel<>();
        lstCars.setModel(listModel);
        
        carList = new ArrayList<>();
        
    }
    
    private void showCarDetails(){
        if(lstCars.getSelectedIndex() != -1){
            aCar = lstCars.getSelectedValue();//list to choose an object
            txtareaCarData.setText(aCar.carDetails());
        }
    }
    //useful
    private void deleteCar(){
        int item = lstCars.getSelectedIndex();
        if(item!=-1){
            int response;
            aCar = lstCars.getSelectedValue();
            String prompt = "Are you sure";
            response = OutputHelpers.showOKCancelDiaglog(prompt, "Delete order"+aCar.toString());
            if(response == JOptionPane.YES_OPTION){
                listModel
                    }

        }
    }
    
    
    private void enableControls(boolean enable) {
        GUIUtilities.enableInputFields(pnlInput, enable);
        GUIUtilities.enableInputFields(pnlOutput, enable);
        btnCalculate.setEnabled(enable);
    }
    private void enableBrakeAccelerate(boolean enable) {
        btnAccelerate.setEnabled(enable);
        btnBrake.setEnabled(enable); 
    }
    private void accelerate() {
        if (aCar != null) {
            aCar.accelerate();
            txtCarData.setText(aCar.carDetails());
        }
    }
    private void brake() {
        if (aCar != null) {
            aCar.brake();
            txtCarData.setText(aCar.carDetails());
        }
    }
    private void createNewCar(CarTypes.Cars type) {   
        aCar = null;
        switch (type) {
            case RACE_CAR:
                aCar = new RaceCar();
                break;
            case STREET_TUNED:
                aCar = new StreetTuned();
                break;
            case HOT_ROD:
                aCar = new HotRod();
                break;
            default:
               aCar = new RaceCar();
               break;
        }
        clearFields();
        enableControls(true);
        enableBrakeAccelerate(false);
        setNumberCars();
    }
    
    private void clearFields() {
        GUIUtilities.clearInputFields(pnlInput);
        GUIUtilities.clearInputFields(pnlOutput);
    }
   
    private void setNumberCars() {
        txtNumberObjects.setText(OutputHelpers.formattedInteger(Car.getCarCount()));
    }
    private void exitApplication() {
        ApplicationHelpers.terminateGUIApplication("Car Program");
    }
    private void calculateData() {
        boolean valid;
        
        valid = getCarName();
        if (valid) {
            valid = getNumberCylinders();
        }
        if (valid) {
            valid = getHorsePower();
        }
        
        
        if (valid) {
            txtCarData.setText(aCar.toString());
            Car.incrementCarCount();
            enableBrakeAccelerate(true);
            
            lstModel
        }
        else {
            Car.decrementCarCount();
        }
        setNumberCars();
    }
    private boolean getCarName() {
        boolean valid = false ;
        String str = InputHelpers.getStringField(txtName, "Car Name");
        if (!StringHelpers.IsNullOrEmpty(str)) {
            valid = true;
            aCar.setName(str);
        }
        return valid;
    }
    private boolean getNumberCylinders() {
        boolean valid = false;
        int cylinders = InputHelpers.parseIntegerField(txtNumberCylinders, "Length", Engine.MIN_CYLINDERS, Engine.MAX_CYLINDERS);
        if (cylinders != InputHelpers.CANCEL_FLAG) {
            valid = true;
            aCar.getEngine().setCylinders(cylinders);
        }
        return valid;
    }
    private boolean getHorsePower() {
        boolean valid = false;
        int horsePower = InputHelpers.parseIntegerField(txtHorsePower, "Standard Horse Power", Engine.MIN_HORSE_POWER, Engine.MAX_HORSE_POWER);
        if (horsePower != InputHelpers.CANCEL_FLAG) {
            valid = true;
            aCar.getEngine().setHorsePower(horsePower);
            aCar.adjustHorsePower();
        }
        return valid;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup1 = new javax.swing.ButtonGroup();
        btnGroup2 = new javax.swing.ButtonGroup();
        pnlShapeType = new javax.swing.JPanel();
        radRaceCar = new javax.swing.JRadioButton();
        radHotRod = new javax.swing.JRadioButton();
        radStreetTuned = new javax.swing.JRadioButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlInput = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblLength = new javax.swing.JLabel();
        txtNumberCylinders = new javax.swing.JTextField();
        lblHeight = new javax.swing.JLabel();
        txtHorsePower = new javax.swing.JTextField();
        btnAccelerate = new javax.swing.JButton();
        btnBrake = new javax.swing.JButton();
        pnlOutput = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCarData = new javax.swing.JTextArea();
        btnCalculate = new javax.swing.JButton();
        bntClear = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtNumberObjects = new javax.swing.JTextField();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();
        tbMain = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstCars = new javax.swing.JList<>();
        btnDelete = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtareaCarData = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        pnlShapeType.setBorder(javax.swing.BorderFactory.createTitledBorder("Shape Type"));

        radRaceCar.setText("Race Car");
        radRaceCar.setToolTipText("Select to create a generalized race car");
        radRaceCar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radRaceCarItemStateChanged(evt);
            }
        });

        radHotRod.setText("Hot Rod");
        radHotRod.setToolTipText("Select to create hot rod");
        radHotRod.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radHotRodItemStateChanged(evt);
            }
        });

        radStreetTuned.setText("Street Tuned");
        radStreetTuned.setToolTipText("Select to create street tuned car");
        radStreetTuned.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radStreetTunedItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlShapeTypeLayout = new javax.swing.GroupLayout(pnlShapeType);
        pnlShapeType.setLayout(pnlShapeTypeLayout);
        pnlShapeTypeLayout.setHorizontalGroup(
            pnlShapeTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlShapeTypeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radRaceCar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radHotRod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radStreetTuned)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlShapeTypeLayout.setVerticalGroup(
            pnlShapeTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlShapeTypeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlShapeTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlShapeTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radRaceCar)
                        .addComponent(radHotRod)
                        .addComponent(radStreetTuned))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlShapeTypeLayout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pnlInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Car Information"));

        jLabel3.setText("Name");

        txtName.setToolTipText("Enter the name of the car");

        lblLength.setText("# Cylinders");

        lblHeight.setText("Standard Horsepower");
        lblHeight.setToolTipText("Enter the horse power before alterations");

        txtHorsePower.setToolTipText("Enter the length of the side");

        btnAccelerate.setText("Accelerate");
        btnAccelerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccelerateActionPerformed(evt);
            }
        });

        btnBrake.setText("Brake");
        btnBrake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrakeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInputLayout = new javax.swing.GroupLayout(pnlInput);
        pnlInput.setLayout(pnlInputLayout);
        pnlInputLayout.setHorizontalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLength)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlInputLayout.createSequentialGroup()
                        .addComponent(txtNumberCylinders, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblHeight)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtHorsePower, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAccelerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBrake, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlInputLayout.setVerticalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputLayout.createSequentialGroup()
                .addContainerGap(186, Short.MAX_VALUE)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnAccelerate))
                .addGap(8, 8, 8)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLength)
                    .addComponent(txtNumberCylinders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHeight)
                    .addComponent(txtHorsePower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrake))
                .addContainerGap())
        );

        pnlOutput.setBorder(javax.swing.BorderFactory.createTitledBorder("Car Data"));

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 80));

        txtCarData.setColumns(20);
        txtCarData.setRows(5);
        jScrollPane1.setViewportView(txtCarData);

        javax.swing.GroupLayout pnlOutputLayout = new javax.swing.GroupLayout(pnlOutput);
        pnlOutput.setLayout(pnlOutputLayout);
        pnlOutputLayout.setHorizontalGroup(
            pnlOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOutputLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlOutputLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnlOutputLayout.setVerticalGroup(
            pnlOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOutputLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCalculate.setText("Calculate Data");
        btnCalculate.setToolTipText("Click to calculate the circle information");
        btnCalculate.setMaximumSize(new java.awt.Dimension(110, 25));
        btnCalculate.setMinimumSize(new java.awt.Dimension(110, 25));
        btnCalculate.setPreferredSize(new java.awt.Dimension(110, 25));
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });

        bntClear.setText("Clear fields");
        bntClear.setToolTipText("Click to clear the fields");
        bntClear.setMaximumSize(new java.awt.Dimension(110, 25));
        bntClear.setMinimumSize(new java.awt.Dimension(110, 25));
        bntClear.setPreferredSize(new java.awt.Dimension(110, 25));
        bntClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntClearActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 80));
        jLabel7.setText("# Cars Created:");

        txtNumberObjects.setEditable(false);
        txtNumberObjects.setBackground(new java.awt.Color(204, 204, 204));
        txtNumberObjects.setToolTipText("Displays number of circle created");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Welcome to the Pay Calculator Program");

        tbMain.addTab("tab1", jTabbedPane2);

        lstCars.setModel(new javax.swing.AbstractListModel<Car>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstCars);

        btnDelete.setText("delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");

        jTextField1.setText("jTextField1");

        txtareaCarData.setColumns(20);
        txtareaCarData.setRows(5);
        jScrollPane3.setViewportView(txtareaCarData);

        jLabel2.setText("Car Information");

        jLabel4.setText("Car List");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnDelete)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(290, 290, 290)
                        .addComponent(jLabel2)))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btnDelete))
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("tab1", jPanel2);

        tbMain.addTab("tab2", jTabbedPane4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tbMain))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbMain)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radRaceCarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radRaceCarItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            createNewCar(CarTypes.Cars.RACE_CAR);
        }
    }//GEN-LAST:event_radRaceCarItemStateChanged

    private void radHotRodItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radHotRodItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            createNewCar(CarTypes.Cars.HOT_ROD);
        }
    }//GEN-LAST:event_radHotRodItemStateChanged

    private void radStreetTunedItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radStreetTunedItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            createNewCar(CarTypes.Cars.STREET_TUNED);
        }
    }//GEN-LAST:event_radStreetTunedItemStateChanged

    private void btnAccelerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccelerateActionPerformed
        accelerate();
    }//GEN-LAST:event_btnAccelerateActionPerformed

    private void btnBrakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrakeActionPerformed
        brake();
    }//GEN-LAST:event_btnBrakeActionPerformed

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        calculateData();
    }//GEN-LAST:event_btnCalculateActionPerformed

    private void bntClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntClearActionPerformed
        clearFields();
    }//GEN-LAST:event_bntClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(Car_Tabbed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Car_Tabbed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Car_Tabbed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Car_Tabbed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Car_Tabbed().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntClear;
    private javax.swing.JButton btnAccelerate;
    private javax.swing.JButton btnBrake;
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnDelete;
    private javax.swing.ButtonGroup btnGroup1;
    private javax.swing.ButtonGroup btnGroup2;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblHeight;
    private javax.swing.JLabel lblLength;
    private javax.swing.JList<Car> lstCars;
    private javax.swing.JPanel pnlInput;
    private javax.swing.JPanel pnlOutput;
    private javax.swing.JPanel pnlShapeType;
    private javax.swing.JRadioButton radHotRod;
    private javax.swing.JRadioButton radRaceCar;
    private javax.swing.JRadioButton radStreetTuned;
    private javax.swing.JTabbedPane tbMain;
    private javax.swing.JTextArea txtCarData;
    private javax.swing.JTextField txtHorsePower;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumberCylinders;
    private javax.swing.JTextField txtNumberObjects;
    private javax.swing.JTextArea txtareaCarData;
    // End of variables declaration//GEN-END:variables
}
