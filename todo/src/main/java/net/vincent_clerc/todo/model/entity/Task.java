package net.vincent_clerc.todo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "task")
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Long id;

    @Column(name = "titre", length = 64)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String titre;

    @Column(name = "description")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String description;

    @Column(name = "is_checked")
    @JdbcTypeCode(SqlTypes.BOOLEAN)
    private Boolean isChecked;

    @Column(name = "checked_date")
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    private LocalDateTime checkedDate;

}