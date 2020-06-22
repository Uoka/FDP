package org.ddd.yzf.service.operator.impl;

import org.ddd.yzf.dao.OperatorDAO;
import org.ddd.yzf.entity.Operator;
import org.ddd.yzf.service.operator.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperatorServiceBean implements OperatorService {

    @Autowired
    private OperatorDAO operatorDAO;

    @Override
    public Operator findOperatorByAccountAndPassword(String account, String password) {
        return operatorDAO.findOperatorByAccountAndPassword(account, password);
    }

    @Override
    public Operator findOperatorByPhoneAndPassword(String phone, String password) {
        return operatorDAO.findOperatorByPhoneAndPassword(phone, password);
    }

    @Override
    public Operator findOperatorByEmailAndPassword(String email, String password) {
        return operatorDAO.findOperatorByEmailAndPassword(email, password);
    }

    @Override
    public void addOperator(Operator operator) {
        this.operatorDAO.saveOperator(operator);
    }

    @Override
    public void setOperatorRole(Long operatorId, Long roleId) {
        this.operatorDAO.setOperatorRole(operatorId, roleId);
    }

}
