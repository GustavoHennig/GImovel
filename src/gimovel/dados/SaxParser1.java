package gimovel.dados;

import java.io.IOException;

import javax.xml.parsers.*;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser1 extends DefaultHandler {
    public SaxParser1() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public  void sx(String uri) {

        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            parserFactory.setValidating(false);
            parserFactory.setNamespaceAware(false);
            SaxParser1 SaxParser1Instance = new SaxParser1();
            SAXParser parser = parserFactory.newSAXParser();

            parser.parse(uri, SaxParser1Instance);
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (SAXException exception) {
            exception.printStackTrace();
        } catch (ParserConfigurationException exception) {
            exception.printStackTrace();
        } catch (FactoryConfigurationError exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
    }
}
