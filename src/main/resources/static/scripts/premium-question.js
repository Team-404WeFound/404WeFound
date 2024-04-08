document.addEventListener("DOMContentLoaded", function () {
    // 질문 작성 버튼 클릭 시 이벤트 처리
    document.getElementById("create-btn").addEventListener("click", function () {
        window.location.href = "/premium-questions/new";
    });
});
