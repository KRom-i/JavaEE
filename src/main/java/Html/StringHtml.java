package Html;

public class StringHtml {

    public static String get(String head, Object... content){

        StringBuilder sb = new StringBuilder();

        for (Object o: content
             ) {
            sb.append(o.toString());
            sb.append("<br>");
        }

        return String.format("<html><body>" +
                                     "<h1>%s<h1>" +
                                     "<h2>%s<h2>" +
                                     "</body><html/>", head, sb.toString());
    };

    public static String get(String head){
        return String.format("<html><body>" +
                                     "<h1>%s<h1>" +
                                     "</body><html/>", head);
    };
}
