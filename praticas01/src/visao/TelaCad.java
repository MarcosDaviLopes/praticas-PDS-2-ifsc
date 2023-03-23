package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Pessoa;

import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCad extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCad frame = new TelaCad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(
				new MigLayout("", "[grow][304.00][grow]", "[153.00,grow][78.00,grow][78.00,grow,center][66.00,grow]"));

		JLabel lblNewLabel = new JLabel("Cadastro de pessoa");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNewLabel, "cell 1 0,alignx center");

		JLabel lblCPF = new JLabel("CPF:");
		contentPane.add(lblCPF, "cell 0 1,alignx right");

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "cell 1 1,grow");

		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(40, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1
						.createSequentialGroup().addGap(38).addComponent(txtCPF, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(41, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		JLabel lblNome = new JLabel("Nome:");
		contentPane.add(lblNome, "cell 0 2,alignx right");

		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 1 2,alignx center,aligny center");

		txtNome = new JTextField();
		txtNome.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(36, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel
						.createSequentialGroup().addGap(43).addComponent(txtNome, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(44, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JButton btnCad = new JButton("Cadastrar");
		btnCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String cpftxt = txtCPF.getText();

				Pessoa p = new Pessoa();

				boolean Val = true;

				if (nome != null && !nome.isEmpty()) {
					p.setNome(nome);
				} else {
					Val = false;
					JOptionPane.showMessageDialog(null, "Pessoa não foi Cadastrada");
				}
				if (cpftxt != null && !cpftxt.isEmpty()) {
					Integer cpf = Integer.valueOf(cpftxt);
					p.setCpf(cpf);
				} else {
					Val = false;
					JOptionPane.showMessageDialog(null, "Pessoa não foi Cadastrada");
				}
			}
		});
		contentPane.add(btnCad, "cell 1 3,alignx center");
	}
}
