package gimovel.dados;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;
//import java.io.


//import org.jdom.Element;
//import org.jdom.JDOMException;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.io.xml.DomReader.*;
import java.io.*;
import org.w3c.dom.*;
import java.util.*;

public class Tabuleiro {

    private Casa[] _casas;

    public Tabuleiro() {
        _casas = new Casa[44];
    }

    public void CarregaTabuleiro() {

        int i, pos;
        final int comprimento = 80;
        final int largura = 50;
        final int maxX = 650;
        final int maxY = 460;
        final int pX = 685;
        final int pY = 485;

        _casas[0] = new Casa(pX, pY, comprimento, comprimento,
                             Color.LIGHT_GRAY, 0);
        _casas[13] = new Casa(5, pY, comprimento, comprimento, Color.ORANGE, 13);
        _casas[22] = new Casa(5, 5, comprimento, comprimento, Color.BLUE, 22);
        _casas[35] = new Casa(pX, 5, comprimento, comprimento, Color.yellow, 35);

        pos = 12;

        //Casas de baixo
        for (i = 85; i < maxX; i += 50) {
            _casas[pos] = new Casa(i, pY, largura, comprimento, pos);
            pos--;
        }

        pos = 21;
        //Casas da esquerda
        for (i = 85; i < maxY; i += 50) {
            _casas[pos] = new Casa(5, i, comprimento, largura, pos);
            pos--;
        }

        pos = 23;
        //Casas de cima
        for (i = 85; i < maxX; i += 50) {
            _casas[pos] = new Casa(i, 5, largura, comprimento, pos);
            pos++;
        }

        pos = 36;
        //Casas da direita
        for (i = 85; i < maxY; i += 50) {
            _casas[pos] = new Casa(pX, i, comprimento, largura, pos);
            pos++;
        }

        CarregaInfoCasas(_casas);

    }

    private int getColorRandom() {
        int ret = 0;
        while (ret < 1 | ret > 255) {
            ret = (int) (Math.random() * 150);
        }
        return ret;
    }

    private void CarregaInfoCasas(Casa[] casas) {

        CarregaXML cx = new CarregaXML();
        //  Color cor = null;
        try {


            NodeList nl = cx.read();

            /*
                        XStream xstream = new XStream();
//            DomReader dr = new dom


                        GFile file = new GFile();
             String xml = file.openFileAsText("DefinicaoTabuleiro.xml");

                        System.out.println(xml);

                        CasaXml casa = new CasaXml();
                        casa.setCor('s');
                        casa.setDescricao("Nome");

                        System.out.println( xstream.toXML(casa));

                        List lst = (List) xstream.fromXML(xml);
             */
            /*
                        String casaNome = new String();
                        String casaDescricao = new String();
                        String casaRamo = new String();
                        String casaPreco = new String();
                        String casaRendimento = new String();
                        String casaCorR = new String();
                        String casaCorG = new String();
                        String casaCorB = new String();
             */
            for (int i = 0; i < nl.getLength(); i++) {

                Element casass = (Element) nl.item(i);

                NodeList nlcasa = casass.getChildNodes();

                System.out.println();

                Dictionary dic = new Hashtable();

                for (int ii = 0; ii < nlcasa.getLength(); ii++) {

                    if (nlcasa.item(ii).getNodeType() ==
                        nlcasa.item(ii).ELEMENT_NODE) {

                        Element casaV = (Element) nlcasa.item(ii);
                        System.out.println(casaV.getNodeName());

                        if (casaV.getNodeName() == "Cor") {
                            dic.put(casaV.getNodeName() + "R",
                                    casaV.getAttribute("R"));
                            dic.put(casaV.getNodeName() + "G",
                                    casaV.getAttribute("G"));
                            dic.put(casaV.getNodeName() + "B",
                                    casaV.getAttribute("B"));

                        } else {

                            dic.put(casaV.getNodeName(),
                                    casaV.getFirstChild().getNodeValue());
                        }
                    }

                }

                this.setDadosCasas(casas,
                                   Integer.parseInt(casass.getAttribute("id")),
                                   dic.get("Nome").toString(),
                                   dic.get("Descricao").toString(),
                                   dic.get("Ramo").toString(),
                                   new Color(Integer.parseInt(dic.get("CorR").
                        toString()),
                                             Integer.parseInt(dic.get("CorG").
                        toString()),
                                             Integer.parseInt(dic.get("CorB").
                        toString())),
                                   Integer.parseInt(dic.get("Preco").toString()),
                                   Integer.parseInt(dic.get("Rendimento").
                        toString()));

                //  System.out.println(listcor.getNodeValue());


                /*
                 cor = new Color(Integer.parseInt(ecor.getChildTextTrim("R")),
                 Integer.parseInt(ecor.getChildTextTrim("G")),
                 Integer.parseInt(ecor.getChildTextTrim("B")));


                                setDadosCasas(casas,
                 Integer.parseInt(casa.getAttribute("id").getValue()),
                 casa.getChildTextTrim("Nome"),
                 casa.getChildTextTrim("Descricao"),
                 casa.getChildTextTrim("Ramo"),
                                              cor,
                 Integer.parseInt(casa.getChildTextTrim("Preco")),
                 Integer.parseInt(casa.getChildTextTrim(
                                                      "Rendimento"))
                                        );
                 */

            }

        } catch (Exception err) {
            System.out.println(err.getMessage());
        }

        /**
         * Copia dados das primeiras casas para a segunda
         */
        CopiaCasas();
    }

    private String getValueElement(Element e, String TagName) {

        NodeList nl = e.getElementsByTagName(TagName);
        String ret = "";
        if (nl.getLength() == 1) {

            Element casaV = (Element) nl.item(0);
            ret = casaV.getFirstChild().getNodeValue();

        } else {
            System.out.println("Retorno diferente de 1");
        }

        return ret;
    }

    private void setDadosCasas(Casa[] casa,
                               int id,
                               String NM_Casa,
                               String Descricao,
                               String Ramo,
                               Color cor,
                               int preco,
                               int Rendimento) {
        casa[id].setNm_Casa(NM_Casa);
        casa[id].setDescricao(Descricao);
        casa[id].setRamo(Ramo);
        casa[id].setCor(cor);
        casa[id].setPreco(preco);
        casa[id].setRendimentoAtual(Rendimento);
        casa[id].setRendimentoInicial(Rendimento);
    }

    public Casa[] getCasas() {
        return _casas;
    }

    public Casa getCasa(int ID_Casa) {
        return _casas[ID_Casa];
    }

    public void setCasas(Casa[] casas) {
        _casas = casas;
    }

    public Casa getCasaClicada(int x, int y) {
        Casa ret = null;

        for (int i = 0; i < 44; i++) {
            if (_casas[i].getX() <= x && _casas[i].getY() <= y &&
                (_casas[i].getW() + _casas[i].getX()) >= x &&
                (_casas[i].getH() + _casas[i].getY()) >= y) {
                ret = _casas[i];
            }
        }

        return ret;

    }

    private void CopiaCasas() {
        int i;
        for (i = 1; i < 22; i++) {
            if (i != 13) {
                _casas[i + 22].setCor(_casas[i].getCor());
                _casas[i + 22].setDescricao(_casas[i].getDescricao());
                _casas[i + 22].setNm_Casa(_casas[i].getNm_Casa());
                _casas[i + 22].setPreco(_casas[i].getPreco());
                _casas[i + 22].setRendimentoAtual(_casas[i].getRendimentoAtual());
                _casas[i +
                        22].setRendimentoInicial(_casas[i].getRendimentoInicial());
            }
        }

    }


}
