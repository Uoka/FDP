package org.ddd.yzf.service.operator;

import org.ddd.yzf.entity.Operator;

public interface OperatorService {

    Operator findOperatorByAccountAndPassword(String account, String password);

    Operator findOperatorByPhoneAndPassword(String phone, String password);

    Operator findOperatorByEmailAndPassword(String email, String password);

    void addOperator(Operator operator);

    void setOperatorRole(Long operatorId, Long roleId);
}
