$.post("AdminInfoServlet?action=loginCheck",function (result) {



  if(result!=="true"){
    alert("请先登录");
    window.location.href="BackstageLogin.jsp";
  }else{
    $(".context").show();
  }
});