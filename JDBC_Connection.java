package databaseConnection;

import java.util.Vector;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.awt.EventQueue;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.LayoutStyle;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.GroupLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusAdapter;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JFrame;

public class JDBC_Connection extends JFrame {
	private Statement stmt;
	private String dbName;
	private String userName;
	private String password;
	private String selectCust_args;
	private String selectCust_columns;
	private String selectCust_table;
	private Connection conn;
	private final String databaseLoc = "localhost";
	private final ArrayList<String> columnAList;
	private final ArrayList<String> tableAList;
	private ResultSet rs;
	private String newRecord_Columns;
	private String newRecord_Values;
	private String newTable_Name;
	private String newTable_Columns;
	private JButton button_Disconnect;
	private JButton button_InsertNewRecord;
	private JButton button_Submit;
	private JButton button_insertNewTable;
	private JButton button_newConnection;
	private JButton button_selectRun;
	private JComboBox<String> comboBox_Columns;
	private JComboBox<String> comboBox_Tables;
	private JComboBox<String> comboBox_insertTables;
	private JLabel jLabel1;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JLabel label_DatabaseName;
	private JLabel label_From;
	private JLabel label_I_title;
	private JLabel label_InsertInto;
	private JLabel label_NewRecordTitle;
	private JLabel label_NewtTableTitle;
	private JLabel label_Password;
	private JLabel label_Q_title;
	private JLabel label_Select;
	private JLabel label_U_title;
	private JLabel label_UserName1;
	private JLabel label_Values;
	private JLabel label_Where;
	private JLabel label_columnTitle;
	private JLabel label_customSelect;
	private JLabel label_newColumns;
	private JLabel label_newTable;
	private JLabel label_tableTitle;
	private JLabel lable_safeDisconnect;
	private JPanel panel_Disconnect;
	private JPanel panel_Introduction;
	private JPanel panel_Login;
	private JPanel panel_Query;
	private JPanel panel_Update;
	private JPanel panel_main;
	private JPasswordField password_PW;
	private JTabbedPane tabbedPane_Main;
	private JTable table_Results;
	private JTextArea textArea_Instructions;
	private JTextArea textArea_SafeDisconnect;
	private JTextField textField_DatabaseName;
	private JTextField textField_Username;
	private JTextField textField_insertColumns;
	private JTextField textField_insertValues;
	private JTextField textField_newColumns;
	private JTextField textField_newTableName;
	private JTextField textField_selectColumns;
	private JTextField textField_selectTable;
	private JTextField textField_selectWhere;

	public JDBC_Connection() {
		this.dbName = "";
		this.userName = "";
		this.conn = null;
		this.columnAList = new ArrayList<String>();
		this.tableAList = new ArrayList<String>();
		this.setTitle(" Java Database Application ");
		this.initComponents();
		this.panel_main.remove(this.tabbedPane_Main);
	}

	private void initComponents() {
		this.panel_main = new JPanel();
		this.panel_Login = new JPanel();
		this.label_Password = new JLabel();
		this.textField_Username = new JTextField();
		this.label_UserName1 = new JLabel();
		this.label_DatabaseName = new JLabel();
		this.textField_DatabaseName = new JTextField();
		this.button_Submit = new JButton();
		this.password_PW = new JPasswordField();
		this.jLabel1 = new JLabel();
		this.tabbedPane_Main = new JTabbedPane();
		this.panel_Introduction = new JPanel();
		this.label_I_title = new JLabel();
		this.jScrollPane2 = new JScrollPane();
		this.textArea_Instructions = new JTextArea();
		this.panel_Query = new JPanel();
		this.label_Q_title = new JLabel();
		this.comboBox_Tables = new JComboBox<String>();
		this.label_tableTitle = new JLabel();
		this.jScrollPane1 = new JScrollPane();
		this.table_Results = new JTable();
		this.comboBox_Columns = new JComboBox<String>();
		this.label_columnTitle = new JLabel();
		this.label_customSelect = new JLabel();
		this.label_Select = new JLabel();
		this.textField_selectColumns = new JTextField();
		this.label_From = new JLabel();
		this.textField_selectTable = new JTextField();
		this.label_Where = new JLabel();
		this.textField_selectWhere = new JTextField();
		this.button_selectRun = new JButton();
		this.panel_Update = new JPanel();
		this.label_U_title = new JLabel();
		this.label_newTable = new JLabel();
		this.textField_newTableName = new JTextField();
		this.button_insertNewTable = new JButton();
		this.label_newColumns = new JLabel();
		this.textField_newColumns = new JTextField();
		this.comboBox_insertTables = new JComboBox<String>();
		this.label_InsertInto = new JLabel();
		this.textField_insertColumns = new JTextField();
		this.label_Values = new JLabel();
		this.textField_insertValues = new JTextField();
		this.label_NewtTableTitle = new JLabel();
		this.label_NewRecordTitle = new JLabel();
		this.button_InsertNewRecord = new JButton();
		this.panel_Disconnect = new JPanel();
		this.lable_safeDisconnect = new JLabel();
		this.textArea_SafeDisconnect = new JTextArea();
		this.button_Disconnect = new JButton();
		this.button_newConnection = new JButton();
		this.setDefaultCloseOperation(3);
		this.setAlwaysOnTop(true);
		this.setFocusable(false);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(final WindowEvent evt) {
				JDBC_Connection.this.formWindowClosed(evt);
			}
		});
		this.panel_main.setPreferredSize(new Dimension(800, 600));
		this.label_Password.setFont(new Font("Tahoma", 0, 18));
		this.label_Password.setText("Enter your Password:");
		this.textField_Username.setText("USERNAME");
		this.textField_Username.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(final FocusEvent evt) {
				JDBC_Connection.this.textField_UsernameFocusLost(evt);
			}
		});
		this.label_UserName1.setFont(new Font("Tahoma", 0, 18));
		this.label_UserName1.setText("Enter your username:");
		this.label_DatabaseName.setFont(new Font("Tahoma", 0, 18));
		this.label_DatabaseName.setText("Enter Database Name:");
		this.textField_DatabaseName.setText("DATABASE");
		this.textField_DatabaseName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(final FocusEvent evt) {
				JDBC_Connection.this.textField_DatabaseNameFocusLost(evt);
			}
		});
		this.button_Submit.setFont(new Font("Tahoma", 0, 24));
		this.button_Submit.setText("Submit");
		this.button_Submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent evt) {
				JDBC_Connection.this.button_SubmitActionPerformed(evt);
			}
		});
		this.password_PW.setText("password");
		this.password_PW.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(final FocusEvent evt) {
				JDBC_Connection.this.password_PWFocusLost(evt);
			}
		});
		this.jLabel1.setFont(new Font("Tahoma", 0, 24));
		this.jLabel1.setText("Database Login");
		final GroupLayout panel_LoginLayout = new GroupLayout(this.panel_Login);
		this.panel_Login.setLayout(panel_LoginLayout);
		panel_LoginLayout
				.setHorizontalGroup(panel_LoginLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								panel_LoginLayout
										.createSequentialGroup()
										.addGroup(
												panel_LoginLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																panel_LoginLayout
																		.createSequentialGroup()
																		.addGroup(
																				panel_LoginLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.TRAILING)
																						.addGroup(
																								GroupLayout.Alignment.LEADING,
																								panel_LoginLayout
																										.createSequentialGroup()
																										.addGap(130,
																												130,
																												130)
																										.addGroup(
																												panel_LoginLayout
																														.createParallelGroup(
																																GroupLayout.Alignment.TRAILING)
																														.addComponent(
																																this.label_UserName1)
																														.addComponent(
																																this.label_Password)))
																						.addGroup(
																								panel_LoginLayout
																										.createSequentialGroup()
																										.addContainerGap()
																										.addComponent(
																												this.label_DatabaseName,
																												-2,
																												170,
																												-2)))
																		.addGap(18,
																				18,
																				18)
																		.addGroup(
																				panel_LoginLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addComponent(
																								this.button_Submit)
																						.addGroup(
																								panel_LoginLayout
																										.createParallelGroup(
																												GroupLayout.Alignment.LEADING,
																												false)
																										.addComponent(
																												this.textField_Username)
																										.addComponent(
																												this.textField_DatabaseName)
																										.addComponent(
																												this.password_PW,
																												-1,
																												338,
																												32767))))
														.addGroup(
																panel_LoginLayout
																		.createSequentialGroup()
																		.addGap(293,
																				293,
																				293)
																		.addComponent(
																				this.jLabel1)))
										.addContainerGap(144, 32767)));
		panel_LoginLayout
				.setVerticalGroup(panel_LoginLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								panel_LoginLayout
										.createSequentialGroup()
										.addGap(79, 79, 79)
										.addComponent(this.jLabel1)
										.addGap(101, 101, 101)
										.addGroup(
												panel_LoginLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																this.label_DatabaseName)
														.addComponent(
																this.textField_DatabaseName,
																-2, -1, -2))
										.addGap(18, 18, 18)
										.addGroup(
												panel_LoginLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																this.label_UserName1,
																-2, 42, -2)
														.addComponent(
																this.textField_Username,
																-2, -1, -2))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												panel_LoginLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																this.label_Password,
																-2, 42, -2)
														.addComponent(
																this.password_PW,
																-2, -1, -2))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED,
												164, 32767)
										.addComponent(this.button_Submit)
										.addGap(57, 57, 57)));
		this.tabbedPane_Main.setOpaque(true);
		this.tabbedPane_Main.setPreferredSize(new Dimension(800, 600));
		this.tabbedPane_Main.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(final ChangeEvent evt) {
				JDBC_Connection.this.tabbedPane_MainStateChanged(evt);
			}
		});
		this.panel_Introduction.setName("Intro");
		this.label_I_title.setFont(new Font("Tahoma", 1, 36));
		this.label_I_title.setText("Welcome to the Database");
		this.label_I_title.setName("Database Query Selector");
		this.textArea_Instructions.setEditable(false);
		this.textArea_Instructions.setColumns(20);
		this.textArea_Instructions.setLineWrap(true);
		this.textArea_Instructions.setRows(5);
		this.textArea_Instructions
				.setText("You have successfully logged into your database. \n\nThis is a Java Graphical User Interface that allows users to connect to a database, query for specific information, and update the information in the database. \n\nPlease select a page tab above to move on.\n- If you would like to search for data try the \"Query\" tab. \n- If you would like to create new data select the \"Update\" tab.\n- If you would like to connect to a different database or close the GUI please use the \"Disconnect\" tab.\n\nYou can return here at any time by selecting the \"Intro\" tab.\n\nIf you have any questions please contact the development team over at blankEmail@email.com. They would be happy to assist you.\n\nHave a Nice Day!");
		this.textArea_Instructions.setWrapStyleWord(true);
		this.jScrollPane2.setViewportView(this.textArea_Instructions);
		final GroupLayout panel_IntroductionLayout = new GroupLayout(
				this.panel_Introduction);
		this.panel_Introduction.setLayout(panel_IntroductionLayout);
		panel_IntroductionLayout
				.setHorizontalGroup(panel_IntroductionLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								panel_IntroductionLayout
										.createSequentialGroup()
										.addGroup(
												panel_IntroductionLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																panel_IntroductionLayout
																		.createSequentialGroup()
																		.addGap(161,
																				161,
																				161)
																		.addComponent(
																				this.label_I_title))
														.addGroup(
																panel_IntroductionLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				this.jScrollPane2,
																				-2,
																				757,
																				-2)))
										.addContainerGap(44, 32767)));
		panel_IntroductionLayout
				.setVerticalGroup(panel_IntroductionLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								panel_IntroductionLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(this.label_I_title)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(this.jScrollPane2, -2,
												324, -2)
										.addContainerGap(176, 32767)));
		this.tabbedPane_Main.addTab("Intro", this.panel_Introduction);
		this.panel_Query.setName("Query");
		this.label_Q_title.setFont(new Font("Tahoma", 1, 36));
		this.label_Q_title.setText("Database Query Selector");
		this.label_Q_title.setName("Database Query Selector");
		this.comboBox_Tables.setModel(new DefaultComboBoxModel<String>(
				new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
		this.comboBox_Tables.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent evt) {
				JDBC_Connection.this.comboBox_TablesActionPerformed(evt);
			}
		});
		this.label_tableTitle.setFont(new Font("Tahoma", 0, 18));
		this.label_tableTitle.setText("Select Table:");
		this.table_Results.setAutoCreateRowSorter(true);
		this.table_Results.setModel(new DefaultTableModel(new Object[][]{
				{null, null, null, null}, {null, null, null, null},
				{null, null, null, null}, {null, null, null, null}},
				new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
		this.jScrollPane1.setViewportView(this.table_Results);
		this.comboBox_Columns.setModel(new DefaultComboBoxModel<String>(
				new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
		this.comboBox_Columns.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent evt) {
				JDBC_Connection.this.comboBox_ColumnsActionPerformed(evt);
			}
		});
		this.label_columnTitle.setFont(new Font("Tahoma", 0, 18));
		this.label_columnTitle.setText("Select Column:");
		this.label_customSelect.setFont(new Font("Tahoma", 0, 18));
		this.label_customSelect.setText("Custom Select Statement:");
		this.label_Select.setFont(new Font("Tahoma", 0, 18));
		this.label_Select.setText("SELECT");
		this.label_Select.setBorder(BorderFactory.createBevelBorder(0));
		this.textField_selectColumns.setFont(new Font("Tahoma", 0, 18));
		this.textField_selectColumns.setText("columns");
		this.textField_selectColumns.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(final FocusEvent evt) {
				JDBC_Connection.this.textField_selectColumnsFocusLost(evt);
			}
		});
		this.label_From.setFont(new Font("Tahoma", 0, 18));
		this.label_From.setText("FROM");
		this.label_From.setBorder(BorderFactory.createBevelBorder(0));
		this.textField_selectTable.setFont(new Font("Tahoma", 0, 18));
		this.textField_selectTable.setText("table");
		this.textField_selectTable.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(final FocusEvent evt) {
				JDBC_Connection.this.textField_selectTableFocusLost(evt);
			}
		});
		this.label_Where.setFont(new Font("Tahoma", 0, 18));
		this.label_Where.setText("WHERE");
		this.label_Where.setBorder(BorderFactory.createBevelBorder(0));
		this.textField_selectWhere.setFont(new Font("Tahoma", 0, 18));
		this.textField_selectWhere.setText("arguments");
		this.textField_selectWhere.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(final FocusEvent evt) {
				JDBC_Connection.this.textField_selectWhereFocusLost(evt);
			}
		});
		this.button_selectRun.setFont(new Font("Tahoma", 0, 14));
		this.button_selectRun.setText("RUN");
		this.button_selectRun.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent evt) {
				JDBC_Connection.this.button_selectRunActionPerformed(evt);
			}
		});
		final GroupLayout panel_QueryLayout = new GroupLayout(this.panel_Query);
		this.panel_Query.setLayout(panel_QueryLayout);
		panel_QueryLayout
				.setHorizontalGroup(panel_QueryLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								panel_QueryLayout
										.createSequentialGroup()
										.addGroup(
												panel_QueryLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																panel_QueryLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				this.label_customSelect)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				this.label_Select)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				this.textField_selectColumns,
																				-2,
																				103,
																				-2)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				this.label_From)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				this.textField_selectTable,
																				-2,
																				103,
																				-2)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				this.label_Where)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				this.textField_selectWhere,
																				-2,
																				91,
																				-2)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				this.button_selectRun,
																				-1,
																				-1,
																				32767))
														.addGroup(
																panel_QueryLayout
																		.createSequentialGroup()
																		.addGap(161,
																				161,
																				161)
																		.addComponent(
																				this.label_Q_title))
														.addGroup(
																panel_QueryLayout
																		.createSequentialGroup()
																		.addGap(42,
																				42,
																				42)
																		.addGroup(
																				panel_QueryLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addComponent(
																								this.label_tableTitle)
																						.addComponent(
																								this.comboBox_Tables,
																								-2,
																								133,
																								-2)
																						.addComponent(
																								this.label_columnTitle)
																						.addComponent(
																								this.comboBox_Columns,
																								-2,
																								133,
																								-2))
																		.addGap(128,
																				128,
																				128)
																		.addComponent(
																				this.jScrollPane1,
																				-2,
																				-1,
																				-2)))
										.addGap(23, 23, 23)));
		panel_QueryLayout
				.setVerticalGroup(panel_QueryLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								GroupLayout.Alignment.TRAILING,
								panel_QueryLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(this.label_Q_title)
										.addGap(31, 31, 31)
										.addGroup(
												panel_QueryLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																panel_QueryLayout
																		.createSequentialGroup()
																		.addComponent(
																				this.label_tableTitle)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				this.comboBox_Tables,
																				-2,
																				43,
																				-2)
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				this.label_columnTitle)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				this.comboBox_Columns,
																				-2,
																				43,
																				-2))
														.addComponent(
																this.jScrollPane1,
																-2, 385, -2))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED,
												23, 32767)
										.addGroup(
												panel_QueryLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																this.label_customSelect)
														.addComponent(
																this.label_Select)
														.addComponent(
																this.textField_selectColumns,
																-2, -1, -2)
														.addComponent(
																this.label_From)
														.addComponent(
																this.textField_selectTable,
																-2, -1, -2)
														.addComponent(
																this.label_Where)
														.addComponent(
																this.textField_selectWhere,
																-2, -1, -2)
														.addComponent(
																this.button_selectRun,
																-2, 28, -2))
										.addGap(45, 45, 45)));
		this.tabbedPane_Main.addTab("Query", this.panel_Query);
		this.panel_Update.setName("Update DB");
		this.label_U_title.setFont(new Font("Tahoma", 1, 36));
		this.label_U_title.setText("Database Update Actions");
		this.label_U_title.setName("Database Query Selector");
		this.label_newTable.setText("Create a New Table:");
		this.textField_newTableName.setText("New Table Name");
		this.button_insertNewTable.setText("INSERT");
		this.button_insertNewTable
				.setBorder(BorderFactory.createBevelBorder(0));
		this.button_insertNewTable.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent evt) {
				JDBC_Connection.this.button_insertNewTableActionPerformed(evt);
			}
		});
		this.label_newColumns.setText("With Columns:");
		this.textField_newColumns
				.setText("(column1 datatype, column2 datatype, etc)");
		this.comboBox_insertTables.setModel(new DefaultComboBoxModel<String>(
				new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
		this.label_InsertInto.setText("INSERT into:");
		this.textField_insertColumns.setFont(new Font("Tahoma", 2, 13));
		this.textField_insertColumns
				.setText("(column1,column2,etc.)     NO SPACES       Example: (Name,Date,Email)");
		this.label_Values.setText("VALUES");
		this.textField_insertValues.setFont(new Font("Tahoma", 2, 13));
		this.textField_insertValues
				.setText("(value1,value2, ect.)                  Example: ('Dog', 'Cat', 'String', 25, 54, 'words')");
		this.label_NewtTableTitle.setFont(new Font("Tahoma", 0, 24));
		this.label_NewtTableTitle.setText("Create New Table");
		this.label_NewRecordTitle.setFont(new Font("Tahoma", 0, 24));
		this.label_NewRecordTitle.setText("Insert New Record");
		this.button_InsertNewRecord.setText("INSERT");
		this.button_InsertNewRecord.setToolTipText("");
		this.button_InsertNewRecord.setBorder(BorderFactory
				.createBevelBorder(0));
		this.button_InsertNewRecord.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent evt) {
				JDBC_Connection.this.button_InsertNewRecordActionPerformed(evt);
			}
		});
		final GroupLayout panel_UpdateLayout = new GroupLayout(
				this.panel_Update);
		this.panel_Update.setLayout(panel_UpdateLayout);
		panel_UpdateLayout
				.setHorizontalGroup(panel_UpdateLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								panel_UpdateLayout
										.createSequentialGroup()
										.addGroup(
												panel_UpdateLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																panel_UpdateLayout
																		.createSequentialGroup()
																		.addGap(161,
																				161,
																				161)
																		.addComponent(
																				this.label_U_title))
														.addGroup(
																panel_UpdateLayout
																		.createSequentialGroup()
																		.addGap(28,
																				28,
																				28)
																		.addGroup(
																				panel_UpdateLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING,
																								false)
																						.addGroup(
																								panel_UpdateLayout
																										.createSequentialGroup()
																										.addComponent(
																												this.label_newTable)
																										.addPreferredGap(
																												LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												this.textField_newTableName,
																												-2,
																												-1,
																												-2)
																										.addPreferredGap(
																												LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												this.label_newColumns)
																										.addPreferredGap(
																												LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												this.textField_newColumns,
																												-2,
																												299,
																												-2)
																										.addPreferredGap(
																												LayoutStyle.ComponentPlacement.UNRELATED)
																										.addComponent(
																												this.button_insertNewTable,
																												-1,
																												-1,
																												32767))
																						.addComponent(
																								this.label_NewtTableTitle,
																								-2,
																								200,
																								-2)
																						.addComponent(
																								this.label_NewRecordTitle,
																								-2,
																								200,
																								-2)
																						.addGroup(
																								panel_UpdateLayout
																										.createSequentialGroup()
																										.addGroup(
																												panel_UpdateLayout
																														.createParallelGroup(
																																GroupLayout.Alignment.TRAILING,
																																false)
																														.addGroup(
																																GroupLayout.Alignment.LEADING,
																																panel_UpdateLayout
																																		.createSequentialGroup()
																																		.addComponent(
																																				this.label_Values)
																																		.addGap(18,
																																				18,
																																				18)
																																		.addComponent(
																																				this.textField_insertValues))
																														.addGroup(
																																GroupLayout.Alignment.LEADING,
																																panel_UpdateLayout
																																		.createSequentialGroup()
																																		.addComponent(
																																				this.label_InsertInto)
																																		.addPreferredGap(
																																				LayoutStyle.ComponentPlacement.RELATED)
																																		.addComponent(
																																				this.comboBox_insertTables,
																																				-2,
																																				101,
																																				-2)
																																		.addPreferredGap(
																																				LayoutStyle.ComponentPlacement.RELATED)
																																		.addComponent(
																																				this.textField_insertColumns,
																																				-2,
																																				456,
																																				-2)))
																										.addPreferredGap(
																												LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												this.button_InsertNewRecord,
																												-2,
																												63,
																												-2)))))
										.addContainerGap(73, 32767)));
		panel_UpdateLayout
				.setVerticalGroup(panel_UpdateLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								panel_UpdateLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(this.label_U_title)
										.addGap(55, 55, 55)
										.addComponent(
												this.label_NewtTableTitle, -2,
												34, -2)
										.addGap(18, 18, 18)
										.addGroup(
												panel_UpdateLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																this.label_newTable,
																-2, 35, -2)
														.addComponent(
																this.textField_newTableName,
																-2, 35, -2)
														.addComponent(
																this.button_insertNewTable,
																-2, 35, -2)
														.addComponent(
																this.label_newColumns,
																-2, 35, -2)
														.addComponent(
																this.textField_newColumns,
																-2, 35, -2))
										.addGap(110, 110, 110)
										.addComponent(
												this.label_NewRecordTitle, -2,
												34, -2)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												panel_UpdateLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																panel_UpdateLayout
																		.createSequentialGroup()
																		.addGroup(
																				panel_UpdateLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								this.label_InsertInto,
																								-2,
																								39,
																								-2)
																						.addComponent(
																								this.comboBox_insertTables)
																						.addComponent(
																								this.textField_insertColumns,
																								-2,
																								-1,
																								-2))
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				panel_UpdateLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								this.label_Values)
																						.addComponent(
																								this.textField_insertValues,
																								-2,
																								-1,
																								-2)))
														.addGroup(
																panel_UpdateLayout
																		.createSequentialGroup()
																		.addGap(7,
																				7,
																				7)
																		.addComponent(
																				this.button_InsertNewRecord,
																				-1,
																				-1,
																				32767)))
										.addGap(152, 152, 152)));
		this.tabbedPane_Main.addTab("Update", this.panel_Update);
		this.panel_Disconnect.setName("Update DB");
		this.lable_safeDisconnect.setFont(new Font("Tahoma", 1, 36));
		this.lable_safeDisconnect.setText("Safe Disconnect");
		this.lable_safeDisconnect.setName("Database Query Selector");
		this.textArea_SafeDisconnect.setEditable(false);
		this.textArea_SafeDisconnect.setColumns(20);
		this.textArea_SafeDisconnect.setFont(new Font("Monospaced", 0, 18));
		this.textArea_SafeDisconnect.setLineWrap(true);
		this.textArea_SafeDisconnect.setRows(5);
		this.textArea_SafeDisconnect
				.setText("Please use this tab to safely disconnect from your database before you exit the GUI. If you would like to make a connection to a different database you can also do that here.");
		this.textArea_SafeDisconnect.setWrapStyleWord(true);
		this.textArea_SafeDisconnect.setBorder(new LineBorder(
				new Color(0, 0, 0), 2, true));
		this.button_Disconnect.setFont(new Font("Tahoma", 0, 24));
		this.button_Disconnect.setText("Disconnect Safely");
		this.button_Disconnect.setBorder(BorderFactory.createBevelBorder(0));
		this.button_Disconnect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent evt) {
				JDBC_Connection.this.button_DisconnectActionPerformed(evt);
			}
		});
		this.button_newConnection.setFont(new Font("Tahoma", 0, 18));
		this.button_newConnection.setText("Connect To New Database");
		this.button_newConnection.setBorder(BorderFactory.createBevelBorder(0));
		this.button_newConnection.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent evt) {
				JDBC_Connection.this.button_newConnectionActionPerformed(evt);
			}
		});
		final GroupLayout panel_DisconnectLayout = new GroupLayout(
				this.panel_Disconnect);
		this.panel_Disconnect.setLayout(panel_DisconnectLayout);
		panel_DisconnectLayout
				.setHorizontalGroup(panel_DisconnectLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								panel_DisconnectLayout
										.createSequentialGroup()
										.addGroup(
												panel_DisconnectLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																panel_DisconnectLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				this.button_Disconnect,
																				-2,
																				366,
																				-2)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				this.button_newConnection,
																				-2,
																				366,
																				-2))
														.addGroup(
																panel_DisconnectLayout
																		.createSequentialGroup()
																		.addGap(230,
																				230,
																				230)
																		.addComponent(
																				this.lable_safeDisconnect))
														.addGroup(
																panel_DisconnectLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				this.textArea_SafeDisconnect,
																				-2,
																				744,
																				-2)))
										.addContainerGap(-1, 32767)));
		panel_DisconnectLayout
				.setVerticalGroup(panel_DisconnectLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								panel_DisconnectLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(this.lable_safeDisconnect)
										.addGap(34, 34, 34)
										.addComponent(
												this.textArea_SafeDisconnect,
												-2, 90, -2)
										.addGap(133, 133, 133)
										.addGroup(
												panel_DisconnectLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																this.button_Disconnect,
																-2, 48, -2)
														.addComponent(
																this.button_newConnection,
																-2, 48, -2))
										.addContainerGap(208, 32767)));
		this.tabbedPane_Main.addTab("Disconnect", this.panel_Disconnect);
		final GroupLayout panel_mainLayout = new GroupLayout(this.panel_main);
		this.panel_main.setLayout(panel_mainLayout);
		panel_mainLayout.setHorizontalGroup(panel_mainLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGap(0, 0, 32767)
				.addGroup(
						panel_mainLayout.createParallelGroup(
								GroupLayout.Alignment.LEADING).addComponent(
								this.panel_Login, -1, -1, -2))
				.addGroup(
						panel_mainLayout.createParallelGroup(
								GroupLayout.Alignment.LEADING).addComponent(
								this.tabbedPane_Main,
								GroupLayout.Alignment.TRAILING, -1, -1, -2)));
		panel_mainLayout.setVerticalGroup(panel_mainLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGap(0, 600, 32767)
				.addGroup(
						panel_mainLayout.createParallelGroup(
								GroupLayout.Alignment.LEADING).addComponent(
								this.panel_Login, -1, -1, -2))
				.addGroup(
						panel_mainLayout.createParallelGroup(
								GroupLayout.Alignment.LEADING).addComponent(
								this.tabbedPane_Main, -1, -1, -2)));
		this.tabbedPane_Main.getAccessibleContext().setAccessibleName("Query");
		final GroupLayout layout = new GroupLayout(this.getContentPane());
		this.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGap(0, 824, 32767)
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.LEADING).addGroup(
								layout.createSequentialGroup()
										.addContainerGap()
										.addComponent(this.panel_main, -2, -1,
												-2).addContainerGap(-1, 32767))));
		layout.setVerticalGroup(layout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGap(0, 626, 32767)
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.LEADING).addGroup(
								layout.createSequentialGroup()
										.addContainerGap()
										.addComponent(this.panel_main, -2, -1,
												-2).addContainerGap(-1, 32767))));
		this.pack();
	}

	private void password_PWFocusLost(final FocusEvent evt) {
		this.password = new String(this.password_PW.getPassword());
	}

	private void button_SubmitActionPerformed(final ActionEvent evt) {
		this.dbName = this.textField_DatabaseName.getText();
		this.userName = this.textField_Username.getText();
		this.password = new String(this.password_PW.getPassword());
		if (!this.userName.isEmpty() || !this.userName.contains("")
				|| !this.userName.contentEquals("null")
				|| !this.dbName.isEmpty() || !this.dbName.contains("")
				|| this.dbName.contentEquals("null")) {
			final boolean success = this.makeConnection(this.userName,
					this.dbName, this.password);
			if (success) {
				this.panel_main.removeAll();
				this.panel_main.add(this.tabbedPane_Main);
				this.tabbedPane_Main.setVisible(true);
				this.tabbedPane_Main.setSelectedIndex(0);
				this.panel_main.repaint();
				this.tabbedPane_Main.repaint();
			} else {
				JOptionPane
						.showMessageDialog(this,
								"Your connection attempt failed. Check your password and username.");
			}
		} else {
			System.out.println("IN ERROR ISSUE");
			JOptionPane
					.showMessageDialog(this,
							"You need to enter a user name and database name before logging in.");
		}
	}

	private void textField_DatabaseNameFocusLost(final FocusEvent evt) {
		this.dbName = this.textField_DatabaseName.getText();
	}

	private void textField_UsernameFocusLost(final FocusEvent evt) {
		this.userName = this.textField_Username.getText();
	}

	private void tabbedPane_MainStateChanged(final ChangeEvent evt) {
		final int index = this.tabbedPane_Main.getSelectedIndex();
		switch (index) {
			case 0 : {
				break;
			}
			case 1 : {
				if (this.conn != null) {
					this.populateComboBox(this.comboBox_Tables);
					break;
				}
				break;
			}
			case 2 : {
				if (this.conn != null) {
					this.populateComboBox(this.comboBox_insertTables);
					break;
				}
				break;
			}
			case 3 : {
				break;
			}
			default : {
				System.out.println("WHAT? HOW?");
				break;
			}
		}
	}

	private void comboBox_TablesActionPerformed(final ActionEvent evt) {
		try {
			this.table_Results.removeAll();
			final String item = String.valueOf(this.comboBox_Tables
					.getSelectedItem());
			if (!item.equals("null")) {
				System.out.println(item);
				final String Query = "SELECT * FROM " + item;
				this.rs = this.stmt.executeQuery(Query);
				this.table_Results.setModel(this.buildTableModel(this.rs));
				this.table_Results.repaint();
				if (this.comboBox_Columns.isEnabled()) {
					this.comboBox_Columns.removeAllItems();
					this.comboBox_Columns.addItem(null);
					final ResultSetMetaData meta = this.rs.getMetaData();
					for (int i = 1; i < meta.getColumnCount() + 1; ++i) {
						this.comboBox_Columns.addItem(meta.getColumnLabel(i));
						System.out.println(meta.getColumnLabel(i));
					}
					this.comboBox_Columns.setSelectedItem(null);
					this.comboBox_Columns.repaint();
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(JDBC_Connection.class.getName()).log(
					Level.WARNING, null, ex);
		}
	}

	private void formWindowClosed(final WindowEvent evt) {
		System.out.println("YOUR PANE IS CLOSED");
	}

	private void comboBox_ColumnsActionPerformed(final ActionEvent evt) {
		try {
			final String item = String.valueOf(this.comboBox_Tables
					.getSelectedItem());
			this.table_Results.removeAll();
			final String column = String.valueOf(this.comboBox_Columns
					.getSelectedItem());
			if (column.equals("null")) {
				final String Query = "SELECT * FROM " + item;
				this.rs = this.stmt.executeQuery(Query);
				this.table_Results.setModel(this.buildTableModel(this.rs));
				this.table_Results.repaint();
			} else {
				final String Query = "SELECT "
						+ String.valueOf(this.comboBox_Columns
								.getSelectedItem())
						+ " FROM "
						+ String.valueOf(this.comboBox_Tables.getSelectedItem());
				this.rs = this.stmt.executeQuery(Query);
				this.table_Results.setModel(this.buildTableModel(this.rs));
				this.table_Results.repaint();
			}
		} catch (SQLException ex) {
			Logger.getLogger(JDBC_Connection.class.getName()).log(
					Level.WARNING, null, ex);
		}
	}

	private void button_selectRunActionPerformed(final ActionEvent evt) {
		try {
			if (this.selectCust_columns != null
					&& this.selectCust_table != null
					&& this.selectCust_args != null) {
				this.table_Results.removeAll();
				final String Query = "SELECT " + this.selectCust_columns
						+ " FROM " + this.selectCust_table + " WHERE "
						+ this.selectCust_args;
				final ResultSet rs2 = this.stmt.executeQuery(Query);
				this.table_Results.setModel(this.buildTableModel(rs2));
				this.table_Results.repaint();
				this.comboBox_Columns.setSelectedItem(null);
				this.comboBox_Tables.setSelectedItem(null);
			}
		} catch (SQLException ex) {
			Logger.getLogger(JDBC_Connection.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}

	private void textField_selectColumnsFocusLost(final FocusEvent evt) {
		this.selectCust_columns = this.textField_selectColumns.getText();
	}

	private void textField_selectTableFocusLost(final FocusEvent evt) {
		this.selectCust_table = this.textField_selectTable.getText();
	}

	private void textField_selectWhereFocusLost(final FocusEvent evt) {
		this.selectCust_args = this.textField_selectWhere.getText();
	}

	private void button_DisconnectActionPerformed(final ActionEvent evt) {
		try {
			this.rs.close();
			this.stmt.close();
			this.conn.close();
			System.out.println("Connection Closed safe.");
			System.exit(0);
		} catch (SQLException ex) {
			Logger.getLogger(JDBC_Connection.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}

	private void button_newConnectionActionPerformed(final ActionEvent evt) {
		try {
			if (!this.rs.isClosed() || !this.stmt.isClosed()
					|| !this.conn.isClosed()) {
				this.rs.close();
				this.stmt.close();
				this.conn.close();
				System.out.println("Connection Closed safe.");
			}
		} catch (SQLException ex) {
			Logger.getLogger(JDBC_Connection.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		this.reset();
		this.panel_main.removeAll();
		this.panel_main.repaint();
		this.panel_main.add(this.panel_Login);
		this.panel_main.repaint();
	}

	private void button_InsertNewRecordActionPerformed(final ActionEvent evt) {
		try {
			this.newRecord_Columns = this.textField_insertColumns.getText();
			this.newRecord_Values = this.textField_insertValues.getText();
			final String insertIntoTable = String
					.valueOf(this.comboBox_insertTables.getSelectedItem());
			final int update = this.stmt.executeUpdate("INSERT INTO "
					+ insertIntoTable + " " + this.newRecord_Columns
					+ " VALUES " + this.newRecord_Values + ";");
			this.textField_insertColumns.setText("");
			this.textField_insertValues.setText("");
		} catch (SQLException ex) {
			Logger.getLogger(JDBC_Connection.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}

	private void button_insertNewTableActionPerformed(final ActionEvent evt) {
		try {
			this.newTable_Name = this.textField_newTableName.getText();
			this.newTable_Columns = this.textField_newColumns.getText();
			final int update = this.stmt.executeUpdate("CREATE TABLE "
					+ this.newTable_Name + " " + this.newTable_Columns + ";");
			this.textField_newTableName.setText("");
			this.textField_newColumns.setText("");
		} catch (SQLException ex) {
			Logger.getLogger(JDBC_Connection.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}

	public static void main(final String[] args) {
		try {
			for (final UIManager.LookAndFeelInfo info : UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(JDBC_Connection.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex2) {
			Logger.getLogger(JDBC_Connection.class.getName()).log(Level.SEVERE,
					null, ex2);
		} catch (IllegalAccessException ex3) {
			Logger.getLogger(JDBC_Connection.class.getName()).log(Level.SEVERE,
					null, ex3);
		} catch (UnsupportedLookAndFeelException ex4) {
			Logger.getLogger(JDBC_Connection.class.getName()).log(Level.SEVERE,
					null, ex4);
		}
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new JDBC_Connection().setVisible(true);
			}
		});
	}

	private boolean makeConnection(final String userName,
			final String tableName, final String password) {
		try {
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost/"
					+ tableName, userName, password);
			this.stmt = this.conn.createStatement();
			JOptionPane.showMessageDialog(this,
					"You've successfully connected to the Database!");
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this,
					"There was an error connecting to the Database. " + e);
			System.out.println("Do not connect to DB - Error:" + e);
			return false;
		}
	}

	private void reset() {
		System.out.println("reset!");
		this.conn = null;
		this.rs = null;
		this.dbName = "";
		this.userName = "";
		this.password = "";
		this.comboBox_Tables.removeAll();
		this.comboBox_Columns.removeAll();
		this.tableAList.clear();
		this.columnAList.clear();
	}

	private void populateComboBox(final JComboBox cB) {
		if (this.conn != null) {
			try {
				final DatabaseMetaData md = this.conn.getMetaData();
				final ResultSet rs = md.getTables(this.dbName, null, "%", null);
				while (rs.next()) {
					if (!this.tableAList.contains(rs.getString(3))) {
						this.tableAList.add(rs.getString(3));
					}
				}
				if (cB.isEnabled()) {
					cB.removeAllItems();
					this.tableAList.forEach(tmp -> cB.addItem(tmp));
					cB.repaint();
				}
			} catch (SQLException ex) {
				Logger.getLogger(JDBC_Connection.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
	}

	private DefaultTableModel buildTableModel(final ResultSet rs)
			throws SQLException {
		final ResultSetMetaData meta = rs.getMetaData();
		final Vector<String> columnNames = new Vector<String>();
		final int columnCount = meta.getColumnCount();
		for (int column = 1; column <= columnCount; ++column) {
			columnNames.add(meta.getColumnName(column));
		}
		final Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			final Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; ++columnIndex) {
				vector.add(rs.getObject(columnIndex));
			}
			data.add(vector);
		}
		return new DefaultTableModel(data, columnNames);
	}
}