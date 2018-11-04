//I worked on the homework assignment alone, using only course materials.

/**
 * This is Course.
 * @author Davit
 * @version 1.0
 */

public class Course implements Comparable<Course> {

    protected String name;
    protected int courseCode;
    protected Instructor instructor;
    protected Student[] students;

    /**
     * Constructor
     * @param  name       [the name of the course]
     * @param  courseCode [the code]
     * @param  instructor [the instructor]
     * @param  students   [the students array]
     */

    public Course(String name, int courseCode,
        Instructor instructor, Student[] students) {
        this.name = name;
        this.courseCode = courseCode;
        this.instructor = instructor;
        this.students = new Student[students.length];
        for (int i = 0; i < students.length; i++) {
            this.students[i] = students[i];
        }

    }

    /**
     * [getInstructorName ]
     * @return Instructors name
     */

    public String getInstructorName() {
        return instructor.getName();
    }

    /**
     * [getName ]
     * @return name of the course
     */

    public String getName() {
        return name;
    }

    /**
     * [getCourseCode ]
     * @return Code of the course
     */

    public int getCourseCode() {
        return courseCode;
    }

    /**
     * [getStudents]
     * @return student Object
     */

    public Student[] getStudents() {
        return this.students;
    }

    @Override
    public int compareTo(Course other) {
        if (this.courseCode != other.courseCode) {
            return (this.courseCode - other.courseCode);
        } else {
            return (this.name.compareTo(other.name));
        }
    }

}