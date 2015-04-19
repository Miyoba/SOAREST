package rest;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Andreas on 16.04.2015.
 */
public class Databasehandler {

    public Article article;
    private AtomicLong counter = new AtomicLong();

    /**
     * Restful method that Inserts a new entry in the database
     * @param title
     * @param body
     */
    public void InsertHandler(String title, String body){
        article = new Article();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        article.setId(counter.incrementAndGet());
        article.setTitle(title);
        article.setBody(body);
        session.save(article);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Deletes a entry from the database
     * @param id
     */
    public void DeleteHandler(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("delete Article where id = "+id);
        q.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Changes a Entry in the Database
     * @param id
     * @param title
     * @param body
     */
    public void UpdateHandler(int id, String title, String body){
        article = new Article();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        article.setId(id);
        article.setTitle(title);
        article.setBody(body);
        session.update(article);
        session.getTransaction().commit();
        session.close();
    }
}
