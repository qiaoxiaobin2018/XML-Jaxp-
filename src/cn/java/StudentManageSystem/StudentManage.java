package cn.java.StudentManageSystem;

import cn.xmlParserTest.dom4jTest.dom4jMethod;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import java.util.List;

public class StudentManage {
    //添加一个学生
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
    //根据ID删除一个学生
    public static void delStu(String id) throws Exception {
        /*
        * 1.获取document
        * 2.获取所有的ID
        *   使用Xpath //id 返回list集合
        * 3. 遍历list集合
        * 4. 判断集合里面的ID与传递的ID是否相同
        * 5. 如果相同则把ID所在的Stu删除
        * 6. 回写xml
        *
        * */
        //获取document
        Document document = dom4jMethod.getDocument();
        //获取所有的ID
        List<Node> list = document.selectNodes("//id");
        //遍历list集合
        for(Node node : list){
            //判断集合里面的ID与传递的ID是否相同
            String iid = node.getText();
            if(iid.equals(id)){
                //获取Stu
                Element stu = node.getParent();
                //获取stu的父节点
                Element stuParent = stu.getParent();
                //删除
                stuParent.remove(stu);
            }
        }
        //回写xml
        dom4jMethod.writeBack(document);
    }
    //根据ID查询一个学生信息
    public static Student getStu(String id) throws Exception {
        /*
        * 1.获取document
        * 2.获取所有id
        * 3.遍历list
        * 4.判断集合里面的ID与传递的ID是否相同
        * 5.如果相同则获取该id的stu
        * 6.获取该stu的name age
        * 7.返回student对象
        *
        * */
        //获取document
        Document document = dom4jMethod.getDocument();
        //获取所有的id
        List<Node> list = document.selectNodes("//id");
        //创建student对象
        Student student = new Student();
        //遍历list
        for(Node node : list){
            String idv = node.getText();
            if(idv.equals(id)){
                Element stu = node.getParent();
                String namev = stu.element("name").getText();
                String agev = stu.element("age").getText();
                student.setId(idv);
                student.setName(namev);
                student.setAge(agev);
                break;
            }


        }
        return student;


    }


}
