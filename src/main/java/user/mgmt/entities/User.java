package user.mgmt.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@ToString(of = {"username"})
@Table("USERS")
public class User {

    @Id
    @Column("ID")
    private Long id;
    @Column("USERNAME")
    private String username;
    @Column("LAST_MODIFIED")
    private LocalDateTime lastModified = LocalDateTime.now();

}
