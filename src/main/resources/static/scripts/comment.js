const createCommentButton = document.getElementById('create-comment-btn');
const questionId = createCommentButton.dataset.questionId; // Thymeleaf 표현식으로 questionId 가져오기
if (createCommentButton) {
    createCommentButton.addEventListener('click', event => {

        fetch(`/api/questions/${questionId}`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/json"
            },
            body : JSON.stringify({
                content: document.getElementById('comment-content').value
            })
        }).then(() => {
            alert('등록 완료되었습니다');
            location.replace(`/api/questions/${questionId}`);
        })
    })
}