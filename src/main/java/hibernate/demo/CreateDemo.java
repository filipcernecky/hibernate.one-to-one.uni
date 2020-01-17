package hibernate.demo;

import hibernate.entity.Instructor;
import hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] argz) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create 3 objects
            Instructor tempInstructor1 =
                    new Instructor("Vadim", "Hudoznik", "loner@luv2code.com");

            InstructorDetail tempInstructorDetail1 =
                    new InstructorDetail("http://www.JUST.com/youtube", "stalking");

            Instructor tempInstructor2 =
                    new Instructor("Viktor", "Shutnik", "merc@luv2code.com");

            InstructorDetail tempInstructorDetail2 =
                    new InstructorDetail("http://www.KILL.com/youtube", "digging");

            Instructor tempInstructor3 =
                    new Instructor("Igor", "Sabaka", "bandit@luv2code.com");

            InstructorDetail tempInstructorDetail3 =
                    new InstructorDetail("http://www.ME.com/youtube", "killing");

            // associate objects
            tempInstructor1.setInstructorDetail(tempInstructorDetail1);
            tempInstructor2.setInstructorDetail(tempInstructorDetail2);
            tempInstructor3.setInstructorDetail(tempInstructorDetail3);

            // start a transaction
            session.beginTransaction();

            // save the instructor
            System.out.println("Saving instructor: " + tempInstructor1 + tempInstructor2 + tempInstructor3);
            session.save(tempInstructor1);
            session.save(tempInstructor2);
            session.save(tempInstructor3);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
