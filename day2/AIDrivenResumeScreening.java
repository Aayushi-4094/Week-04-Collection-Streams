import java.util.ArrayList;
import java.util.List;

abstract class JobRole{
    private String rollName;

    public JobRole(String rollName) {
        this.rollName = rollName;
    }

    public String getRollName(){
        return rollName; 
    } 
}

class SoftwareEngineer extends JobRole{
    public SoftwareEngineer(){
        super("Software Engineer");
    }
}

class DataScientist extends JobRole{
    public DataScientist(){
        super("Data Scientist");
    }
}
class ProductManager extends JobRole{
    public ProductManager(){
        super("Product Manager");
    }
}

class Resume<T extends JobRole>{
    private T jobRole;
    private String name;
    private String skills;

    public Resume(T jobRole, String name, String skills) {
        this.jobRole = jobRole;
        this.name = name;
        this.skills = skills;
    }

    public T getJobRole(){
        return jobRole;
    }

    public String getName(){
        return name;
    }

    public String getSkills(){
        return skills;
    }
}
public class AIDrivenResumeScreening {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> softwareEngineerResume = new Resume<>(new SoftwareEngineer(), "aayushi Agarwal", "Java, Python, Spring");
        Resume<DataScientist> dataScientistResume = new Resume<>(new DataScientist(), "Pritesh Agarwal", "Pandas, Python, Analysis");
        Resume<ProductManager> productManagerResume = new Resume<>(new ProductManager(), "Shubh Bansal", "Excel, Communication, Spring");
        List<Resume<? extends JobRole>> resumes = new ArrayList<>();
        resumes.add(softwareEngineerResume);
        resumes.add(dataScientistResume);
        resumes.add(productManagerResume);
        processResumes(resumes);

    }

    public static void processResumes(List<Resume<? extends JobRole>> resumes){
        for(Resume<? extends JobRole> resume : resumes){
            System.out.println("Candidtae Name :" + resume.getName());
            System.out.println("Job Role :" + resume.getJobRole());
            System.out.println("Skills :" + resume.getSkills());
        }
    }
}
