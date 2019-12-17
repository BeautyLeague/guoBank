<%@ page import="java.awt.*" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page contentType="image/jpeg" language="java" %>

<%!
    //获取随机颜色
    public Color getColor() {
        Random ran = new Random();
        int r = ran.nextInt(256); //产生0-255的随机数
        int g = ran.nextInt(256);
        int b = ran.nextInt(256);
        return new Color(r,g ,b);
    }

    //获取4为随机数子
    public String getNum(){
        return String.valueOf((int)(Math.random()*9000) + 1000);
    }
%>

<%
    //禁止缓存,防止验证码过期
    response.setHeader("Pragma","no-cache");
    response.setHeader("Cache-control","no-cache");
    response.setHeader("Expires","0");


    //绘制验证码
    BufferedImage image = new BufferedImage(130,40,BufferedImage.TYPE_INT_RGB);
    //画笔
    Graphics graphics = image.getGraphics();
    graphics.fillRect(0,0,130,40);
    //绘制干扰线条
    for (int i = 0;i<70;i++) {
        Random ran = new Random();
        int xBegin = ran.nextInt(130);
        int yBegin = ran.nextInt(130);


        int xEnd = ran.nextInt(xBegin + 10);
        int yEnd = ran.nextInt(yBegin + 10);

        graphics.setColor(getColor());

        //绘制线条
        graphics.drawLine(xBegin,yBegin,xEnd,yEnd);
    }


        graphics.setFont(new Font("seif",Font.ITALIC,25));
        //绘制验证码
        graphics.setColor(Color.BLACK);
        String checkCode = getNum();//获取验证码
        StringBuffer sb = new StringBuffer();
        Random ran = new Random();
        for (int j = 0; j < checkCode.length(); j++) {
            int x = ran.nextInt(20)+20*(j+1);
            int y = ran.nextInt(20)+15;
            graphics.drawString(checkCode.charAt(j)+"",x,y);
        }



        //将验证码真实值保存起来
        session.setAttribute("checkCode",checkCode);

        //真实产生图片
        ImageIO.write(image,"jpeg",response.getOutputStream());
        out.clear();
        out = pageContext.pushBody();

%>
