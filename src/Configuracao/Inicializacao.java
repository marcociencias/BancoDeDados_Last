/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracao;

import Spacenet.FormBD;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author marco.junior
 */
public class Inicializacao {
    
   public static void main(String args[])
   {  //    public void telaInicial(){
        Runnable r = new Runnable()
           
    
        
    //    Runnable r = new Runnable()
        {   
        @Override
        public void run() {
        {
            String teste = "WINDOWTITLE eq SPACENET IT BACKUP - BANCO DE DADOS";
            String comando = "tasklist /v /fi "+"\" "+teste+"\""+"  ";
            System.out.println("comando" + comando);
                try {
                    Process p;
                    p = Runtime.getRuntime().exec(comando);
                    InputStream input= p.getInputStream();  
                    BufferedInputStream reader= new BufferedInputStream(input);  
                    Scanner sc= new Scanner(p.getInputStream()); 
                    int i =0;
                    while(sc.hasNextLine())
                    {
                    i++; // variavel para varres o array
                    String java = "javaw.exe";
                    boolean linha= sc.nextLine().contentEquals(java);
                    System.out.println("linha" + linha + " quantidade" + i);
                    if(Thread.interrupted()) break;
                    switch (i) {
                        case 1:
                        FormBD TelaP = new FormBD();
                        TelaP.setVisible(true);

                        break;
                        case 2:
                        break;
                        case 3:
                        break;
                        case 4:
                        JOptionPane.showMessageDialog(null,"JÁ EXISTE UM NEPOS BACKUP ABERTO","NEPOS BACKUP",JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                        default:
                        break;
                                }
                    }
     
            } catch (SAXException ex) {
                Logger.getLogger(Inicializacao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Inicializacao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(Inicializacao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(Inicializacao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Inicializacao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Inicializacao.class.getName()).log(Level.SEVERE, null, ex);
            }
     
        }
       
    }
          
                };
                Thread t1 = new Thread(r);
                t1.start();
                
                }
    
   
    }
    



