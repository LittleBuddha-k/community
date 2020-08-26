package com.littlebuddha.community.base.mapper;

import java.util.List;

public interface BaseMapper<E> {

    /**
     * 单条查询
     * @param id
     * @return 实体类
     */
    E get(String id);

    E get(E entity);

    List<E> findList(E entity);

    int insert(E entity);

    int update(E entity);

    int deleteByLogic(String id);

    int deleteByPhysics(String id);
}
