package pkg002javaoffstream;

public class HtmlGenerator {
    private static FileManager fm;
    private static String nomeFile = "Rubrica.html";
    private static Rubrica rubrica;

    public HtmlGenerator(Rubrica r){
        fm = new FileManager(nomeFile);
        rubrica = r;
    }

    private static void iniziaHTML(){
        fm.scriviSuFile(nomeFile, rubrica,
                "<!DOCTYPE html>\n" +
                        "<html lang=\"it\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>Rubrica</title>\n" +
                        "    <style>\n" +
                        "        /* RESET E BODY */\n" +
                        "        * {\n" +
                        "            margin: 0;\n" +
                        "            padding: 0;\n" +
                        "            box-sizing: border-box;\n" +
                        "        }\n" +
                        "        \n" +
                        "        body {\n" +
                        "            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\n" +
                        "            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);\n" +
                        "            min-height: 100vh;\n" +
                        "            padding: 40px 20px;\n" +
                        "            display: flex;\n" +
                        "            flex-direction: column;\n" +
                        "            align-items: center;\n" +
                        "        }\n" +
                        "\n" +
                        "        /* CONTAINER PRINCIPALE */\n" +
                        "        .rubrica-container {\n" +
                        "            max-width: 500px;\n" +
                        "            width: 100%;\n" +
                        "        }\n" +
                        "\n" +
                        "        /* TITOLO */\n" +
                        "        h1 {\n" +
                        "            text-align: center;\n" +
                        "            color: white;\n" +
                        "            font-size: 2.5em;\n" +
                        "            margin-bottom: 30px;\n" +
                        "            text-shadow: 2px 2px 4px rgba(0,0,0,0.3);\n" +
                        "        }\n" +
                        "\n" +
                        "        /* CARDS CONTATTI */\n" +
                        "        .contatto-card {\n" +
                        "            background: rgba(255, 255, 255, 0.95);\n" +
                        "            backdrop-filter: blur(10px);\n" +
                        "            border-radius: 20px;\n" +
                        "            padding: 25px;\n" +
                        "            margin-bottom: 20px;\n" +
                        "            box-shadow: 0 20px 40px rgba(0,0,0,0.1);\n" +
                        "            transition: all 0.3s ease;\n" +
                        "            border: 1px solid rgba(255,255,255,0.2);\n" +
                        "        }\n" +
                        "\n" +
                        "        .contatto-card:hover {\n" +
                        "            transform: translateY(-5px);\n" +
                        "            box-shadow: 0 30px 60px rgba(0,0,0,0.15);\n" +
                        "        }\n" +
                        "\n" +
                        "        /* STILI PER I PARAGRAFI */\n" +
                        "        p {\n" +
                        "            font-size: 1.2em;\n" +
                        "            color: #333;\n" +
                        "            line-height: 1.6;\n" +
                        "        }\n" +
                        "\n" +
                        "        /* ICONA TELEFONO (opzionale) */\n" +
                        "        .contatto-card::before {\n" +
                        "            content: \"\uD83D\uDCF1\";\n" +
                        "            font-size: 2em;\n" +
                        "            display: block;\n" +
                        "            text-align: center;\n" +
                        "            margin-bottom: 15px;\n" +
                        "            opacity: 0.7;\n" +
                        "        }\n" +
                        "    </style>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <div class=\"rubrica-container\">\n" +
                        "        <h1>Rubrica</h1>");
    }

    private static void chiudiHTML(){
        fm.scriviSuFile(nomeFile, rubrica, "</div>\n" + "</body>\n" + "</html>");
    }

    public static void generaHTMLcontatti(){
        if(rubrica.getRubrica().isEmpty()) return;

        iniziaHTML();
        for(Contatto c : rubrica.getRubrica()){
            fm.scriviSuFile(nomeFile, rubrica, "<div class=\"contatto-card\">"+ "<p>" + c.toString() + "</p>" + "</div>");
        }
        chiudiHTML();
    }
}
