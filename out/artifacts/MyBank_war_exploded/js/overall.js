$(function () {
    $("body").click(function (e) {
        var value = getMousePos(window.event);
        create(value.x, value.y);
    });
})


function getMousePos(event) {
    var e = event || window.event;
    var scrollX = document.documentElement.scrollLeft || document.body.scrollLeft;
    var scrollY = document.documentElement.scrollTop || document.body.scrollTop;
    var x = e.pageX || e.clientX + scrollX;
    var y = e.pageY || e.clientY + scrollY;
    return { 'x': x, 'y': y };
}
count = 0;
a = [
    '富强', '明主', '文明', '和谐', '自由', '平等', '公正', '法制', '爱国', '敬业', '诚信', '友善'
]
function create(x, y) {
    var tag = $("<span onselectstart='return false;' id='abc' style='position: absolute;top: " + y + "px;left: " + x + "px;z-index: 9999;font-size:11px;color:red;'>" + a[count] + "</span>");
    if (count === 11) {
        count = 0;
    } else {
        count++;
    }
    $("body").append(tag);
    animation1(tag, y);
}

function animation1(obj, y) {
    var num = y - 100;
    $(obj).animate({ top: "" + num + "px", opacity: '0.1', }, 600, function () {
        $(obj).remove();
    });
}