/**
 *
 * @author Davit Gabrielyan
 * @version 1.0 Apr 10, 18
 **/

public class GSquareGradebook {

    private MySortedSet<Student> theSet;

    /**
     * [GSquareGradebook constructor]
     */

    public GSquareGradebook() {
        theSet = new MySortedSet<>();
    }

    /**
     * [addStudent method]
     * @param name          [student name]
     * @param testGrade     [the grade]
     * @param homeworkGrade [the hw grade]
     */

    public void addStudent(String name, int testGrade, int homeworkGrade) {
        Student newStudent = new Student(name, testGrade, homeworkGrade);
        theSet.add(newStudent);
    }

    /**
     * [setTestGrade method]
     * @param name      [the name]
     * @param testGrade [the test grade]
     */

    public void setTestGrade(String name, int testGrade) {
        Student legitStudent = new Student(name, 0, 0);
        legitStudent = theSet.get(legitStudent);
        legitStudent.setTestGrade(testGrade);
    }

    /**
     * [setHomeworkGrade method]
     * @param name          [the name]
     * @param homeworkGrade [the hw grade]
     */

    public void setHomeworkGrade(String name, int homeworkGrade) {
        Student legitStudent = new Student(name, 0, 0);
        legitStudent = theSet.get(legitStudent);
        legitStudent.setTestGrade(homeworkGrade);
    }

    /**
     * [getStudents method]
     * @return [a trimmed array]
     */

    public Student[] getStudents() {
        Student[] tmp = new Student[theSet.getCount()];
        Student[] x = theSet.toArray(tmp);
        return x;
    }
}
