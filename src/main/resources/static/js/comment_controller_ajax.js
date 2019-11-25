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
    var commentTemplate = $("#commentCreateTemplate").html();
    var template = commentTemplate.format(data.commentNo, data.postsNo, data.comment, data.commentDate, data.commentWriter);
    $(".commentTitle").append(template);
    $("#commentContent").val("");
}

// 댓글 삭제 Ajax
$(document).on('click', '.commentDeleteBtn', commentDeleteJs);

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
// 댓글 수정 put 해야함. 데이터 컨트롤러로 안넘어가고있음
function commentDeleteError() {
    console.log("DELETE ERROR");
}

// 댓글 수정 Ajax. textarea 열기
$(document).on('click', '.commentUpdateBtn', openCommentUpdateForm);

function openCommentUpdateForm(e) {
    e.preventDefault();
    console.log("openUpdateForm click!!");

    var updateBtn = $(this);
    var commentNo = updateBtn.attr("value");
    var commentContentDiv = "commentContentDiv" + commentNo;
    var commentContentTextarea = "commentContentTextarea" + commentNo;

    var commentContent = document.getElementById(commentContentDiv).innerText;

    //document.getElementById(commentContentDiv).style.display = "none";          // contentDiv
    document.getElementById(commentContentTextarea).style.display = "inline";   // contentTextarea
    document.getElementById(commentContentTextarea).value = commentContent;     // textarea에 값 배치

    $('.commentUpdateBtn').css({display: 'none'});             // 수정 버튼 none
    $('.commentDeleteBtn').css({display: 'none'});             // 삭제 버튼 none
    $('.commentUpdateComplateBtn').css({display: 'inline'});   // 수정 완료버튼 inline
    $('.commentCancelBtn').css({display: 'inline'});           // 취소 버튼 inline
}

// 댓글 수정 Ajax.
$(document).on('click', '.commentUpdateComplateBtn', commentUpdateJs);

function commentUpdateJs(e) {
    e.preventDefault();
    console.log("commentUpdateComplate click!!");

    var complateBtn = $(this);
    var commentNo = complateBtn.attr("value");
    console.log("no :" + commentNo);

    var queryString = $(".commentContentTextarea").serialize();
    console.log(queryString);

    var url = complateBtn.attr("href");
    console.log("url : " + url);

    $.ajax({
        type: 'put',
        url: url,
        data: queryString,
        dataType: 'json',
        error: commentUpdateError,
        success: function (data) {
            console.log("comment Update Data : " + data);

        }
    });
}

function commentUpdateError() {

}


String.prototype.format = function () {
    var args = arguments;
    return this.replace(/{(\d+)}/g, function (match, number) {
        return typeof args[number] != 'undefined'
            ? args[number]
            : match
            ;
    });
};