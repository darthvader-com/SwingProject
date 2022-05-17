package swt.apps.views;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import swt.apps.common.BaseFrameView;
import swt.apps.common.JTextFieldMaxLength;
import swt.apps.controller.UserController;

@SuppressWarnings("all")
public class SignInFrameView extends BaseFrameView {

	private static final long serialVersionUID = 1L;
	
	private JPasswordField pwdReField;
	private JPasswordField pwdField;
	private JTextField idField;
	private JTextField birthField;
	private JTextField nameField;
	
	private JTextFieldMaxLength jt;
	
	// 아이디 중복체크 flag
	private Boolean isFlag = false;
	
	// 아이디 중복체크
	String idType = "";

	private UserController uc = new UserController();

	public SignInFrameView(){
		
		/*********************************************************************************
		 *                                                                               *
		 *                                VIEW SOURCE                                    *
		 *                                                                               *
		 *********************************************************************************/
		
		getContentPane().setLayout(null);

		// 아이디
		JLabel idLabel = new JLabel("아이디");
		idLabel.setBounds(54, 59, 72, 15);
		getContentPane().add(idLabel);

		idField = new JTextField(15);
		idField.setDocument(new JTextFieldMaxLength(15));
		idField.setBounds(147, 56, 150, 21);
		getContentPane().add(idField);
		idField.setColumns(10);

		// 아이디중복체크
		JButton idCheckBtn = new JButton("아이디중복체크");
		idCheckBtn.setBounds(309, 55, 120, 23);
		getContentPane().add(idCheckBtn);

		// 비밀번호
		JLabel pwdLabel1 = new JLabel("비밀번호");
		pwdLabel1.setBounds(54, 90, 72, 15);
		getContentPane().add(pwdLabel1);

		pwdField = new JPasswordField();
		pwdField.setDocument(new JTextFieldMaxLength(15));
		pwdField.setBounds(147, 87, 150, 21);
		getContentPane().add(pwdField);

		// 비밀번호 확인
		JLabel pwdLabel2 = new JLabel("비밀번호확인");
		pwdLabel2.setBounds(54, 121, 72, 15);
		getContentPane().add(pwdLabel2);

		pwdReField = new JPasswordField();
		pwdReField.setDocument(new JTextFieldMaxLength(15));
		pwdReField.setBounds(147, 118, 150, 21);
		getContentPane().add(pwdReField);

		// 성별 라디오 버튼
		JLabel genderLabel = new JLabel("성별");
		genderLabel.setBounds(54, 180, 72, 15);
		getContentPane().add(genderLabel);

		ButtonGroup group = new ButtonGroup();

		JRadioButton maleBtn = new JRadioButton("남");
		maleBtn.setBounds(162, 176, 57, 23);
		maleBtn.setActionCommand("M");
		group.add(maleBtn);
		getContentPane().add(maleBtn);

		JRadioButton femaleBtn = new JRadioButton("여");
		femaleBtn.setBounds(223, 176, 91, 23);
		femaleBtn.setActionCommand("F");
		group.add(femaleBtn);
		getContentPane().add(femaleBtn);

		// 이름
		JLabel nameLabel = new JLabel("이름");
		nameLabel.setBounds(54, 152, 57, 15);
		getContentPane().add(nameLabel);

		nameField = new JTextField();
		nameField.setDocument(new JTextFieldMaxLength(10));
		nameField.setBounds(147, 149, 150, 21);
		getContentPane().add(nameField);
		nameField.setColumns(10);

		// 생년월일
		JLabel birthLabel = new JLabel("생년월일");
		birthLabel.setBounds(54, 205, 57, 15);
		getContentPane().add(birthLabel);

		//birthField = new JTextField("YYYYMMDD");
		birthField = new JTextField();
		birthField.setBounds(147, 205, 150, 21);
		getContentPane().add(birthField);
		birthField.setColumns(10);
		//birthField.setForeground(Color.GRAY);
		birthField.setDocument(new JTextFieldMaxLength(6));
		
		JLabel birthDetailLabel = new JLabel("(YYYYMMDD)");
		birthDetailLabel.setBounds(54, 221, 84, 15);
		getContentPane().add(birthDetailLabel);

		// 가입/취소버튼
		JButton signInBtn = new JButton("가입");
		signInBtn.setBounds(123, 256, 97, 23);
		getContentPane().add(signInBtn);
		
		JButton cancelBtn = new JButton("취소");
		cancelBtn.setBounds(230, 256, 97, 23);
		getContentPane().add(cancelBtn);
		
		// 필수입력 값 표시용 라벨
		JLabel requireLabel = new JLabel("*은 필수입력 값입니다");
		requireLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		requireLabel.setBounds(54, 20, 273, 15);
		getContentPane().add(requireLabel);
		
		JLabel requireFieldLabel1 = new JLabel("*");
		requireFieldLabel1.setBounds(40, 59, 17, 15);
		getContentPane().add(requireFieldLabel1);
		
		JLabel requireFieldLabel2 = new JLabel("*");
		requireFieldLabel2.setBounds(40, 90, 17, 15);
		getContentPane().add(requireFieldLabel2);
		
		JLabel requireFieldLabel3 = new JLabel("*");
		requireFieldLabel3.setBounds(40, 121, 17, 15);
		getContentPane().add(requireFieldLabel3);
		
		JLabel requireFieldLabel4 = new JLabel("*");
		requireFieldLabel4.setBounds(40, 152, 17, 15);
		getContentPane().add(requireFieldLabel4);
		
		JLabel requireFieldLabel5 = new JLabel("*");
		requireFieldLabel5.setBounds(40, 180, 17, 15);
		getContentPane().add(requireFieldLabel5);
		
		JLabel requireFieldLabel6 = new JLabel("*");
		requireFieldLabel6.setBounds(40, 205, 17, 15);
		getContentPane().add(requireFieldLabel6);

		// 생년월일 placeholder
		/*
		birthField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (birthField.getText().equals("YYYYMMDD")) {
					birthField.setText("");
					birthField.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (birthField.getText().isEmpty()) {
					birthField.setForeground(Color.GRAY);
					birthField.setText("YYYYMMDD");
				}
			}
		});
		*/
		
		/*********************************************************************************
		 *                                                                               *
		 *                                LABEL SOURCE                                   *
		 *                                                                               *
		 *********************************************************************************/
		
		// 가입라벨
		JLabel inputCheckLabel = new JLabel(getMessage("msg.input_check"));
		JLabel idCheckLabel = new JLabel(getMessage("msg.id_input_check"));
		JLabel successLabel = new JLabel(getMessage("msg.signin_success"));
		JLabel failLabel = new JLabel(getMessage("msg.proccess_fail"));
		
		JLabel tempLabel = new JLabel();
		
		/*********************************************************************************
		 *                                                                               *
		 *                              VARIABLE SOURCE                                  *
		 *                                                                               *
		 *********************************************************************************/
		
		// ex) String str = "";
		
		/*********************************************************************************
		 *                                                                               *
		 *                          ACTION LISTENER SOURCE                               *
		 *                                                                               *
		 *********************************************************************************/

		
		// 가입버튼
		signInBtn.addActionListener(e -> {

			// 입력값 체크
			if (idField.getText().equals("") ||
				pwdField.getPassword().length == 0 ||
				pwdReField.getPassword().length == 0 ||
				nameField.getText().equals("") || 
				group.getSelection() == null ||
				birthField.getText().equals("YYYYMMDD")
			) {
				JOptionPane.showMessageDialog(null, inputCheckLabel, "알림", JOptionPane.WARNING_MESSAGE);
			} else if(isFlag == false){ 
				// 아이디 중복체크 확인
				tempLabel.setText(getMessage("msg.id_duplicate_check_require"));
				JOptionPane.showMessageDialog(null, tempLabel, "알림", JOptionPane.WARNING_MESSAGE);
			} else if(!idType.equals(idField.getText())){ 
				// 아이디 중복체크 확인
				tempLabel.setText(getMessage("msg.id_duplicate_check_require"));
				JOptionPane.showMessageDialog(null, tempLabel, "알림", JOptionPane.WARNING_MESSAGE);
			}  else {
			
				HashMap<String, Object> map = new HashMap<>();
				
				// 비밀번호 toString
				StringBuilder sb = new StringBuilder();
				StringBuilder sbRe = new StringBuilder();
				
				for(char c :  pwdField.getPassword()) {
					sb.append(c);
				}
				
				for(char c :  pwdReField.getPassword()) {
					sbRe.append(c);
				}
				
				// 비밀번호/확인 체크
				if(!sb.toString().equals(sbRe.toString())) {
					tempLabel.setText(getMessage("msg.password_differ"));
					JOptionPane.showMessageDialog(null, tempLabel, "알림", JOptionPane.WARNING_MESSAGE);
				}

				map.put("id", idField.getText());
				map.put("pwd", sb.toString());
				map.put("name", nameField.getText());
				map.put("gender", group.getSelection().getActionCommand());
				map.put("birth", birthField.getText());
				
				String rtn = uc.insertSignIn(map);
				
				if(rtn == "success") {
					JOptionPane.showMessageDialog(null, successLabel, "알림", JOptionPane.WARNING_MESSAGE);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, failLabel, "알림", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		// 취소버튼
		cancelBtn.addActionListener(e -> {
			dispose();
		});
		
		// 아이디 중복체크
		idCheckBtn.addActionListener(e -> {
			// 입력값 체크
			if (idField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, idCheckLabel, "알림", JOptionPane.WARNING_MESSAGE);
			} else {
				HashMap<String, Object> map = new HashMap<>();
				map.put("id", idField.getText());
				try {
					HashMap<String, Object> resultMap = uc.selectIdCheck(map);
					
					if(resultMap.size() > 0) {
						isFlag = false;
						tempLabel.setText(getMessage("msg.id_duplicate"));
						JOptionPane.showMessageDialog(null, tempLabel, "알림", JOptionPane.WARNING_MESSAGE);
					} else {
						isFlag = true;
						tempLabel.setText(getMessage("msg.id_available"));
						JOptionPane.showMessageDialog(null, tempLabel, "알림", JOptionPane.WARNING_MESSAGE);
					}
					
				} catch (Exception ex) {
					System.err.println(ex.getMessage());
				}
			}
		});
		
		// 아이디 중복체크 키다운
		KeyListener keyListener = new KeyListener() {
			@Override
			 public void keyPressed(KeyEvent keyEvent) {}
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {
				idType = idField.getText();
			}
		};

		idField.addKeyListener(keyListener);
		
		
		/*********************************************************************************
		 *                                                                               *
		 *                                 MAIN SOURCE                                   *
		 *                                                                               *
		 *********************************************************************************/

		// Main
		setVisible(true);
		setResizable(false);
		setBounds(100, 100, 470, 340);
		setTitle("회원가입");
	}
}
