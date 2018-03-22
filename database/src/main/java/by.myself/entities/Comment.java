package by.myself.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "my-cache")
public class Comment extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Column(name = "datetime_comment")
    private LocalDateTime dateTime;

    @Column(name = "text")
    private String text;
}
