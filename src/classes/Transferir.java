/**
 * TSI - POO - Allan Amâncio, Márcio José, Yuri Sousa
 * Swing class - Transferir
*/
package classes;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Transferir {

	private JFrame frame;
	private Estacionamento estacionamento;
	private JTextField vagaOrigemField;
	private JTextField vagaDestinoField;

	public Transferir(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Valetinho - Sistema de Estacionamento");
		frame.setBounds(100, 100, 530, 346);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Transferir Vaga");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(149, 25, 224, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel vagaOrigemLabel = new JLabel("Vaga Origem");
		vagaOrigemLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		vagaOrigemLabel.setBounds(103, 88, 104, 19);
		frame.getContentPane().add(vagaOrigemLabel);
		
		vagaOrigemField = new JTextField();
		vagaOrigemField.setBounds(203, 89, 86, 20);
		frame.getContentPane().add(vagaOrigemField);
		vagaOrigemField.setColumns(10);
		
		JLabel vagaDestinoLabel = new JLabel("Vaga Destino");
		vagaDestinoLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		vagaDestinoLabel.setBounds(103, 142, 104, 19);
		frame.getContentPane().add(vagaDestinoLabel);
		
		vagaDestinoField = new JTextField();
		vagaDestinoField.setColumns(10);
		vagaDestinoField.setBounds(203, 143, 86, 20);
		frame.getContentPane().add(vagaDestinoField);
		JButton btnNewButton = new JButton("Transferir");
		JLabel errorLabel = new JLabel("");
		errorLabel.setForeground(new Color(0, 0, 0));
		errorLabel.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				errorLabel.setText("");
				int vagaDestino=0;
				int vagaOrigem=0;
				try {
					vagaOrigem = Integer.parseInt(vagaOrigemField.getText());
					vagaOrigemField.setText("");
					vagaDestino = Integer.parseInt(vagaDestinoField.getText());
					vagaDestinoField.setText("");
				}
				catch (NumberFormatException ex) { 
					errorLabel.setText("Error: digite números válidos para as vagas!"); 
					return;
				}
				try {
					estacionamento.transferir(vagaOrigem, vagaDestino);
					JOptionPane.showMessageDialog(null, "Placa transferida da vaga " + vagaOrigem + " para a vaga " + vagaDestino);
					frame.dispose();
				}catch (Exception e1) {
					errorLabel.setText("Error: "+e1.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(181, 204, 137, 38);
		frame.getContentPane().add(btnNewButton);
		JButton voltarButton = new JButton("Voltar");
		voltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		voltarButton.setBounds(0, 0, 72, 23);
		errorLabel.setBounds(10, 274, 496, 25);
		frame.getContentPane().add(voltarButton);
		frame.getContentPane().add(errorLabel);
	}
}