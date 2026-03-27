package CKeditor;


import org.dom4j.Document;

public class HtmlUtils {
    public static String removeHtmlTags(String input) {
        if (input == null) {
            return  null;
        }
        return input.replaceAll("\\<.*?\\>", "");
    }
}
