package GUI;


/**
 * @author Tahreem
 */


import compressordecompressor.compressor;
import compressordecompressor.decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AppFrame extends JFrame implements ActionListener{
    
    JButton compressButton;
    JButton decompressButton;
    
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        JLabel welcomeLabel = new JLabel("Welcome to the Compression/Decompression Tool!");
        welcomeLabel.setBounds(20, 20, 400, 30);
        welcomeLabel.setForeground(Color.cyan); // Set the foreground color to green
        this.add(welcomeLabel);
        
        compressButton=new JButton("Select file to Compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20,100,200,30);
        compressButton.setBackground(Color.green); // set the background color of the button
        
        decompressButton=new JButton("Select file to Decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250,100,200,30);
        decompressButton.setBackground(Color.cyan); // set the background color of the button
        
        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(500,200);
        this.getContentPane().setBackground(Color.lightGray);
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compressButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    compressor.method(file);
                    JOptionPane.showMessageDialog(null, "Compression successful!");
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                    
                }
            }            
        }
        if(e.getSource()==decompressButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    decompressor.method(file);
                   
                    JOptionPane.showMessageDialog(null, "Decompression successful!");
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                    
                }
            }
            
        }
    }
}