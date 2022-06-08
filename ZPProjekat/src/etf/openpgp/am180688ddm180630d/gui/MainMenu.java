package etf.openpgp.am180688ddm180630d.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.*; 
import javax.swing.*;

import etf.openpgp.am180688ddm180630d.data.PublicKey;
import etf.openpgp.am180688ddm180630d.data.PublicKeyRing;   

public class MainMenu extends Frame {
	
	Panel glavni = new Panel(new BorderLayout());
	Panel za_dugmice = new Panel(new GridLayout(5,1,3,7));
	Button upravljanje_postojecim_kljucevima = new Button("Upravljanje postojecim kljucevima");
	Button uvoz_izvoz_kljuceva = new Button("Uvoz/izvoz kljuceva");
	Button prstenovi_kljuceva = new Button("Prstenovi kljuceva");
	Button posalji_poruku = new Button("Posalji poruku");
	Button primi_poruku = new Button("Primi poruku");
	Dialog upk; Dialog uik; Dialog pk; Dialog posalji; Dialog primi;
	Panel generisanje_i_brisanje = new Panel(new GridLayout(4,2,4,2));
	Label username = new Label("Username");
	TextField user = new TextField();
	Label email = new Label("Email");
	TextField e_mail = new TextField();
	Label rsa = new Label("RSA Lenght");
	Checkbox checkbox1 = new Checkbox("1024");
	Checkbox checkbox2 = new Checkbox("2048");
	Checkbox checkbox3 = new Checkbox("4096");
	Panel panel_za_checkbox = new Panel(new GridLayout(1,3,2,2));
	Label password = new Label("Password");
	TextField pass = new TextField();
	Button generisi = new Button("Generisi");
	Label key = new Label("Key");
	Label password2 = new Label("Password");
	TextField pass2 = new TextField();
	Panel generisanje_i_brisanje2 = new Panel(new GridLayout(2,2,4,2));
	Button obrisi = new Button("Obrisi");
	Choice padajuca_lista = new Choice();
	Label putanja = new Label("Putanja");
	Label kljuc = new Label("Kljuc");
	TextField polje_za_putanju = new TextField();
	Choice padajuca_lista_za_uik = new Choice();
	Button uvezi = new Button("Uvezi"); Button nazad3 = new Button("Nazad");
	Button izvezi = new Button("Izvezi");
	 JPanel Jpanel = new JPanel(new GridLayout(2,1));
	 JPanel Jpanel2 = new JPanel(new BorderLayout()); 
	
	JFrame f=new JFrame();    
    String data_za_privatni_kljuc[][]={}; 
    
    
    String zaglavlje_za_privatni_kljuc[]={"Timestamp","KeyID","Public Key", "Encrypted Private Key", "User ID"};       
    JTable jt_privatni;
    String data_za_javni_kljuc[][]={};    
    String zaglavlje_za_javni_kljuc[]={"Timestamp","KeyID","Public Key","Owner Trust", "User ID", "Key Legitimacy","Signatures","Signature Trust"}; 
    JTable jt_javni;
	
	
	public MainMenu() {
		
		setVisible(true);
		setSize(400,400);
		setTitle("PGP Simulator");
		
		za_dugmice.add(upravljanje_postojecim_kljucevima);
		za_dugmice.add(uvoz_izvoz_kljuceva);
		za_dugmice.add(prstenovi_kljuceva);
		za_dugmice.add(posalji_poruku);
		za_dugmice.add(primi_poruku);
		glavni.add(za_dugmice);
		add(za_dugmice, BorderLayout.CENTER);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
				
			}
		});

		 
		
		
		 dodajDialoge();
		 
		dodajOsluskivace();
		
	}

	protected void dodajDialoge() {
		upk = new Dialog(this,"Upravljanje postojecim kljucevima", true);
		upk.setLayout(new BorderLayout()); 
		upk.setSize(500,300);
		Panel glavni = new Panel(new GridLayout(2,1));
		Button nazad = new Button("Nazad");
		upk.add(nazad, BorderLayout.SOUTH);
		generisanje_i_brisanje.add(username);
		generisanje_i_brisanje.add(user);
		generisanje_i_brisanje.add(email);
		generisanje_i_brisanje.add(e_mail);
		generisi.addActionListener ( new ActionListener()  {  
			 public void actionPerformed( ActionEvent e ) {  
	                String uname = user.getText();
	                String email = e_mail.getText();
	                String pword = pass.getText();
	                if(checkbox1.getState())
	                {
	                	PublicKey pk = new PublicKey(1024, uname, email, pword);
	                }
	                else if (checkbox2.getState())
	                {
	                	PublicKey pk = new PublicKey(2048, uname, email, pword);
	                }
	                else 
	                {
	                	PublicKey pk = new PublicKey(4096, uname, email, pword);
	                }
	                padajuca_lista.removeAll();
	        		for(PublicKey pk: PublicKeyRing.ring)
	        		{
	        			padajuca_lista.add(pk.getUserID());
	        		}
	            }  
	        });  
		panel_za_checkbox.add(checkbox1);
		panel_za_checkbox.add(checkbox2);
		panel_za_checkbox.add(checkbox3);
		generisanje_i_brisanje.add(rsa);
		generisanje_i_brisanje.add(panel_za_checkbox);
		generisanje_i_brisanje.add(password);
		generisanje_i_brisanje.add(pass);
		Panel pomocni = new Panel(new BorderLayout());
		pomocni.add(generisanje_i_brisanje, BorderLayout.CENTER);
		pomocni.add(generisi, BorderLayout.SOUTH);
		
		
		Panel pomocni2 = new Panel(new BorderLayout());
		generisanje_i_brisanje2.add(key);
		generisanje_i_brisanje2.add(padajuca_lista);
		generisanje_i_brisanje2.add(password2);
		generisanje_i_brisanje2.add(pass2);
		pomocni2.add(generisanje_i_brisanje2, BorderLayout.CENTER);
		pomocni2.add(obrisi, BorderLayout.SOUTH);
		
		obrisi.addActionListener ( new ActionListener()  {  
			 public void actionPerformed( ActionEvent e ) {  
	                PublicKey pk = null;
	                String vrednost = padajuca_lista.getSelectedItem();
	                String pword = pass2.getText();
	                PublicKeyRing.remove(vrednost, pword);
	                padajuca_lista.removeAll();
	        		for(PublicKey pk2: PublicKeyRing.ring)
	        		{
	        			padajuca_lista.add(pk2.getUserID());
	        		}
	            }  
	        });
		
		glavni.add(pomocni);
		glavni.add(pomocni2);
		
		upk.add(glavni, BorderLayout.CENTER);
		nazad.addActionListener ( new ActionListener()  {  
			 public void actionPerformed( ActionEvent e ) {  
	                upk.setVisible(false);  
	            }  
	        });  

// gui za uvoz izvoz
			Label nista = new Label();
//			Panel glavni_za_uik = new Panel(new BorderLayout());
			Panel grid_za_uik = new Panel(new GridLayout(3,3,5,50));
	//		grid_za_uik.setSize(100,100);
			
			grid_za_uik.add(putanja);
			grid_za_uik.add(polje_za_putanju);
			grid_za_uik.add(uvezi);
			grid_za_uik.add(kljuc);
			grid_za_uik.add(padajuca_lista_za_uik);
			grid_za_uik.add(izvezi);
			grid_za_uik.add(nista);
			grid_za_uik.add(nista);
			grid_za_uik.add(nista);
			izvezi.addActionListener ( new ActionListener()  {  
				 public void actionPerformed( ActionEvent e ) {  
		                String path = polje_za_putanju.getText();
		                String name = padajuca_lista_za_uik.getSelectedItem();
		                for(PublicKey pk: PublicKeyRing.ring)
		                {
		                	if(pk.getUserID().equals(name))
		                	{
		                		pk.writeToFile(path);
		                	}
		                }
	            }  
	         });  
//			glavni_za_uik.add(grid_za_uik, BorderLayout.CENTER);
			
		
			uik = new Dialog(this,"Uvoz/Izvoz kljuceva", true);
			uik.setLayout(new BorderLayout()); 
			uik.setSize(500,300);
			Button nazad2 = new Button("Nazad");
			uik.add(grid_za_uik, BorderLayout.CENTER);
			uik.add(nazad2, BorderLayout.SOUTH);
			
			 nazad2.addActionListener ( new ActionListener()  {  
				 public void actionPerformed( ActionEvent e ) {  
		                uik.setVisible(false);  
	            }  
  	         });  
/////////////////////////// Gui za prsten kljuca
			 
			 Panel glavni_za_pk = new Panel(new BorderLayout());
			 Panel grid_za_pk = new Panel(new GridLayout(2,1));
			 	
	//		     data_za_privatni_kljuc[0][0]= "nesto";      
			 	
	//			pk = new Dialog(this,"Prsten kljuceva", true);
	//			pk.setLayout(new BorderLayout()); 
				f.setSize(900,400);
				

				 nazad3.addActionListener ( new ActionListener()  {  
					 public void actionPerformed( ActionEvent e ) {  
			                f.setVisible(false);
			                f.dispose();
		            }  
			    });  

			
				posalji = new Dialog(this,"Posalji poruku", true);
				posalji.setLayout(new FlowLayout()); 
				posalji.setSize(500,300);
				Button nazad4 = new Button("Nazad");
				posalji.add(nazad4);
					
				 nazad4.addActionListener ( new ActionListener()  {  
					 public void actionPerformed( ActionEvent e ) {  
				               posalji.setVisible(false);  
				           }  
				 });
				 
				 primi = new Dialog(this,"Primi poruku", true);
				 primi.setLayout(new FlowLayout()); 
				 primi.setSize(500,300);
				 Button nazad5 = new Button("Nazad");
				 primi.add(nazad5);
						
					 nazad5.addActionListener ( new ActionListener()  {  
						 public void actionPerformed( ActionEvent e ) {  
					               primi.setVisible(false);  
					           }  
					 });  

	}
	protected void dodajOsluskivace() {
		
		
		upravljanje_postojecim_kljucevima.addActionListener ( new ActionListener()  {  
            public void actionPerformed( ActionEvent e )  {  

				upk.setVisible(true);
		    }  
        });  
		
		uvoz_izvoz_kljuceva.addActionListener ( new ActionListener()  {  
            public void actionPerformed( ActionEvent e )  {  

				padajuca_lista_za_uik.removeAll();
        		for(PublicKey pk2: PublicKeyRing.ring)
        		{
        			padajuca_lista_za_uik.add(pk2.getUserID());
        		}
				uik.setVisible(true);
		    }  
        });  

		
		prstenovi_kljuceva.addActionListener ( new ActionListener()  {  
            public void actionPerformed( ActionEvent e )  {  
            	data_za_javni_kljuc = new String[ PublicKeyRing.ring.size()][8];
            	int j = 0;
            	for(PublicKey pubkey: PublicKeyRing.ring)
            	{
            		String[] pkdata = pubkey.getTableRow();
            		for(int i=0; i<8; i++)
            		{
            			data_za_javni_kljuc[j][i]=pkdata[i];
            		}
            		j++;
            	}
            	jt_privatni=new JTable(data_za_privatni_kljuc,zaglavlje_za_privatni_kljuc);    
//       		 jt_privatni.setBounds(30, 30, 400, 150);          
       		 JScrollPane sp=new JScrollPane(jt_privatni);
       		 Jpanel.removeAll();
       		 Jpanel.add(sp);
       		 jt_javni = new JTable(data_za_javni_kljuc, zaglavlje_za_javni_kljuc);
       		 JScrollPane sp2=new JScrollPane(jt_javni);
       		 Jpanel.add(sp2);
       		 f.add(Jpanel, BorderLayout.CENTER);
       		 f.add(nazad3, BorderLayout.SOUTH);
       		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				f.setVisible(true);
		    }  
        });  

		
		posalji_poruku.addActionListener ( new ActionListener()  {  
            public void actionPerformed( ActionEvent e )  {  

				posalji.setVisible(true);
		    }  
        });  

		
		primi_poruku.addActionListener ( new ActionListener()  {  
            public void actionPerformed( ActionEvent e )  {  

				primi.setVisible(true);
		    }  
        });  
	}
}
