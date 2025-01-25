function deletePost(seq) {
    // 사용자 확인
    if (confirm('정말 삭제하시겠습니까?1')) {
        fetch(`/api/boards/${seq}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(response => {
            if (response.ok) {
                alert('삭제에 성공했습니다.');
                // 삭제 성공 후 리다이렉트
                window.location.href = '/board/boards';
            } else {
                alert('삭제에 실패했습니다.');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('삭제 중 오류가 발생했습니다.');
        });
    }
}