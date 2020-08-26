function showSelectTag(){
    $("#select-tag").show();
}

/*点击标签后将标签的值放入input框*/
function selectTags(tag) {
    var previous = $("#tags").val();
    if(previous.indexOf(tag) == -1){
        if(previous){
            $("#tags").val(previous + '、' + tag);
        }else {
            $("#tags").val(tag);
        }
    }
}

/*折叠二级评论*/
function collapseComments(e) {
    var id = e.getAttribute("data-id");
    var comment = $("#comment-" + id);

    var collapse = e.getAttribute("data-collapse");
    if (collapse) {
        comment.removeClass("in")
        e.removeAttribute("data-collapse")
    } else {
        comment.addClass("in");
        e.setAttribute("data-collapse", "in");
    }
}


/*
* 提交评论的方法
*/
function questionComment() {
    var questionId = $("#question-id").val();
    var commentContent = $("#reply-content").val();
    comment(questionId,commentContent,1);
}

function childrenComment(e) {
    var parentId = e.getAttribute("data-id");
    var content = $("#input-"+ parentId ).val();
    comment(parentId,content,2);
}

function comment(parentId,content,type) {
    $.ajax({
        type: "POST",
        url: "/community/comment/save",
        data: {
            "parentId": parentId,
            "commentContent": content,
            "type": type
        },
        success: function (data) {
            if (data.code == 200) {
                //重新加载刷新页面
                window.location.reload();
                //$("#reply-frame").hide();隐藏部分
            } else {
                if (data.code == 202) {
                    var isAccept = confirm(data.message);
                    if (isAccept) {
                        window.open("/community/login");
                        window.localStorage.setItem("closable", "true");
                    }
                } else {
                    alert(data.message)
                }
            }
        },
        dataType: "json"
    });
}