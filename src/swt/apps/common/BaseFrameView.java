package swt.apps.common;

import java.io.FileReader;
import java.util.Properties;

import javax.swing.JFrame;

public abstract class BaseFrameView extends JFrame {

	private static final long serialVersionUID = 1L;

	protected Properties commonProperties = new Properties();
	private String path = BaseFrameView.class.getResource("../properties/").getPath();

	public String getMessage(String msg) {
		String returnMsg = null;
		try {
			commonProperties.load(new FileReader(path + "message.properties"));
			returnMsg = commonProperties.getProperty(msg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return returnMsg == null ? "일시적인 장애입니다" : returnMsg;
	}
	
	

}
