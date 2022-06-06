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
		
		glavni.add(pomocni);
		glavni.add(pomocni2);
		
		upk.add(glavni, BorderLayout.CENTER);
		nazad.addActionListener ( new ActionListener()  {  
			 public void actionPerformed( ActionEvent e ) {  
	                upk.setVisible(false);  
	            }  
	        });  
		 
			uik = new Dialog(this,"Uvoz/Izvoz kljuceva", true);
			uik.setLayout(new FlowLayout()); 
			uik.setSize(500,300);
			Button nazad2 = new Button("Nazad");
			uik.add(nazad2);
			
			 nazad2.addActionListener ( new ActionListener()  {  
				 public void actionPerformed( ActionEvent e ) {  
		                uik.setVisible(false);  
	            }  
  	         });  
			 
			 
				pk = new Dialog(this,"Prsten kljuceva", true);
				pk.setLayout(new FlowLayout()); 
				pk.setSize(500,300);
				Button nazad3 = new Button("Nazad");
				pk.add(nazad3);
				
				 nazad3.addActionListener ( new ActionListener()  {  
					 public void actionPerformed( ActionEvent e ) {  
			                pk.setVisible(false);  
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

				uik.setVisible(true);
		    }  
        });  

		
		prstenovi_kljuceva.addActionListener ( new ActionListener()  {  
            public void actionPerformed( ActionEvent e )  {  

				pk.setVisible(true);
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
