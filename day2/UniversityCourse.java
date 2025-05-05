import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String name;

    public CourseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class ExamCourse extends CourseType {
    public ExamCourse(String name) {
        super(name);
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String name) {
        super(name);
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String name) {
        super(name);
    }
}

class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public T getCourseType() {
        return courseType;
    }
}

public class UniversityCourse {
    public static void displayCourses(List<Course<? extends CourseType>> courses) {
        for (Course<? extends CourseType> course : courses) {
            System.out.println("Course Name: " + course.getCourseName());
            System.out.println("Course Type: " + course.getCourseType().getName());
        }
    }

    public static void main(String[] args) {
        Course<ExamCourse> examCourse = new Course<>("Mathematics", new ExamCourse("Exam-Based"));
        Course<AssignmentCourse> assignmentCourse = new Course<>("Programming", new AssignmentCourse("Assignment-Based"));
        Course<ResearchCourse> researchCourse = new Course<>("Thesis", new ResearchCourse("Research-Based"));
        List<Course<? extends CourseType>> courses = new ArrayList<>();
        courses.add(examCourse);
        courses.add(assignmentCourse);
        courses.add(researchCourse);

        displayCourses(courses);
    }
}


