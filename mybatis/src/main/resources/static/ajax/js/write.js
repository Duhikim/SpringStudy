
//이벤트 리스너 등록
// 목록
const listButton = document.getElementById('listBtn');
listButton.addEventListener('click', handleListButtonClick);

// 등록
const saveButton = document.getElementById('saveBtn');
saveButton.addEventListener('click', handleSaveButtonClick);


// 버튼 클릭 이벤트 처리 함수
function handleSaveButtonClick() {

    const jsonData = {
        reguser: document.getElementById("reguser").value,
        title: document.getElementById("title").value,
        contents: document.getElementById("contents").value
    };


  const apiUrl = '/api/board';

    fetch(apiUrl, {
        method: 'POST', // 사용할 HTTP 메서드
        headers: {
             'Content-Type': 'application/json'
        },
        body: JSON.stringify(jsonData)
    })
    .then(response => {
        // HTTP 응답 상태를 확인
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        // JSON 데이터를 파싱하여 Promise 반환
        return response.json();
      })
      .then(data => {
        console.log("success");
        // JSON 데이터 사용
        alert("등록되었습니다.");
        window.location.href = '/list';
      })
      .catch(error => {
        // 오류 처리
        alert(error);
        console.error('Error:', error);
      });

}

function handleListButtonClick() {
    window.location.href = '/list';
}