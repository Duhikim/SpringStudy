function updatePost() {
    const form = document.getElementById('editForm');

    // JSON 데이터 준비
    const data = {
        seq: form.querySelector('#seq').value,
        title: form.querySelector('#title').value,
        contents: form.querySelector('#contents').value,
        regUser: form.querySelector('#regUser').value
    };

    fetch(`/api/boards`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        alert('수정에 성공했습니다.');
        // 수정 성공 시 페이지 리다이렉트 또는 메시지 표시
        window.location.href = '/board/boards';
    })
    .catch(error => {
        console.error('Error:', error);
        alert('수정 중 오류가 발생했습니다.');
    });
}