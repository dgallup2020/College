/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;
import business.*;
import helpers.*;

import java.awt.event.ItemEvent;

public class Car_GUI extends javax.swing.JFrame {

    private Car aCar;
    
    public Car_GUI() {
        initComponents();
        setNumberCars();
        enableControls(false);
        enableBrakeAccelerate(false);
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
            txtCarData.setText(aCar.toString());
        }
    }
    private void brake() {
        if (aCar != null) {
            aCar.brake();
            txtCarData.setText(aCar.toString());
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

        grpShapeType = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCalculate = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        pnlOutput = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCarData = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        pnlInput = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblLength = new javax.swing.JLabel();
        txtNumberCylinders = new javax.swing.JTextField();
        pnlShapeType = new javax.swing.JPanel();
        radRaceCar = new javax.swing.JRadioButton();
        radHotRod = new javax.swing.JRadioButton();
        radStreetTuned = new javax.swing.JRadioButton();
        lblHeight = new javax.swing.JLabel();
        txtHorsePower = new javax.swing.JTextField();
        btnAccelerate = new javax.swing.JButton();
        btnBrake = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtNumberObjects = new javax.swing.JTextField();
        bntClear = new javax.swing.JButton();
        btnTurnRight = new javax.swing.JButton();
        btnTurnLeft = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnTireChange = new javax.swing.JButton();
        btnRefuel = new javax.swing.JButton();
        btnCruise = new javax.swing.JButton();
        btnBumping = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Circle Program");

        jLabel1.setText("Welcome to the Pay Calculator Program");

        jLabel2.setText("Select the type of car and enter the car information");
        jLabel2.setToolTipText("");

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

        btnExit.setText("Exit");
        btnExit.setPreferredSize(new java.awt.Dimension(110, 25));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        pnlOutput.setBorder(javax.swing.BorderFactory.createTitledBorder("Car Data"));

        txtCarData.setColumns(20);
        txtCarData.setRows(5);
        jScrollPane1.setViewportView(txtCarData);

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 80));

        javax.swing.GroupLayout pnlOutputLayout = new javax.swing.GroupLayout(pnlOutput);
        pnlOutput.setLayout(pnlOutputLayout);
        pnlOutputLayout.setHorizontalGroup(
            pnlOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOutputLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlOutputLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnlOutputLayout.setVerticalGroup(
            pnlOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOutputLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Car Information"));

        jLabel3.setText("Name");

        txtName.setToolTipText("Enter the name of the car");

        lblLength.setText("# Cylinders");

        pnlShapeType.setBorder(javax.swing.BorderFactory.createTitledBorder("Shape Type"));

        grpShapeType.add(radRaceCar);
        radRaceCar.setText("Race Car");
        radRaceCar.setToolTipText("Select to create a generalized race car");
        radRaceCar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radRaceCarItemStateChanged(evt);
            }
        });

        grpShapeType.add(radHotRod);
        radHotRod.setText("Hot Rod");
        radHotRod.setToolTipText("Select to create hot rod");
        radHotRod.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radHotRodItemStateChanged(evt);
            }
        });

        grpShapeType.add(radStreetTuned);
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
                .addGroup(pnlShapeTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radRaceCar)
                    .addComponent(radHotRod)
                    .addComponent(radStreetTuned)))
        );

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
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlShapeType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 303, Short.MAX_VALUE)
                        .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAccelerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBrake, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlInputLayout.setVerticalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlShapeType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 80));
        jLabel7.setText("# Cars Created:");

        txtNumberObjects.setEditable(false);
        txtNumberObjects.setBackground(new java.awt.Color(204, 204, 204));
        txtNumberObjects.setToolTipText("Displays number of circle created");

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

        btnTurnRight.setText("Turn Right");
        btnTurnRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTurnRightActionPerformed(evt);
            }
        });

        btnTurnLeft.setText("Turn Left");
        btnTurnLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTurnLeftActionPerformed(evt);
            }
        });

        btnStop.setText("STOP");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        btnTireChange.setText("Tire Change");
        btnTireChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTireChangeActionPerformed(evt);
            }
        });

        btnRefuel.setText("Refuel");
        btnRefuel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefuelActionPerformed(evt);
            }
        });

        btnCruise.setText("CRUISING");
        btnCruise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCruiseActionPerformed(evt);
            }
        });

        btnBumping.setText("BUMPING");
        btnBumping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBumpingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNumberObjects, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnTurnLeft)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnTireChange)
                                        .addGap(34, 34, 34)
                                        .addComponent(btnCruise)
                                        .addGap(30, 30, 30)
                                        .addComponent(btnBumping)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnTurnRight)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnStop)
                                        .addGap(34, 34, 34)
                                        .addComponent(btnRefuel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bntClear, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTurnRight)
                    .addComponent(btnStop)
                    .addComponent(btnRefuel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNumberObjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTurnLeft)
                    .addComponent(btnTireChange)
                    .addComponent(btnCruise)
                    .addComponent(btnBumping))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        calculateData();
    }//GEN-LAST:event_btnCalculateActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        exitApplication();
    }//GEN-LAST:event_btnExitActionPerformed

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

    private void bntClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntClearActionPerformed
        clearFields();
    }//GEN-LAST:event_bntClearActionPerformed

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

    private void btnTurnRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurnRightActionPerformed
        // TODO add your handling code here:
        aCar.turnRight();
        txtCarData.setText(aCar.toString() + "\n" + aCar.getCarinterfaceStatus());
    }//GEN-LAST:event_btnTurnRightActionPerformed

    private void btnTurnLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTurnLeftActionPerformed
        // TODO add your handling code here:
        aCar.turnLeft();
        txtCarData.setText(aCar.toString() + "\n" + aCar.getCarinterfaceStatus());
    }//GEN-LAST:event_btnTurnLeftActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        // TODO add your handling code here:
        aCar.stop();
        txtCarData.setText(aCar.toString() + "\n" + aCar.getCarinterfaceStatus());
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnTireChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTireChangeActionPerformed
        // TODO add your handling code here:
        if(aCar instanceof RaceCar){
            aCar.changeTires();
        txtCarData.setText(aCar.toString() + "\n" + aCar.getCarinterfaceStatus());
                //"instance of racecar");//aCar.getCarinterfaceStatus());
        }
            
    }//GEN-LAST:event_btnTireChangeActionPerformed

    private void btnRefuelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefuelActionPerformed
        // TODO add your handling code here:
        if(aCar instanceof RaceCar){
            aCar.fillUpGas();
            txtCarData.setText(aCar.toString() + "\n" + aCar.getCarinterfaceStatus());
                //"instance of racecar");//aCar.getCarinterfaceStatus());
        }
    }//GEN-LAST:event_btnRefuelActionPerformed

    private void btnCruiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCruiseActionPerformed
        // TODO add your handling code here:
        if(aCar instanceof StreetTuned){
            aCar.justCruising();
            txtCarData.setText(aCar.toString() + "\n" + aCar.getCarinterfaceStatus());
                //"instance of racecar");//aCar.getCarinterfaceStatus());
        }
    }//GEN-LAST:event_btnCruiseActionPerformed

    private void btnBumpingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBumpingActionPerformed
        // TODO add your handling code here:
         if(aCar instanceof StreetTuned){
            aCar.bump();
            txtCarData.setText(aCar.toString() + "\n" + aCar.getCarinterfaceStatus());
                //"instance of racecar");//aCar.getCarinterfaceStatus());
        }
    }//GEN-LAST:event_btnBumpingActionPerformed

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
            java.util.logging.Logger.getLogger(Car_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Car_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Car_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Car_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        Car_GUI mainForm = new Car_GUI();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIUtilities.centerForm(mainForm);
                mainForm.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntClear;
    private javax.swing.JButton btnAccelerate;
    private javax.swing.JButton btnBrake;
    private javax.swing.JButton btnBumping;
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnCruise;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnRefuel;
    private javax.swing.JButton btnStop;
    private javax.swing.JButton btnTireChange;
    private javax.swing.JButton btnTurnLeft;
    private javax.swing.JButton btnTurnRight;
    private javax.swing.ButtonGroup grpShapeType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHeight;
    private javax.swing.JLabel lblLength;
    private javax.swing.JPanel pnlInput;
    private javax.swing.JPanel pnlOutput;
    private javax.swing.JPanel pnlShapeType;
    private javax.swing.JRadioButton radHotRod;
    private javax.swing.JRadioButton radRaceCar;
    private javax.swing.JRadioButton radStreetTuned;
    private javax.swing.JTextArea txtCarData;
    private javax.swing.JTextField txtHorsePower;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumberCylinders;
    private javax.swing.JTextField txtNumberObjects;
    // End of variables declaration//GEN-END:variables
}
