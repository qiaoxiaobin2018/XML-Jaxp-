package cn.java.StudentManageSystem;

import cn.xmlParserTest.dom4jTest.dom4jMethod;
import org.dom4j.Document;
import org.dom4j.Element;

public class StudentManage {
    public static void addStu(Student student) throws Exception {
        /*
        * 1.获取document
        * 2.获取根节点
        * 3.在根节点下面创建stu标签
        * 4.在stu下面依次添加id name age
        * 5.在id name age下面依次添加值
        *
        * 6.回写xml
        *
        * */
        //获取document
        Document document = dom4jMethod.getDocument();
        //获取根节点
        Element root = document.getRootElement();
        //在根节点下面创建stu标签
        Element stu = root.addElement("stu");
        //在stu下面依次添加id name age
        Element id1 = stu.addElement("id");
        Element name1 = stu.addElement("name");
        Element age1 = stu.addElement("age");
        //在id name age下面依次添加值
        id1.setText(student.getId());
        name1.setText(student.getName());
        age1.setText(student.getAge());


        //回写xml
        dom4jMethod.writeBack(document);
    }

}
