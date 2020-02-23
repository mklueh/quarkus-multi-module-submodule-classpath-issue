package com.demo.common.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SharedModel extends PanacheEntity {

    private String name;

    private LocalDateTime createdAt;

}
