package org.ld.mechanism.admin.jurisdiction.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.ld.mechanism.admin.jurisdiction.jpa.JurisdictionJpa;
import org.ld.mechanism.admin.jurisdiction.model.JurisdictionModel;
import org.ld.mechanism.admin.jurisdiction.service.JurisdictionService;
import org.ld.mechanism.util.responseResult.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
@Slf4j
@Service
public class JurisdictionServiceImpl implements JurisdictionService {

    @Autowired
    private JurisdictionJpa jpa;

    @CachePut(cacheNames = "jurisdiction")
    @Override
    public ResponseResult<JurisdictionModel> save(JurisdictionModel model) {
        List<JurisdictionModel> list = jpa.findByNameAndIdentification(model.getName(), model.getIdentification());
        if (list.size() > 0)
            return new ResponseResult<>(false, "权限名称以及权限标识同组冲突", null);
        else {
            jpa.save(model);
            return new ResponseResult<>(true, "成功", null);
        }
    }

    @CacheEvict(cacheNames = "jurisdiction")
    @Override
    public ResponseResult<JurisdictionModel> delete(String uuid) {
        jpa.deleteById(uuid);
        return new ResponseResult<>(true, "成功", null);
    }

    @CachePut(cacheNames = "jurisdiction")
    @Override
    public ResponseResult<JurisdictionModel> update(JurisdictionModel model) {
        List<JurisdictionModel> list = jpa.findByNameAndIdentification(model.getName(), model.getIdentification());
        if (list.size() > 0)
            return new ResponseResult<>(false, "权限名称以及权限标识同组冲突", null);
        else {
//            findone数据库返回数据，并不是数据库实例，更改后需要手动调用flus刷新，并且当数据返回为空的时候实体为空
//            getone为数据库实时数据实例，更改后不需手动刷新，但当数据为空的时候实体不为空，但实体属性为空
            JurisdictionModel one = jpa.getOne(model.getUuid());
            if (one.getName() != null) {
                one.setIdentification(model.getIdentification());
                one.setName(model.getName());
                one.setType(model.getType());
                return new ResponseResult<>(true, "成功", null);
            } else
                return new ResponseResult<>(false, "未查询到记录", null);
        }
    }

    @Cacheable(cacheNames = "jurisdiction")
    @Override
    public ResponseResult<JurisdictionModel> findByUuid(String uuid) {
        Optional<JurisdictionModel> one = jpa.findById(uuid);
        if (one.isPresent())
            return new ResponseResult<>(true, "成功", one.get());
        else
            return new ResponseResult<>(false, "未查询到记录", null);
    }

    @Cacheable(cacheNames = "jurisdiction")
    @Override
    public ResponseResult<Page<JurisdictionModel>> page(int pageNow, int pageSize, JurisdictionModel model) {
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.ASC, "name"));//排序信息
        Specification<JurisdictionModel> spec = queryTj(model);
        PageRequest pageRequest = PageRequest.of(pageNow, pageSize, Sort.by(orders));
        Page<JurisdictionModel> page = jpa.findAll(spec, pageRequest);
        if (!page.getContent().isEmpty())
            return new ResponseResult<>(true, "成功", page);
        else
            return new ResponseResult<>(false, "未查询到数据", null);
    }

    //    查询条件
    private Specification<JurisdictionModel> queryTj(JurisdictionModel model) {
        return new Specification<JurisdictionModel>() {//查询条件构造
            @Override
            public Predicate toPredicate(Root<JurisdictionModel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (model != null) {
                    if (model.getName() != null && !model.getName().isEmpty()) {
                        Predicate p1 = cb.like(root.get("name").as(String.class), "%" + model.getName() + "%");
                        predicates.add(cb.and(p1));
                    }
                }
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }
}
