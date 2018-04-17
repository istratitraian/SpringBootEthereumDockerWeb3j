package com.ethereum.web3j.domains.abs;

import java.util.Date;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;

/**
 * @author I.T.W764
 */
@MappedSuperclass
public class AbstractDomainDateCreated extends AbstractDomain {

  @Temporal(javax.persistence.TemporalType.TIMESTAMP)
  private Date created;
  @Temporal(javax.persistence.TemporalType.TIMESTAMP)
  private Date updated;

  public Date getCreated() {
    return created;
  }

  public Date getUpdated() {
    return updated;
  }

  @PreUpdate
  @PrePersist
  public void updateTimeStamps() {
    updated = new Date();
    if (created == null) {
      created = new Date();
    }
  }
}
