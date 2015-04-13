package hibernateTemplate;

import org.hibernate.Session;

public interface HibernateReader {
	<E> E returnQuery(Session session);
}
