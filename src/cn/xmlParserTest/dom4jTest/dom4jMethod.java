package cn.xmlParserTest.dom4jTest;

import cn.xmlParserTest.jaxpTest.TestSax;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.omg.CORBA.portable.ValueOutputStream;
import sun.security.pkcs11.wrapper.CK_ATTRIBUTE;

import java.io.FileOutputStream;

public class dom4jMethod {

    public static final String PATH = "src/test.xml";

    //获取document
    public static Document getDocument() {
        try{
            //创建解析器
            SAXReader saxReader = new SAXReader();
            //得到document
            Document document = saxReader.read(PATH);
            //返回
            return document;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //写回xml
    public static void writeBack(Document document){
        try{
            OutputFormat outputFormat = OutputFormat.createPrettyPrint();
            XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(PATH),outputFormat);
            xmlWriter.write(document);
            xmlWriter.close();
            System.out.println("Done!");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
