/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.registration.business.custom.impl;

import lk.ijse.registration.business.custom.CourseBO;
import lk.ijse.registration.dao.DAOFactory;
import lk.ijse.registration.dao.custom.CourseDAO;
import lk.ijse.registration.db.JPAUtil;
import lk.ijse.registration.dto.CourseDTO;
import lk.ijse.registration.entity.Course;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SSNLIVE
 */
public class CourseBOImpl implements CourseBO {

    private CourseDAO courseDAO;
    private SessionFactory sessionFactory;
    private EntityManagerFactory entityManagerFactory;


    public CourseBOImpl() {
        this.courseDAO = (CourseDAO) DAOFactory.getInstance().getDAO(DAOFactory.dAOTypes.Course);
        entityManagerFactory = JPAUtil.getInstance().getEntityManagerFactory();


    }


    public boolean addCourse(CourseDTO addC) throws Exception {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();


            courseDAO.setEntityManager(entityManager);

            Course course = new Course(addC.getcID(), addC.getName(), addC.getDuration());
            courseDAO.save(course);

            entityManager.getTransaction().commit();
            return true;


        }


    public boolean deleteCourse(String id) throws Exception {

EntityManager entityManager = entityManagerFactory.createEntityManager();

entityManager.getTransaction().begin();


            courseDAO.setEntityManager(entityManager);



            courseDAO.delete(id);
            entityManager.getTransaction().commit();
            entityManager.close();

            return true;

    }

    public boolean updateCourse(CourseDTO upC) throws Exception {

    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();


            courseDAO.setEntityManager(entityManager);

            Course course = courseDAO.find(upC.getcID());
            course.setDuration(upC.getDuration());
            course.setName(upC.getName());
            course.setcID(upC.getcID());
            courseDAO.update(course);
            entityManager.getTransaction().commit();
            entityManager.close();

            return true;

    }

    public ArrayList<CourseDTO> getAllCourses() throws Exception {

    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();


            courseDAO.setEntityManager(entityManager);

            List<Course> allCourses = courseDAO.getAll();
            entityManager.getTransaction().commit();

            ArrayList<CourseDTO> dtos = new ArrayList<>();

            for (Course c : allCourses) {
                CourseDTO coursesDTO = new CourseDTO(c.getcID(), c.getName(), c.getDuration());
                dtos.add(coursesDTO);
            }
            return dtos;

    }

    public CourseDTO findCourse(String id) throws Exception {
EntityManager entityManager = entityManagerFactory.createEntityManager();
entityManager.getTransaction().begin();


            courseDAO.setEntityManager(entityManager);

            Course course = courseDAO.find(id);
            CourseDTO courseDTO = new CourseDTO(course.getcID(), course.getName(), course.getDuration());
            entityManager.getTransaction().commit();

            return courseDTO;


//        Course c = courseDAO.find(id);
//        CourseDTO cDTO = new CourseDTO(c.getcID(),c.getName(),c.getDuration());
//        return cDTO;
    }

    public ArrayList<String> getCourseIDs() throws Exception {

    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();


            courseDAO.setEntityManager(entityManager);

            List<Course> allcourseIds = courseDAO.getAll();

            ArrayList<String> allids = new ArrayList<>();
            for (Course course : allcourseIds
                    ) {
                allids.add(course.getcID());

            }
            entityManager.getTransaction().commit();
            entityManager.close();
            return allids;
        }
    }

