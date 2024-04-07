function validateForm() {
    var email = document.forms["joinForm"]["email"].value;
    var nickName = document.forms["joinForm"]["nickName"].value;
    var password = document.forms["joinForm"]["password"].value;

    // 각 필드가 비어 있는지 확인
    if (email == "" || nickName == "" || password == "") {
        alert("모든 항목은 필수로 입력해야 합니다.");
        return false;
    }

    // 이메일 형식 확인
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
        alert("올바른 이메일 주소를 입력하세요.");
        return false;
    }
return true;
}
