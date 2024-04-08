document.addEventListener("DOMContentLoaded", function () {
    // 수정 버튼 클릭 시 이벤트 처리
    document.getElementById("modify-btn").addEventListener("click", function () {
        var questionId = document.getElementById("question-id").value;
        window.location.href = `/premium-questions/${questionId}/edit`;
    });

    // 삭제 버튼 클릭 시 이벤트 처리
    document.getElementById("delete-btn").addEventListener("click", function () {
        var questionId = document.getElementById("question-id").value;
        // 삭제 확인 로직 추가
        var confirmDelete = confirm("정말로 삭제하시겠습니까?");
        if (confirmDelete) {
            // 삭제 요청을 서버로 보냄
            fetch(`/api/${questionId}`, {
                method: "DELETE"
            }).then(response => {
                if (response.ok) {
                    // 삭제 성공 시 페이지 새로고침
                    window.location.reload();
                } else {
                    alert("삭제에 실패하였습니다.");
                }
            }).catch(error => {
                console.error("Error:", error);
                alert("삭제 요청을 보내는 중 오류가 발생하였습니다.");
            });
        }
    });

    // 목록으로 가기 버튼 클릭 시 이벤트 처리
    document.getElementById("back-btn").addEventListener("click", function () {
        window.location.href = "/premium-questions";
    });

    // 질문에 댓글 달기 버튼 클릭 시 이벤트 처리
    document.getElementById("create-comment-btn").addEventListener("click", function () {
        var questionId = this.getAttribute("th:data-question-id");
        var commentContent = document.getElementById("comment-content").value;

        // 댓글 내용이 비어있는지 확인
        if (commentContent.trim() === "") {
            alert("댓글을 입력하세요.");
            return;
        }

        // 댓글 생성 요청을 서버로 보냄
        fetch(`/api/premium-questions/${questionId}/comments`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                content: commentContent
            })
        }).then(response => {
            if (response.ok) {
                // 댓글 생성 성공 시 페이지 새로고침
                window.location.reload();
            } else {
                alert("댓글 생성에 실패하였습니다.");
            }
        }).catch(error => {
            console.error("Error:", error);
            alert("댓글 생성 요청을 보내는 중 오류가 발생하였습니다.");
        });
    });
});
