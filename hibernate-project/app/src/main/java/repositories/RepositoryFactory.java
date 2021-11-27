package repositories;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;

@Slf4j
public class RepositoryFactory {

    static {
        Properties appProperties = new Properties();
        try {
            appProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("app.properties"));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    private RepositoryFactory() {
        //factory empty private
    }

    public static StudentRepository getStudentRepository() {
        return StudentRepositoryJPA.getInstance();
    }

 //   public static CourseRepository getCourseRepository() {
 //       return CourseRepositoryPostgres.getInstance(datasource);
 //   }

  //  public static TeacherRepository getTeacherRepository() {
 //       return TeacherRepositoryPostgres.getInstance(datasource);
 //   }
}
