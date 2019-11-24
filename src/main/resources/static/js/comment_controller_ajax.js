// 댓글 추가 Ajax
$("#commentCreateBtn").click(commentCreateJs);

function commentCreateJs(e) {
    e.preventDefault();
    console.log("commentCreate click!!");

    var queryString = $("#commentForm").serialize();
    console.log("queryString : " + queryString);

    var url = $("#commentForm").attr("action");
    console.log("url : " + url);

    $.ajax({
        type: 'post',
        url: url,
        data: queryString,
        dataType: 'json',
        error: onCommentCreateError,
        success: onCommentCreateSuccess
    });
}

function onCommentCreateError() {
}

function onCommentCreateSuccess(data) {
    console.log(data);
    var commentTemplate = $("#commentTemplate").html();
    var template = commentTemplate.format(data.commentNo, data.postsNo, data.comment, data.commentDate, data.commentWriter);
    $(".commentTitle").append(template);
    $("#commentContent").val("");
}

// 댓글 삭제 Ajax
$(document).on('click', '.commentDelete', commentDeleteJs);

function commentDeleteJs(e) {
    e.preventDefault();
    console.log("commentDelete click!!");

    var deleteBtn = $(this);
    console.log("deleteBtn this : " + deleteBtn);
    var url = deleteBtn.attr("href");
    console.log("url : " + url);

    $.ajax({
        type: 'delete',
        url: url,
        dataType: 'json',
        error: commentDeleteError,
        success: function (data) {
            console.log(data);
            if (data.valid) {
                deleteBtn.closest("article").remove();
            } else {
                alert(data.errorMessage);
            }
        }
    });
}

function commentDeleteError() {
    console.log("DELETE ERROR");
}

// 댓글 삭제 Ajax
// $(document).on('click','commentUpdate', commentUpdateJs);
//
// function commentUpdate(e) {
//
// }


String.prototype.format = function () {
    var args = arguments;
    return this.replace(/{(\d+)}/g, function (match, number) {
        return typeof args[number] != 'undefined'
            ? args[number]
            : match
            ;
    });
};