const createButton = document.getElementById('create-btn');

if (createButton) {
    createButton.addEventListener('click', event => {
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


const modifyButton = document.getElementById("modify-btn");

if (modifyButton) {
    // 클릭 이벤트가 감지되면 수정 API 요청
    modifyButton.addEventListener('click', event => {
        let params = new URLSearchParams(location.search);
        let questionId = params.get('questionId');

        fetch(`/api/questions/${questionId}`, {
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            })
        }).then(() => {
            alert('수정이 완료되었습니다');
            location.replace(`/api/questions/${questionId}`);
        });
    });
}

const backBtn = document.getElementById("back-btn");
if (backBtn) {
    backBtn.addEventListener("click", function() {
        location.href = (`/api/questions`);
    });
}

