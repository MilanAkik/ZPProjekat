package etf.openpgp.am180688ddm180630d.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
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
	Dialog upk;
	Dialog uik;
	Dialog pk;
	Dialog posalji;
	Dialog primi;
	
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
		upk.setLayout(new FlowLayout()); 
		upk.setSize(500,300);
		Button nazad = new Button("Nazad");
		upk.add(nazad);
		
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
