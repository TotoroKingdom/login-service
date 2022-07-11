package com.totoro.service;

import com.totoro.domain.model.AjaxResult;
import com.totoro.domain.model.LoginBody;

public interface RegisterService {

    /**
     * 注册
     */
    AjaxResult register(LoginBody loginBody);

    /**
     * 激活
     * @param code
     * @return
     */
    AjaxResult active(String code);


}
