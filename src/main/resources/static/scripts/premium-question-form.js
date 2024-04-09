document.addEventListener("DOMContentLoaded", function () {
    // 질문 작성 완료 버튼 클릭 시 이벤트 처리
    document.getElementById("question-form").addEventListener("submit", function (event) {
        event.preventDefault(); // 폼 제출 방지

        var title = document.getElementById("title").value;
        var content = document.getElementById("content").value;

        // 제목과 내용이 모두 입력되었는지 확인
        if (title.trim() === "" || content.trim() === "") {
            alert("제목과 내용을 모두 입력하세요.");
            return;
        }

        // 질문 생성 요청을 서버로 보냄
        fetch("/api/premium-questions", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                title: title,
                content: content
            })
        }).then(response => {
            if (response.ok) {
                // 질문 생성 성공 시 홈페이지로 이동
                window.location.href = "/premium-questions";
            } else {
                alert("질문 생성에 실패하였습니다.");
            }
        }).catch(error => {
            console.error("Error:", error);
            alert("질문 생성 요청을 보내는 중 오류가 발생하였습니다.");
        });
    });
});
