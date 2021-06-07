package students.training.program;


import static org.assertj.core.api.Assertions.*;

import jdk.jfr.Description;
import org.testng.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReportGeneratorTest {

    public String report;
    private static final Logger LOG = LogManager.getLogger(ReportGeneratorTest.class.getName());

    @BeforeClass
    private List<HashMap<String, Integer>> generateCourseList(){

        HashMap<String, Integer> course = new HashMap<>();
        List<HashMap<String, Integer>> listOfCourses = new ArrayList<>();

        course.put("Test design", 10);
        course.put("Page Object", 16);
        course.put("Selenium", 21);
        listOfCourses.add(course);

        return listOfCourses;
    }
    @BeforeMethod
    private void startTest(Method method){
        String testName = method.getName();
        LOG.info("Test " + testName + " is running");
    }

    @Test(groups = {"unittest"}, suiteName = "ReportGenerator Unit Tests Test Suite")
    @Description("Create a short student report with valid report type")
    public void testShortReportGeneration() throws Exception {

        String testReport = "Ivanov Ivan (Java SE) - Training completed. d 1 hours have passed since the end.";

        Student student1 = new Student("Ivanov Ivan", "Java SE", Constants.COURSE_START_DATE,
                generateCourseList());
        ReportGenerator reportGenerator = new ReportGenerator();
        report = reportGenerator.generateStudentReport(student1,0);

        assertThat(testReport.equals(report));
    }

    @Test(groups = {"unittest"}, suiteName = "ReportGenerator Unit Tests Test Suite")
    @Description("Create a full student report with valid report type param")
    public void testFullReportGeneration() throws Exception {

        String testReport = "Student: Ivanov Ivan\n" + "Working Hours: from 10 to 18\n"
                + "Programs: \n Test design-10 h\nPage Object-16 h\nSelenium-21 h\nStart Date: "
                + Constants.COURSE_START_DATE + "\nEnd Date: " + Constants.END_DATE
                + "\nTraining completed. 10 d 1 hours have passed since the end.\n";

        Student student1 = new Student("Ivanov Ivan", "Java SE", Constants.COURSE_START_DATE,
                generateCourseList());
        ReportGenerator reportGenerator = new ReportGenerator();
        report = reportGenerator.generateStudentReport(student1,1);

        assertThat(testReport.equals(report));
    }

    @Test(groups = {"unittest"}, suiteName = "ReportGenerator Unit Tests Test Suite")
    @Description("Create a short student report without report type param")
    public void testShortReportGenerationWithoutReportType() throws Exception {

        String testReport = "Ivanov Ivan (Java SE) - Training completed. 10 d 1 hours have passed since the end.";

        Student student1 = new Student("Ivanov Ivan", "Java SE", Constants.COURSE_START_DATE,
                generateCourseList());
        ReportGenerator reportGenerator = new ReportGenerator();
        report = reportGenerator.generateStudentReport(student1);

        assertThat(testReport.equals(report));
    }

    @AfterMethod
    private void finishingTest(Method method){
        String testName = method.getName();
        LOG.info("Test " + testName + " is finished");
    }

    @AfterClass
    private void finishingSuite(){
        LOG.info("All tests completed");
    }
}
