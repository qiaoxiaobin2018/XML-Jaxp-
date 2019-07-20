package cn.xmlParserTest.jaxpTest;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

public class TestDom {
    /*
    * 1.创建解析器工厂
    * 2.根据解析器工厂创建解析器
    * 3.解析xml放回document
    * 4.得到所有的name元素
    * */
    public static void main(String[] args) throws Exception {
        //selectSingle();
        //createEle();
        //modifySex();
        //delSex();
        listElement();

    }

    //获取元素所有值
    public static void selectAll() throws ParserConfigurationException, SAXException, IOException {
        //创建解析器工厂
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //创建解析器
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        //解析xml返回document
        Document document = builder.parse("src/test.xml");
        //得到所有的name元素
        NodeList nodeList = document.getElementsByTagName("age");
        //遍历
        for(int i = 0;i<nodeList.getLength();i++){
            Node name1 = nodeList.item(i);
            //获取元素的值
            System.out.println(name1.getTextContent());

        }
    }

    //获取元素单个值
    public static void selectSingle() throws Exception {
        //创建解析器工厂
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //创建解析器
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        //解析xml返回document
        Document document = builder.parse("src/test.xml");
        //得到所有的name元素
        String s = document.getElementsByTagName("age").item(0).getTextContent();
        System.out.println(s);
    }

    //添加一个元素(sex)
    public static void createEle() throws Exception {
        /*
        * 1.创建解析器工厂
        * 2.根据解析器工厂创建解析器
        * 3.解析xml，返回document
        * 4.得到第一个P1，getElementsByTagName("age").item(0)
        * 5.创建sex标签,createElement
        * 6.创建文本createTextNode
        * 7.把文本添加到sex下面 appendChild
        * 8.把sex添加到第一个P1下面
        * 9.回写xml
        *
        * */
        //创建解析器工厂
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //根据解析器工厂创建解析器
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        //解析xml，返回document
        Document document = builder.parse("src/test.xml");
        //得到第一个P1
        Node p1 = document.getElementsByTagName("p1").item(0);
        //创建sex标签
        Element sex = document.createElement("sex");
        //创建文本
        Text man = document.createTextNode("man");
        //把文本添加到sex下面
        sex.appendChild(man);
        //将sex添加到p1下面
        p1.appendChild(sex);
        //回写
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document),new StreamResult("src/test.xml"));

        System.out.println("Done!");
    }

    //修改节点中的内容
    public static void modifySex() throws Exception {
        /*
         * 1.创建解析器工厂
         * 2.根据解析器工厂创建解析器
         * 3.解析xml，返回document
         * 4.获取sex元素
         * 5.赋新值
         * 6.回写xml
         *
         * */
        //创建解析器工厂
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //根据解析器工厂创建解析器
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        //解析xml，返回document
        Document document = builder.parse("src/test.xml");
        //获取sex元素
        Node sex = document.getElementsByTagName("sex").item(0);
        //设置新的值
        sex.setTextContent("human");
        //写回
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document),new StreamResult("src/test.xml"));

        System.out.println("Done!");
    }

    //删除sex节点
    public static void delSex() throws Exception {
        /*
        * 1.创建解析器工厂
        * 2.根据解析器工厂创建解析器
        * 3.解析xml，返回document
        * 4.获取sex节点
        * 5.获取sex的父节点
        * 6.删除使用父节点删除，removeChild方法
        * 7.回写xml
        *
        * */
        //创建解析器工厂
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //根据解析器工厂创建解析器
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        //解析xml，返回document
        Document document = builder.parse("src/test.xml");
        //获取sex元素
        Node  sex1 = document.getElementsByTagName("sex").item(0);
        //得到sex的父节点
        Node parentNode = sex1.getParentNode();
        //使用父节点删除
        parentNode.removeChild(sex1);
        //写回
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document),new StreamResult("src/test.xml"));

        System.out.println("Done!");

    }

    //遍历节点
    public static void listElement() throws Exception {
        /*
         * 1.创建解析器工厂
         * 2.根据解析器工厂创建解析器
         * 3.解析xml，返回document
         *
         * =======递归实现=========
         * 4.获取根节点
         * 5.获取根节点的子节点
         * 6.获取根节点的子节点的子节点
         *
         * */
        //创建解析器工厂
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //根据解析器工厂创建解析器
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        //解析xml，返回document
        Document document = builder.parse("src/test.xml");
        //递归遍历的方法
        sublist(document,1);
    }

    //递归遍历的方法
    public static void sublist(Node node,int cen) throws Exception {
        //得到一层子节点
        NodeList nodeList = node.getChildNodes();
        //循环
        for(int i = 0;i<nodeList.getLength();i ++){
            //得到节点
            Node node1 = nodeList.item(i);
            //输出（只输出元素的名称，而忽略空格、回车、换行等符号）
            if(node1.getNodeType() == Node.ELEMENT_NODE){
                out(cen);
                System.out.println(node1.getNodeName());
            }
            //递归
            sublist(node1,cen+2);
        }

    }

    //输出空格
    public static void out(int cen){
        for(int i = 0;i<cen;i ++){
            System.out.print(" ");
        }
    }
}
