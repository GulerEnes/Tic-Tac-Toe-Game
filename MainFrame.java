
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author enesguler
 */
public class MainFrame extends javax.swing.JFrame {
    private static javax.swing.JButton[] map = new javax.swing.JButton[9];
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() throws InterruptedException {
        initComponents();
        map[0] = Box1;
        map[1] = Box2;
        map[2] = Box3;
        map[3] = Box4;
        map[4] = Box5;
        map[5] = Box6;
        map[6] = Box7;
        map[7] = Box8;
        map[8] = Box9;
        
        
    }
    public static char whoWin(){
        //Horizontal control
        for(int i = 0; i<=6; i+=3)
            if (map[i].getText().charAt(0) == map[i+1].getText().charAt(0) && 
                    map[i].getText().charAt(0) == map[i+2].getText().charAt(0) &&
                    map[i].getText().charAt(0) != ' ')
                return map[i].getText().charAt(0);
        //Vertical control
        for(int i = 0; i<=2; i++)
            if (map[i].getText().charAt(0) == map[i+3].getText().charAt(0) && 
                    map[i].getText().charAt(0) == map[i+6].getText().charAt(0) &&
                    map[i].getText().charAt(0) != ' ')
                return map[i].getText().charAt(0);
        //Diagonal control
        if (map[0].getText().charAt(0) == map[4].getText().charAt(0) && 
                    map[0].getText().charAt(0) == map[8].getText().charAt(0) &&
                    map[4].getText().charAt(0) != ' ')
            return map[4].getText().charAt(0);
        if (map[2].getText().charAt(0) == map[4].getText().charAt(0) && 
                    map[2].getText().charAt(0) == map[6].getText().charAt(0) &&
                    map[4].getText().charAt(0) != ' ')
            return map[4].getText().charAt(0);
        return 'b';
    }
    public static void aiMove(){
        char[] m = new char[9];
        for(int i = 0; i<9; i++)
            m[i] = map[i].getText().charAt(0);
        
        int wBox = isThereLogicalMove(m, 'O'); //Win Move
        if(wBox != -1){
            map[wBox].setText("O");
            map[wBox].setEnabled(false);
            return;
        }
        int bBox = isThereLogicalMove(m, 'X'); //Block Move
        if(bBox != -1){
            map[bBox].setText("O");
            map[bBox].setEnabled(false);
            return;
        }
        else{//Random Play
            Random rand = new Random();
            int rBox;
            do{
                rBox = rand.nextInt(9);
            }while(map[rBox].getText().charAt(0) != ' ');
            map[rBox].setText("O");
            map[rBox].setEnabled(false);
        }
        
    }
    public static int isThereLogicalMove(char[] m, char c){
        //Horizontal control
        for(int i = 0; i<9; i+=3){
            if(m[i] == ' ' && m[i+1] == c && m[i+2] == c)
                return i;
            if(m[i] == c && m[i+1] == ' ' && m[i+2] == c)
                return i+1;
            if(m[i] == c && m[i+1] == c && m[i+2] == ' ')
                return i+2;
        }
        //Vertical control
        for(int i = 0; i<3; i++){
            if(m[i] == ' ' && m[i+3] == c && m[i+6] == c)
                return i;
            if(m[i] == c && m[i+3] == ' ' && m[i+6] == c)
                return i+3;
            if(m[i] == c && m[i+3] == c && m[i+6] == ' ')
                return i+6;
        }
        //Diagonal check
        if(m[0] == ' ' && m[4] == c && m[8] == c)
            return 0;
        if(m[0] == c && m[4] == ' ' && m[8] == c)
            return 4;
        if(m[0] == c && m[4] == c && m[8] == ' ')
            return 8;
        if(m[2] == ' ' && m[4] == c && m[6] == c)
            return 2;
        if(m[2] == c && m[4] == ' ' && m[6] == c)
            return 4;
        if(m[2] == c && m[4] == c && m[6] == ' ')
            return 6;
        
        else 
            return -1;
    }
    public boolean isGameEnd(){
        int count = 0;
        for(javax.swing.JButton b: map)
            if(b.getText().charAt(0) == ' ')
                count++;
        if(count == 0)
            return true;
        
        char winner = whoWin();
        if(winner == 'b')
            return false;
            
        else{//Game finish
            if(winner == 'X')
                playerWinNumber.setText(Integer.toString(Integer.parseInt(playerWinNumber.getText())+1));
            else if(winner == 'O')
                computerWinNumber.setText(Integer.toString(Integer.parseInt(computerWinNumber.getText())+1));
            
            return true;
        }
    }
    public void nextMove(){
        if(!isGameEnd()){
            aiMove();
            if(isGameEnd())
                Reset.doClick();
        }
        else
            Reset.doClick();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gamePanel = new javax.swing.JPanel();
        Box4 = new javax.swing.JButton();
        Box7 = new javax.swing.JButton();
        Box2 = new javax.swing.JButton();
        Box1 = new javax.swing.JButton();
        Box5 = new javax.swing.JButton();
        Box3 = new javax.swing.JButton();
        Box6 = new javax.swing.JButton();
        Box8 = new javax.swing.JButton();
        Box9 = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        computerLabel = new javax.swing.JLabel();
        playerLabel = new javax.swing.JLabel();
        computerWinNumber = new javax.swing.JLabel();
        playerWinNumber = new javax.swing.JLabel();
        NewGame = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TicTacToe by Enes Güler");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        gamePanel.setPreferredSize(new java.awt.Dimension(402, 402));

        Box4.setFont(new java.awt.Font("Ubuntu", 0, 64)); // NOI18N
        Box4.setText(" ");
        Box4.setPreferredSize(new java.awt.Dimension(132, 132));
        Box4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box4ActionPerformed(evt);
            }
        });

        Box7.setFont(new java.awt.Font("Ubuntu", 0, 64)); // NOI18N
        Box7.setText(" ");
        Box7.setPreferredSize(new java.awt.Dimension(132, 132));
        Box7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box7ActionPerformed(evt);
            }
        });

        Box2.setFont(new java.awt.Font("Ubuntu", 0, 64)); // NOI18N
        Box2.setText(" ");
        Box2.setPreferredSize(new java.awt.Dimension(132, 132));
        Box2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box2ActionPerformed(evt);
            }
        });

        Box1.setFont(new java.awt.Font("Ubuntu", 0, 64)); // NOI18N
        Box1.setText(" ");
        Box1.setPreferredSize(new java.awt.Dimension(132, 132));
        Box1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box1ActionPerformed(evt);
            }
        });

        Box5.setFont(new java.awt.Font("Ubuntu", 0, 64)); // NOI18N
        Box5.setText(" ");
        Box5.setPreferredSize(new java.awt.Dimension(132, 132));
        Box5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box5ActionPerformed(evt);
            }
        });

        Box3.setFont(new java.awt.Font("Ubuntu", 0, 64)); // NOI18N
        Box3.setText(" ");
        Box3.setPreferredSize(new java.awt.Dimension(132, 132));
        Box3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box3ActionPerformed(evt);
            }
        });

        Box6.setFont(new java.awt.Font("Ubuntu", 0, 64)); // NOI18N
        Box6.setText(" ");
        Box6.setPreferredSize(new java.awt.Dimension(132, 132));
        Box6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box6ActionPerformed(evt);
            }
        });

        Box8.setFont(new java.awt.Font("Ubuntu", 0, 64)); // NOI18N
        Box8.setText(" ");
        Box8.setPreferredSize(new java.awt.Dimension(132, 132));
        Box8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box8ActionPerformed(evt);
            }
        });

        Box9.setFont(new java.awt.Font("Ubuntu", 0, 64)); // NOI18N
        Box9.setText(" ");
        Box9.setPreferredSize(new java.awt.Dimension(132, 132));
        Box9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Box9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePanelLayout.createSequentialGroup()
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gamePanelLayout.createSequentialGroup()
                        .addComponent(Box4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Box5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Box6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gamePanelLayout.createSequentialGroup()
                        .addComponent(Box1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Box2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Box3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gamePanelLayout.createSequentialGroup()
                        .addComponent(Box7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Box8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Box9, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gamePanelLayout.createSequentialGroup()
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Box1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Box2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Box3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Box4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Box5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Box6, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Box7, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Box8, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Box9, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        computerLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        computerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        computerLabel.setText("Computer");
        computerLabel.setPreferredSize(new java.awt.Dimension(106, 21));

        playerLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        playerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerLabel.setText("Player");
        playerLabel.setPreferredSize(new java.awt.Dimension(106, 21));

        computerWinNumber.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        computerWinNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        computerWinNumber.setText("0");

        playerWinNumber.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        playerWinNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerWinNumber.setText("0");

        NewGame.setText("New Game");
        NewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(computerWinNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(computerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerWinNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(NewGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(Reset)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(computerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(computerWinNumber)
                            .addComponent(playerWinNumber))
                        .addGap(26, 26, 26)
                        .addComponent(NewGame)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Box1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box1ActionPerformed
        Box1.setText("X");
        Box1.setEnabled(false);
        nextMove();
    }//GEN-LAST:event_Box1ActionPerformed

    private void Box2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box2ActionPerformed
        Box2.setText("X");
        Box2.setEnabled(false);
        nextMove();
    }//GEN-LAST:event_Box2ActionPerformed

    private void Box3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box3ActionPerformed
        Box3.setText("X");
        Box3.setEnabled(false);
        nextMove();
    }//GEN-LAST:event_Box3ActionPerformed

    private void Box4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box4ActionPerformed
        Box4.setText("X");
        Box4.setEnabled(false);
        nextMove();
    }//GEN-LAST:event_Box4ActionPerformed

    private void Box5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box5ActionPerformed
        Box5.setText("X");
        Box5.setEnabled(false);
        nextMove();
    }//GEN-LAST:event_Box5ActionPerformed

    private void Box6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box6ActionPerformed
        Box6.setText("X");
        Box6.setEnabled(false);
        nextMove();
    }//GEN-LAST:event_Box6ActionPerformed

    private void Box7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box7ActionPerformed
        Box7.setText("X");
        Box7.setEnabled(false);
        nextMove();
    }//GEN-LAST:event_Box7ActionPerformed

    private void Box8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box8ActionPerformed
        Box8.setText("X");
        Box8.setEnabled(false);
        nextMove();
    }//GEN-LAST:event_Box8ActionPerformed

    private void Box9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Box9ActionPerformed
        Box9.setText("X");
        Box9.setEnabled(false);
        nextMove();
    }//GEN-LAST:event_Box9ActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        for(javax.swing.JButton b: map){
            b.setText(" ");
            b.setEnabled(true);
        }
    }//GEN-LAST:event_ResetActionPerformed

    private void NewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewGameActionPerformed
        Reset.doClick();
        playerWinNumber.setText("0");
        computerWinNumber.setText("0");
    }//GEN-LAST:event_NewGameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException {
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFrame().setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
            
            
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Box1;
    private javax.swing.JButton Box2;
    private javax.swing.JButton Box3;
    private javax.swing.JButton Box4;
    private javax.swing.JButton Box5;
    private javax.swing.JButton Box6;
    private javax.swing.JButton Box7;
    private javax.swing.JButton Box8;
    private javax.swing.JButton Box9;
    private javax.swing.JButton NewGame;
    private javax.swing.JButton Reset;
    private javax.swing.JLabel computerLabel;
    private javax.swing.JLabel computerWinNumber;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JLabel playerLabel;
    private javax.swing.JLabel playerWinNumber;
    // End of variables declaration//GEN-END:variables
}
