package com.guobank.web;

import com.alibaba.fastjson.JSON;
import com.guobank.entity.User;
import com.guobank.guopeng.service.impl.UserInfoService;
import com.guobank.service.AdminInfoService;
import com.guobank.service.impl.AdminInfoServiceImpl;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.*;

/**
 * @author : pengliang
 * @version V1.0
 * @Project: webSocket
 * @Package com.websocket
 * @Descriptio /**
 * @Project: webSocket
 * @Package com.websocket
 * @Description: TODO
 * @date Date : 2020年02月15日 20:37
 */
@ServerEndpoint("/testWebSocket/{type}/{id}/{objectSessionId}")
public class KeFuWebSocket {


    public static List<KeFuWebSocket> socketList = new Vector<KeFuWebSocket>();

    public static List<KeFuWebSocket> requests = new Vector<>();

    private UserInfoService userInfoService = new UserInfoService();

    private AdminInfoService adminInfoService = new AdminInfoServiceImpl();

    private Session session;

    private String sessionId;

    private String objectSessionId;

    private String type;

    private Object entity;

    private Date date;

    public String getObjectSessionId() {
        return objectSessionId;
    }

    public void setObjectSessionId(String objectSessionId) {
        this.objectSessionId = objectSessionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getEntity() {
        return entity;
    }

    public void setEntity(Object entity) {
        this.entity = entity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("type") String type, @PathParam("id") String id, @PathParam(value = "objectSessionId") String objectSessionId) {
        try {
            setObjectSessionId(objectSessionId);
            setDate(new Date());
            setType(type);
            setSessionId(session.getId());
            this.session = session;
            if ("user".equals(type)) {
                entity = userInfoService.userById(new Integer(id));
                requests.add(this);
            } else {
                entity = adminInfoService.getAdminInfo(id);
                for (KeFuWebSocket socket : socketList) {
                    if (socket.sessionId.equals(objectSessionId)) {
                        socket.objectSessionId = sessionId;
                        socket.session.getBasicRemote().sendText("true");
                    }
                }
            }
            socketList.add(this);
            System.out.println("连接成功，sessionId:" + session.getId());
        } catch (Exception e) {
            System.out.println("连接失败，sessionId:" + session.getId());
        }

    }

    @OnClose
    public void onClose(Session session) {
        try {
//            Iterator<KeFuWebSocket> iterator = socketList.iterator();
//            while (iterator.hasNext()){
//                KeFuWebSocket item = iterator.next();
//                if(item.session == session){
//
//                    for (KeFuWebSocket socket : socketList) {
//                        try {
//                            if (objectSessionId.equals(socket.sessionId)) {
//                                socket.session.getBasicRemote().sendText("false");
//                            }
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    iterator.remove();
//                    requests.remove(item);
//                }
//            }
            requests.remove(this);
            socketList.remove(this);
            for (KeFuWebSocket socket : socketList) {
                try {
                    if (objectSessionId.equals(socket.sessionId)) {
                        socket.session.getBasicRemote().sendText("false");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
//            for (KeFuWebSocket item : socketList) {
//                if (item.session == session) {
//                    socketList.remove(item);
//                    requests.remove(item);
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("关闭成功，id:" + session.getId());
    }

    @OnMessage
    public void onMessage(String message) {
        for (KeFuWebSocket socket : socketList) {
            try {
                if (objectSessionId.equals(socket.sessionId)) {
                    socket.session.getBasicRemote().sendText(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println(error.getMessage());
    }
}
