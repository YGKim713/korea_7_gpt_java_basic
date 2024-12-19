package chapter12.model;

public class Student {
    private String name;
    private int age;
    private String studentId;

    public Student(String name, int age, String studentId) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getStudentId() { return studentId; }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {  // 모든 클래스의 최상위 클래스인 Object 클래스로부터 출력 메서드 오버라이딩
        return "Student [ Name: " + name + ", Age: " + age + ", ID: " + studentId + "]";
    }
}
