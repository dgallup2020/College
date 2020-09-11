/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;
import business.shapes.*;
import business.point.*;
import business.shapes.*;
import business.dimension.*;
import helpers.*;

import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;

public class Shapes_GUI extends javax.swing.JFrame {

    private Shape aShape;
    
    public Shapes_GUI() {
        initComponents();
        setNumberShapes();
        enableControls(false);
    }
     private void enableControls(boolean enable) {
        GUIUtilities.enableInputFields(pnlInput, enable);
        GUIUtilities.enableInputFields(pnlOutput, enable);
        btnCalculate.setEnabled(enable);
    }
      private void createNewShape(ShapeTypes.Shapes type) {   
        if (Shape.validShapeCount()) {
             aShape = null;
            switch (type) {
                case CIRCLE:
                    aShape = new Circle();
                    break;
                case SQUARE:
                    aShape = new Square();
                    break;
                case RECTANGLE:
                    aShape = new Rectangle();
                    break;
                default: 
                    aShape = new Circle();
                    break;
            }
            clearFields();
            enableControls(true);
            setLabels();
        }
        else {
            OutputHelpers.showExceptionDialog("Too many shapes--cannot continue until a shape has been deleted", "Too Many Shapes");
            enableControls(false);
        }
    }
    private void setLabels() {
        switch (aShape.getType()) {
            case CIRCLE:
                lblLength.setText("Radius");
                lblHeight.setVisible(false);
                txtHeight.setVisible(false);
                break;
            case SQUARE:
                lblLength.setText("Side Length");
                lblHeight.setVisible(false);
                txtHeight.setVisible(false);
                break;
            case RECTANGLE:
                lblLength.setText("Side Length");
                lblHeight.setVisible(true);
                lblHeight.setText("Height Length");
                txtHeight.setVisible(true);
                break;
            default:
                lblLength.setText("Length");
                txtLength.setVisible(true);
                lblHeight.setText("Height");
                txtHeight.setVisible(true);
                break;
        }
    }
    private void clearFields() {
        GUIUtilities.clearInputFields(pnlInput);
        GUIUtilities.clearInputFields(pnlOutput);
    }
    private void deleteShape() {
        int response;
        response = OutputHelpers.showOKCancelDiaglog("Are you sure you want to delete the shape", "Delete Shape");
        if (response == JOptionPane.YES_OPTION) {
            Shape.deleteShape();
            setNumberShapes();
        }
        else {
            OutputHelpers.showExceptionDialog("Too many shapes--cannot continue until a shape has been deleted", "Too Many Shapes");
        }
        clearFields();
        enableControls(false);
    }
    private void setNumberShapes() {
        txtNumberObjects.setText(Shape.getShapeCountToString());
    }
    private void exitApplication() {
        ApplicationHelpers.terminateGUIApplication("Circle Program");
    }
    private void calculateData() {
        boolean valid;
        
        valid = getShapeName();
        if (valid) {
            valid = getShapeLength();
        }
        if (valid) {
            valid = getShapeHeight();
        }
        if (valid) {
            valid = getXCoordinate();
        }
        if (valid) {
            valid = getYCoordinate();
        }
        if (valid) {
            txtCircle.setText(aShape.toString());
            Shape.incrementShapeCount();
            setNumberShapes();
        }
    }
    private boolean getShapeName() {
        boolean valid = false ;
        String str = InputHelpers.getStringField(txtName, "Circle Name");
        if (!StringHelpers.IsNullOrEmpty(str)) {
            valid = true;
            aShape.setName(str);
        }
        return valid;
    }
    private boolean getShapeLength() {
        boolean valid = false;
        int length = InputHelpers.parseIntegerField(txtLength, "Length", ShapeDimensions.MIN_SIZE, ShapeDimensions.MAX_SIZE);
        if (length != InputHelpers.CANCEL_FLAG) {
            valid = true;
            aShape.getDimensions().setLength(length);
        }
        return valid;
    }
    private boolean getShapeHeight() {
        boolean valid = false;
         if (aShape.getDimensions() instanceof ShapeTwoDimenions) {
            int height = InputHelpers.parseIntegerField(txtHeight, "Height", ShapeDimensions.MIN_SIZE, ShapeDimensions.MAX_SIZE);
            if (height != InputHelpers.CANCEL_FLAG) {
                valid = true;
                aShape.getDimensions().setHeight(height);
            }
         }
         else {
             valid = true;
         }
         return valid;
    }
    private boolean getXCoordinate() {
        boolean valid = false;
        int X = InputHelpers.parseIntegerField(txtX, "X Coordinate", Point.MIN_COORDINATE, Point.MAX_COORDINATE);
        if (X != InputHelpers.CANCEL_FLAG) {
            valid = true;
            aShape.getPoint().setX(X);
        }
        return valid;
    }
    private boolean getYCoordinate() {
        boolean valid = false;
        int Y = InputHelpers.parseIntegerField(txtY, "Y Coordinate", Point.MIN_COORDINATE, Point.MAX_COORDINATE);
        if (Y != InputHelpers.CANCEL_FLAG) {
            valid = true;
            aShape.getPoint().setY(Y);
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
        txtCircle = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        pnlInput = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblLength = new javax.swing.JLabel();
        txtLength = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtX = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtY = new javax.swing.JTextField();
        pnlShapeType = new javax.swing.JPanel();
        radCircle = new javax.swing.JRadioButton();
        radSquare = new javax.swing.JRadioButton();
        radRectangle = new javax.swing.JRadioButton();
        lblHeight = new javax.swing.JLabel();
        txtHeight = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        txtNumberObjects = new javax.swing.JTextField();
        bntClear = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuExit = new javax.swing.JMenuItem();
        mnuCircle = new javax.swing.JMenu();
        mnuCalculate = new javax.swing.JMenuItem();
        mnuClear = new javax.swing.JMenuItem();
        mnuDeleteCircle = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Circle Program");

        jLabel1.setText("Welcome to the Circle Program");

        jLabel2.setText("Select the type of shape and enter the shape information");
        jLabel2.setToolTipText("");

        btnCalculate.setText("Calculate Data");
        btnCalculate.setToolTipText("Click to calculate the circle information");
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

        pnlOutput.setBorder(javax.swing.BorderFactory.createTitledBorder("Shape Data"));

        txtCircle.setColumns(20);
        txtCircle.setRows(5);
        jScrollPane1.setViewportView(txtCircle);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8))
        );

        pnlInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Shape Input Information"));

        jLabel3.setText("Name");

        lblLength.setText("Radius");

        jLabel5.setText("X");

        jLabel6.setText("Y");

        pnlShapeType.setBorder(javax.swing.BorderFactory.createTitledBorder("Shape Type"));

        grpShapeType.add(radCircle);
        radCircle.setText("Circle");
        radCircle.setToolTipText("Select to create a circle");
        radCircle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radCircleItemStateChanged(evt);
            }
        });

        grpShapeType.add(radSquare);
        radSquare.setText("Square");
        radSquare.setToolTipText("Select to create a square");
        radSquare.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radSquareItemStateChanged(evt);
            }
        });

        grpShapeType.add(radRectangle);
        radRectangle.setText("Rectangle");
        radRectangle.setToolTipText("Select to create a rectangle");
        radRectangle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radRectangleItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlShapeTypeLayout = new javax.swing.GroupLayout(pnlShapeType);
        pnlShapeType.setLayout(pnlShapeTypeLayout);
        pnlShapeTypeLayout.setHorizontalGroup(
            pnlShapeTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlShapeTypeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radCircle)
                .addGap(18, 18, 18)
                .addComponent(radSquare)
                .addGap(18, 18, 18)
                .addComponent(radRectangle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlShapeTypeLayout.setVerticalGroup(
            pnlShapeTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlShapeTypeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlShapeTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radCircle)
                    .addComponent(radSquare)
                    .addComponent(radRectangle))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        lblHeight.setText("Side Length");
        lblHeight.setToolTipText("Side Length");

        txtHeight.setToolTipText("Enter the length of the side");

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
                            .addGroup(pnlInputLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtName))
                            .addGroup(pnlInputLayout.createSequentialGroup()
                                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlInputLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtX, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlInputLayout.createSequentialGroup()
                                        .addComponent(lblLength)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtLength, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlInputLayout.createSequentialGroup()
                                        .addComponent(lblHeight)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlInputLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtY, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        pnlInputLayout.setVerticalGroup(
            pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInputLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlShapeType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLength)
                    .addComponent(txtLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHeight)
                    .addComponent(txtHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGroup(pnlInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 80));
        jLabel7.setText("# Shapes Created:");

        btnDelete.setText("Delete Shape");
        btnDelete.setToolTipText("Click to delete a shape");
        btnDelete.setPreferredSize(new java.awt.Dimension(110, 25));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtNumberObjects.setEditable(false);
        txtNumberObjects.setBackground(new java.awt.Color(204, 204, 204));
        txtNumberObjects.setToolTipText("Displays number of circle created");

        bntClear.setText("Clear fields");
        bntClear.setToolTipText("Click to clear the fields");
        bntClear.setPreferredSize(new java.awt.Dimension(110, 25));
        bntClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntClearActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        mnuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        mnuExit.setText("Exit");
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        jMenu1.add(mnuExit);

        jMenuBar1.add(jMenu1);

        mnuCircle.setText("Circle");

        mnuCalculate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        mnuCalculate.setText("Calculate");
        mnuCalculate.setToolTipText("Click to cancel the circle data");
        mnuCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCalculateActionPerformed(evt);
            }
        });
        mnuCircle.add(mnuCalculate);

        mnuClear.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK));
        mnuClear.setText("Clear Fields");
        mnuClear.setToolTipText("Click to create a new circle");
        mnuClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuClearActionPerformed(evt);
            }
        });
        mnuCircle.add(mnuClear);

        mnuDeleteCircle.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        mnuDeleteCircle.setText("Delete Circle");
        mnuDeleteCircle.setToolTipText("Click to delete a circle");
        mnuDeleteCircle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDeleteCircleActionPerformed(evt);
            }
        });
        mnuCircle.add(mnuDeleteCircle);

        jMenuBar1.add(mnuCircle);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 23, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNumberObjects, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(pnlInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlOutput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bntClear, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(11, 11, 11)
                .addComponent(pnlInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNumberObjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        calculateData();
    }//GEN-LAST:event_btnCalculateActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        exitApplication();
    }//GEN-LAST:event_btnExitActionPerformed

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
         exitApplication();
    }//GEN-LAST:event_mnuExitActionPerformed

    private void mnuCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCalculateActionPerformed
        calculateData();
    }//GEN-LAST:event_mnuCalculateActionPerformed

    private void mnuClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuClearActionPerformed
        clearFields();
    }//GEN-LAST:event_mnuClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       deleteShape();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void mnuDeleteCircleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDeleteCircleActionPerformed
        deleteShape();
    }//GEN-LAST:event_mnuDeleteCircleActionPerformed

    private void radCircleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radCircleItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            createNewShape(ShapeTypes.Shapes.CIRCLE);
        }
    }//GEN-LAST:event_radCircleItemStateChanged

    private void radSquareItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radSquareItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
             createNewShape(ShapeTypes.Shapes.SQUARE);
        }
    }//GEN-LAST:event_radSquareItemStateChanged

    private void radRectangleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radRectangleItemStateChanged
       if (evt.getStateChange() == ItemEvent.SELECTED) {
             createNewShape(ShapeTypes.Shapes.RECTANGLE);
        }
    }//GEN-LAST:event_radRectangleItemStateChanged

    private void bntClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntClearActionPerformed
        clearFields();
    }//GEN-LAST:event_bntClearActionPerformed

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
            java.util.logging.Logger.getLogger(Shapes_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Shapes_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Shapes_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Shapes_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        Shapes_GUI mainForm = new Shapes_GUI();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUIUtilities.centerForm(mainForm);
                mainForm.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntClear;
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.ButtonGroup grpShapeType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHeight;
    private javax.swing.JLabel lblLength;
    private javax.swing.JMenuItem mnuCalculate;
    private javax.swing.JMenu mnuCircle;
    private javax.swing.JMenuItem mnuClear;
    private javax.swing.JMenuItem mnuDeleteCircle;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JPanel pnlInput;
    private javax.swing.JPanel pnlOutput;
    private javax.swing.JPanel pnlShapeType;
    private javax.swing.JRadioButton radCircle;
    private javax.swing.JRadioButton radRectangle;
    private javax.swing.JRadioButton radSquare;
    private javax.swing.JTextArea txtCircle;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextField txtLength;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumberObjects;
    private javax.swing.JTextField txtX;
    private javax.swing.JTextField txtY;
    // End of variables declaration//GEN-END:variables
}
