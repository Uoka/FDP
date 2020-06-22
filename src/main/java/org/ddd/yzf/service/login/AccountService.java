package org.ddd.yzf.service.login;

import org.ddd.yzf.dto.RequestDTO;
import org.ddd.yzf.dto.RespondDTO;

public interface AccountService {

    RespondDTO<Object> userLogin(RequestDTO<Object> requestDTO);

    void userLogout();
}
