package swt.apps.common;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/*
 * 
 *   JTextField의 입력 최대 길이를 설정하기 위해 사용
 * 
 *   ex) 입력최대 길이 10으로 설정
 *       JTextField jf = new JTextField();
 *		 jf.setDocument(new JTextFieldMaxLength(10))
 *
 */
public class JTextFieldMaxLength extends PlainDocument {

	private static final long serialVersionUID = 1L;
	private int limit;

	public JTextFieldMaxLength(int limit) {
		super();
		this.limit = limit;
	}

	public JTextFieldMaxLength(int limit, boolean upper) {
		super();
		this.limit = limit;
	}

	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		if (str == null)
			return;

		if ((getLength() + str.length()) <= limit) {
			super.insertString(offset, str, attr);
		}
	}
}