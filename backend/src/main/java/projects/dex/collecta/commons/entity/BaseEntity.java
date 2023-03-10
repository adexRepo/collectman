package projects.dex.collecta.commons.entity;

import java.time.ZonedDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@MappedSuperclass
@EntityListeners(value = { AuditingEntityListener.class })
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BaseEntity implements Cloneable {

    @CreatedBy
    @Column(name = "inserted_by", nullable = false, updatable = false)
    protected String insertedBy;

    @CreatedDate
    @Column(name = "inserted_at", nullable = false, updatable = false)
    protected ZonedDateTime insertedAt;

    @LastModifiedBy
    @Column(name = "updated_by", nullable = false)
    protected String updatedBy;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    protected ZonedDateTime updatedAt;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
