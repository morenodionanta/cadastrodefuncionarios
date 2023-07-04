/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.cadastrodefuncionarios.view;

import com.mycompany.cadastrodefuncionarios.Departamento;
import com.mycompany.cadastrodefuncionarios.Funcionario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aluno
 */
public class principal extends javax.swing.JFrame {

	ArrayList<Departamento> ListaDep;
	ArrayList<Funcionario> ListaFunc;  // Adicionada a lista de funcionários
	String modoDep;
	String modoFunc;                   // Adicionada a variável de modo que muda a configuração

	public void LoadTableDep() {
		DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Código", "Nome"}, 0);

		for (int i = 0; i < ListaDep.size(); i++) {
			Object linha[] = new Object[]{ListaDep.get(i).getCodigo(),
				ListaDep.get(i).getNome()};
			modelo.addRow(linha);
		}

		tbl_dep_dpts.setModel(modelo);
		tbl_dep_dpts.getColumnModel().getColumn(0).setPreferredWidth(50);
		tbl_dep_dpts.getColumnModel().getColumn(1).setPreferredWidth(200);

		//Preenche a lista do combo box
		LoadCBDep();
	}

	public void LoadTablefunc() {
		DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Matricula", "Nome", "Matricula"}, 0);

		for (int i = 0; i < ListaDep.size(); i++) {
			Object linha[] = new Object[]{ListaFunc.get(i).getMatricula(),
				ListaFunc.get(i).getNome()};
			modelo.addRow(linha);
		}

		tbl_Func_Funcs.setModel(modelo);
		tbl_Func_Funcs.getColumnModel().getColumn(0).setPreferredWidth(50);
		tbl_Func_Funcs.getColumnModel().getColumn(1).setPreferredWidth(200);

		//Preenche a lista do combo box
		LoadCBDep();
	}

	public void LoadCBDep() {
		cb_func_deps.removeAllItems();
		cb_func_deps.addItem("Selecione");
		for (int i = 0; i < ListaDep.size(); i++) {
			cb_func_deps.addItem(ListaDep.get(i).getNome());
		}
	}

	public void ManipulaInterfaceFunc() {
		switch (modoFunc) {
			case "Navegar":
				btn_func_salvar.setEnabled(false);
				btn_func_cancelar.setEnabled(false);
				c_func_mat.setEnabled(false);
				c_func_nome.setEnabled(false);
				btn_func_novo.setEnabled(true);
				btn_func_editar.setEnabled(false);
				btn_func_excluir.setEnabled(false);
				cb_func_deps.setEnabled(false);
				break;

			case "Novo":
				btn_func_salvar.setEnabled(true);
				btn_func_cancelar.setEnabled(true);
				c_func_mat.setEnabled(true);
				c_func_nome.setEnabled(true);
				cb_func_deps.setEnabled(true);
				btn_func_novo.setEnabled(false);
				btn_func_editar.setEnabled(false);
				btn_func_excluir.setEnabled(false);
				break;

			case "Editar":
				btn_func_salvar.setEnabled(true);
				btn_func_cancelar.setEnabled(true);
				c_func_mat.setEnabled(true);
				c_func_nome.setEnabled(true);
				cb_func_deps.setEnabled(true);
				btn_func_novo.setEnabled(true);
				btn_func_editar.setEnabled(false);
				btn_func_excluir.setEnabled(false);
				break;

			case "Excluir":
				btn_func_salvar.setEnabled(false);
				btn_func_cancelar.setEnabled(false);
				c_func_mat.setEnabled(false);
				c_func_nome.setEnabled(false);
				cb_func_deps.setEnabled(false);
				btn_func_novo.setEnabled(true);
				btn_func_editar.setEnabled(false);
				btn_func_excluir.setEnabled(false);
				break;

			case "Selecao":
				btn_func_salvar.setEnabled(false);
				btn_func_cancelar.setEnabled(false);
				c_func_mat.setEnabled(false);
				c_func_nome.setEnabled(false);
				cb_func_deps.setEnabled(false);
				btn_func_novo.setEnabled(true);
				btn_func_editar.setEnabled(true);
				btn_func_excluir.setEnabled(true);
				break;
			default:
				System.out.println("Modo inválido");
		}
	}

	public void ManipulaInterfaceDep() {
		switch (modoDep) {
			case "Navegar":
				btn_dep_salvar.setEnabled(false);
				btn_dep_cancelar.setEnabled(false);
				c_dep_codigo.setEnabled(false);
				c_dep_nome.setEnabled(false);
				btn_dep_novo.setEnabled(true);
				btn_dep_editar.setEnabled(false);
				btn_dep_excluir.setEnabled(false);
				break;

			case "Novo":
				btn_dep_salvar.setEnabled(true);
				btn_dep_cancelar.setEnabled(true);
				c_dep_codigo.setEnabled(true);
				c_dep_nome.setEnabled(true);
				btn_dep_novo.setEnabled(false);
				btn_dep_editar.setEnabled(false);
				btn_dep_excluir.setEnabled(false);
				break;

			case "Editar":
				btn_dep_salvar.setEnabled(true);
				btn_dep_cancelar.setEnabled(true);
				c_dep_codigo.setEnabled(true);
				c_dep_nome.setEnabled(true);
				btn_dep_novo.setEnabled(true);
				btn_dep_editar.setEnabled(false);
				btn_dep_excluir.setEnabled(false);
				break;

			case "Excluir":
				btn_dep_salvar.setEnabled(false);
				btn_dep_cancelar.setEnabled(false);
				c_dep_codigo.setEnabled(false);
				c_dep_nome.setEnabled(false);
				btn_dep_novo.setEnabled(true);
				btn_dep_editar.setEnabled(false);
				btn_dep_excluir.setEnabled(false);
				break;

			case "Selecao":
				btn_dep_salvar.setEnabled(false);
				btn_dep_cancelar.setEnabled(false);
				c_dep_codigo.setEnabled(false);
				c_dep_nome.setEnabled(false);
				btn_dep_novo.setEnabled(true);
				btn_dep_editar.setEnabled(true);
				btn_dep_excluir.setEnabled(true);
				break;
			default:
				System.out.println("Modo inválido");
		}
	}

	/**
	 * Creates new form Principal
	 */
	public principal() {
		initComponents();
		setLocationRelativeTo(null);
		ListaDep = new ArrayList();
		ListaFunc = new ArrayList(); //Adicionada a inicialização da nova lista
		modoDep = "Navegar";
		modoFunc = "Navegar";       // Adicionada a configuração inicial
		ManipulaInterfaceDep();
		ManipulaInterfaceFunc();    // Adicionada a chamada da função que manipula a tela
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                btn_dep_NOVO = new javax.swing.JButton();
                btn_dep_EDITAR = new javax.swing.JButton();
                btn_dep_EXCLUIR = new javax.swing.JButton();
                jPanel4 = new javax.swing.JPanel();
                LBLMATRICULA = new javax.swing.JLabel();
                LBLNOME = new javax.swing.JLabel();
                c_dep_MATRICULA = new javax.swing.JTextField();
                c_dep_NOME = new javax.swing.JTextField();
                btn_dep_SALVAR = new javax.swing.JButton();
                btn_dep_CANCELAR = new javax.swing.JButton();
                jComboBox1 = new javax.swing.JComboBox<>();
                LBLDEP = new javax.swing.JLabel();
                jTabbedPane1 = new javax.swing.JTabbedPane();
                jPanel1 = new javax.swing.JPanel();
                jScrollPane2 = new javax.swing.JScrollPane();
                tbl_dep_dpts = new javax.swing.JTable();
                jPanel3 = new javax.swing.JPanel();
                lblCodigo = new javax.swing.JLabel();
                lblNome = new javax.swing.JLabel();
                btn_dep_salvar = new javax.swing.JButton();
                btn_dep_cancelar = new javax.swing.JButton();
                c_dep_codigo = new javax.swing.JTextField();
                c_dep_nome = new javax.swing.JTextField();
                btn_dep_novo = new javax.swing.JButton();
                btn_dep_editar = new javax.swing.JButton();
                btn_dep_excluir = new javax.swing.JButton();
                jPanel2 = new javax.swing.JPanel();
                btn_func_novo = new javax.swing.JButton();
                btn_func_editar = new javax.swing.JButton();
                jScrollPane3 = new javax.swing.JScrollPane();
                tbl_Func_Funcs = new javax.swing.JTable();
                btn_func_excluir = new javax.swing.JButton();
                jPanel5 = new javax.swing.JPanel();
                lblmatricula = new javax.swing.JLabel();
                lblNome1 = new javax.swing.JLabel();
                btn_func_salvar = new javax.swing.JButton();
                btn_func_cancelar = new javax.swing.JButton();
                c_func_mat = new javax.swing.JTextField();
                c_func_nome = new javax.swing.JTextField();
                cb_func_deps = new javax.swing.JComboBox<>();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                ValidadorCPF = new javax.swing.JFormattedTextField();
                jLabel3 = new javax.swing.JLabel();
                jFormattedTextField2 = new javax.swing.JFormattedTextField();

                btn_dep_NOVO.setText("Novo");
                btn_dep_NOVO.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn_dep_NOVOActionPerformed(evt);
                        }
                });

                btn_dep_EDITAR.setText("Editar");
                btn_dep_EDITAR.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn_dep_EDITARActionPerformed(evt);
                        }
                });

                btn_dep_EXCLUIR.setText("Excluir");

                jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Funcionario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 3, 12))); // NOI18N

                LBLMATRICULA.setText("Matricula:");

                LBLNOME.setText("Nome:");

                c_dep_NOME.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                c_dep_NOMEActionPerformed(evt);
                        }
                });

                btn_dep_SALVAR.setText("Salvar");
                btn_dep_SALVAR.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn_dep_SALVARActionPerformed(evt);
                        }
                });

                btn_dep_CANCELAR.setText("Cancelar");
                btn_dep_CANCELAR.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn_dep_CANCELARActionPerformed(evt);
                        }
                });

                jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

                LBLDEP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                LBLDEP.setText("Dep:");

                javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
                jPanel4.setLayout(jPanel4Layout);
                jPanel4Layout.setHorizontalGroup(
                        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(126, 126, 126)
                                                .addComponent(btn_dep_SALVAR)
                                                .addGap(170, 170, 170)
                                                .addComponent(btn_dep_CANCELAR))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addComponent(LBLDEP)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(LBLMATRICULA)
                                                                        .addComponent(LBLNOME))
                                                                .addGap(28, 28, 28)
                                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(c_dep_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(c_dep_MATRICULA, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jPanel4Layout.setVerticalGroup(
                        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(LBLMATRICULA)
                                        .addComponent(c_dep_MATRICULA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(LBLNOME)
                                        .addComponent(c_dep_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(LBLDEP))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn_dep_SALVAR)
                                        .addComponent(btn_dep_CANCELAR))
                                .addGap(17, 17, 17))
                );

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jTabbedPane1.setBackground(new java.awt.Color(204, 0, 51));
                jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(204, 0, 51), new java.awt.Color(255, 0, 0), new java.awt.Color(255, 0, 0), new java.awt.Color(255, 0, 51)));
                jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
                jTabbedPane1.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N

                jPanel1.setBackground(new java.awt.Color(204, 204, 204));

                jScrollPane2.setForeground(new java.awt.Color(255, 204, 0));

                tbl_dep_dpts.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
                tbl_dep_dpts.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null, null},
                                {null, null},
                                {null, null},
                                {null, null}
                        },
                        new String [] {
                                "Codigo", "Nome"
                        }
                ) {
                        Class[] types = new Class [] {
                                java.lang.Integer.class, java.lang.String.class
                        };
                        boolean[] canEdit = new boolean [] {
                                false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types [columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                tbl_dep_dpts.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                tbl_dep_dptsMouseClicked(evt);
                        }
                });
                jScrollPane2.setViewportView(tbl_dep_dpts);

                jPanel3.setBackground(new java.awt.Color(204, 204, 204));
                jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Departamento\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 3, 12))); // NOI18N
                jPanel3.setForeground(new java.awt.Color(255, 51, 51));

                lblCodigo.setBackground(new java.awt.Color(0, 255, 255));
                lblCodigo.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
                lblCodigo.setText("Codigo:");

                lblNome.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
                lblNome.setText("Nome");

                btn_dep_salvar.setText("Salvar");
                btn_dep_salvar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn_dep_salvarActionPerformed(evt);
                        }
                });

                btn_dep_cancelar.setText("Cancelar");
                btn_dep_cancelar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn_dep_cancelarActionPerformed(evt);
                        }
                });

                c_dep_codigo.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                c_dep_codigoActionPerformed(evt);
                        }
                });

                c_dep_nome.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                c_dep_nomeActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNome)
                                        .addComponent(lblCodigo))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(c_dep_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(c_dep_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(btn_dep_salvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_dep_cancelar)
                                .addGap(212, 212, 212))
                );
                jPanel3Layout.setVerticalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCodigo)
                                        .addComponent(c_dep_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNome)
                                        .addComponent(c_dep_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn_dep_salvar)
                                        .addComponent(btn_dep_cancelar))
                                .addGap(24, 24, 24))
                );

                btn_dep_novo.setForeground(new java.awt.Color(0, 51, 255));
                btn_dep_novo.setText("Novo");
                btn_dep_novo.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn_dep_novoActionPerformed(evt);
                        }
                });

                btn_dep_editar.setForeground(new java.awt.Color(255, 204, 0));
                btn_dep_editar.setText("Editar");
                btn_dep_editar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn_dep_editarActionPerformed(evt);
                        }
                });

                btn_dep_excluir.setForeground(new java.awt.Color(255, 0, 51));
                btn_dep_excluir.setText("Excluir");
                btn_dep_excluir.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn_dep_excluirActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(btn_dep_novo)
                                .addGap(118, 118, 118)
                                .addComponent(btn_dep_editar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                                .addComponent(btn_dep_excluir)
                                .addGap(142, 142, 142))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(btn_dep_editar)
                                                .addComponent(btn_dep_novo))
                                        .addComponent(btn_dep_excluir))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jTabbedPane1.addTab("Departamento", jPanel1);

                btn_func_novo.setForeground(new java.awt.Color(0, 51, 255));
                btn_func_novo.setText("Novo");
                btn_func_novo.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn_func_novoActionPerformed(evt);
                        }
                });

                btn_func_editar.setForeground(new java.awt.Color(255, 204, 0));
                btn_func_editar.setText("Editar");
                btn_func_editar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn_func_editarActionPerformed(evt);
                        }
                });

                jScrollPane3.setForeground(new java.awt.Color(255, 204, 0));

                tbl_Func_Funcs.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
                tbl_Func_Funcs.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null, null, null},
                                {null, null, null},
                                {null, null, null},
                                {null, null, null}
                        },
                        new String [] {
                                "matricula", "Nome", "Departamento"
                        }
                ) {
                        Class[] types = new Class [] {
                                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
                        };
                        boolean[] canEdit = new boolean [] {
                                false, false, false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types [columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                tbl_Func_Funcs.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                tbl_Func_FuncsMouseClicked(evt);
                        }
                });
                jScrollPane3.setViewportView(tbl_Func_Funcs);

                btn_func_excluir.setForeground(new java.awt.Color(255, 0, 51));
                btn_func_excluir.setText("Excluir");
                btn_func_excluir.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn_func_excluirActionPerformed(evt);
                        }
                });

                jPanel5.setBackground(new java.awt.Color(204, 204, 204));
                jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Departamento\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 3, 12))); // NOI18N
                jPanel5.setForeground(new java.awt.Color(255, 51, 51));

                lblmatricula.setBackground(new java.awt.Color(0, 255, 255));
                lblmatricula.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
                lblmatricula.setText("matricula:");

                lblNome1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
                lblNome1.setText("Nome");

                btn_func_salvar.setText("Salvar");
                btn_func_salvar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn_func_salvarActionPerformed(evt);
                        }
                });

                btn_func_cancelar.setText("Cancelar");
                btn_func_cancelar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btn_func_cancelarActionPerformed(evt);
                        }
                });

                c_func_mat.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                c_func_matActionPerformed(evt);
                        }
                });

                c_func_nome.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                c_func_nomeActionPerformed(evt);
                        }
                });

                cb_func_deps.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                cb_func_depsActionPerformed(evt);
                        }
                });

                jLabel1.setText("Dep:");

                jLabel2.setText("CPF");

                try {
                        ValidadorCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
                } catch (java.text.ParseException ex) {
                        ex.printStackTrace();
                }
                ValidadorCPF.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                ValidadorCPFActionPerformed(evt);
                        }
                });

                jLabel3.setText("TELEFONE");

                try {
                        jFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) 9####-####")));
                } catch (java.text.ParseException ex) {
                        ex.printStackTrace();
                }

                javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
                jPanel5.setLayout(jPanel5Layout);
                jPanel5Layout.setHorizontalGroup(
                        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(btn_func_salvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                                .addComponent(btn_func_cancelar)
                                .addGap(212, 212, 212))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblNome1)
                                                        .addComponent(lblmatricula)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3))
                                                .addGap(27, 27, 27))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(c_func_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(c_func_mat, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cb_func_deps, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(ValidadorCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jPanel5Layout.setVerticalGroup(
                        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblmatricula)
                                        .addComponent(c_func_mat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNome1)
                                        .addComponent(c_func_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(ValidadorCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cb_func_deps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn_func_salvar)
                                        .addComponent(btn_func_cancelar))
                                .addGap(24, 24, 24))
                );

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(btn_func_novo)
                                .addGap(118, 118, 118)
                                .addComponent(btn_func_editar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                                .addComponent(btn_func_excluir)
                                .addGap(142, 142, 142))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                );
                jPanel2Layout.setVerticalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(btn_func_editar)
                                                .addComponent(btn_func_novo))
                                        .addComponent(btn_func_excluir))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jTabbedPane1.addTab("funcionario", jPanel2);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void c_dep_NOMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_dep_NOMEActionPerformed
		// TODO add your handling code here:
        }//GEN-LAST:event_c_dep_NOMEActionPerformed

        private void btn_dep_SALVARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_SALVARActionPerformed
		int cod = Integer.parseInt(c_dep_codigo.getText());
		Departamento D = new Departamento(cod, c_dep_nome.getText());
		ListaDep.add(D);

		LoadTableDep();
        }//GEN-LAST:event_btn_dep_SALVARActionPerformed

        private void c_dep_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_dep_nomeActionPerformed
		// TODO add your handling code here:
        }//GEN-LAST:event_c_dep_nomeActionPerformed

        private void btn_dep_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_novoActionPerformed
		c_dep_codigo.setText("");
		c_dep_nome.setText("");

		modoDep = "Novo";
		ManipulaInterfaceDep();
        }//GEN-LAST:event_btn_dep_novoActionPerformed

        private void btn_dep_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_cancelarActionPerformed
		c_dep_codigo.setText("");
		c_dep_nome.setText("");
		modoDep = "Navegar";
		ManipulaInterfaceDep();
        }//GEN-LAST:event_btn_dep_cancelarActionPerformed

        private void btn_dep_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_salvarActionPerformed
		int cod = Integer.parseInt(c_dep_codigo.getText());
		//Testa se foi clicado o botão novo ou editar
		if (modoDep.equals("Novo")) {
			Departamento D = new Departamento(cod, c_dep_nome.getText());
			ListaDep.add(D);
		} else if (modoDep.equals("Editar")) {
			int index = tbl_dep_dpts.getSelectedRow();
			ListaDep.get(index).setCodigo(cod);
			ListaDep.get(index).setNome(c_dep_nome.getText());
		}

		LoadTableDep();
		modoDep = "Navegar";
		ManipulaInterfaceDep();
		c_dep_codigo.setText("");
		c_dep_nome.setText("");
        }//GEN-LAST:event_btn_dep_salvarActionPerformed

        private void tbl_dep_dptsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dep_dptsMouseClicked
		//Pega a linha selecionada
		int index = tbl_dep_dpts.getSelectedRow();

		//Testa a validade da linha selecionada
		if (index >= 0 && index < ListaDep.size()) {
			//Seleciona a linha e preenche os campos para edição
			Departamento D = ListaDep.get(index);
			c_dep_codigo.setText(String.valueOf(D.getCodigo()));
			c_dep_nome.setText(D.getNome());
			//Manipula a interface para o modo seleção
			modoDep = "Selecao";
			ManipulaInterfaceDep();
		}
        }//GEN-LAST:event_tbl_dep_dptsMouseClicked

        private void btn_dep_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_editarActionPerformed
		modoDep = "Editar";
		ManipulaInterfaceDep();
        }//GEN-LAST:event_btn_dep_editarActionPerformed

        private void btn_dep_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_excluirActionPerformed
		int index = tbl_dep_dpts.getSelectedRow();
		if (index >= 0 && index < ListaDep.size()) {
			ListaDep.remove(index);
		}
		LoadTableDep();
		modoDep = "Navegar";
		ManipulaInterfaceDep();
        }//GEN-LAST:event_btn_dep_excluirActionPerformed

        private void btn_dep_NOVOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_NOVOActionPerformed
		c_dep_MATRICULA.setText("");
		c_dep_NOME.setText("");

		modoDep = "Novo";
		ManipulaInterfaceDep();
        }//GEN-LAST:event_btn_dep_NOVOActionPerformed

        private void btn_dep_CANCELARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_CANCELARActionPerformed
		c_dep_codigo.setText("");
		c_dep_nome.setText("");
		modoDep = "Navegar";
		ManipulaInterfaceDep();
        }//GEN-LAST:event_btn_dep_CANCELARActionPerformed

        private void btn_dep_EDITARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dep_EDITARActionPerformed
		// TODO add your handling code here:
        }//GEN-LAST:event_btn_dep_EDITARActionPerformed

        private void c_dep_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_dep_codigoActionPerformed
		// TODO add your handling code here:
        }//GEN-LAST:event_c_dep_codigoActionPerformed

        private void btn_func_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_novoActionPerformed
		c_func_mat.setText("");
		c_func_nome.setText("");

		modoFunc = "Novo";
		ManipulaInterfaceFunc();
        }//GEN-LAST:event_btn_func_novoActionPerformed

        private void btn_func_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_editarActionPerformed
		modoFunc = "Editar";
		ManipulaInterfaceDep();
        }//GEN-LAST:event_btn_func_editarActionPerformed

        private void tbl_Func_FuncsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_Func_FuncsMouseClicked
		//Pega a linha selecionada
		int index = tbl_Func_Funcs.getSelectedRow();

		//Testa a validade da linha selecionada
		if (index >= 0 && index < ListaFunc.size()) {
			//Seleciona a linha e preenche os campos para edição
			Funcionario F = ListaFunc.get(index);
			c_func_mat.setText(String.valueOf(F.getMatricula()));
			c_func_nome.setText(F.getNome());
			//Manipula a interface para o modo seleção
			modoFunc = "Selecao";
			ManipulaInterfaceDep();
		}
        }//GEN-LAST:event_tbl_Func_FuncsMouseClicked

        private void btn_func_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_excluirActionPerformed
		int index = tbl_Func_Funcs.getSelectedRow();
		if (index >= 0 && index < ListaFunc.size()) {
			ListaFunc.remove(index);
		}
		LoadTableDep();
		modoFunc = "Navegar";
		ManipulaInterfaceDep();
        }//GEN-LAST:event_btn_func_excluirActionPerformed

        private void btn_func_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_salvarActionPerformed
		int index = cb_func_deps.getSelectedIndex();
		if (index == 0) {
			JOptionPane.showMessageDialog(this, "Você deve selecionar um departamento");
		} else {
			Funcionario F = new Funcionario();
			F.setMatricula(Integer.parseInt(c_func_mat.getText()));
			F.setNome(c_func_nome.getText());
			F.setDep(ListaDep.get(index - 1));

			ListaFunc.add(F);
			ListaDep.get(index - 1).addFunc(F);
		}
		LoadTableFunc();
		modoFunc = "Navegar";
		ManipulaInterfaceFunc();

        }//GEN-LAST:event_btn_func_salvarActionPerformed

        private void btn_func_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_func_cancelarActionPerformed
		c_func_mat.setText("");
		c_func_nome.setText("");
		modoFunc = "Navegar";
		ManipulaInterfaceFunc();
        }//GEN-LAST:event_btn_func_cancelarActionPerformed

        private void c_func_matActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_func_matActionPerformed
		// TODO add your handling code here:
        }//GEN-LAST:event_c_func_matActionPerformed

        private void c_func_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_func_nomeActionPerformed
		// TODO add your handling code here:
        }//GEN-LAST:event_c_func_nomeActionPerformed

        private void cb_func_depsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_func_depsActionPerformed
		// TODO add your handling code here:
        }//GEN-LAST:event_cb_func_depsActionPerformed

        private void ValidadorCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValidadorCPFActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_ValidadorCPFActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;

				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(principal.class
				.getName()).log(java.util.logging.Level.SEVERE, null, ex);

		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(principal.class
				.getName()).log(java.util.logging.Level.SEVERE, null, ex);

		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(principal.class
				.getName()).log(java.util.logging.Level.SEVERE, null, ex);

		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(principal.class
				.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new principal().setVisible(true);
			}
		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel LBLDEP;
        private javax.swing.JLabel LBLMATRICULA;
        private javax.swing.JLabel LBLNOME;
        private javax.swing.JFormattedTextField ValidadorCPF;
        private javax.swing.JButton btn_dep_CANCELAR;
        private javax.swing.JButton btn_dep_EDITAR;
        private javax.swing.JButton btn_dep_EXCLUIR;
        private javax.swing.JButton btn_dep_NOVO;
        private javax.swing.JButton btn_dep_SALVAR;
        private javax.swing.JButton btn_dep_cancelar;
        private javax.swing.JButton btn_dep_editar;
        private javax.swing.JButton btn_dep_excluir;
        private javax.swing.JButton btn_dep_novo;
        private javax.swing.JButton btn_dep_salvar;
        private javax.swing.JButton btn_func_cancelar;
        private javax.swing.JButton btn_func_editar;
        private javax.swing.JButton btn_func_excluir;
        private javax.swing.JButton btn_func_novo;
        private javax.swing.JButton btn_func_salvar;
        private javax.swing.JTextField c_dep_MATRICULA;
        private javax.swing.JTextField c_dep_NOME;
        private javax.swing.JTextField c_dep_codigo;
        private javax.swing.JTextField c_dep_nome;
        private javax.swing.JTextField c_func_mat;
        private javax.swing.JTextField c_func_nome;
        private javax.swing.JComboBox<String> cb_func_deps;
        private javax.swing.JComboBox<String> jComboBox1;
        private javax.swing.JFormattedTextField jFormattedTextField2;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JPanel jPanel4;
        private javax.swing.JPanel jPanel5;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JScrollPane jScrollPane3;
        private javax.swing.JTabbedPane jTabbedPane1;
        private javax.swing.JLabel lblCodigo;
        private javax.swing.JLabel lblNome;
        private javax.swing.JLabel lblNome1;
        private javax.swing.JLabel lblmatricula;
        private javax.swing.JTable tbl_Func_Funcs;
        private javax.swing.JTable tbl_dep_dpts;
        // End of variables declaration//GEN-END:variables

	private void LoadTableFunc() {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}
}
