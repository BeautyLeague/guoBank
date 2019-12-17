<%@ page import="java.awt.*" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.imageio.ImageIO" %><%--
  Created by IntelliJ IDEA.
  User: 25826
  Date: 2019/11/5
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
    public Color getColor(){
        Random random = new Random();
        int r =  random.nextInt(256);
        int g =  random.nextInt(256);
        int b =  random.nextInt(256);
        return new Color(r,g,b);
    }
    public String getLetter(){
        Random random = new Random();
        char one = (char)(random.nextInt(26)+65);
        char two = (char)(random.nextInt(26)+65);
        char three = (char)(random.nextInt(26)+65);
        char four = (char)(random.nextInt(26)+65);
        return new String(new char[]{one,two,three,four});
    }
%>


<%
    //禁止缓存,防止验证码过期
    response.setHeader("Pragma","no-cache");
    response.setHeader("Cache-control","no-cache");
    response.setHeader("Expires","0");


    BufferedImage image = new BufferedImage(140,30,BufferedImage.TYPE_INT_RGB);

    //画笔
   Graphics graphics =  image.getGraphics();
    graphics.fillRect(0,0,140,40);
    Random random = new Random();
    for (int i = 1; i < 60; i++) {
        int startX = random.nextInt(140);
        int startY = random.nextInt(30);

        int endX = random.nextInt(startX+15);
        int endY = random.nextInt(startY+15);
        graphics.setColor(getColor());
        graphics.drawLine(startX,startY,endX,endY);
    }


    graphics.setFont(new Font("seif",Font.ITALIC,20));
    graphics.setColor(Color.BLACK);
    String letter = getLetter();
    for (int i = 0; i < letter.length(); i++) {
        int x = random.nextInt(20)+30*(i);
        int y = random.nextInt(20)+15;
        graphics.drawString(letter.charAt(i)+"",x,y);
    }

    session.setAttribute("checkCode",letter);

    ImageIO.write(image,"jpeg",response.getOutputStream());
    out.clear();
    out = pageContext.pushBody();
%>