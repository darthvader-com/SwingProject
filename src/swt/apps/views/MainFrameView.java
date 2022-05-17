package swt.apps.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import swt.apps.common.BaseFrameView;
import swt.apps.controller.MainController;

@SuppressWarnings("all")
public class MainFrameView extends BaseFrameView {
	
	private JFrame frame;
	private JTextField idTextField;
	private JPasswordField pwdPwdField;
	private MainController mc = new MainController();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setUIFont(new FontUIResource("맑은고딕", Font.PLAIN, 12));
					MainFrameView window = new MainFrameView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		});
	}

	public static void setUIFont(FontUIResource f) {
		Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource)
				UIManager.put(key, f);
		}
	}

	public MainFrameView() {
		initialize();
	}

	private void initialize() {
		// JFrame Init
		frame = new JFrame();
		frame.setBounds(100, 100, 320, 231);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("테스트");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		// 아이디 입력
		JLabel idLabel = new JLabel("아이디");
		idLabel.setBounds(31, 38, 57, 15);
		frame.getContentPane().add(idLabel);

		idTextField = new JTextField();
		idTextField.setBounds(91, 37, 174, 21);
		frame.getContentPane().add(idTextField);
		idTextField.setColumns(10);

		// 비밀번호 입력
		JLabel pwdLabel = new JLabel("비밀번호");
		pwdLabel.setBounds(31, 69, 57, 15);
		frame.getContentPane().add(pwdLabel);

		pwdPwdField = new JPasswordField();
		pwdPwdField.setBounds(91, 68, 174, 21);
		frame.getContentPane().add(pwdPwdField);

		// 로그인 버튼
		JButton loginBtn = new JButton("로그인");
		loginBtn.setBounds(23, 107, 122, 23);
		frame.getContentPane().add(loginBtn);
		loginBtn.addActionListener(e -> {
			JLabel idCheckLabel = new JLabel(getMessage("msg.id_input_check"));
			JLabel pwdCheckLabel = new JLabel(getMessage("msg.pwd_input_check"));

			if (idTextField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, idCheckLabel, "알림", JOptionPane.WARNING_MESSAGE);
			} else if (pwdPwdField.getPassword().length == 0) {
				JOptionPane.showMessageDialog(null, pwdCheckLabel, "알림", JOptionPane.WARNING_MESSAGE);
			}
		});

		// 가입버튼
		JButton signInBtn = new JButton("회원가입");
		signInBtn.setBounds(157, 107, 122, 23);
		frame.getContentPane().add(signInBtn);

		signInBtn.addActionListener(e -> {
			mc.popSignIn();
		});

		// 비밀번호찾기 버튼
		JButton findPwdBtn = new JButton("비밀번호 찾기");
		findPwdBtn.setBounds(86, 140, 122, 23);
		frame.getContentPane().add(findPwdBtn);

	}
}
