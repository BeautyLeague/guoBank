package com.guobank.util;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author : pengliang
 * @version V1.0
 * @Project: guoBank
 * @Package com.guobank.wanzehao.util
 * @Descriptio /**
 * @Project: guoBank
 * @Package com.guobank.wanzehao.util
 * @Description: TODO
 * @date Date : 2020年01月02日 9:56
 */
public class TestSession implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session添加的键"+httpSessionBindingEvent.getName());
        System.out.println("session添加的值"+httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session移除的键"+httpSessionBindingEvent.getName());
        System.out.println("session移除的值"+httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session更改的键"+httpSessionBindingEvent.getName());
    }
}
