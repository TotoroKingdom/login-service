package com.totoro.domain.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description TODO
 * @Author totoro
 * @Date 2022-07-09 20:19
 */
@Data
@Entity
@Table(name = "t_notice")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 用户昵称
     */
    @Column(name = "content")
    private String content;
}
