package hasan.mohamed.shehata.sampleemps.models;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
abstract class Auditable {
    /**
     * String field containing the username of who created this row
     */
    @CreatedBy
    protected String createdby;

    /**
     * Date field containing the date and time when the row was created
     * <p>
     * Temporal(TIMESTAMP) - Sets the precision of the date being saved. In this case Date and Time
     */
    @CreatedDate
    @Temporal(TIMESTAMP)
    protected Date createddate;

    /**
     * String field containing the username of who last modified this row
     */
    @LastModifiedBy
    protected String lastmodifiedby;

    /**
     * Date field containing the data and time when the row was last modified
     * <p>
     * Temporal(TIMESTAMP) - Sets the precision of the date being saved. In this case Date and Time
     */
    @LastModifiedDate
    @Temporal(TIMESTAMP)
    protected Date lastmodifieddate;

    public String getCreatedby() {
        return createdby;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public String getLastmodifiedby() {
        return lastmodifiedby;
    }

    public Date getLastmodifieddate() {
        return lastmodifieddate;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public void setLastmodifiedby(String lastmodifiedby) {
        this.lastmodifiedby = lastmodifiedby;
    }

    public void setLastmodifieddate(Date lastmodifieddate) {
        this.lastmodifieddate = lastmodifieddate;
    }
}
