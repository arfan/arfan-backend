package backend.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


/**
 * This class is used to access data for the User entity.
 * Repository annotation allows the component scanning support to find and 
 * configure the DAO wihtout any XML configuration and also provide the Spring 
 * exceptiom translation.
 * Since we've setup setPackagesToScan and transaction manager on
 * DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the
 * method. If exception occurs it will also call rollback().
 */

@Repository
@Transactional
public class SalesOrderDao {
  
  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  /**
   * Save the user in the database.
   */
  public void create(SalesOrder salesOrder) {
    entityManager.persist(salesOrder);
    entityManager.flush();
    return;
  }
  
  /**
   * Delete the user from the database.
   */
  public void delete(SalesOrder salesOrder) {
    if (entityManager.contains(salesOrder))
      entityManager.remove(salesOrder);
    else
      entityManager.remove(entityManager.merge(salesOrder));
    return;
  }
  
  /**
   * Return all the users stored in the database.
   */
  @SuppressWarnings("unchecked")
  public List<SalesOrder> getAll() {
    return entityManager.createQuery("from sales_order").getResultList();
  }

  /**
   * Return the user having the passed id.
   */
  public SalesOrder getById(long id) {
    return entityManager.find(SalesOrder.class, id);
  }

  /**
   * Update the passed user in the database.
   */
  public void update(SalesOrder salesOrder) {
    entityManager.merge(salesOrder);
    return;
  }

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  // An EntityManager will be automatically injected from entityManagerFactory
  // setup on DatabaseConfig class.
  @PersistenceContext
  private EntityManager entityManager;
  
} 
