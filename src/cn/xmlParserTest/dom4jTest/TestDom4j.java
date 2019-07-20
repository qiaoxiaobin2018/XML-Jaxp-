package cn.xmlParserTest.dom4jTest;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.util.List;

public class TestDom4j {
    public static void main(String[] args) throws Exception {
        modifyAge();

    }
    //修改第一个p1下面元素age的值为30
    public static void modifyAge() throws Exception {
        /*
        * 1.得到document
        * 2.得到第一个p1元素
        * 3.得到第一个p1下面的age
        * 4.修改值为30
        *
        * 5.回写xml
        *
        * */
        //得到document
        Document document = dom4jMethod.getDocument();
        //得到第一个p1元素
        Element root = document.getRootElement();
        Element p1 = root.element("p1");
        //得到第一个p1下面的age
        Element age = p1.element("age");
        //修改值为300
        age.setText("300");
        //回写xml
        dom4jMethod.writeBack(document);

    }

    //在age之前添加school元素
    public static void addBeforeAge() throws Exception {
        /*
         * 1.创建解析器
         * 2.得到document
         * 3.得到根节点
         * 4.得到第一个p1元素
         * 5.获取p1下面的所有元素
         * 6.创建school元素
         * 7.在school下面创建文本
         * 8.在list的特定位置添加
         *
         * 9.回写xml
        *
        * */
        //得到document
        Document document = dom4jMethod.getDocument();
        //得到根节点
        Element root = document.getRootElement();
        //得到第一个P1元素
        Element p1 = root.element("p1");
        //获取p1下面的所有元素
        List<Element> list = p1.elements();

        //创建school元素
        Element school = DocumentHelper.createElement("school");
        //在school下面创建文本
        school.setText("SXU");
        //在特定位置添加
        list.add(1,school);

        //回写xml
        dom4jMethod.writeBack(document);

    }

    //在p1下添加sex元素，并赋值
    public static void addSex() throws Exception {
        /*
        * 1.创建解析器
        * 2.得到document
        * 3.得到根节点
        *
        * 4.得到第一个p1元素
        * 5.在p1下面直接添加元素
        * 6.在sex下面创建文本
        *
        * 7.回写xml
        *
        * */
        //创建解析器
        SAXReader saxReader = new SAXReader();
        //得到document
        Document document = saxReader.read("src/test.xml");
        //获取根节点
        Element root = document.getRootElement();
        //得到第一个p1元素
        Element p1 = root.element("p1");
        //在p1下面直接添加元素
        Element sex = p1.addElement("sex");
        //在sex下面创建文本
        sex.setText("nan");

        //回写
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();//输出格式有缩进
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/test.xml"),outputFormat);
        xmlWriter.write(document);
        xmlWriter.close();
        System.out.println("Done!");


    }
    //查询第二个name元素的值
    public static void selectNameSecond() throws Exception {
        /*
         * 1.创建解析器
         * 2.得到document
         * 3.得到根节点
         *
         * 4.得到第二个P1
         * 5.得到P1下面的第一个name
         * 5.得到name中的值
         *
         * */
        //创建解析器
        SAXReader saxReader = new SAXReader();
        //得到document
        Document document = saxReader.read("src/test.xml");
        //获取根节点
        Element root = document.getRootElement();
        //得到第二个P1
        List<Element> list = root.elements("p1");
        //选择第二个,下标从0开始
        Element p2 = list.get(1);
        //得到p1下面的name元素
        Element name = p2.element("name");
        //获取name的值
        String s = name.getText();
        //输出
        System.out.println(s);



    }
    //查询第一个name元素的值
    public static void selectNameSingle() throws Exception {
        /*
         * 1.创建解析器
         * 2.得到document
         * 3.得到根节点
         *
         * 4.得到P1
         * 5.得到P1下面的第一个name
         * 5.得到name中的值
         *
         * */
        //创建解析器
        SAXReader saxReader = new SAXReader();
        //得到document
        Document document = saxReader.read("src/test.xml");
        //获取根节点
        Element root = document.getRootElement();

        //获取第一个p1
        Element p1 = root.element("p1");
        //获取name元素
        Element name = p1.element("name");
        //得到name中的值
        String s = name.getText();
        //输出
        System.out.println(s);


    }
    //查询xml中所有name元素的值
    public static void selectName() throws Exception {
        /*
        * 1.创建解析器
        * 2.得到document
        * 3.得到根节点
        *
        * 4.得到P1
        * 5.得到P1下面的name
        * 5.得到name中的值
        *
        * */
        //创建解析器
        SAXReader saxReader = new SAXReader();
        //得到document
        Document document = saxReader.read("src/test.xml");
        //得到根节点
        Element root = document.getRootElement();

        //得到P1
        List<Element> list = root.elements("p1");
        //遍历list
        for(Element element:list){
            //element是每一个p1元素
            //得到p1下面的name元素
            Element name = element.element("name");
            //得到name元素中的值
            String s = name.getText();
            System.out.println(s);
        }

    }

}
