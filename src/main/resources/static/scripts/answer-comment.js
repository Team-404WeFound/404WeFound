document.addEventListener('DOMContentLoaded', () => {
    const addCommentButtons = document.querySelectorAll('.add-comment-btn');
    const submitCommentButtons = document.querySelectorAll('.submit-comment-btn');

    addCommentButtons.forEach(button => {
        button.addEventListener('click', () => {
            const commentForm = button.nextElementSibling;
            commentForm.style.display = commentForm.style.display === 'none' ? 'block' : 'none';
        });
    });

    submitCommentButtons.forEach(button => {
        button.addEventListener('click', async () => {
            const answerId = button.parentElement.previousElementSibling.dataset.answerId;
            const content = button.previousElementSibling.value;

            try {
                const response = await fetch(`/api/answers/${answerId}/answerComments`, {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({ content }),
                });

                if (response.ok) {
                    alert('댓글이 성공적으로 등록되었습니다.');
                    location.reload();
                } else {
                    alert('댓글 등록에 실패했습니다.');
                }
            } catch (error) {
                console.error('Error:', error);
                alert('댓글 등록 중 오류가 발생했습니다.');
            }
        });
    });
});