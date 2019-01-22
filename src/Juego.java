/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author patricia
 */
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;


public class Juego implements ActionListener

{	
	Frame ventana;
	Button iniciar, botones[], tesoro, eleccion, otro_juego;
	Label coordenadas1, coordenadas2, respuesta, mensaje, conteo, titulo, x, y, N, S, O, E, NE, NO, SO, SE;
	
	int cont1, cont2, cont3, intentos[], t_x, t_y, b_x, b_y;
	
	Random random;	
	
	public static void main(String args[])
	
	   {
		   new Juego();		 		
	   }
	
	public Juego()
	
	{
		random = new Random();
		
		ventana = new Frame("Busca el tesoro !");
		ventana.setBounds(350, 100, 900, 620);
	        ventana.setBackground(Color.cyan);
		ventana.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		ventana.setLayout(null);
		ventana.setVisible(true);
		
		mensaje = new Label();
		mensaje.setBounds(40, 120, 60, 40);
		mensaje.setBackground(Color.cyan);
		ventana.add(mensaje);
		
		respuesta = new Label();
		respuesta.setBounds(40, 180, 90, 30);
		respuesta.setBackground(Color.white);
	
		iniciar = new Button("Comenzar");
		iniciar.setBounds(40, 65, 70, 40);
		iniciar.setBackground(Color.orange);
		iniciar.addActionListener(this);
		ventana.add(iniciar);
		
		titulo = new Label("Intentos");
		titulo.setBounds(40, 230, 50, 30);
		
		conteo = new Label("0");
		conteo.setBounds(40, 260, 30, 30);
		conteo.setBackground(Color.white);

		otro_juego = new Button("Otra vez?!");
	    otro_juego.setBounds(30, 330, 100, 40);
	    otro_juego.setBackground(Color.orange);
	    otro_juego.addActionListener(this);
	    
	    N = new Label("NORTE");
	    N.setBounds(500, 60, 50, 20);
	    N.setBackground(Color.orange);
	    ventana.add(N);
	    
	    S = new Label("SUR");
	    S.setBounds(520, 560, 30, 20);
	    S.setBackground(Color.orange);
	    ventana.add(S);
		
	    O = new Label("OESTE");
	    O.setBounds(230, 300, 50, 20);
	    O.setBackground(Color.orange);
	    ventana.add(O);
	    
	    E = new Label("ESTE");
	    E.setBounds(780, 300, 40, 20);
	    E.setBackground(Color.orange);
	    ventana.add(E);
	    
	    NO = new Label("Nor-Oeste");
	    NO.setBounds(220, 90, 60, 20);
	    NO.setBackground(Color.orange);
	    ventana.add(NO);
	    
	    SO = new Label("Sur-Oeste");
	    SO.setBounds(220, 540, 60, 20);
	    SO.setBackground(Color.orange);
	    ventana.add(SO);
	    
	    NE = new Label("Nor-Este");
	    NE.setBounds(760, 90, 60, 20);
	    NE.setBackground(Color.orange);
	    ventana.add(NE);
	    
	    SE = new Label("Sur-Este");
	    SE.setBounds(770, 540, 60, 20);
	    SE.setBackground(Color.orange);
	    ventana.add(SE);
	    
	    botones = new Button[100];
		
		for(cont1=0;cont1<botones.length;cont1++)
			
		{	
			botones[cont1] = new Button();
			botones[cont1].setBounds(330+40*(cont1/10), 130+40*(cont1%10), 40, 40);
			botones[cont1].addActionListener(this);
			botones[cont1].setBackground(Color.orange);	
			ventana.add(botones[cont1]);
			botones[cont1].setVisible(false);
		}
		
		
		
		for(cont2=10;cont2>=1;cont2--)
			
	   {		
			coordenadas1 = new Label(String.valueOf(cont2));
			coordenadas1.setBounds(300+(cont2*40), 530, 40, 40);
			coordenadas1.setText(String.valueOf(cont2));
			coordenadas1.setBackground(Color.cyan);
			ventana.add(coordenadas1);
			
			coordenadas2 = new Label(String.valueOf(cont2));
			coordenadas2.setBounds(300, 530-(cont2*40), 40, 40);
			coordenadas2.setText(String.valueOf(cont2));
			coordenadas2.setBackground(Color.cyan);
			ventana.add(coordenadas2);	
		}
					
	}
	

	public void actionPerformed(ActionEvent pati)
	
	{
		
		if(pati.getSource()==iniciar||pati.getSource()==otro_juego)	
		    {
			    tesoro = new Button();
		    	tesoro = botones[random.nextInt(botones.length)];
		    	t_x = tesoro.getLocation().x;
		    	t_y = tesoro.getLocation().y;
		    	mensaje.setBackground(Color.white);
			    mensaje.setText("A buscar !");
			    ventana.add(titulo);
			    ventana.add(conteo);
			    iniciar.setVisible(false);
			  
			    for(int a=0;a<botones.length;a++)
			    {
			    	botones[a].setVisible(true);
			    }   
		    }		    
		if(pati.getSource()!=tesoro)
	    	{
			    conteo.setText(String.valueOf(cont3));
	            
	            
	            Button eleccion;
	            eleccion = (Button) pati.getSource();
	            eleccion.setBackground(Color.lightGray);
	            b_x = eleccion.getLocation().x;
	            b_y = eleccion.getLocation().y;
	            ventana.add(respuesta);
	            
	            cont3++;
	            
	            if(t_x==b_x&&t_y<b_y)
	               {
	            	   respuesta.setText("al Norte!");
	               }
	            if(t_x==b_x&&t_y>b_y)
	               {
	            	   respuesta.setText("al Sur!");
	               }
	            if(t_x>b_x&&t_y>b_y)
	               {
	            	   respuesta.setText("al Sur-Este!");
	               }
	            if(t_x>b_x&&t_y<b_y)
	               {
	            	   respuesta.setText("al Nor-Este!");
	               }
	            if(t_x<b_x&&t_y<b_y)
	               {
	            	   respuesta.setText("al Nor-Oeste!");
	               }
	            if(t_x<b_x&&t_y>b_y)
	               {
	            	   respuesta.setText("al Sur-Oeste!");
	               }
	            if(t_x<b_x&&t_y==b_y)
	               {
	                   respuesta.setText("al Oeste!");
	               }
	            if(t_x>b_x&&t_y==b_y)
	               {
	            	   respuesta.setText("al Este!");
	               }
	    	}
		if(pati.getSource()==tesoro)
		      {
			     respuesta.setText("Bingo!");
			     respuesta.setBackground(Color.green);
			     ventana.add(otro_juego);
			     tesoro.setBackground(Color.green);
			     mensaje.setVisible(false);		   
		      }   
		   if (pati.getSource()==otro_juego)
	          {
		       respuesta.setVisible(false);
		       otro_juego.setVisible(false);
	               for(int a=0;a<botones.length;a++)
	               	     {
			    	 botones[a].setVisible(false);
			     }  
		       new Juego(); 
	          }   		
    }
}