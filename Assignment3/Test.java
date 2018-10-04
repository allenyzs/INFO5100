public class Test {
    public static class Student{
        int id;
        String name;

        Student(String name, int id){
            this.name = name;
            this.id = id;
        }

        public int getId(){
            return id;
        }

        public String getName(){
            return name;
        }
    }

    public static class Course{
        String name;
        int numberOfStudent;
        Student[] regStudent;

        Course(String title){
            this.name = title;
            this.numberOfStudent = 0;
            this.regStudent = new Student[10];
        }

        public void registerStudent(Student student){
            if (!isFull()){
                regStudent[numberOfStudent++] = student;
            }
        }

        public Student[] getStudents(){
            return regStudent;
        }

        public int getNumberOfStudent() {
            return numberOfStudent;
        }

        public String getName() {
            return name;
        }

        public boolean isFull(){
            if (numberOfStudent > 9){
                return true;
            } else {
                return false;
            }
        }
    }
    public static void main(String[] args){


        //test case as follow :)
//        Student s1 = new Student("Allen", 0);
//        Student s2 = new Student("John", 1);
//        Student s3 = new Student("Lisa", 2);
//
//        Course c1 = new Course("INFO5100");
//
//        if (!c1.isFull()){
//            c1.registerStudent(s1);
//            c1.registerStudent(s2);
//            c1.registerStudent(s3);
//            c1.registerStudent(s1);
//            c1.registerStudent(s2);
//            c1.registerStudent(s3);
//            c1.registerStudent(s1);
//            c1.registerStudent(s2);
//            c1.registerStudent(s3);
//            c1.registerStudent(s1);
//            c1.registerStudent(s2);
//            c1.registerStudent(s3);
//        }
//
//        Student[] res = c1.getStudents();
//
//        for (int i = 0; i < res.length; i++){
//            if (res[i] != null){
//                System.out.println(res[i].name);
//            }
//        }
//        System.out.println(s1.getId());
//        System.out.println(s1.getName());
//        System.out.println(c1.getName());
//        System.out.println(c1.getNumberOfStudent());
    }
}
