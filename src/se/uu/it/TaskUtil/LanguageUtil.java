package se.uu.it.TaskUtil;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageUtil {

	private static final String baseName = "locale/TaskManager";
	private static Boolean localeSet = false;
	
	public static final Locale English = Locale.ENGLISH;
	public static final Locale Chinese = Locale.CHINESE;
	public static final Locale Swedish = new Locale("sv","SE");
	
	private static ResourceBundle rb;
	
	public LanguageUtil(){
		if (!localeSet) {
			rb = ResourceBundle.getBundle(baseName, Locale.getDefault());
			localeSet = true;
		}
	}

	public static void SetLocale(Locale locale){
		rb = ResourceBundle.getBundle(baseName, locale);
		localeSet = true;
	}
	
	public static String getString(String str){
		if (localeSet)
		{
			return rb.getString(str);
		}else {
				throw (new IllegalStateException(
						"The LanguageUtil Locale has not been set"));
		}
	}
}
