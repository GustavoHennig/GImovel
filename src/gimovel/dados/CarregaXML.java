package gimovel.dados;

import java.util.*;
import javax.xml.parsers.*;
import java.io.*;
import org.xml.sax.*;
import org.w3c.dom.*;

public class CarregaXML {

    private final String DEFINICAO_TABULEIRO_NOME_ARQUIVO = "DefinicaoTabuleiro.xml";

    public NodeList read() {
//        SAXBuilder builder = new SAXBuilder();
        String err = "";
        Document doc = null;
        try {
            File xmlFile = new File(DEFINICAO_TABULEIRO_NOME_ARQUIVO);
            InputStream in = null;
            if (xmlFile.exists()) {
                in = new FileInputStream(xmlFile);
            } else {
                in = getClass().getResourceAsStream("/" + DEFINICAO_TABULEIRO_NOME_ARQUIVO);
            }

            //
//""
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            dbf.setValidating(false);
            DocumentBuilder db = dbf.newDocumentBuilder();

            doc = db.parse(in);

            //  doc.getdo
        } catch (ParserConfigurationException pce) {
            err = pce.toString();
        } catch (SAXParseException spe) {
            StringBuffer sb = new StringBuffer(spe.toString());

            sb.append("\n  Line number: " + spe.getMessage());
            sb.append("\n  Line number: " + spe.getLineNumber());
            sb.append("\nColumn number: " + spe.getColumnNumber());
            sb.append("\n Public ID: " + spe.getPublicId());
            sb.append("\n System ID: " + spe.getSystemId() + "\n");
            err = sb.toString();
        } catch (SAXException se) {
            err = se.toString();
            if (se.getException() != null) {
                err += " caused by: " + se.getException().toString();
            }
        } catch (IOException ie) {
            err = ie.toString();
        }

        System.out.println(err);

        Iterator i = null;
        NodeList casas = null;

        if (doc != null) {

            //Document doc = builder.build(filename);
            Element tabuleiro = doc.getDocumentElement();
            casas = tabuleiro.getElementsByTagName("Casa");
            // Iterator i = casas.iterator();
        }
        return casas;
    }

    public void GravaJogadores(Jogadores jog) {

        Jogador j;

        for (int i = 0; i < jog.Count(); i++) {
            j = jog.Jogador(i);
            j.getNome();

        }

        File xmlFile = new File("e:\\teste.xml");

        String err = "";
        Document doc = null;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            dbf.setValidating(false);
            DocumentBuilder db = dbf.newDocumentBuilder();

            doc = db.newDocument();

            //  doc.getdo
        } catch (ParserConfigurationException pce) {
            err = pce.toString();
        }

        doc.createElement("OLAH");

    }


    /*
        public NodeList read(String filename) {
//        SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File(filename);
            String err = "";
      try {

          //  SAXParserFactory fac = SAXParserFactory.newInstance();
            DefaultHandler dh = DefaultHandler();
            fac.setValidating( true );

            SAXParser parser = fac.newSAXParser();
             parser.parse( filename, dh );

            }
            catch(ParserConfigurationException e){
                err = e.toString();
            }

            catch(Exception ee){
                        err = ee.toString();
                    }


            Document doc = null;



            System.out.println(err);

            Iterator i = null;
            NodeList casas = null;

            if (doc != null) {

                //Document doc = builder.build(filename);
                Element tabuleiro = doc.getDocumentElement();
                casas = tabuleiro.getElementsByTagName("Casa");
                // Iterator i = casas.iterator();
            }
            return casas;
        }

     */
}
