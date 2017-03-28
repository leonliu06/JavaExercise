package mvc;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18n {
	Locale locale = Locale.CHINA;
	Locale locale2 = new Locale("en");
	Locale locale3 = new Locale("zh", "CN", "WIN");
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("xxx");
	
	//MultipartFile
}
