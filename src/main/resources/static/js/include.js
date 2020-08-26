$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "/community/include",
        data: "",
        success: function (data) {
            if(data.code == 200){
                var noticeCount = data.data.noticeCount;
                $("#noticeCount").text(noticeCount);
                $("#newDynamic").text(noticeCount);
            }
        },
        dataType: "json"
    });
});