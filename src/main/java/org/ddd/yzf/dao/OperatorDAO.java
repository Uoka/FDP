package org.ddd.yzf.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.ddd.yzf.entity.Operator;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface OperatorDAO {

    Integer saveOperator(Operator operator);

    void setOperatorRole(@Param("operatorId") Long operatorId, @Param("roleId") Long roleId);

    Operator findOperatorByAccountAndPassword(@Param("account") String account, @Param("password") String password);

    Operator findOperatorByPhoneAndPassword(@Param("phone") String phone, @Param("password") String password);

    Operator findOperatorByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
