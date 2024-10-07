package com.example.test.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;
// @Data -> @Getter, @Setter, @RequiredArgConstructor, (@ToString, @EqualsAndHashCode), @Value

// @AllArgsConstructor, @Builder - ломают JPA сущьность т.к. не оставляют конструктор по умолчанию.
// Обязательно добавлять @NoArgsConstructor
@ToString // при использовнии необходимо исключать ассоциативные поля
// (@ManyToMany, @ManyToOne) аннотацией @ToString.Exclude
@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    private Long id;
    private String title;
    private String description;
    private String category;
    private int rating;

    @Override
    public final boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        Class<?> oEffectivClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer()
                .getPersistentClass()
                : o.getClass();

        Class<?> thisEffectivClass = this instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer()
                .getPersistentClass()
                : o.getClass();

        if(thisEffectivClass != oEffectivClass) return false;
        Article article = (Article) o;

        return getId() != null && Objects.equals(getId(), article.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer()
                .getPersistentClass()
                .hashCode()
                : getClass().hashCode();
    }



}
