package com.maciej.interceptors;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Iterator;

public class AuditInterceptor extends EmptyInterceptor {

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("Saving entity");
        return false;
    }

    @Override
    public void postFlush(Iterator entities) {
        System.out.println("After entity has been flushed");
    }
}
