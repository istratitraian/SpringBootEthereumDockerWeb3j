package com.ethereum.web3j.domains.abs;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * @author I.T.W764
 */
@MappedSuperclass
public class AbstractDomain implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  protected Integer id;

  @Version
  private Integer version;

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

}
