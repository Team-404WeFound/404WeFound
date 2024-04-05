const createCommentButton = document.getElementById('create-comment-btn');

if (createCommentButton) {
    createCommentButton.addEventListener('click', event => {
        fetch(`/api/questions`, {
            method: 'POST',
            headers: {
                "Content-Type": "application/json"
            },
            body : JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            }),
        }).then(() => {
            alert('등록 완료되었습니다');
            location.replace("/api/questions");
        })
    })
}