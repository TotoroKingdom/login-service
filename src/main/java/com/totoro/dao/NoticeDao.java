package com.totoro.dao;

import com.totoro.domain.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Description TODO
 * @Author totoro
 * @Date 2022-07-09 21:44
 */
public interface NoticeDao extends JpaRepository<Notice,Long>, JpaSpecificationExecutor<Notice> {


}
