import java.awt.*; 
 import java.awt.event.*; 
 import java.util.*; 
 import javax.swing.*; 
  
 public class TicTacToe implements ActionListener{ 
  
     Random random = new Random(); 
     JFrame frame = new JFrame(); 
     JPanel title_panel = new JPanel(); 
     JPanel button_panel = new JPanel(); 
     JLabel textfield = new JLabel(); 
     JButton[] buttons = new JButton[9]; 
     boolean player1_turn; 
  
     TicTacToe(){ 
  
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
         frame.setSize(800,800); 
         frame.getContentPane().setBackground(new Color(50,50,50)); 
         frame.setLayout(new BorderLayout()); 
         frame.setVisible(true); 
  
  
         textfield.setBackground(new Color(25,25,25)); 
         textfield.setForeground(new Color(255, 0,0)); 
         textfield.setFont(new Font("serif",Font.BOLD,75)); 
         textfield.setHorizontalAlignment(JLabel.CENTER); 
         textfield.setText("Tic-Tac-Toe"); 
         textfield.setOpaque(true); 
  
         title_panel.setLayout(new BorderLayout()); 
         title_panel.setBounds(0,0,800,100); 
  
         button_panel.setLayout(new GridLayout(3,3)); 
         button_panel.setBackground(new Color(150,150,150)); 
  
         for(int i=0;i<9;i++) { 
             buttons[i] = new JButton(); 
             button_panel.add(buttons[i]); 
             buttons[i].setFont(new Font("serif",Font.BOLD,120)); 
             buttons[i].setFocusable(false); 
             buttons[i].addActionListener(this); 
         } 
  
         title_panel.add(textfield); 
         frame.add(title_panel,BorderLayout.NORTH); 
         frame.add(button_panel); 
  
         firstTurn(); 
     } 
  
     @Override 
     public void actionPerformed(ActionEvent e) { 
  
         for(int i=0;i<9;i++) { 
             if(e.getSource()==buttons[i]) { 
                 if(player1_turn) { 
                     if(buttons[i].getText()=="") { 
                         buttons[i].setForeground(new Color(255,0,0)); 
                         buttons[i].setText("A"); 
                         player1_turn=false; 
                         textfield.setText("B turn"); 
                         check(); 
                     } 
                 } 
                 else { 
                     if(buttons[i].getText()=="") { 
                         buttons[i].setForeground(new Color(0,0,255)); 
                         buttons[i].setText("B"); 
                         player1_turn=true; 
                         textfield.setText("A turn"); 
                         check(); 
                     } 
                 } 
             } 
         } 
     } 
  
     public void firstTurn() { 
  
         try { 
             Thread.sleep(2000); 
         } catch (InterruptedException e) { 
             e.printStackTrace(); 
         } 
  
         if(random.nextInt(2)==0) { 
             player1_turn=true; 
             textfield.setText("A turn"); 
         } 
         else { 
             player1_turn=false; 
             textfield.setText("B turn"); 
         } 
     } 
  
     public void check() { 
         //check X win conditions 
         if( 
                 (buttons[0].getText()=="A") && 
                         (buttons[1].getText()=="A") && 
                         (buttons[2].getText()=="A") 
         ) { 
             aWins(0,1,2); 
         } 
         if( 
                 (buttons[3].getText()=="A") && 
                         (buttons[4].getText()=="A") && 
                         (buttons[5].getText()=="A") 
         ) { 
             aWins(3,4,5); 
         } 
         if( 
                 (buttons[6].getText()=="A") && 
                         (buttons[7].getText()=="A") && 
                         (buttons[8].getText()=="A") 
         ) { 
             aWins(6,7,8); 
         } 
         if( 
                 (buttons[0].getText()=="A") && 
                         (buttons[3].getText()=="A") && 
                         (buttons[6].getText()=="A") 
         ) { 
             aWins(0,3,6); 
         } 
         if( 
                 (buttons[1].getText()=="A") && 
                         (buttons[4].getText()=="A") && 
                         (buttons[7].getText()=="A") 
         ) { 
             aWins(1,4,7); 
         } 
         if( 
                 (buttons[2].getText()=="A") && 
                         (buttons[5].getText()=="A") && 
                         (buttons[8].getText()=="A") 
         ) { 
             aWins(2,5,8); 
         } 
         if( 
                 (buttons[0].getText()=="A") && 
                         (buttons[4].getText()=="A") && 
                         (buttons[8].getText()=="A") 
         ) { 
             aWins(0,4,8); 
         } 
         if( 
                 (buttons[2].getText()=="A") && 
                         (buttons[4].getText()=="A") && 
                         (buttons[6].getText()=="A") 
         ) { 
             aWins(2,4,6); 
         } 
         //check B win conditions 
         if( 
                 (buttons[0].getText()=="B") && 
                         (buttons[1].getText()=="B") && 
                         (buttons[2].getText()=="B") 
         ) { 
             bWins(0,1,2); 
         } 
         if( 
                 (buttons[3].getText()=="B") && 
                         (buttons[4].getText()=="B") && 
                         (buttons[5].getText()=="B") 
         ) { 
             bWins(3,4,5); 
         } 
         if( 
                 (buttons[6].getText()=="B") && 
                         (buttons[7].getText()=="B") && 
                         (buttons[8].getText()=="B") 
         ) { 
             bWins(6,7,8); 
         } 
         if( 
                 (buttons[0].getText()=="B") && 
                         (buttons[3].getText()=="B") && 
                         (buttons[6].getText()=="B") 
         ) { 
             bWins(0,3,6); 
         } 
         if( 
                 (buttons[1].getText()=="B") && 
                         (buttons[4].getText()=="B") && 
                         (buttons[7].getText()=="B") 
         ) { 
             bWins(1,4,7); 
         } 
         if( 
                 (buttons[2].getText()=="B") && 
                         (buttons[5].getText()=="B") && 
                         (buttons[8].getText()=="B") 
         ) { 
             bWins(2,5,8); 
         } 
         if( 
                 (buttons[0].getText()=="B") && 
                         (buttons[4].getText()=="B") && 
                         (buttons[8].getText()=="B") 
         ) { 
             bWins(0,4,8); 
         } 
         if( 
                 (buttons[2].getText()=="B") && 
                         (buttons[4].getText()=="B") && 
                         (buttons[6].getText()=="B") 
         ) { 
             bWins(2,4,6); 
         } 
     } 
  
     public void aWins(int a,int b,int c) { 
         buttons[a].setBackground(Color.RED); 
         buttons[b].setBackground(Color.RED); 
         buttons[c].setBackground(Color.RED); 
  
         for(int i=0;i<9;i++) { 
             buttons[i].setEnabled(false); 
         } 
         textfield.setText("A wins"); 
     } 
     public void bWins(int a,int b,int c) { 
         buttons[a].setBackground(Color.RED); 
         buttons[b].setBackground(Color.RED); 
         buttons[c].setBackground(Color.RED); 
  
         for(int i=0;i<9;i++) { 
             buttons[i].setEnabled(false); 
         } 
         textfield.setText("B wins"); 
     } 
  
     public void draw(int a,int b,int c) { 
         buttons[a].setBackground(Color.RED); 
         buttons[b].setBackground(Color.RED); 
         buttons[c].setBackground(Color.RED); 
  
         for(int i=0;i<9;i++) { 
             buttons[i].setEnabled(false); 
         } 
         textfield.setText("drawn"); 
     } 
  
 }
