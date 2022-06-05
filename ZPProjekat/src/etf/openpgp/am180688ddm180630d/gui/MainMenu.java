package etf.openpgp.am180688ddm180630d.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainMenu extends Frame {
	
	Panel glavni = new Panel(new BorderLayout());
	Panel za_dugmice = new Panel(new GridLayout(5,1,3,7));
	Button upravljanje_postojecim_kljucevima = new Button("Upravljanje postojecim kljucevima");
	Button uvoz_izvoz_kljuceva = new Button("Uvoz/izvoz kljuceva");
	Button prstenovi_kljuceva = new Button("Prstenovi kljuceva");
	Button posalji_poruku = new Button("Posalji poruku");
	Button primi_poruku = new Button("Primi poruku");
	
	
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
		
		dodajOsluskivace();

	}
	
	private void dodajOsluskivace() {
		
		upravljanje_postojecim_kljucevima.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ovde metoda koju poziva
			}
		});
		
		uvoz_izvoz_kljuceva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ovde metoda koju poziva
			}
		});
		
		prstenovi_kljuceva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ovde metoda koju poziva
			}
		});
		
		posalji_poruku.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ovde metoda koju poziva
			}
		});
		
		primi_poruku.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ovde metoda koju poziva
			}
		});
	}
}
