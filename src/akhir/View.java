/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package akhir;

import imageHelper.ImageProcessing;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ucup_aw
 */
public class View extends javax.swing.JFrame {

    ImageProcessing imageBackground = null, image2 = null;

    /**
     * Creates new form View
     */
    public View() {
        initComponents();
        setLocationRelativeTo(null);
        imageBackground = new ImageProcessing();
        image2 = new ImageProcessing();

        BufferedImage background;
        try {
            background = ImageIO.read(new File("./Citra Images/video/video 0001.jpg"));
            imageBackground.setImage(background);
            citraBG.setIcon(new ImageIcon(imageBackground.getImage().getScaledInstance(290, 290, 0)));
            citraBG.setText("");
            imageBackground.imageToGray(0);
            citraBGgray.setIcon(new ImageIcon(imageBackground.getGrayImage().getScaledInstance(290, 290, 0)));
            citraBGgray.setText("");
        } catch (IOException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
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

        citraBGgray = new javax.swing.JLabel();
        citraBG = new javax.swing.JLabel();
        prosesSubstractionButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jh = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        citraSubstractionLabelHasil = new javax.swing.JLabel();
        subs = new javax.swing.JLabel();
        citraBiner = new javax.swing.JLabel();
        citraFrame = new javax.swing.JLabel();
        citraFrameGray = new javax.swing.JLabel();
        citraErosi = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Final Project - Pengolahan Citra Digital");

        citraBGgray.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        citraBGgray.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Background Gray", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 1, 12))); // NOI18N

        citraBG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        citraBG.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Background Awal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 1, 12))); // NOI18N

        prosesSubstractionButton.setText("Proses");
        prosesSubstractionButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prosesSubstractionButtonMouseClicked(evt);
            }
        });
        prosesSubstractionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prosesSubstractionButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Jumlah : ");

        jh.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jh.setText("0");

        jButton4.setText("Pilih Gambar");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        citraSubstractionLabelHasil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        citraSubstractionLabelHasil.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Citra Hasil Akhir", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 1, 12))); // NOI18N

        subs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subs.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Citra Hasil Substraction", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 1, 12))); // NOI18N

        citraBiner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        citraBiner.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Citra Hasil Binerisasi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 1, 12))); // NOI18N

        citraFrame.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        citraFrame.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Citra Awal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 1, 12))); // NOI18N

        citraFrameGray.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        citraFrameGray.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Citra Gray", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 1, 12))); // NOI18N

        citraErosi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        citraErosi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Citra Hasil Erosi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 1, 12))); // NOI18N

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Tentang");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(prosesSubstractionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jh, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(citraBG, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(citraFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(citraBGgray, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(citraBiner, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(citraFrameGray, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subs, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(citraErosi, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(citraSubstractionLabelHasil, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prosesSubstractionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jh)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(citraBG, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(citraFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(citraFrameGray, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subs, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(citraSubstractionLabelHasil, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(citraErosi, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(citraBGgray, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(citraBiner, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        final String path = "./Citra Images/video";
        javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
        chooser.setCurrentDirectory(new File(path));

        chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public final static String jpeg = "jpeg";
            public final String jpg = "jpg";
            public final String gif = "gif";
            public final String tiff = "tiff";
            public final String tif = "tif";
            public final String png = "png";

            /*Get the extension of a file.*/
            public String getExtension(java.io.File f) {
                String ext = null;
                String s = f.getName();
                int i = s.lastIndexOf('.');

                if (i > 0 && i < s.length() - 1) {
                    ext = s.substring(i + 1).toLowerCase();
                }
                return ext;
            }

            @Override
            public String getDescription() {
                return "All Images extensions (jpg, gif, tiff, tif, png)";
            }

            @Override
            public boolean accept(java.io.File f) {
                if (f.isDirectory()) {
                    return true;
                }

                String extension = getExtension(f);
                if (extension != null) {
                    return extension.equals(tiff)
                            || extension.equals(tif)
                            || extension.equals(gif)
                            || extension.equals(jpeg)
                            || extension.equals(jpg)
                            || extension.equals(png);
                }

                return false;
            }
        });

        if (chooser.showDialog(this, "  Open  ")
                == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File file = chooser.getSelectedFile();
            String filePath = file.toString();
            try {
                final BufferedImage bimg = ImageIO.read(new File(filePath));
                Thread t = new Thread() {
                    @Override
                    public void run() {
                        image2.setImage(bimg);
                        citraFrame.setIcon(new ImageIcon(image2.getImage().getScaledInstance(290, 290, 0)));
                        image2.imageToGray(0);
                        citraFrameGray.setIcon(new ImageIcon(image2.getGrayImage().getScaledInstance(290, 290, 0)));
                        citraSubstractionLabelHasil.setText("");
                        ImageProcessing ok = new ImageProcessing();
                        ok.setImage(image2.imageSubstraction(imageBackground.getGrayImage()));
                        ok.imageToGray(0);
                        ok.imageToBinary();
                        citraSubstractionLabelHasil.setIcon(new ImageIcon(image2.setBorderObject(image2.setBorderObject(image2.erosi(ok.getBinaryImage()))).getScaledInstance(290, 290, 0)));
                        subs.setText("");
                        citraErosi.setIcon(new ImageIcon(image2.erosi(ok.getBinaryImage()).getScaledInstance(290, 290, 0)));
                        subs.setIcon(new ImageIcon(image2.imageSubstraction(imageBackground.getGrayImage()).getScaledInstance(290, 290, 0)));
                        citraBiner.setIcon(new ImageIcon(ok.getBinaryImage().getScaledInstance(290, 290, 0)));
                    }
                };
                t.start();

            } catch (IOException e) {
                javax.swing.JOptionPane.showMessageDialog(
                        this, "File Tidak Ditemukan " + e);
            }
        }
    }//GEN-LAST:event_jButton4MouseClicked

    private void prosesSubstractionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prosesSubstractionButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prosesSubstractionButtonActionPerformed

    private void prosesSubstractionButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prosesSubstractionButtonMouseClicked
        final String path = "./Citra Images/video";
        Thread t = new Thread() {
            @Override
            public void run() {
                BufferedImage imageInput;
                for (int j = 11; j <= 4349; j++) {
                    try {
                        citraSubstractionLabelHasil.setText("");
                        if (j < 10) {
                            imageInput = ImageIO.read(new File(path + "/video 000".concat(Integer.toString(j).concat(".jpg"))));
                        } else if (j >= 10 && j < 100) {
                            imageInput = ImageIO.read(new File(path + "/video 00".concat(Integer.toString(j).concat(".jpg"))));
                        } else if (j >= 100 && j < 1000) {
                            imageInput = ImageIO.read(new File(path + "/video 0".concat(Integer.toString(j).concat(".jpg"))));
                        } else {
                            imageInput = ImageIO.read(new File(path + "/video ".concat(Integer.toString(j).concat(".jpg"))));
                        }
                        image2.setImage(imageInput);
                        citraFrame.setIcon(new ImageIcon(image2.getImage().getScaledInstance(290, 290, 0)));
                        image2.imageToGray(0);
                        citraFrameGray.setIcon(new ImageIcon(image2.getGrayImage().getScaledInstance(290, 290, 0)));
                        subs.setText("");
                        subs.setIcon(new ImageIcon(image2.imageSubstraction(imageBackground.getGrayImage()).getScaledInstance(290, 290, 0)));
                        ImageProcessing ok = new ImageProcessing();
                        ok.setImage(image2.imageSubstraction(imageBackground.getGrayImage()));
                        ok.imageToGray(0);
                        ok.imageToBinary();
                        citraBiner.setIcon(new ImageIcon(ok.getBinaryImage().getScaledInstance(290, 290, 0)));
                        citraErosi.setIcon(new ImageIcon(image2.erosi(ok.getBinaryImage()).getScaledInstance(290, 290, 0)));
                        citraSubstractionLabelHasil.setIcon(new ImageIcon(image2.setBorderObject(image2.erosi(ok.getBinaryImage())).getScaledInstance(290, 290, 0)));
                        jh.setText("" + image2.getJumlahHuman());

                    } catch (IOException e) {
                        System.out.println("Data Tidak Ditemukan");
                    }
                }
            }
        };
        t.start();
    }//GEN-LAST:event_prosesSubstractionButtonMouseClicked

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
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            try {
                javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex1) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel citraBG;
    private javax.swing.JLabel citraBGgray;
    private javax.swing.JLabel citraBiner;
    private javax.swing.JLabel citraErosi;
    private javax.swing.JLabel citraFrame;
    private javax.swing.JLabel citraFrameGray;
    private javax.swing.JLabel citraSubstractionLabelHasil;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel jh;
    private javax.swing.JButton prosesSubstractionButton;
    private javax.swing.JLabel subs;
    // End of variables declaration//GEN-END:variables
}