import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Student{
    String id;
    String firstName;
    String lastName;
    String sex;

    public Student(String id, String firstName, String lastName, String sex){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
    }
}

class AllStudent{
    public List<Student> allStudent = new ArrayList<>();

    public List<Student> getAllStudent(){
        return allStudent;
    }

    public void addStudent(Student s){
        allStudent.add(s);
    }

    public int getNumberOfStudents(){
        return allStudent.size();
    }
}

class StudentsTabelModel implements TableModel{

    private AllStudent allStudent;

    public StudentsTabelModel(AllStudent allStudent){
        this.allStudent = allStudent;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) return "ID";
        if (columnIndex == 1) return "FirstName";
        if (columnIndex == 2) return "LastName";
        if (columnIndex == 3) return "Sex";
        return null;
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return 4;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Collection<Student> students = allStudent.getAllStudent();
        int r = -1;
        for (Student student : students){
            r++;
            if (rowIndex == r){
                if (columnIndex == 0) return student.id + "";
                if (columnIndex == 1) return student.firstName;
                if (columnIndex == 2) return student.lastName;
                if (columnIndex == 3) return student.sex;
            }
        }
        return null;
    }
}
public class StudentInfoSystem extends JFrame{
    public JTable sTable;
    JButton addButton;
    JPanel cur;
    JLabel idLabel;
    JLabel firstNameLabel;
    JLabel lastNameLabel;
    JLabel sexLabel;
    JTextField idText;
    JTextField firstNameText;
    JTextField lastNameText;
    JTextField sexText;


    public StudentInfoSystem(){
        AllStudent allStudent = new AllStudent();
        cur = new JPanel(new GridLayout(4, 2));

        addButton = new JButton("add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idText.getText();
                String fnt = firstNameText.getText();
                String lnt = lastNameText.getText();
                String sex = sexText.getText();

                allStudent.addStudent(new Student(id, fnt, lnt, sex));
                sTable.updateUI();
                idText.setText("");
                firstNameText.setText("");
                lastNameText.setText("");
                sexText.setText("");
            }
        });
        idLabel = new JLabel("ID");
        firstNameLabel = new JLabel("First Name");
        lastNameLabel = new JLabel("Last Name");
        sexLabel = new JLabel("Sex");

        idText = new JTextField(10);
        firstNameText = new JTextField(10);
        lastNameText = new JTextField(10);
        sexText = new JTextField(10);

        StudentsTabelModel model = new StudentsTabelModel(allStudent);
        sTable = new JTable(model);
        JScrollPane jScrollPane = new JScrollPane(sTable);

        cur.add(idLabel);
        cur.add(idText);
        cur.add(firstNameLabel);
        cur.add(firstNameText);
        cur.add(lastNameLabel);
        cur.add(lastNameText);
        cur.add(sexLabel);
        cur.add(sexText);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(BorderLayout.CENTER, addButton);
        container.add(BorderLayout.NORTH, cur);
        container.add(BorderLayout.SOUTH, jScrollPane);


        setSize(600, 600);
        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args){
        new StudentInfoSystem();
    }
}
