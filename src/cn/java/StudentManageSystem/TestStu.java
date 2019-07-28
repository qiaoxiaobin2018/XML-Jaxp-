package cn.java.StudentManageSystem;

public class TestStu {
    public static void main(String[] args) throws Exception {
        //testAdd();
        //testDel("1001");
        testGet("1001");
    }
    //测试添加学生
    public static void testAdd() throws Exception {
        StudentManage studentManage = new StudentManage();
        Student student = new Student();
        student.setId("1001");
        student.setName("May");
        student.setAge("30");
        //添加学生信息
        studentManage.addStu(student);
        System.out.println("Done!");
    }
    //测试删除学生
    public static void testDel(String id) throws Exception{

        StudentManage.delStu(id);
        System.out.println("Done!");
    }
    //测试查询学生
    public static void testGet(String id) throws Exception{
        Student student = StudentManage.getStu(id);
        System.out.println(student.toString());
        //System.out.print("id: "+student.getId()+"\nname: "+student.getName()+"\nage: "+student.getAge());
    }
}
