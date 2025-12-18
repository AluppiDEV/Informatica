package Java.Html_parser;

public class Main {

    public static void main(String[] args) {

        String[] test = {
                "<html><body></body></html>",
                "<html><body>Test</body></html>",
                "<b><i>Grassetto Corsivo</i></b>",
                "<html><body></html></body>",
                "<div><p>Test</div>",
                "<html><body>",
                "</div>"
        };

        for (String s : test) {
            System.out.println(HtmlValidator.isValid(s));
        }

    }
}
