function confirmWithdrawal() {
    if (confirm("정말로 회원 탈퇴하시겠습니까?")) {
        document.getElementById("withdrawForm").submit();
        alert("회원 탈퇴가 완료되었습니다.");
    }
}