package cn.java.StudentManageSystem;

public class TestStu {
    public static void main(String[] args) throws Exception {
        addStu();
    }
    //测试添加学生
    public static void addStu() throws Exception {
        StudentManage studentManage = new StudentManage();
        Student student = new Student();
        student.setId("1002");
        student.setName("Mary");
        student.setAge("30");
        //添加学生信息
        studentManage.addStu(student);
        System.out.println("Done!");
    }
}
