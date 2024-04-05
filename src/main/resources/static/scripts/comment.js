const createCommentButton = document.getElementById('create-comment-btn');

if (createCommentButton) {
    createCommentButton.addEventListener('click', event => {
        let params = new URLSearchParams(location.search);
        let questionId = params.get('questionId');

        fetch(`/api/questions/{questionId}`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/json"
            },
            body : JSON.stringify({
                content: document.getElementById('content').value
            }),
        }).then(() => {
            alert('등록 완료되었습니다');
            location.replace(`/api/questions/${questionId}`);
        })
    })
}