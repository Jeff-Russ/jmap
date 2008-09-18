/*
 * Copyright all rights reserved by LVUP Shanghai.
 * 
 */

package com.lvup.webnav.test.bean.main;

import com.lvup.webnav.jmap.controller.BasicBean;
import com.lvup.webnav.jmap.controller.ControllerBase;
import com.lvup.webnav.jmap.validator.MaxLength;
import com.lvup.webnav.jmap.validator.Required;
import com.lvup.webnav.jmap.validator.Message;
import com.lvup.webnav.jmap.validator.MinLength;
import com.lvup.webnav.jmap.validator.RulePattern;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author Steve Yao <steve.yao@lvup.com>
 */
public class Login extends BasicBean {
    
    /**
     * This static field should be removed to a base class, this base class
     * can be inseerted in the real bean and BasicBean like this:
     * BasicBean -> BaseBean -> Login
     * the BaseBean can supply some common methods or fields for help.
     */
    private static final String RES_PATH = "com/lvup/webnav/test/resources";
    private static final String EMAIL_PATTERN =
            "(^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$)";
    
    /**
     * example for use the message=@Message(value="std.required")
     */
    @Required(fieldName=@Message(value="main.loginname", resource=RES_PATH))
    @MaxLength(value=20, fieldName=@Message(value="main.loginname", resource=RES_PATH))
    @MinLength(value=5, fieldName=@Message(value="main.loginname", resource=RES_PATH))
    @RulePattern(value=EMAIL_PATTERN, fieldName=@Message(value="main.loginname", resource=RES_PATH))
    private String loginName;
    
    private String passwd;

    private int[] chkTest;
    
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public void execute() {
        // 
    }
    
    @Override 
    public void initFormValues(ControllerBase controller) 
            throws IllegalAccessException, InvocationTargetException {
        // if some actions must be done before the form values, just like 
        // security check ...
        //
        super.initFormValues(controller);
        // other validating actions
        if(! this.isFormValid()) {
            // other validating actions
        }
    }

    public int[] getChkTest() {
        return chkTest;
    }

    public void setChkTest(int[] chkTest) {
        this.chkTest = chkTest;
    }
}
