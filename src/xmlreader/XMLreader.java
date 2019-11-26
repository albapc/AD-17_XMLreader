package xmlreader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author Alba
 */
public class XMLreader {

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory xif = XMLInputFactory.newInstance();
        XMLStreamReader xsr = xif.createXMLStreamReader(new FileInputStream("products.xml"));
        
        
        ArrayList<Products> listaPr = new ArrayList<>();
        Products pr = new Products();
        
        while(xsr.hasNext()) {
            
            if(xsr.getEventType() == XMLStreamConstants.START_ELEMENT) {
                    
                switch (xsr.getLocalName()) {
                    case "product":
//                        String nomAv = xsr.getAttributeValue(0); //devuelve el nombre del valor del atributo
                        System.out.println(xsr.getAttributeValue(0));
                        pr.setCodigo(xsr.getAttributeValue(0));
                        xsr.next();
                        break;
                    case "descricion":
                        xsr.next();
                        System.out.println(xsr.getText());
                        pr.setDescricion(xsr.getText());
                        break;
                    case "prezo":
                        xsr.next();
                        System.out.println(xsr.getText());
                        pr.setPrezo(Double.parseDouble(xsr.getText()));
                        break;
                    default:
                        xsr.next();
                        break;
                }
                    
            } else {
                xsr.next();
            }
            
            if (pr.getCodigo() != null && pr.getPrezo() != 0 && pr.getDescricion() != null) {
                    listaPr.add(pr);
                    pr = new Products();
                }
            }

            System.out.println(listaPr.toString());
            xsr.close();
        }
    }
    

