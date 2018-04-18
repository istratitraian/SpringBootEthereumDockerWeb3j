package com.ethereum.web3j.domains.repos;

import com.ethereum.web3j.domains.BetrUser;
import java.util.List;
//import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author I.T.W764
 */
//@Service
public class AwsDbTemplate {

//  private final JdbcTemplate jdbcTemplate;

//  @Autowired
//  public AwsDbTemplate(DataSource dataSource) {
//    this.jdbcTemplate = new JdbcTemplate(dataSource);
//  }

//  @Transactional(readOnly = true)
  public List<BetrUser> loadAll() {
    // read data on the read replica
    return null;
  }

//  @Transactional
  public void updatePerson(BetrUser person) {
    // write data into database
  }
}
